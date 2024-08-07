package com.github.xuyuanzhi.template.admin.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.alibaba.fastjson.JSON;
import com.github.xuyuanzhi.template.core.config.AccessControl;
import com.github.xuyuanzhi.template.core.config.UserHolder;
import com.github.xuyuanzhi.template.core.utils.Constants;
import com.github.xuyuanzhi.template.core.utils.TokenUtils;
import com.github.xuyuanzhi.template.core.view.ResponseJson;
import com.github.xuyuanzhi.template.core.view.UserView;

public class AdminInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(AdminInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // get token from parameters
        String token = request.getParameter(Constants.TOKEN_KEY);

        // get token from request header
        if (StringUtils.isBlank(token)) {
            token = request.getHeader(Constants.TOKEN_KEY);
        }

        // get token from cookie
        if (StringUtils.isBlank(token)) {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie c : cookies) {
                    if (Constants.TOKEN_KEY.equals(c.getName())) {
                        token = c.getValue();
                        break;
                    }
                }
            }
        }

        // verify token
        if (StringUtils.isNotBlank(token)) {
            UserView user = TokenUtils.verifyToken(token);
            if (user != null) {
                UserHolder.set(user);
                request.setAttribute("user", user);
            }
        }
        
     // 设置默认访问限制，开发环境设置为none
        AccessControl.Level level = AccessControl.Level.NONE;
        if (handler instanceof HandlerMethod) {
            final HandlerMethod handlerMethod = (HandlerMethod) handler;
            final Class<?> clazz = handlerMethod.getBeanType();

            if (handlerMethod.getMethod().isAnnotationPresent(AccessControl.class)) {
                level = handlerMethod.getMethod().getDeclaredAnnotation(AccessControl.class).level();
            } else if (clazz.isAnnotationPresent(AccessControl.class)) {
                level = clazz.getDeclaredAnnotation(AccessControl.class).level();
            }
        }

        // invoke controller method
        if (level == AccessControl.Level.NONE || UserHolder.get() != null) {
            return true;
        }

        if (isAjax(request)) {
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(JSON.toJSONString(ResponseJson.response(ResponseJson.CODE_NOAUTH, "请登录")));
            response.getWriter().flush();
        } else {
            response.sendRedirect("/");
        }

        return false;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        UserHolder.remove();
    }

    private boolean isAjax(HttpServletRequest request) {
        return "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
    }
}

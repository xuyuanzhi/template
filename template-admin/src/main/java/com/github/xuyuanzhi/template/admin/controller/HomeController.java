package com.github.xuyuanzhi.template.admin.controller;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.xuyuanzhi.template.core.config.AccessControl;
import com.github.xuyuanzhi.template.core.config.AccessControl.Level;
import com.github.xuyuanzhi.template.core.config.UserHolder;
import com.github.xuyuanzhi.template.core.entity.User;
import com.github.xuyuanzhi.template.core.service.UserService;
import com.github.xuyuanzhi.template.core.utils.RandomUtils;
import com.github.xuyuanzhi.template.core.utils.TokenUtils;
import com.github.xuyuanzhi.template.core.view.ResponseJson;
import com.github.xuyuanzhi.template.core.view.UserView;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "主类")
@Controller
public class HomeController {
	
	//版本号，解决缓存问题
	private static final String version = DateFormatUtils.format(System.currentTimeMillis(), "yyyyMMddHHmm");
	
	private static final String keyOfCaptcha = RandomUtils.generateUUID();

    @Autowired
    private UserService userService;

    @ApiOperation(value = "首页")
    @GetMapping({ "/", "/index", "/index.html" })
    public String index(Model model) {
    	// 版本号，解决缓存问题
    	model.addAttribute("version", version);
        return "index";
    }

    @ApiOperation(value = "登录")
    @PostMapping("/login")
    @ResponseBody
    public ResponseJson<JSONObject> login(@RequestBody UserView param) {
        if (StringUtils.isBlank(param.getPhoneNo())) {
            return ResponseJson.failure("手机号码不能为空");
        }

        if (StringUtils.isBlank(param.getPassword())) {
            return ResponseJson.failure("密码不能为空");
        }

        //uncomment these code
//        User user = userService
//                .getOne(new QueryWrapper<User>().eq("PHONE_NO", param.getPhoneNo()).eq("USER_TYPE", User.TYPE_ADMIN));
//        if (user == null || user.getStatus() != User.STATUS_ACTIVE) {
//            return ResponseJson.failure("用户不存在或已禁用");
//        }
//
//        if (!user.getPassword().equals(DigestUtils.md5Hex(param.getPassword() + "#" + user.getSecureKey()))) {
//            return ResponseJson.failure("用户名或密码错误");
//        }
//
//        String token = TokenUtils.createToken(user, 240);
//        if (StringUtils.isBlank(token)) {
//            return ResponseJson.failure("登录失败");
//        }

        JSONObject json = new JSONObject();
//        json.put("token", token);
//        json.put("name", user.getName());
        json.put("token", "token_value");
        json.put("name", "Jack");
        return ResponseJson.success(json);
    }
    
    @AccessControl(level = Level.NONE)
	@GetMapping("/captchaImage")
	@ResponseBody
	public ResponseJson<JSONObject> captchaImage() {
		LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);

		JSONObject json = new JSONObject();
		json.put("image", lineCaptcha.getImageBase64());
		json.put("uuid", DigestUtils.md5Hex(keyOfCaptcha + lineCaptcha.getCode()));

		return ResponseJson.success(json);
	}
    
    @GetMapping("/userInfo")
    @ResponseBody
    @AccessControl(level =Level.SESSION)
    public ResponseJson<UserView> userInfo() {
		return ResponseJson.success(UserHolder.get());
	}
    
    @GetMapping("/logout")
    @ResponseBody
    public ResponseJson<User> logout() {
		return ResponseJson.success();
	}
}

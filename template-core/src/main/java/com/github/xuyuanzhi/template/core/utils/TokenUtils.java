package com.github.xuyuanzhi.template.core.utils;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.github.xuyuanzhi.template.core.entity.User;
import com.github.xuyuanzhi.template.core.view.UserView;

@Component
public class TokenUtils {

    private static Logger logger = LoggerFactory.getLogger(TokenUtils.class);

    private static String secret = "abcdefghijklmnopqrstuvwxyz0123456789823743747";

    public static String createToken(UserView user, int minutes) {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        String token = JWT.create().withIssuer("system") // 发布者
                .withIssuedAt(new Date()) // 生成签名的时间
                .withExpiresAt(DateUtils.addMinutes(new Date(), minutes)) // 生成签名的有效期, 分钟
                .withClaim("userId", user.getId()) // 用户id
                .withClaim("userName", user.getName()) // 名称
                .sign(algorithm);
        return token;
    }
    
    public static String createToken(User user, int minutes) {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        String token = JWT.create().withIssuer("system") // 发布者
                .withIssuedAt(new Date()) // 生成签名的时间
                .withExpiresAt(DateUtils.addMinutes(new Date(), minutes)) // 生成签名的有效期, 分钟
                .withClaim("userId", user.getId()) // 用户id
                .withClaim("userName", user.getName()) // 名称
                .sign(algorithm);
        return token;
    }

    public static UserView verifyToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        JWTVerifier verifier = JWT.require(algorithm).withIssuer("system").build();
        try {
            DecodedJWT jwt = verifier.verify(token);
            if (jwt != null) {
                String userId = jwt.getClaim("userId").asString();
                String userName = jwt.getClaim("userName").asString();
                if (StringUtils.isNotBlank(userId)) {
                	UserView user = new UserView();
                    user.setId(userId);
                    user.setName(userName);
                    return user;
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

}

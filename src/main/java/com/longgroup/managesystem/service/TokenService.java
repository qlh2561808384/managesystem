package com.longgroup.managesystem.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.longgroup.managesystem.domain.Users;
import org.springframework.stereotype.Service;


/**
 * @author jinbin
 * @date 2018-07-08 21:04
 */
@Service("TokenService")
public class TokenService {
    public String getToken(Users user) {
        String token="";
        token = JWT.create().withAudience(String.valueOf(user.getId()))// 将 user id 保存到 token 里面
                .sign(Algorithm.HMAC256(user.getPassword()));// 以 password 作为 token 的密钥
        return token;
    }
}

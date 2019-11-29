package com.longgroup.managesystem.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/**
 *
 *      设置15分钟过期也是出于安全考虑，防止token被窃取，不过一般选择基于token认证，传输方式我们都应该选择https，
 *      这样别人无法抓取到我们的请求信息。这个私钥是非常重要的，加密解密都需要用到它，要设置的足够复杂并且不能被盗取，
 *      我这里选用的是一串uuid，加密方式是HMAC256。
 * @return
 * @author qlh
 * @creed: Talk is cheap,show me the code
 * @date
 */
public class jwtUtils {
    //设置过期时间
    private static final long EXPIRE_TIME = 15 * 60 * 1000;

    private static final String TOKEN_SECRET  = "76b00b6b604346309e11fef3cb80bd24";

    /**
     * 生成签名，15分钟后过期
     */
    public static String sign(String username,String userid) {
        try{
            //过期时间
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            //私钥以及加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            //设置头部信息
            Map<String, Object> header = new HashMap<String, Object>(2);
            header.put("type", "JWT");
            header.put("alg", "HS256");
            //附带username userid 信息，生成标签
            return JWT.create()
                    .withHeader(header)//头
                    .withClaim("username", username)
                    .withClaim("userid", userid)
                    .withExpiresAt(date)//过期时间
                    .sign(algorithm);//私钥以及加密算法
        }catch (Exception e){
            return null;
        }

    }
}

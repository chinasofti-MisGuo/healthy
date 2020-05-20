package com.mongolia.test;

import cn.hutool.crypto.SecureUtil;
import com.mongolia.util.JWTUtils;
import org.junit.Test;

/**
 * @author Dong.w
 */
public class TokenTest {

    @Test
    public void tokenTest()throws Exception{
        String str = "username";
        String username = JWTUtils.sign(str, "username");
        System.out.println(username);
    }

    @Test
    public void test() throws Exception{
        String str = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1Nzg0MDAwODQsInVzZXJuYW1lIjoidXNlcm5hbWUifQ.wWWOB8AA_tzzCGXNoRHUHrWW9qk6Kvx8SO8ATrCHVgc";
        System.out.println(JWTUtils.getUsername(str));
    }

    @Test
    public void md5Test() throws Exception{
        String str = "123456";
        System.out.println(SecureUtil.md5(str));
        System.out.println(SecureUtil.hmacMd5("mongolia").digestHex(str));
    }

}

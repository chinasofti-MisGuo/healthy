package com.mongolia.util;

import cn.hutool.crypto.SecureUtil;
import com.mongolia.model.enums.ConstantEnum;

/**
 * 密码相关工具类
 * @author Dong.w
 */
public class EncryptionUtils {

    /**
     * MD5盐值加密
     * @param password  密码明文
     * @return  密码密文
     */
    public static String md5AndSalt(String password){
        return SecureUtil.hmacMd5(ConstantEnum.ENCRYPTION_KEY.getValue().toString()).digestHex(password);
    }

}

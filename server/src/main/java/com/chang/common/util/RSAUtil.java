package com.chang.common.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * 私钥加密，公钥解密工具类
 */
public class RSAUtil {
    //非对称密钥算法
    public static final String KEY_ALGORITHM = "RSA";

    //公钥
    public static final String PUBLIC_KEY = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAIcxR2n8aEgiFg0g2jvAgtwpx6qync0phN7bPOIX9qDhmL29liNb7bGREmL/phOqUzPvN4jT8g7PC17tFun/YeMCAwEAAQ==";

    //私钥
    public static final String PRIVATE_KEY = "MIIBUwIBADANBgkqhkiG9w0BAQEFAASCAT0wggE5AgEAAkEAhzFHafxoSCIWDSDaO8CC3CnHqrKdzSmE3ts84hf2oOGYvb2WI1vtsZESYv+mE6pTM+83iNPyDs8LXu0W6f9h4wIDAQABAkAWcRC4wESTTM06SqzPZGqUn37ckB/v0aeT0vLtWSsAk5SfpK4oFo8Jsn+F/ffZ43ZxyV9Mk5yHvEXoxnD+wbxRAiEAvcFtPqCY2Lg5WYZ4lrjm1yIEZ9OJhJLiNgOn/pMDH3sCIQC2Y4QjuSZz6vnNap+JWHlCGxlOx6XATpuiYtC2m8ZGuQIgcW4W58EInURCxAlmPHL7Ss7C423IXr+PCcrVuZAX5dECIDXZ0CwUAKx9FmB2OMB+pN7FzYUbIW9URlN9xY4FFFfRAiBf6evSJ3suNu/XLosuEWB/mwdJQTsCSHi090aa024baw==";


    /**
     * 私钥加密
     *
     * @param data 待加密数据
     * @param privateKeyStr 密钥
     * @return 加密后数据
     */
    public static String encryptByPrivateKey(String data, String privateKeyStr) throws Exception {

        //取得私钥
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKeyStr));
        KeyFactory keyFactory = KeyFactory.getInstance(RSAUtil.KEY_ALGORITHM);
        //生成私钥
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
        //数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);

        return Base64.encodeBase64String(cipher.doFinal(data.getBytes()));
    }


    /**
     * 公钥解密
     *
     * @param data 待解密数据
     * @param publicKeyStr  公钥串
     * @return String 解密数据
     * @throws Exception
     */
    public static String decryptByPublicKey(String data, String publicKeyStr) throws Exception {

        //实例化密钥工厂
        KeyFactory keyFactory = KeyFactory.getInstance(RSAUtil.KEY_ALGORITHM);
        //初始化公钥
        //密钥材料转换
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(Base64.decodeBase64(publicKeyStr));
        //产生公钥
        PublicKey pubKey = keyFactory.generatePublic(x509KeySpec);
        //数据解密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, pubKey);

        return new String(cipher.doFinal(Base64.decodeBase64(data)));
    }


    public static void main(String[] args) throws Exception {

        String aaa = encryptByPrivateKey("15632563256", RSAUtil.PRIVATE_KEY);
        System.out.println("加密后的数据======" + aaa);

        System.out.println("解密后的数据======" + decryptByPublicKey(aaa, RSAUtil.PUBLIC_KEY));
    }

}

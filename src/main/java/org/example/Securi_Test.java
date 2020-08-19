package org.example;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.HexUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import cn.hutool.crypto.asymmetric.Sign;
import cn.hutool.crypto.asymmetric.SignAlgorithm;
import cn.hutool.crypto.digest.HMac;
import cn.hutool.crypto.digest.HmacAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

public class Securi_Test {

//    对于对称加密，实现了：
//    AES
//    ARCFOUR
//    Blowfish
//    DES
//    DESede
//    RC2
//    PBEWithMD5AndDES
//    PBEWithSHA1AndDESede
//    PBEWithSHA1AndRC2_40


//    对于非对称加密，实现了：
//    RSA
//    DSA


//    对于摘要算法实现了：
//    MD2
//    MD5
//    SHA-1
//    SHA-256
//    SHA-384
//    SHA-512
//    HmacMD5
//    HmacSHA1
//    HmacSHA256
//    HmacSHA384
//    HmacSHA512

    public static void main(String[] args) {
//        aes();
//
//        des();

        rsa();

//        sign();
//
//        hmacmd5();
    }



    // 摘要加密
    private static void hmacmd5() {
        String testStr = "test中文";

        byte[] key = "password".getBytes();
        HMac mac = new HMac(HmacAlgorithm.HmacSHA256, key);

        String macHex1 = mac.digestHex(testStr);  //b977f4b13f93f549e06140971bded384
    }

    // 签名和验证
    private static void sign() {
        byte[] data = "我是一段测试字符串".getBytes();
        Sign sign = SecureUtil.sign(SignAlgorithm.MD5withRSA);
        //签名
        byte[] signed = sign.sign(data);
        //验证签名
        boolean verify = sign.verify(data, signed);
    }

    private static void rsa() {
        KeyPair pair = SecureUtil.generateKeyPair("RSA");
        PrivateKey privateKey = pair.getPrivate();
        PublicKey  publicKey = pair.getPublic();

        // 私钥
        RSA rsa = new RSA(privateKey.toString(), null);

        // 加密值
        String a = "2707F9FD4288CEF302C972058712F24A5F3EC62C5A14AD2FC59DAB93503AA0FA17113A020EE4EA35EB53F"
                + "75F36564BA1DABAA20F3B90FD39315C30E68FE8A1803B36C29029B23EB612C06ACF3A34BE815074F5EB5AA3A"
                + "C0C8832EC42DA725B4E1C38EF4EA1B85904F8B10B2D62EA782B813229F9090E6F7394E42E6F44494BB8";

        // 使用私钥进行解密
        byte[] decrypt = rsa.decrypt(HexUtil.decodeHex(a), KeyType.PrivateKey);

        System.out.println(StrUtil.str(decrypt, CharsetUtil.CHARSET_UTF_8));
    }


    // 对称加密
    private static void aes() {
        String content = "test中文";

        //随机生成密钥
        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();

        //构建
        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, key);

        //加密
        byte[] encrypt = aes.encrypt(content);
        //解密
        byte[] decrypt = aes.decrypt(encrypt);

        //加密为16进制表示
        String encryptHex = aes.encryptHex(content);
        //解密为字符串
        String decryptStr = aes.decryptStr(encryptHex, CharsetUtil.CHARSET_UTF_8);
    }

    // 对称加密
    private static void des() {
        String content = "test中文";

        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.DESede.getValue()).getEncoded();

        SymmetricCrypto des = new SymmetricCrypto(SymmetricAlgorithm.DESede, key);

        //加密
        byte[] encrypt = des.encrypt(content);
        //解密
        byte[] decrypt = des.decrypt(encrypt);

        //加密为16进制字符串（Hex表示）
        String encryptHex = des.encryptHex(content);
        //解密为字符串
        String decryptStr = des.decryptStr(encryptHex);
    }
}

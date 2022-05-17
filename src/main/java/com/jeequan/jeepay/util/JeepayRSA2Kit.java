package com.jeequan.jeepay.util;

import java.io.*;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Map;

/***
 * RSA2 签名（参考alipay-sdk）
 *
 * @author terrfly
 * @site https://www.jeequan.com
 * @date 2022/5/17 18:04
 */
public class JeepayRSA2Kit {

    private static final int DEFAULT_BUFFER_SIZE = 8192;
    public static final String CHARSET_UTF8 = "UTF-8";
    public static final String SIGN_TYPE_RSA = "RSA";
    public static final String SIGN_SHA256RSA_ALGORITHMS = "SHA256WithRSA";

    private static void io(Reader in, Writer out) throws IOException {

        char[] buffer = new char[( DEFAULT_BUFFER_SIZE >> 1 )];
        int amount;

        while ((amount = in.read(buffer)) >= 0) {
            out.write(buffer, 0, amount);
        }
    }

    private static String readText(InputStream ins) throws IOException {
        Reader reader = new InputStreamReader(ins);
        StringWriter writer = new StringWriter();

        io(reader, writer);

        return writer.toString();
    }

    private static PublicKey getPublicKeyFromX509(String algorithm, InputStream ins) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance(algorithm);

        StringWriter writer = new StringWriter();
        io(new InputStreamReader(ins), writer);

        byte[] encodedKey = writer.toString().getBytes();

        encodedKey = Base64.decodeBase64(encodedKey);

        return keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));
    }


    private static PrivateKey getPrivateKeyFromPKCS8(String algorithm,
                                                     InputStream ins) throws Exception {
        if (ins == null || StringUtils.isEmpty(algorithm)) {
            return null;
        }

        KeyFactory keyFactory = KeyFactory.getInstance(algorithm);

        byte[] encodedKey = readText(ins).getBytes();

        encodedKey = Base64.decodeBase64(encodedKey);

        return keyFactory.generatePrivate(new PKCS8EncodedKeySpec(encodedKey));
    }

    /** 签名 */
    public static String getSign(Map params, String privateKey) throws Exception {
        return getSign(JeepayKit.getStrSort(params), privateKey);
    }


    /** 签名 */
    public static String getSign(String content, String privateKey) throws Exception {

        PrivateKey priKey = getPrivateKeyFromPKCS8(SIGN_TYPE_RSA, new ByteArrayInputStream(privateKey.getBytes()));

        Signature signature = Signature.getInstance(SIGN_SHA256RSA_ALGORITHMS);

        signature.initSign(priKey);

        signature.update(content.getBytes(CHARSET_UTF8));

        byte[] signed = signature.sign();

        return new String(Base64.encodeBase64(signed));
    }


    /** 验签 **/
    public static boolean verify(Map map, String publicKey, String sign) throws Exception {
        return verify(JeepayKit.getStrSort(map), publicKey, sign);
    }

    /** 验签 **/
    public static boolean verify(String content, String publicKey, String sign) throws Exception {

        PublicKey pubKey = getPublicKeyFromX509(SIGN_TYPE_RSA, new ByteArrayInputStream(publicKey.getBytes()));

        Signature signature = Signature.getInstance(SIGN_SHA256RSA_ALGORITHMS);

        signature.initVerify(pubKey);

        signature.update(content.getBytes(CHARSET_UTF8));

        return signature.verify(Base64.decodeBase64(sign.getBytes()));
    }


}

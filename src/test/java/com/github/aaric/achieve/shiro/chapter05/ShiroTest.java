package com.github.aaric.achieve.shiro.chapter05;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.CodecSupport;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.crypto.hash.HashRequest;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.SimpleByteSource;
import org.junit.Assert;
import org.junit.Test;

import java.security.Key;

/**
 * ShiroTest
 *
 * @author Aaric, created on 2017-09-26T12:44.
 * @since 1.0-SNAPSHOT
 */
public class ShiroTest {

    @Test
    public void testBase64() {
        String password = "hello";
        String base64string = Base64.encodeToString(password.getBytes());
        String password2 = Base64.decodeToString(base64string);
        Assert.assertEquals(password, password2);
    }

    @Test
    public void testCodecSupport() {
        byte[] bytes = CodecSupport.toBytes("hello", CodecSupport.PREFERRED_ENCODING);
        Assert.assertEquals("hello", CodecSupport.toString(bytes, CodecSupport.PREFERRED_ENCODING));
    }

    @Test
    public void testMd5() {
        String password = "123";
        String salt = "zhang";
        String md5 = new Md5Hash(password, salt).toString();
        Assert.assertEquals("195d91be1e3ba6f1c857d46f24c5a454", md5);
    }

    @Test
    public void testHash() {
        String password = "123";
        String salt = "zhang";
        String hash = new SimpleHash("SHA-1", password, salt).toString();
        Assert.assertEquals("f0f474f5c5c7152f320d2f0428df9d903c0190ee", hash);
    }

    @Test
    public void testHashService() {
        DefaultHashService service = new DefaultHashService();
        service.setHashAlgorithmName("SHA-512");
        service.setPrivateSalt(new SimpleByteSource("123"));
        service.setGeneratePublicSalt(true);
        service.setRandomNumberGenerator(new SecureRandomNumberGenerator());
        service.setHashIterations(1);

        HashRequest request = new HashRequest.Builder()
                .setAlgorithmName("MD5")
                .setSource(ByteSource.Util.bytes("zhang"))
                .setSalt(ByteSource.Util.bytes("123"))
                .setIterations(2)
                .build();

        String hex = service.computeHash(request).toHex();
        Assert.assertEquals("d0348d8fd2a816688a45ee3487c02bea", hex);
    }

    @Test
    public void testAES() {
        AesCipherService service = new AesCipherService();
        service.setKeySize(128);

        // key
        Key key = service.generateNewKey();
        String keyString = Base64.encodeToString(key.getEncoded());

        // encode
        String password = "123";
        String encryptText = service.encrypt(password.getBytes(), key.getEncoded()).toHex();

        // decode
        String password2 = CodecSupport.toString(service.decrypt(Hex.decode(encryptText), Base64.decode(keyString)).getBytes());

        Assert.assertEquals(password2, password);
    }
}

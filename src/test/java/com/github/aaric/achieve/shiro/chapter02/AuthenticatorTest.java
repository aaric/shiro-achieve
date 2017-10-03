package com.github.aaric.achieve.shiro.chapter02;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * AuthenticatorTest
 *
 * @author Aaric, created on 2017-10-03T15:41.
 * @since 1.0-SNAPSHOT
 */
public class AuthenticatorTest {

    private void login(String iniResourcePath) {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(iniResourcePath);

        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();

        try {
            UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
            subject.login(token);

            System.out.println("login success");

        } catch (AuthenticationException e) {
            System.err.println("login failed");
        }
    }

    @Test
    @Ignore
    public void testFirstSuccessfulStrategy() {
        login("classpath:chapter02/shiro-realm-multi.ini");
        Subject subject = SecurityUtils.getSubject();

        PrincipalCollection principals = subject.getPrincipals();
        Assert.assertEquals(2, principals.asList().size());
    }

    @Test
    @Ignore
    public void testAtLeastOneSuccessfulStrategy() {
        login("classpath:chapter02/shiro-realm-multi.ini");
        Subject subject = SecurityUtils.getSubject();

        PrincipalCollection principals = subject.getPrincipals();
        Assert.assertEquals(1, principals.asList().size());
    }

    @Test
    public void testAllSuccessfulStrategy() {
        login("classpath:chapter02/shiro-realm-multi.ini");
        Subject subject = SecurityUtils.getSubject();

        PrincipalCollection principals = subject.getPrincipals();
        Assert.assertEquals(2, principals.asList().size());
    }
}

package com.github.aaric.achieve.shiro.chapter02;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * LoginLogoutTest
 */
public class LoginLogoutTest {

    @Test
    public void testHelloWorld() {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:chapter02/shiro.ini");

        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();

        try {
            UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
            subject.login(token);

            System.out.println("login success");
            Assert.assertEquals(true, subject.isAuthenticated());

        } catch (AuthenticationException e) {
            System.err.println("login failed");
        }

        subject.logout();
    }

    @Test
    public void testMyRealm1() {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:chapter02/shiro-realm.ini");

        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();

        try {
            UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
            subject.login(token);

            System.out.println("login success");
            Assert.assertEquals(true, subject.isAuthenticated());

        } catch (AuthenticationException e) {
            System.err.println("login failed");
        }

        subject.logout();
    }

    @Test
    @Ignore
    public void testJdbcRealm() {
        /**
         * JdbcRealm->
         * 获取用户密码：select password from users where username = ?
         * 获取用户密码及盐：select password, password_salt from users where username = ?
         * 获取用户角色：select role_name from user_roles where username = ?
         * 获取角色对应的权限信息：select permission from roles_permissions where role_name = ?
         */
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:chapter02/shiro-realm-jdbc.ini");

        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();

        try {
            UsernamePasswordToken token = new UsernamePasswordToken("admin", "123");
            subject.login(token);

            System.out.println("login success");
            Assert.assertEquals(true, subject.isAuthenticated());

        } catch (AuthenticationException e) {
            System.err.println("login failed");
        }

        subject.logout();
    }

}

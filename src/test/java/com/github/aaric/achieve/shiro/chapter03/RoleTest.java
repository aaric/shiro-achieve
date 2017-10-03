package com.github.aaric.achieve.shiro.chapter03;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * RoleTest
 *
 * @author Aaric, created on 2017-10-03T16:32.
 * @since 1.0-SNAPSHOT
 */
public class RoleTest {

    protected void login(String iniResourcePath, String username, String password) {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(iniResourcePath);

        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();

        try {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            subject.login(token);

            System.out.println("login success");

        } catch (AuthenticationException e) {
            System.err.println("login failed");
        }
    }

    @Test
    public void testHasRole() {
        login("classpath:chapter03/shiro-role.ini", "zhang", "123");
        Subject subject = SecurityUtils.getSubject();

        Assert.assertTrue(subject.hasRole("role1"));
        Assert.assertTrue(subject.hasAllRoles(Arrays.asList("role1", "role2")));
        Assert.assertNotNull(subject.hasRoles(Arrays.asList("role1", "role2", "role3")));
    }

    @Test(expected = UnauthorizedException.class)
    public void testCheckRole() {
        login("classpath:chapter03/shiro-role.ini", "zhang", "123");
        Subject subject = SecurityUtils.getSubject();

        subject.checkRole("role1");
        subject.checkRoles(Arrays.asList("role1", "role3"));
    }
}

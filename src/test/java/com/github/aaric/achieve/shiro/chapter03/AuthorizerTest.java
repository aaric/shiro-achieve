package com.github.aaric.achieve.shiro.chapter03;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.junit.Assert;
import org.junit.Test;

/**
 * AuthorizerTest
 *
 * @author Aaric, created on 2017-10-03T20:11.
 * @since 1.0-SNAPSHOT
 */
public class AuthorizerTest extends RoleTest {

    @Test
    public void testIsPermitted() {
        login("classpath:chapter03/shiro-authorizer.ini", "zhang", "123");
        Subject subject = SecurityUtils.getSubject();

        Assert.assertTrue(subject.isPermitted("user1:update"));
        Assert.assertTrue(subject.isPermitted("user2:update"));

        Assert.assertTrue(subject.isPermitted("+user1+2"));
        Assert.assertTrue(subject.isPermitted("+user1+8"));
        Assert.assertTrue(subject.isPermitted("+user1+10"));
        Assert.assertFalse(subject.isPermitted("+user1+4"));


        Assert.assertTrue(subject.isPermitted("menu:view"));
    }
}

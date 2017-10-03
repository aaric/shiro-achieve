package com.github.aaric.achieve.shiro.chapter03;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.apache.shiro.subject.Subject;
import org.junit.Assert;
import org.junit.Test;

/**
 * PermissionTest
 *
 * @author Aaric, created on 2017-10-03T16:46.
 * @since 1.0-SNAPSHOT
 */
public class PermissionTest extends RoleTest {

    @Test
    public void testIsPermitted() {
        login("classpath:chapter03/shiro-permission.ini", "zhang", "123");
        Subject subject = SecurityUtils.getSubject();

        Assert.assertTrue(subject.isPermitted("user:create"));
        Assert.assertTrue(subject.isPermittedAll("user:create", "user:update"));
        Assert.assertFalse(subject.isPermitted("user:view"));
    }

    @Test(expected = UnauthorizedException.class)
    public void testCheckPermitted() {
        login("classpath:chapter03/shiro-permission.ini", "zhang", "123");
        Subject subject = SecurityUtils.getSubject();

        subject.checkPermission("user:create");
        subject.checkPermissions("user:create", "user:update");
        subject.checkPermission("user:view");
    }

    @Test
    public void testCheckPermittedWithAdmin() {
        login("classpath:chapter03/shiro-permission.ini", "admin", "123");
        Subject subject = SecurityUtils.getSubject();

        subject.checkPermission("user:create");
        subject.checkPermissions("user:create", "user:update");
        subject.checkPermission("user:view");
    }

    @Test
    public void testCheckPermittedWithRow() {
        login("classpath:chapter03/shiro-permission.ini", "test", "123");
        Subject subject = SecurityUtils.getSubject();

        subject.checkPermission("user:view:1");
        subject.checkPermission(new WildcardPermission("user:view:1"));
        subject.checkPermissions("user:update:1", "user:delete:1");
    }
}

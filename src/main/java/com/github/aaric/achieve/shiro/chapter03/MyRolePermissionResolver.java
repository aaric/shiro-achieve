package com.github.aaric.achieve.shiro.chapter03;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.RolePermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;

import java.util.Arrays;
import java.util.Collection;

/**
 * MyRolePermissionResolver
 *
 * @author Aaric, created on 2017-10-03T19:59.
 * @since 1.0-SNAPSHOT
 */
public class MyRolePermissionResolver implements RolePermissionResolver {

    @Override
    public Collection<Permission> resolvePermissionsInRole(String roleString) {
        if ("role1".equals(roleString)) {
            return Arrays.asList(new WildcardPermission("menu:*"));
        }
        return null;
    }
}

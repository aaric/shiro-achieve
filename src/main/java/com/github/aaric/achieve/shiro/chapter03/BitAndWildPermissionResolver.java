package com.github.aaric.achieve.shiro.chapter03;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.PermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;

/**
 * BitAndWildPermissionResolver
 *
 * @author Aaric, created on 2017-10-03T19:53.
 * @since 1.0-SNAPSHOT
 */
public class BitAndWildPermissionResolver implements PermissionResolver {

    @Override
    public Permission resolvePermission(String permissionString) {
        /**
         * 以 “+”开头来解析权限字符串为 BitPermission
         */
        if(permissionString.startsWith("+")) {
            return new BitPermission(permissionString);
        } else {
            return new WildcardPermission(permissionString);
        }
    }
}

package com.github.aaric.achieve.shiro.chapter06.dao;

import com.github.aaric.achieve.shiro.chapter06.entity.Permission;

/**
 * PermissionDao
 *
 * @author Aaric, created on 2017-10-05T14:55.
 * @since 1.0-SNAPSHOT
 */
public interface PermissionDao {

    Permission createPermission(Permission permission);

    void deletePermission(Long permissionId);
}

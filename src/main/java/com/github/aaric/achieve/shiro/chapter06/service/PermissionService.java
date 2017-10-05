package com.github.aaric.achieve.shiro.chapter06.service;

import com.github.aaric.achieve.shiro.chapter06.entity.Permission;

/**
 * PermissionService
 *
 * @author Aaric, created on 2017-10-05T15:13.
 * @since 1.0-SNAPSHOT
 */
public interface PermissionService {

    Permission createPermission(Permission permission);

    void deletePermission(Long permissionId);
}

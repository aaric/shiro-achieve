package com.github.aaric.achieve.shiro.chapter06.service;

import com.github.aaric.achieve.shiro.chapter06.entity.Role;

/**
 * RoleService
 *
 * @author Aaric, created on 2017-10-05T15:12.
 * @since 1.0-SNAPSHOT
 */
public interface RoleService {

    Role createRole(Role role);

    void deleteRole(Long roleId);

    void correlationPermissions(Long roleId, Long... permissionIds);

    void uncorrelationPermissions(Long roleId, Long... permissionIds);
}

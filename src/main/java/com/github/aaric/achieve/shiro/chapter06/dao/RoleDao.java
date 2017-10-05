package com.github.aaric.achieve.shiro.chapter06.dao;

import com.github.aaric.achieve.shiro.chapter06.entity.Role;

/**
 * RoleDao
 *
 * @author Aaric, created on 2017-10-05T14:54.
 * @since 1.0-SNAPSHOT
 */
public interface RoleDao {

    Role createRole(Role role);

    void deleteRole(Long roleId);

    void correlationPermissions(Long roleId, Long... permissionIds);

    void uncorrelationPermissions(Long roleId, Long... permissionIds);
}

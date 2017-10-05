package com.github.aaric.achieve.shiro.chapter06.service;

import com.github.aaric.achieve.shiro.chapter06.dao.RoleDao;
import com.github.aaric.achieve.shiro.chapter06.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RoleServiceImpl
 *
 * @author Aaric, created on 2017-10-05T15:12.
 * @since 1.0-SNAPSHOT
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    public Role createRole(Role role) {
        return roleDao.createRole(role);
    }

    public void deleteRole(Long roleId) {
        roleDao.deleteRole(roleId);
    }

    public void correlationPermissions(Long roleId, Long... permissionIds) {
        roleDao.correlationPermissions(roleId, permissionIds);
    }

    public void uncorrelationPermissions(Long roleId, Long... permissionIds) {
        roleDao.uncorrelationPermissions(roleId, permissionIds);
    }
}

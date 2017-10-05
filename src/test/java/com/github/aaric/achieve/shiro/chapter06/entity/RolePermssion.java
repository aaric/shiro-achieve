package com.github.aaric.achieve.shiro.chapter06.entity;

import com.github.aaric.achieve.shiro.chapter06.base.BaseEntity;

/**
 * RolePermssion
 *
 * @author Aaric, created on 2017-10-05T14:23.
 * @since 1.0-SNAPSHOT
 */
public class RolePermssion extends BaseEntity {

    private static final long serialVersionUID = -1808885668826617846L;

    private Long roleId;
    private Long permissionId;

    public RolePermssion() {
    }

    public RolePermssion(Long roleId, Long permissionId) {
        this.roleId = roleId;
        this.permissionId = permissionId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
}

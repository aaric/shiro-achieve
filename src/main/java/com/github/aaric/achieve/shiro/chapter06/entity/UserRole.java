package com.github.aaric.achieve.shiro.chapter06.entity;

import com.github.aaric.achieve.shiro.chapter06.base.BaseEntity;

/**
 * UserRole
 *
 * @author Aaric, created on 2017-10-05T14:47.
 * @since 1.0-SNAPSHOT
 */
public class UserRole extends BaseEntity {

    private static final long serialVersionUID = -1606314250803972763L;

    private Long userId;
    private Long roleId;

    public UserRole() {
    }

    public UserRole(Long userId, Long roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}

package com.github.aaric.achieve.shiro.chapter06.entity;

import com.github.aaric.achieve.shiro.chapter06.base.BaseEntity;

/**
 * Permission
 *
 * @author Aaric, created on 2017-10-05T14:03.
 * @since 1.0-SNAPSHOT
 */
public class Permission extends BaseEntity {

    private static final long serialVersionUID = 4107610465960640040L;

    private Long id;
    private String permission;
    private String description;
    private Boolean available = Boolean.FALSE;

    public Permission() {
    }

    public Permission(String permission, String description) {
        this.permission = permission;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}

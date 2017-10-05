package com.github.aaric.achieve.shiro.chapter06.entity;

import com.github.aaric.achieve.shiro.chapter06.base.BaseEntity;

/**
 * Role
 *
 * @author Aaric, created on 2017-10-05T14:21.
 * @since 1.0-SNAPSHOT
 */
public class Role extends BaseEntity {

    private static final long serialVersionUID = 2686631629702379376L;

    private Long id;
    private String role;
    private String description;
    private Boolean available = Boolean.FALSE;

    public Role() {
    }

    public Role(String role, String description) {
        this.role = role;
        this.description = description;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

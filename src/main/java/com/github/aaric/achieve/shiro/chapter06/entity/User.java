package com.github.aaric.achieve.shiro.chapter06.entity;

import com.github.aaric.achieve.shiro.chapter06.base.BaseEntity;

/**
 * User
 *
 * @author Aaric, created on 2017-10-05T14:46.
 * @since 1.0-SNAPSHOT
 */
public class User extends BaseEntity {

    private static final long serialVersionUID = -294060232719569555L;

    private Long id;
    private String username;
    private String password;
    private String salt;
    private Boolean locked = Boolean.FALSE;

    public User() {
    }

    public User(String username, String password, String salt) {
        this.username = username;
        this.password = password;
        this.salt = salt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public String getCredentialsSalt() {
        return username + salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }
}

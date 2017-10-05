package com.github.aaric.achieve.shiro.chapter06.service;

import com.github.aaric.achieve.shiro.chapter06.entity.User;

import java.util.Set;

/**
 * UserService
 *
 * @author Aaric, created on 2017-10-05T15:10.
 * @since 1.0-SNAPSHOT
 */
public interface UserService {

    User createUser(User user);

    void changePassword(Long userId, String newPassword);

    void correlationRoles(Long userId, Long... roleIds);


    void uncorrelationRoles(Long userId, Long... roleIds);

    User findByUsername(String username);

    Set<String> findRoles(String username);

    Set<String> findPermissions(String username);
}

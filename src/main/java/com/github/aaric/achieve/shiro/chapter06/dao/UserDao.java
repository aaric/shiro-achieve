package com.github.aaric.achieve.shiro.chapter06.dao;

import com.github.aaric.achieve.shiro.chapter06.entity.User;

import java.util.Set;

/**
 * UserDao
 *
 * @author Aaric, created on 2017-10-05T14:53.
 * @since 1.0-SNAPSHOT
 */
public interface UserDao {

    User createUser(User user);

    void updateUser(User user);

    void deleteUser(Long userId);

    void correlationRoles(Long userId, Long... roleIds);

    void uncorrelationRoles(Long userId, Long... roleIds);

    User findOne(Long userId);

    User findByUsername(String username);

    Set<String> findRoles(String username);

    Set<String> findPermissions(String username);
}

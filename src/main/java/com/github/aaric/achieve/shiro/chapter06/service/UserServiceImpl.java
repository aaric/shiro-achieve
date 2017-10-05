package com.github.aaric.achieve.shiro.chapter06.service;

import com.github.aaric.achieve.shiro.chapter06.dao.UserDao;
import com.github.aaric.achieve.shiro.chapter06.entity.User;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * UserServiceImpl
 *
 * @author Aaric, created on 2017-10-05T15:11.
 * @since 1.0-SNAPSHOT
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    private String getEncryptString(String password, String salt) {
        return new SimpleHash("md5", password, ByteSource.Util.bytes(salt), 2).toHex();
    }

    public User createUser(User user) {
        user.setSalt(new SecureRandomNumberGenerator().nextBytes().toHex());
        user.setPassword(getEncryptString(user.getPassword(), user.getCredentialsSalt()));
        return userDao.createUser(user);
    }


    public void changePassword(Long userId, String newPassword) {
        User user = userDao.findOne(userId);
        user.setPassword(newPassword);
        user.setPassword(getEncryptString(newPassword, user.getCredentialsSalt()));
        userDao.updateUser(user);
    }


    public void correlationRoles(Long userId, Long... roleIds) {
        userDao.correlationRoles(userId, roleIds);
    }


    public void uncorrelationRoles(Long userId, Long... roleIds) {
        userDao.uncorrelationRoles(userId, roleIds);
    }


    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }


    public Set<String> findRoles(String username) {
        return userDao.findRoles(username);
    }


    public Set<String> findPermissions(String username) {
        return userDao.findPermissions(username);
    }
}

package com.github.aaric.achieve.shiro.chapter05;

import com.github.aaric.achieve.shiro.chapter03.RoleTest;
import org.junit.Ignore;
import org.junit.Test;

/**
 * PasswordTest
 *
 * @author Aaric, created on 2017-10-05T10:22.
 * @since 1.0-SNAPSHOT
 */
public class PasswordTest extends RoleTest {

    @Test
    public void testMyRealm1() {
        login("classpath:chapter05/shiro-passwordservice.ini", "zhang", "123");
    }

    @Test
    @Ignore
    public void testJdbcRealm() {
        login("classpath:chapter05/shiro-passwordservice-jdbc.ini", "zhang", "123");
    }

    @Test
    public void testMyRealm2() {
        login("classpath:chapter05/shiro-hashedCredentialsMatcher.ini", "liu", "123");
    }
}

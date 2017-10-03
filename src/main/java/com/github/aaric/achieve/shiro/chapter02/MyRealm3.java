package com.github.aaric.achieve.shiro.chapter02;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * MyRealm3
 *
 * @author Aaric, created on 2017-10-03T15:42.
 * @since 1.0-SNAPSHOT
 */
public class MyRealm3 implements Realm {

    @Override
    public String getName() {
        return "myrealm1";
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        String password = String.valueOf((char[]) token.getCredentials());

        if(!StringUtils.equals("zhang", username)) {
            throw new UnknownAccountException();
        }
        if(!StringUtils.equals("123", password)) {
            throw new IncorrectCredentialsException();
        }
        return new SimpleAuthenticationInfo("zhang@163.com", password, getName());
    }
}

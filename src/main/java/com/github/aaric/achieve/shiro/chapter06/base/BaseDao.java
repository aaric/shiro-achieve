package com.github.aaric.achieve.shiro.chapter06.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * BaseDao
 *
 * @author Aaric, created on 2017-10-05T14:57.
 * @since 1.0-SNAPSHOT
 */
public abstract class BaseDao {

    @Autowired
    protected JdbcTemplate jdbcTemplate;
}

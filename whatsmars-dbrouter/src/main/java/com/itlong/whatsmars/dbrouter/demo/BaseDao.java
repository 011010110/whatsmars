package com.itlong.whatsmars.dbrouter.demo;

import org.apache.ibatis.session.SqlSession;

/**
 * Author: qing
 * Date: 14-10-12
 */
public abstract class BaseDao {

    protected SqlSession sqlSession;

    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }
}

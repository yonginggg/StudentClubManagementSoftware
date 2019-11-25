package com.zks.Tool;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MybatiesSession {
    public static SqlSession getSession() {
        String resources = "mybatis.cfg.xml";
        Reader reader = null;
        SqlSession session = null;
        try {
            reader = Resources.getResourceAsReader(resources);
            SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
            session = sqlMapper.openSession();

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return session;
    }
}

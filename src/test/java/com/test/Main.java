package com.test;

import com.denny.test.PageUtil;
import com.denny.test.Post;
import com.denny.test.User;
import net.sf.json.JSONArray;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.List;


public class Main {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;

    static {
        try {
            reader = Resources.getResourceAsReader("Configure.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSession() {
        return sqlSessionFactory;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        SqlSession session = sqlSessionFactory.openSession();
        try {

            List<User> list = session.selectList("com.yiibai.userMaper.getUser",new PageUtil(1,3));


            System.out.println("userList" + list);



            JSONArray jsonArray=JSONArray.fromObject(list);

            System.out.println(jsonArray.toString());

            
        } finally {
            session.close();
        }
    }

}

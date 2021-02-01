package com.zdltech.mybatis;

import com.zdltech.mybatis.entity.TUserEntity;
import com.zdltech.mybatis.model.TUserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.List;

public class TUserMapperTest {
    private static SqlSessionFactory sqlSessionFactory;



    public static void main(String[] args)  {
        try {
            two();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void two() throws Exception{
        Reader reader= Resources.getResourceAsReader("mybatis-config.xml");
        sqlSessionFactory =  new SqlSessionFactoryBuilder().build(reader);
        reader.close();
        SqlSession  sqlSession = sqlSessionFactory.openSession();

        try {
            TUserMapper mapper = sqlSession.getMapper(TUserMapper.class);
            List<TUserEntity> list = mapper.selectAll();
            if (list!=null){
                for (TUserEntity item :list) {
                    System.out.println(item.toString());
                }
            }else{
                System.out.println("list is null");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }


    private static void one() throws Exception{
        Reader reader= Resources.getResourceAsReader("mybatis-config.xml");
        sqlSessionFactory =  new SqlSessionFactoryBuilder().build(reader);
        reader.close();
        SqlSession  sqlSession = sqlSessionFactory.openSession();
        try {
            List<TUserEntity> list = sqlSession.selectList("selectAll");
            if (list!=null){
                for (TUserEntity item :list) {
                    System.out.println(item.toString());
                }
            }else{
                System.out.println("list is null");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }
}

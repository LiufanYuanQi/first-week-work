package person.liufan.service.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import person.liufan.service.entity.City;
import person.liufan.service.mapper.CityMapper;
import person.liufan.service.mapper.ProvinceMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/12
 */
public class Mappers {
    private static SqlSession sqlSession = null;

    static {
        String config = "mybatis.xml";
        SqlSessionFactory sqlSessionFactory = null;
        try (InputStream in = Resources.getResourceAsStream(config)) {
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            sqlSessionFactory = sqlSessionFactoryBuilder.build(in);

        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSession = sqlSessionFactory.openSession();
    }

    public static  <T> T getMapper(Class<T> mapperClass) {
        return sqlSession.getMapper(mapperClass);
    }



    public static void myBatisCommit() {
        sqlSession.commit();
    }
}

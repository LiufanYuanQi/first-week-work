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
    public static <T> T getMapper(Class<T> mapperClass) {
        String config = "mybatis.xml";
        T mapper = null;
        try (InputStream in = Resources.getResourceAsStream(config)) {
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            mapper = sqlSession.getMapper(mapperClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mapper;
    }
}

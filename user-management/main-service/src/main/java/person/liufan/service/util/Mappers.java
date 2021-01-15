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
 * 对mybatis操作的封装
 */
public class Mappers {
    private static SqlSession sqlSession = null;

    /**
     * 初始化创建sqlSession
     * */
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
    /**
     * 获取接口动态代理对象
     * @param mapperClass
     * @param <T>
     * @return
     */
    public static  <T> T getMapper(Class<T> mapperClass) {
        return sqlSession.getMapper(mapperClass);
    }
    /**
     * 提交事务
     */
    public static void myBatisCommit() {
        sqlSession.commit();
    }
}

package person.liufan.service.impl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import person.liufan.service.LoginService;
import person.liufan.service.entity.City;
import person.liufan.service.mapper.CityMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/12
 */
public class LoginServiceImpl implements LoginService {
    @Override
    public List<City> listCity() {
        String config = "mybatis.xml";
        InputStream in = null;
        List<City> list = null;
        try {
            in= Resources.getResourceAsStream(config);
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            CityMapper mapper = sqlSession.getMapper(CityMapper.class);
            list = mapper.listCity();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return list;
    }
}

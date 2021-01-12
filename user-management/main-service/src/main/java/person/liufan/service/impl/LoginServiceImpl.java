package person.liufan.service.impl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import person.liufan.service.LoginService;
import person.liufan.service.entity.City;
import person.liufan.service.mapper.CityMapper;
import person.liufan.service.util.Mappers;

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
        List<City> list = Mappers.getCityMapper().listCity();
        return list;
    }
}

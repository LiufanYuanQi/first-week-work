package person.liufan.service.impl;

import person.liufan.service.RegisterService;
import person.liufan.service.entity.User;
import person.liufan.service.mapper.UserMapper;
import person.liufan.service.util.Mappers;

import java.util.List;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/13
 */
public class RegisterServiceImpl implements RegisterService {
    @Override
    public Boolean sava(User user) {
        UserMapper userMapper = Mappers.getMapper(UserMapper.class);
        Integer flag = userMapper.insertSelective(user);
        List<User> list = userMapper.listUser();
        for (User obj : list) {
            System.out.println(obj);
        }
        Mappers.myBatisCommit();
        return flag == 1;
    }
}

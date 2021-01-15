package person.liufan.service.impl;

import person.liufan.service.UserService;
import person.liufan.service.entity.City;
import person.liufan.service.entity.Province;
import person.liufan.service.entity.User;
import person.liufan.service.mapper.CityMapper;
import person.liufan.service.mapper.ProvinceMapper;
import person.liufan.service.mapper.UserMapper;
import person.liufan.service.util.Mappers;
import person.liufan.service.vo.UserDetailVO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/13
 */
public class UserServiceImpl implements UserService {

    {
        UserMapper userMapper = Mappers.getMapper(UserMapper.class);
        this.userMapper = userMapper;
    }
    private UserMapper userMapper;

    @Override
    public Boolean sava(User user) {
        User rest = userMapper.selectByName(user);
        if (rest != null) {
            return false;
        }
        Integer flag = userMapper.insertSelective(user);
        Mappers.myBatisCommit();
        return flag == 1;
    }

    @Override
    public List<User> listUserDetailByName(String name) {
        User user = new User();
        user.setUserName(name);
        List<User> list = userMapper.listUserByName(user);
        return list;
    }

    @Override
    public User getUserById(String id) {
        return userMapper.selectByPrimaryKey(Long.valueOf(id));
    }

    @Override
    public Boolean updateUser(User user) {
        int flag = userMapper.updateByPrimaryKeySelective(user);
        Mappers.myBatisCommit();
        return flag == 1;
    }

    @Override
    public Boolean deleteUserByIds(String[] ids) {
        int flag = userMapper.deleteByIds(ids);
        Mappers.myBatisCommit();
        return flag == 1;
    }


}

package person.liufan.service.impl;

import person.liufan.service.LoginService;
import person.liufan.service.entity.City;
import person.liufan.service.entity.User;
import person.liufan.service.mapper.UserMapper;
import person.liufan.service.util.Mappers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/12
 */
public class LoginServiceImpl implements LoginService {
    private UserMapper userMapper;
    {
        UserMapper userMapper = Mappers.getMapper(UserMapper.class);
        this.userMapper = userMapper;
    }

    @Override
    public Map login(String userName, String password) {
        Map map = new HashMap();
        boolean flag = false;
        User user = new User();
        user.setUserName(userName);
        User rest = userMapper.selectByName(user);
        /*
        * 如果用户存在返回tru及对应user
        * 用户不存在或者错误返回false及提示消息
        * */
        if (rest != null) {
            flag = password.equals(rest.getUserPassword());
            if (flag) {
                map.put("flag", true);
                map.put("user", rest);
                return map;
            }
        }
        map.put("flag", false);
        map.put("message", "账号验证错误");
        return map;
    }
}

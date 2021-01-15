package person.liufan.service.mapper;

import person.liufan.service.entity.User;
import person.liufan.service.vo.UserDetailVO;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> listUserByName(User user);

    int deleteByIds(String[] ids);

    User selectByName(User user);
}
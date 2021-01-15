package person.liufan.service;

import person.liufan.service.entity.User;
import person.liufan.service.vo.UserDetailVO;

import java.util.List;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/13
 *
 * 处理对User相关的业务
 */
public interface UserService {
    /**
     * 通过名字对User进行查询如果，用户名存在不保存
     * 不存在对User进行保存保存成功返回Boolean确认
     * @param user
     * @return
     */
    Boolean sava(User user);

    /**
     * 通过名字模糊查询User，返回list结果
     * @param name
     * @return
     */
    List<User> listUserDetailByName(String name);

    /**
     * 通过id获取User
     * @param id
     * @return
     */
    User getUserById(String id);

    /**
     * 通过id更新User
     * @param user
     * @return
     */
    Boolean updateUser(User user);

    /**
     * 通过ids批量删除User
     * @param ids
     * @return
     */
    Boolean deleteUserByIds(String[] ids);


}

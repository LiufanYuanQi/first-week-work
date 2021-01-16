package person.liufan.service;

import com.github.pagehelper.PageInfo;
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
     * @param user 需要保存的user对象
     * @return 保存成功返回true
     */
    Boolean sava(User user);

    /**
     * 通过名字模糊查询User，返回list结果
     * @param name 需要查询的名字
     * @return 查询到的结果
     */
    PageInfo<User> listUserDetailByName(String name, int pageNum, int pageSize);

    /**
     * 通过id获取User
     * @param id 需要查询的id
     * @return 查询到的结果
     */
    User getUserById(String id);

    /**
     * 通过id更新User
     * @param user 包装好的user对象，其id为需要修改的id，其余为需要更新的字段
     * @return 更新结果
     */
    Boolean updateUser(User user);

    /**
     * 通过ids批量删除User
     * @param ids 需要删除的id数组
     * @return 删除结果
     */
    Boolean deleteUserByIds(String[] ids);


}

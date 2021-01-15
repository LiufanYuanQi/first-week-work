package person.liufan.service.mapper;

import person.liufan.service.entity.User;

import java.util.List;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/15
 */
public interface UserMapper {
    /**
     * 通过主键删除记录
     * @param id id
     * @return 1成功，0失败
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 插入一条记录
     * @param record 记录实体，全部非空
     * @return 1成功，0失败
     */
    int insert(User record);

    /**
     * 选择性插入一条记录
     * @param record 记录实体
     * @return 1成功，0失败
     */
    int insertSelective(User record);

    /**
     * 通过主键查询记录
     * @param id id
     * @return 记录实体
     */
    User selectByPrimaryKey(Long id);

    /**
     * 通过主键选择性更新字段
     * @param record 记录实体
     * @return 1成功，0失败
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * 通过主键更新字段
     * @param record 记录实体
     * @return 1成功，0失败
     */
    int updateByPrimaryKey(User record);

    /**
     * 通过Name模糊查询记录
     * @param user 记录实体，其name为查询条件
     * @return 记录实体集合
     */
    List<User> listUserByName(User user);

    /**
     * 通过主键数组批量删除user
     * @param ids ids
     * @return 1成功，0失败
     */
    int deleteByIds(String[] ids);

    /**
     * 通过name查询具体记录
     * @param user 记录实体，name为查询条件
     * @return 查询结果
     */
    User selectByName(User user);
}
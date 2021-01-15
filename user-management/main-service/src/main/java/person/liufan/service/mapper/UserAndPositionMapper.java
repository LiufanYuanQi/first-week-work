package person.liufan.service.mapper;

import person.liufan.service.entity.UserAndPosition;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/15
 */
public interface UserAndPositionMapper {
    /**
     * 通过主键删除记录
     * @param id id
     * @return 1成功，0失败
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 插入一条记录
     * @param record 记录实体，所有非空
     * @return 1成功，0失败
     */
    int insert(UserAndPosition record);

    /**
     * 选择性插入一条记录
     * @param record 记录实体
     * @return 1成功，0失败
     */
    int insertSelective(UserAndPosition record);

    /**
     * 通过主键查询数据
     * @param id id
     * @return 记录实体
     */
    UserAndPosition selectByPrimaryKey(Long id);

    /**
     * 通过主键选择性更新数据
     * @param record 记录实体
     * @return 1成功，0失败
     */
    int updateByPrimaryKeySelective(UserAndPosition record);

    /**
     * 通过主键更新记录
     * @param record 记录实体，所有非空
     * @return 1成功，0失败
     */
    int updateByPrimaryKey(UserAndPosition record);

    /**
     * 通过用户id获取职位id
     * @param id 用户id
     * @return 职位id
     */
    Long getPositionIdByUserId(Long id);

    /**
     * 通过用户id删除记录
     * @param userId 用户id
     * @return 1成功，0失败
     */
    int deletePositionByUserId(Long userId);

    /**
     * 通过用户id更新一条数据
     * @param userAndPosition 记录实体，包括用户id，职位id
     * @return 1成功，0失败
     */
    int updateByUserId(UserAndPosition userAndPosition);

    /**
     * 通过多个职位id进行删除
     * @param ids 职位的id数组
     * @return 1成功，0失败
     */
    int deleteByPositionIds(String[] ids);
}
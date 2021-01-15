package person.liufan.service.mapper;

import person.liufan.service.entity.Position;

import java.util.List;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/15
 */
public interface PositionMapper {
    /**
     * 通过主键删除记录
     * @param id id
     * @return 1成功，0失败
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 插入记录，所有字段非空
     * @param record 记录实体
     * @return 1成功，0失败
     */
    int insert(Position record);

    /**
     * 选择性插入一条记录
     * @param record 记录实体
     * @return 1成功，0失败
     */
    int insertSelective(Position record);

    /**
     * 通过主键查询记录
     * @param id id
     * @return 记录实体
     */
    Position selectByPrimaryKey(Long id);

    /**
     * 通过主键选择性更新记录
     * @param record 记录实体，其中有id
     * @return 1成功，0失败
     */
    int updateByPrimaryKeySelective(Position record);

    /**
     * 通过主键更新所有字段
     * @param record 记录实体，所有字段非空
     * @return 1成功，0失败
     */
    int updateByPrimaryKey(Position record);

    /**
     * 查询所有记录
     * @return 记录实体集合
     */
    List<Position> listPosition();

    /**
     * 通过id数组删除记录
     * @param ids id数组
     * @return 1成功，0失败
     */
    int deleteByIds(String[] ids);

    /**
     * 通过职位名称查询职位记录
     * @param position 记录
     * @return 实体
     */
    Position selectByName(Position position);
}
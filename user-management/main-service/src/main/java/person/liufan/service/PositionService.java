package person.liufan.service;

import person.liufan.service.entity.Position;

import java.util.List;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/14
 */
public interface PositionService {
    /**
     * 保存一个position
     * @param position 保存的职位对象
     * @return 保存是否成功，成功为true
     */
    Boolean save(String position);

    /**
     * 查询所有的position
     * @return 职位的集合
     */
    List<Position> listPosition();

    /**
     * 通过id更新一个position
     * @param position 需要更新的职位对象，需要其id
     * @return 是否更新成功，成功为true
     */
    Boolean updatePosition(Position position);

    /**
     * 通过id查询对应的position
     * @param id 需要查询的id
     * @return 查询到的position对象
     */
    Position queryPosition(String id);

    /**
     * 通过ids批量删除position并且将关系表中的对应记录删除
     * @param ids 需要删除的id数组
     * @return 是否保存成功，成功为true
     */
    Boolean deleteUserByIds(String[] ids);
}

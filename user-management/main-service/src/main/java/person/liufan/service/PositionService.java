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
     * @param position
     * @return
     */
    Boolean save(String position);

    /**
     * 查询所有的position
     * @return
     */
    List<Position> listPosition();

    /**
     * 通过id更新一个position
     * @param position
     * @return
     */
    Boolean updatePosition(Position position);

    /**
     * 通过id查询对应的position
     * @param id
     * @return
     */
    Position queryPosition(String id);

    /**
     * 通过ids批量删除position并且将关系表中的对应记录删除
     * @param ids
     * @return
     */
    Boolean deleteUserByIds(String[] ids);
}

package person.liufan.service.impl;

import person.liufan.service.PositionService;
import person.liufan.service.entity.Position;
import person.liufan.service.entity.UserAndPosition;
import person.liufan.service.mapper.PositionMapper;
import person.liufan.service.mapper.UserAndPositionMapper;
import person.liufan.service.util.Mappers;

import java.util.List;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/14
 */
public class PositionServiceImpl implements PositionService {
    private PositionMapper positionMapper;
    {
        PositionMapper positionMapper = Mappers.getMapper(PositionMapper.class);
        this.positionMapper = positionMapper;
    }

    @Override
    public Boolean save(String position) {
        Position position1 = new Position();
        position1.setUserPosition(position);
        int flag = positionMapper.insertSelective(position1);
        Mappers.myBatisCommit();
        return flag == 1;
    }

    @Override
    public List<Position> listPosition() {
        return positionMapper.listPosition();
    }

    @Override
    public Position queryPosition(String id) {
        return positionMapper.selectByPrimaryKey(Long.valueOf(id));
    }

    @Override
    public Boolean updatePosition(Position position) {
        int flag = positionMapper.updateByPrimaryKeySelective(position);
        Mappers.myBatisCommit();
        return flag == 1;
    }

    @Override
    public Boolean deleteUserByIds(String[] ids) {
        //删除id对应职位
        int flag = positionMapper.deleteByIds(ids);
        //删除positionid为ids的用户职位关系表中记录
        UserAndPositionMapper userAndPositionMapper = Mappers.getMapper(UserAndPositionMapper.class);
        int flag2 = userAndPositionMapper.deleteByPositionIds(ids);
        Mappers.myBatisCommit();
        return flag + flag2 == 2;
    }
}

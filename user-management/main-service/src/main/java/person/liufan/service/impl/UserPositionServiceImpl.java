package person.liufan.service.impl;

import person.liufan.service.UserPositionService;
import person.liufan.service.entity.Position;
import person.liufan.service.entity.User;
import person.liufan.service.entity.UserAndPosition;
import person.liufan.service.mapper.PositionMapper;
import person.liufan.service.mapper.UserAndPositionMapper;
import person.liufan.service.mapper.UserMapper;
import person.liufan.service.util.Mappers;

import java.util.Date;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/14
 */
public class UserPositionServiceImpl implements UserPositionService {
    private UserMapper userMapper;
    private UserAndPositionMapper uapMapper;
    private PositionMapper positionMapper;
    {
        UserAndPositionMapper uapMapper = Mappers.getMapper(UserAndPositionMapper.class);
        UserMapper userMapper = Mappers.getMapper(UserMapper.class);
        PositionMapper positionMapper = Mappers.getMapper(PositionMapper.class);
        this.uapMapper = uapMapper;
        this.userMapper = userMapper;
        this.positionMapper = positionMapper;
    }
    @Override
    public String queryPositionByUserId(Long id) {
        Long positionId = uapMapper.getPositionIdByUserId(id);
        Position position = positionMapper.selectByPrimaryKey(positionId);
        if (position == null) {
            return "暂无职位";
        }
        return position.getUserPosition();
    }

    @Override
    public Boolean deletePosition(Long userId) {
        int flag = uapMapper.deletePositionByUserId(userId);
        Mappers.myBatisCommit();
        return flag == 1;
    }

    @Override
    public Boolean updatePosition(Long userId,Long positionId) {
        Long rest = uapMapper.getPositionIdByUserId(userId);
        UserAndPosition userAndPosition = new UserAndPosition();
        userAndPosition.setUserId(userId);
        userAndPosition.setPositionId(positionId);
        int flag = 0;
        if (rest == null) {
            flag = uapMapper.insertSelective(userAndPosition);
        } else {

            flag = uapMapper.updateByUserId(userAndPosition);
        }

        Mappers.myBatisCommit();
        return flag == 1;
    }

    @Override
    public void initUserAndPosition() {
        User user = new User();
        user.setUserName("admin");
        User admin = userMapper.selectByName(user);
        if (admin == null) {
            user.setUserPassword("admin");
            user.setUserEmail("admin");
            user.setUserProvince(1);
            user.setUserCity(1L);
            user.setCreateTime(new Date());
            userMapper.insertSelective(user);
            Mappers.myBatisCommit();
            admin = userMapper.selectByName(user);
        }
        Position position = new Position();
        position.setUserPosition("admin");
        Position adminPosition = positionMapper.selectByName(position);
        if (adminPosition == null) {
            positionMapper.insertSelective(position);
            Mappers.myBatisCommit();
            adminPosition = positionMapper.selectByName(position);
        }
        updatePosition(admin.getId(), adminPosition.getId());
        Mappers.myBatisCommit();
    }
}

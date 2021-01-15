package person.liufan.service.mapper;

import person.liufan.service.entity.UserAndPosition;

public interface UserAndPositionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserAndPosition record);

    int insertSelective(UserAndPosition record);

    UserAndPosition selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserAndPosition record);

    int updateByPrimaryKey(UserAndPosition record);

    Long getPositionIdByUserId(Long id);

    int deletePositionByUserId(Long userId);

    int updateByUserId(UserAndPosition userAndPosition);

    int deleteByPositionIds(String[] ids);
}
package person.liufan.service.mapper;

import person.liufan.service.entity.Position;

import java.util.List;

public interface PositionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Position record);

    int insertSelective(Position record);

    Position selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);

    List<Position> listPosition();

    int deleteByIds(String[] ids);

    Position selectByName(Position position);
}
package person.liufan.service.mapper;

import person.liufan.service.entity.Province;

import java.util.List;

public interface ProvinceMapper {
    List<Province> listProvince();

    Integer deleteByPrimaryKey(Integer id);

    Integer insert(Province record);

    Integer insertSelective(Province record);

    Province selectByPrimaryKey(Integer id);

    Integer updateByPrimaryKeySelective(Province record);

    Integer updateByPrimaryKey(Province record);
}
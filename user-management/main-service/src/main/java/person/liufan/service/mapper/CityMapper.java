package person.liufan.service.mapper;

import person.liufan.service.entity.City;

import java.util.List;

public interface CityMapper {
    List<City> listCity();

    Integer deleteByPrimaryKey(Long id);

    Integer insert(City record);

    Integer insertSelective(City record);

    City selectByPrimaryKey(Long id);

    Integer updateByPrimaryKeySelective(City record);

    Integer updateByPrimaryKey(City record);

    List<City> listCityByProvince(Long provinceId);
}
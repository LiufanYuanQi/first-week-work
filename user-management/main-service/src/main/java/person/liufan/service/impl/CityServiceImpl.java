package person.liufan.service.impl;

import person.liufan.service.CityService;
import person.liufan.service.entity.City;
import person.liufan.service.entity.Province;
import person.liufan.service.mapper.CityMapper;
import person.liufan.service.mapper.ProvinceMapper;
import person.liufan.service.util.Mappers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/13
 */
public class CityServiceImpl implements CityService {
    @Override
    public List<City> listCity(Long provinceId) {
        CityMapper cityMapper = Mappers.getMapper(CityMapper.class);
        List<City> cities = cityMapper.listCityByProvince(provinceId);
        return cities;
    }
}

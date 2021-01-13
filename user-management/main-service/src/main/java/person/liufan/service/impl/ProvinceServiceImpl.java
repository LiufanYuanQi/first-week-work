package person.liufan.service.impl;

import person.liufan.service.entity.City;
import person.liufan.service.entity.Province;
import person.liufan.service.mapper.CityMapper;
import person.liufan.service.mapper.ProvinceMapper;
import person.liufan.service.util.Mappers;
import person.liufan.service.ProvinceService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/13
 */
public class ProvinceServiceImpl implements ProvinceService {
    @Override
    public List<Province> listProvince() {
        CityMapper cityMapper = Mappers.getMapper(CityMapper.class);
        ProvinceMapper provinceMapper = Mappers.getMapper(ProvinceMapper.class);
        List<City> cities = cityMapper.listCity();
        List<Province> provinces = provinceMapper.listProvince();
        for (Province province : provinces){
            List<City> list = new ArrayList<>();
            for (City city : cities) {
                if (Integer.valueOf(city.getProvinceId().toString()).equals(province.getId())) {
                    list.add(city);
                }
            }
            province.setCities(list);
        }
        return provinces;
    }
}

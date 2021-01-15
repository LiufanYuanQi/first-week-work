package person.liufan.service;

import person.liufan.service.entity.Province;

import java.util.List;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/13
 */
public interface ProvinceService {

    /**
     * 查询所有的省份
     * @return
     */
    List<Province> listProvince();

    /**
     * 通过省份id和城市id查询对应的省市并返回province/city形式
     * @param provinceId
     * @param cityId
     * @return
     */
    String getProvinceAndCity(Integer provinceId, Long cityId);
}

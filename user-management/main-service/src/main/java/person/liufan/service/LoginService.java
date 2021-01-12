package person.liufan.service;

import person.liufan.service.entity.City;
import person.liufan.service.entity.Province;

import java.util.List;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/12
 *
 * 这个用于完成登录相关的服务
 */
public interface LoginService {
    List<City> listCity();
}

package person.liufan.service;

import person.liufan.service.entity.City;
import person.liufan.service.entity.Province;

import java.util.List;
import java.util.Map;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/12
 *
 * 这个用于完成登录相关的服务
 */
public interface LoginService {
    /**
     * 验证账户
     * @param userName 用户名
     * @param password 用户密码
     * @return map key：flag 为true时存入k"user",v:user对象
     *         flag为false时 存入message：错误信息
     */
    Map login(String userName, String password);
}

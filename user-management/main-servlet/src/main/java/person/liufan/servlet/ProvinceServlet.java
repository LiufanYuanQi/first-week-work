package person.liufan.servlet;

import person.liufan.constant.ServletConsts;
import person.liufan.service.CityService;
import person.liufan.service.ProvinceService;
import person.liufan.service.entity.City;
import person.liufan.service.entity.Province;
import person.liufan.service.impl.CityServiceImpl;
import person.liufan.service.impl.ProvinceServiceImpl;
import person.liufan.util.MyPrintOut;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/12
 *
 * 用于处理获取省份城市ajax请求的servlet
 *
 */
public class ProvinceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String type = request.getParameter(ServletConsts.TYPE);
        /**
         * 返回所有省份
         */
        if (ServletConsts.TYPE_PROVINCE.equals(type)) {
            ProvinceService provinceService = new ProvinceServiceImpl();
            List<Province> list = provinceService.listProvince();
            MyPrintOut.printJson(response,list);
        }
        /**
         * 返回所有的城市
         */
        if (ServletConsts.TYPE_CITY.equals(type)) {
            CityService cityService = new CityServiceImpl();
            Long provinceId = Long.valueOf(request.getParameter("provinceId"));
            List<City> list = cityService.listCity(provinceId);
            MyPrintOut.printJson(response,list);
        }




    }
}

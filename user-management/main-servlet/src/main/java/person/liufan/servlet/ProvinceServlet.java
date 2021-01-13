package person.liufan.servlet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import person.liufan.service.CityService;
import person.liufan.service.entity.City;
import person.liufan.service.entity.Province;
import person.liufan.service.impl.CityServiceImpl;
import person.liufan.service.impl.ProvinceServiceImpl;
import person.liufan.service.ProvinceService;
import person.liufan.util.MyPrintOut;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/12
 *
 * 用于处理获取省份城市ajax请求的servlet
 * 请求路径为/provinces
 * 调用service层返回一个tree型的data返回前端
 *
 */
public class ProvinceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String type = request.getParameter("type");

        if ("province".equals(type)) {
            ProvinceService provinceService = new ProvinceServiceImpl();
            List<Province> list = provinceService.listProvince();
            MyPrintOut.printJson(response,list);
        }
        if ("city".equals(type)) {
            CityService cityService = new CityServiceImpl();
            Long provinceId = Long.valueOf(request.getParameter("provinceId"));
            List<City> list = cityService.listCity(provinceId);
            MyPrintOut.printJson(response,list);
        }




    }
}

package person.liufan.servlet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import person.liufan.service.entity.Province;
import person.liufan.service.impl.ProvinceServiceImpl;
import person.liufan.service.ProvinceService;

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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        ProvinceService provinceService = new ProvinceServiceImpl();
        List<Province> list = provinceService.listProvince();

        ObjectMapper om = new ObjectMapper();
        String json = "{}";
        try {
            json = om.writeValueAsString(list);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(json);
        writer.println(json);
    }
}

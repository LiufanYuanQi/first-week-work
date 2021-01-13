package person.liufan.servlet;

import javafx.scene.input.DataFormat;
import person.liufan.service.RegisterService;
import person.liufan.service.entity.User;
import person.liufan.service.impl.RegisterServiceImpl;
import person.liufan.util.MyPrintOut;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/12
 *
 * 这个servlet用于接收用户注册数据
 * 路径为/user_register
 * 1、对数据进行后端验证
 * 2、验证成功交给service模块保存
 * 3、验证失败返回前端一个友好的页面
 * 4、将service层抛出的异常信息返回前端一个友好的界面
 */
public class UserRegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RegisterService registerService = new RegisterServiceImpl();
        Boolean flag = registerService.sava(toUser(request));
        MyPrintOut.printJson(response,flag);
    }

    /**
     * 对request中的数据进行验证，验证成功包装成User对象用于存储
     * @param request http请求数据
     * @return User对象
     */
    private User toUser(HttpServletRequest request) {
        User user = new User();
        //暂时不进行验证
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String provinceId = request.getParameter("provinceId");
        String cityId = request.getParameter("cityId");
        String hobbies = request.getParameter("hobbies");

        user.setUserName(username);
        user.setUserPassword(password);
        user.setUserEmail(email);
        user.setUserProvince(Integer.valueOf(provinceId));
        user.setUserCity(Long.valueOf(cityId));
        user.setUserHobby(hobbies);
        user.setCreateTime(new Date());

        return user;
    }

}

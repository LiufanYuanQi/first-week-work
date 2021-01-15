package person.liufan.servlet;

import person.liufan.service.LoginService;
import person.liufan.service.UserPositionService;
import person.liufan.service.UserService;
import person.liufan.service.impl.LoginServiceImpl;
import person.liufan.service.impl.UserPositionServiceImpl;
import person.liufan.service.impl.UserServiceImpl;
import person.liufan.util.MyPrintOut;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/12
 *
 * 这个servlet用于接收登录请求
 * 请求路径为/userLogin
 * 对请求参数进行验证，验证成功调用service
 * 验证失败返回前端提示信息
 * 根据service调用结果返回数据
 * 1、调用成功，将查询出的用户信息保存至session域中，跳转至主页。
 * 2、调用失败，service抛出异常，捕获异常，并且将异常信息发送给前端。
 *
 */
public class LoginServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        UserPositionService userPositionService = new UserPositionServiceImpl();
        userPositionService.initUserAndPosition();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        LoginService userService = new LoginServiceImpl();
        /**
         * 登录请求
         * 对传入参数进行验证
         * 验证成功放入session中
         */
        if ("login".equals(type)) {
            String userName = request.getParameter("userName");
            String password = request.getParameter("userPassword");
            Map map = userService.login(userName, password);
            if ((boolean)map.get("flag")) {
                HttpSession session = request.getSession();
                session.setAttribute("user", map.get("user"));
                map.remove("user");
                MyPrintOut.printJson(response,map);
            } else {
                MyPrintOut.printJson(response,map);
            }
         }
    }
}

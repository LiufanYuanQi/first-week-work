package person.liufan.servlet;

import person.liufan.constant.ServletConsts;
import person.liufan.service.LoginService;
import person.liufan.service.UserPositionService;
import person.liufan.service.impl.LoginServiceImpl;
import person.liufan.service.impl.UserPositionServiceImpl;
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
    public void init() {
        UserPositionService userPositionService = new UserPositionServiceImpl();
        userPositionService.initUserAndPosition();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter(ServletConsts.TYPE);
        LoginService userService = new LoginServiceImpl();
        /**
         * 登录请求
         * 对传入参数进行验证
         * 验证成功放入session中
         */
        if (ServletConsts.TYPE_LOGIN.equals(type)) {
            String userName = request.getParameter(ServletConsts.PARAMETER_USER_NAME);
            String password = request.getParameter(ServletConsts.PARAMETER_USER_PASSWORD);
            Map map = userService.login(userName, password);
            if ((boolean)map.get(ServletConsts.LOGIN_RESET)) {
                HttpSession session = request.getSession();
                session.setAttribute(ServletConsts.LOGIN_USER, map.get(ServletConsts.LOGIN_USER));
                map.remove(ServletConsts.LOGIN_USER);
            }
            MyPrintOut.printJson(response,map);
        }
    }
}

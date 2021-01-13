package person.liufan.servlet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import person.liufan.service.LoginService;
import person.liufan.service.entity.City;
import person.liufan.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
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
 * 这个servlet用于接收登录请求
 * 请求路径为/login
 * 对请求参数进行验证，验证成功调用service
 * 验证失败返回前端提示信息
 * 根据service调用结果返回数据
 * 1、调用成功，将查询出的用户信息保存至session域中，跳转至主页。
 * 2、调用失败，service抛出异常，捕获异常，并且将异常信息发送给前端。
 *
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
}

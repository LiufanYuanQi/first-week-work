package person.liufan.servlet;

import javax.servlet.http.HttpServlet;

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

}

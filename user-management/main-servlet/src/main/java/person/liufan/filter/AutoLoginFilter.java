package person.liufan.filter;

import person.liufan.constant.ServletConsts;
import person.liufan.service.entity.User;
import person.liufan.service.impl.LoginServiceImpl;
import person.liufan.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/16
 */
public class AutoLoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * 对login.html过滤，当存在用户和密码cookie时进行验证，验证成功跳转LoginServlet，失败重定向到login.html
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Cookie[] cookies = request.getCookies();
        boolean hasUsername = false;
        boolean hasPassword = false;
        String username = "";
        String password = "";
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if (ServletConsts.PARAMETER_USER_NAME.equals(name)) {
                    username = cookie.getValue();
                    hasUsername = true;
                }
                if (ServletConsts.PARAMETER_USER_PASSWORD.equals(name)) {
                    password = cookie.getValue();
                    hasPassword = true;
                }
            }
        }
        if (hasUsername && hasPassword) {
            Map rest = new LoginServiceImpl().login(username, password);
            if ((boolean) rest.get(ServletConsts.LOGIN_RESET)) {
                HttpSession session = request.getSession();
                session.setAttribute(ServletConsts.LOGIN_USER, rest.get(ServletConsts.LOGIN_USER));
                response.sendRedirect("/static/html/main/usermanagement.html");
            }
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}

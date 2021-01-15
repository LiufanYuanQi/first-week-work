package person.liufan.servlet;

import person.liufan.service.ProvinceService;
import person.liufan.service.UserPositionService;
import person.liufan.service.UserService;
import person.liufan.service.entity.User;
import person.liufan.service.impl.ProvinceServiceImpl;
import person.liufan.service.impl.UserPositionServiceImpl;
import person.liufan.service.impl.UserServiceImpl;
import person.liufan.service.vo.UserDetailVO;
import person.liufan.util.MyPrintOut;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/13
 * <p>
 * 这个servlet用于处理管理用户信息的相关请求
 */
public class UserManagementServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        UserService userService = new UserServiceImpl();
        UserPositionService userPositionService = new UserPositionServiceImpl();
        /**
         * 查询所有的user并且封装成vo返回前端
         */
        if ("queryDetail".equals(type)) {
            List<User> users = userService.listUserDetailByName(request.getParameter("username"));
            List<UserDetailVO> voList = new ArrayList<>();
            for (User obj : users) {
                UserDetailVO vo = new UserDetailVO();
                vo.setId(obj.getId());
                vo.setUserName(obj.getUserName());
                vo.setUserEmail(obj.getUserEmail());
                String provinceAndCity = getProvinceAndCity(obj.getUserProvince(), obj.getUserCity());
                vo.setUserProvinceAndCity(provinceAndCity);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                vo.setCreateTime(simpleDateFormat.format(obj.getCreateTime()));
                String position = userPositionService.queryPositionByUserId(obj.getId());
                vo.setPosition(position);
                voList.add(vo);
            }
            MyPrintOut.printJson(response, voList);
        }
        /**
         * 通过id获取user对应的user对象输出
         */
        if ("queryById".equals(type)) {
            String id = request.getParameter("id");
            User user = userService.getUserById(id);
            MyPrintOut.printJson(response, user);
        }
        /**
         * 将前端传入的参数进行更新
         */
        if ("update".equals(type)) {
            User user = toUser(request);
            Boolean flag = userService.updateUser(user);
            MyPrintOut.printJson(response, flag);
        }
        /**
         * 将前端传来的多个id进行处理，批量删除
         */
        if ("delete".equals(type)) {
            String param = request.getParameter("deleteList");
            String[] ids = param.split("&");
            Boolean flag = userService.deleteUserByIds(ids);
            MyPrintOut.printJson(response, flag);
        }
        /**
         * 通过userid获取对应的职位
         */
        if ("queryPositionById".equals(type)) {
            Long userId = Long.valueOf(request.getParameter("id"));
            String position = userPositionService.queryPositionByUserId(userId);
            MyPrintOut.printJson(response, position);
        }
        /**
         * 通过userid删除对应的用户职位关系
         */
        if ("deleteUserPosition".equals(type)) {
            Long userId = Long.valueOf(request.getParameter("id"));
            Boolean flag = userPositionService.deletePosition(userId);
            MyPrintOut.printJson(response, flag);
        }
        /**
         * 通过userid更新对应的用户职位关系
         */
        if ("updateUserPosition".equals(type)) {
            Long userId = Long.valueOf(request.getParameter("userId"));
            Long positionId = Long.valueOf(request.getParameter("positionId"));

            Boolean flag = userPositionService.updatePosition(userId, positionId);
            MyPrintOut.printJson(response, flag);
        }

    }

    /**
     * 将用户的provinceid和cityid翻译成对应的字符串
     * @param provinceId
     * @param cityId
     * @return province/city形式
     */

    private String getProvinceAndCity(Integer provinceId, Long cityId) {
        ProvinceService provinceService = new ProvinceServiceImpl();
        String provinceAndCity = provinceService.getProvinceAndCity(provinceId, cityId);
        return provinceAndCity;
    }

    /**
     * 对request中的参数进行封装
     * @param request
     * @return 封装好的user
     */
    private User toUser(HttpServletRequest request) {
        User user = new User();
        //暂时不进行验证
        String id = request.getParameter("id");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String provinceId = request.getParameter("provinceId");
        String cityId = request.getParameter("cityId");
        String hobbies = request.getParameter("hobbies");

        user.setId(Long.valueOf(id));
        user.setUserName(username);
        user.setUserPassword(password);
        user.setUserEmail(email);
        user.setUserProvince(Integer.valueOf(provinceId));
        user.setUserCity(Long.valueOf(cityId));
        user.setUserHobby(hobbies);
        user.setUpdateTime(new Date());

        return user;
    }
}

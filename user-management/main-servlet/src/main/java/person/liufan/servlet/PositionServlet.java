package person.liufan.servlet;

import person.liufan.service.PositionService;
import person.liufan.service.entity.Position;
import person.liufan.service.impl.PositionServiceImpl;
import person.liufan.util.MyPrintOut;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/13
 *
 * 这个servlet用于处理职务的增删改查
 */
public class PositionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        PositionService positionService = new PositionServiceImpl();
        /**
         * 保存对应职位
         */
        if ("save".equals(type)) {
            Boolean flag = positionService.save(request.getParameter("position"));
            MyPrintOut.printJson(response, flag);
        }
        /**
         * 查询所有的职位返回list
         */
        if ("queryDetail".equals(type)) {
            List<Position> list = positionService.listPosition();
            MyPrintOut.printJson(response, list);
        }
        /**
         * 通过id查询对应职位
         */
        if ("queryById".equals(type)) {
            Position position = positionService.queryPosition(request.getParameter("id"));
            MyPrintOut.printJson(response,position);
        }
        /**
         * 通过id更新职位
         */
        if ("update".equals(type)) {
            Position position = new Position();
            position.setId(Long.valueOf(request.getParameter("id")));
            position.setUserPosition(request.getParameter("position"));
            Boolean flag = positionService.updatePosition(position);
        }
        /**
         * 通过id删除职位
         */
        if ("delete".equals(type)) {
            String param = request.getParameter("deleteList");
            String[] ids = param.split("&");
            Boolean flag = positionService.deleteUserByIds(ids);
            MyPrintOut.printJson(response, flag);
        }
    }
}

package person.liufan.servlet;

import person.liufan.constant.ServletConsts;
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

    private static final String PARAMETER_ID = "id";
    private static final String PARAMETER_POSITION = "position";
    private static final String PARAMETER_DELETE_LIST = "deleteList";
    private static final String PARAMETER_SPLIT = "&";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter(ServletConsts.TYPE);
        PositionService positionService = new PositionServiceImpl();
        /**
         * 保存对应职位
         */
        if (ServletConsts.TYPE_SAVE.equals(type)) {
            Boolean flag = positionService.save(request.getParameter(PARAMETER_POSITION));
            MyPrintOut.printJson(response, flag);
        }
        /**
         * 查询所有的职位返回list
         */
        if (ServletConsts.TYPE_QUERY_DETAIL.equals(type)) {
            List<Position> list = positionService.listPosition();
            MyPrintOut.printJson(response, list);
        }
        /**
         * 通过id查询对应职位
         */
        if (ServletConsts.TYPE_QUERY_BY_ID.equals(type)) {
            Position position = positionService.queryPosition(request.getParameter(PARAMETER_ID));
            MyPrintOut.printJson(response,position);
        }
        /**
         * 通过id更新职位
         */
        if (ServletConsts.TYPE_UPDATE.equals(type)) {
            Position position = new Position();
            position.setId(Long.valueOf(request.getParameter(PARAMETER_ID)));
            position.setUserPosition(request.getParameter(PARAMETER_POSITION));
            Boolean flag = positionService.updatePosition(position);
        }
        /**
         * 通过id删除职位
         */
        if (ServletConsts.TYPE_DELETE.equals(type)) {
            String param = request.getParameter(PARAMETER_DELETE_LIST);
            String[] ids = param.split(PARAMETER_SPLIT);
            Boolean flag = positionService.deleteUserByIds(ids);
            MyPrintOut.printJson(response, flag);
        }
    }
}

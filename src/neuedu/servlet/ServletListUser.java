package neuedu.servlet;

import neuedu.dao.UserInfoDao;
import neuedu.dao.impl.UserInfoDaoImpl;
import neuedu.entity.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServletListUser", urlPatterns = "/ListUser")
public class ServletListUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserInfoDao userInfoDao = new UserInfoDaoImpl();
        try {
            // 获取数据
            List<UserInfo> list = userInfoDao.queryAll();
            // 数据保存到Session
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("list", list);
            // 页面跳转
            response.sendRedirect("/vipPage.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

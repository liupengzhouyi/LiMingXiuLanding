package neuedu.servlet;

import neuedu.dao.UserInfoDao;
import neuedu.dao.impl.UserInfoDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletDeleteUser", urlPatterns = "/DeleteUser")
public class ServletDeleteUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取表单信息
        String id = request.getParameter("id");
        Integer integer = new Integer(id);
        // 删除
        UserInfoDao userInfoDao = new UserInfoDaoImpl();
        try {
            int key = userInfoDao.delUser(integer);
            System.out.println(key);
            if (key == 0) {
                System.out.println("删除");
                response.sendRedirect("/delete.jsp");
            } else {
                System.out.println("没有删除");
                response.sendRedirect("/error.jsp");
            }
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

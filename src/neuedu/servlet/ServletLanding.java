package neuedu.servlet;

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

@WebServlet(name = "ServletLanding", urlPatterns="/Landing")
public class ServletLanding extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取表单信息
        String username = request.getParameter("username");
        String pass = request.getParameter("pass");

        // 验证用户
        UserInfoDaoImpl userInfoDao = new UserInfoDaoImpl();
        try {
            UserInfo userInfo = userInfoDao.landing(username, pass);
            if (userInfo == null) {
                System.out.println("用户名或者密码错误！");
                response.sendRedirect("/error.jsp");
            } else {
                System.out.println("保存Session");
                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("user", userInfo);
                System.out.println("登陆成功");
                if(userInfo.getType() == 0) {
                    System.out.println("普通用户");
                    response.sendRedirect("/userWelcome.jsp");
                    // userWelcome.jsp
                } else {
                    System.out.println("VIP用户");
                    response.sendRedirect("/ListUser");
                }
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

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

@WebServlet(name = "ServletUpdate", urlPatterns = "/updateUser")
public class ServletUpdate extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        String userID = (String)httpSession.getAttribute("userID");
        String username = request.getParameter("username");
        String type = request.getParameter("type");
        UserInfo userInfo = new UserInfo();
        userInfo.setId(new Integer(userID));
        userInfo.setUsername(username);
        if ("vip".equals(type)) {
            userInfo.setType(1);
        } else {
            userInfo.setType(0);
        }
        // 查看用户名重复
        UserInfoDaoImpl userInfoDao = new UserInfoDaoImpl();
        try {
            boolean key = userInfoDao.selectUser(username);
            if (key) {
                // 重复
                System.out.println("用户名重复");
                response.sendRedirect("/usernameError.jsp");
            } else {
                // 不重复
                System.out.println("用户名不重复");
                // 开始注册
                int registerKey = userInfoDao.updateUser(userInfo);
                System.out.println("registerKey: " + registerKey);
                if (registerKey == 1) {
                    System.out.println("编辑失败");
                    response.sendRedirect("/registeredFailure.jsp");
                } else {
                    System.out.println("编辑成功");
                    response.sendRedirect("/success.jsp");
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

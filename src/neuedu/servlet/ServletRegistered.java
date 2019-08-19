package neuedu.servlet;

import neuedu.dao.impl.UserInfoDaoImpl;
import neuedu.entity.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletRegistered", urlPatterns = "/Registered")
public class ServletRegistered extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取表单信息
        String username = request.getParameter("username");
        String pass = request.getParameter("pass");
        String type = request.getParameter("type");
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(username);
        userInfo.setPass(pass);
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
            } else {
                // 不重复
                System.out.println("用户名不重复");
                // 开始注册
                int registerKey = userInfoDao.addUser(userInfo);
                if (registerKey != 1) {
                    System.out.println("注册失败");
                } else {
                    System.out.println("注册成功");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(userInfo.toString());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

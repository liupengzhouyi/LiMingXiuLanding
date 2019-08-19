package neuedu.servlet;

import neuedu.dao.impl.UserInfoDaoImpl;
import neuedu.entity.UserInfo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Servlet01
 */
@WebServlet("/Servlet01")
public class Servlet01 extends HttpServlet {

    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet01() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String flag = request.getParameter("flag");
		UserInfoDaoImpl impl = new UserInfoDaoImpl();
		if ("zengjia".equals(flag)) {
			String p1 = request.getParameter("username");
			String p2 = request.getParameter("pass");
			
			UserInfo u = new UserInfo();
			u.setUsername(p1);
			u.setPass(p2);
			int i = impl.addUser(u);
			if (i>0) {
				response.getWriter().println("��Ӽ�¼�ɹ�");
			}else{
				response.getWriter().println("��Ӽ�¼ʧ��");
			}
			
		}else if("xiugai".equals(flag)){
			String p1 = request.getParameter("username");
			String p2 = request.getParameter("pass");
			String p3 = request.getParameter("id");
			
			UserInfo u = new UserInfo();
			u.setUsername(p1);
			u.setPass(p2);
			u.setId(Integer.parseInt(p3));
			int i = impl.modifyUser(u);
			
			if (i>0) {
				response.getWriter().println("�޸ļ�¼�ɹ�");
			}else{
				response.getWriter().println("�޸ļ�¼ʧ��");
			}
		}else if("shanchu".equals(flag)){
			String id = request.getParameter("id");
			int i = impl.delUser(Integer.parseInt(id));
			
			if (i>0) {
				response.getWriter().println("ɾ����¼�ɹ�");
			}else{
				response.getWriter().println("ɾ����¼ʧ��");
			}
		}else if("chaxun".equals(flag)){
			String p1 = request.getParameter("username");
			String p2 = request.getParameter("pass");
			
			
			UserInfo u = impl.queryByExample(p1, p2);
			if (u.getId()!=0) {
				request.getSession().setAttribute("currUser", u);//����¼���û�������session��Χ��
				request.getRequestDispatcher("welcome.jsp").forward(request, response);
			}else{
				request.setAttribute("msg", "�û��������벻ƥ��");
				request.getRequestDispatcher("denglu.jsp").forward(request, response);
			}
		}else if("toAddUserPage".equals(flag)){
			response.sendRedirect("adduser.jsp");
		}else if("toUpdateUserPage".equals(flag)){
			response.sendRedirect("modifyuser.jsp");
		}else if("chaxunAll".equals(flag)){
			List<UserInfo> list = impl.queryAll();
			
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("list.jsp").forward(request, response);
		}
	}
}

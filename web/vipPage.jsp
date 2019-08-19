<%@ page import="neuedu.entity.UserInfo" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2019-08-19
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    HttpSession httpSession = request.getSession();
    List<UserInfo> list = (List<UserInfo>) httpSession.getAttribute("list");
    UserInfo userInfo1 = (UserInfo) httpSession.getAttribute("user");
%>

<h1 style="text-align:center">
    不知名网站——用户登陆成功
</h1>
<hr>
<h1 style="text-align:center; color: gold">
    欢迎VIP用户 <%=userInfo1.getUsername()%>访问某不知名网站
</h1>


<table border="1">
    <tr>
        <th>
            用户ID
        </th>
        <th>
            用户名
        </th>
        <th>
            用户类型
        </th>
        <th>
            是否编辑
        </th>
        <th>
            是否删除
        </th>
    </tr>

    <%
        for (UserInfo userInfo : list) {
    %>
    <tr>
        <td>
            <%=userInfo.getId()%>
        </td>
        <td>
            <%=userInfo.getUsername()%>
        </td>
        <td>
            <%
                if (userInfo.getType() == 0) {
            %>
            普通用户
            <%
            } else {
            %>
            VIP用户
            <%
                }
            %>
        </td>
        <td>
            <a href="/DeleteUser?id=<%=userInfo.getId()%>">编辑</a>
        </td>
        <td>
            <a href="/DeleteUser?id=<%=userInfo.getId()%>">删除</a>
        </td>
    </tr>
    <%
        }
    %>

</table>
</body>
</html>


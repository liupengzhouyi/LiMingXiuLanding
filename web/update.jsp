<%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2019-08-19
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="text-align:center">
    不知名网站——编辑
</h1>
<hr>
<%
    HttpSession httpSession = request.getSession();
    httpSession.setAttribute("userID", request.getParameter("id"));
    System.out.println(httpSession.getAttribute("userID").toString());
%>
<form action="/updateUser" method="post">
    <table >
        <tr>
            <th>
                用户名
            </th>
            <td>
                <input type="text" name="username">
            </td>
        </tr>
        <tr>
            <th>
                注册类型
            </th>
            <td>
                管理员：
                <input type="radio" checked="checked" name="type" value="vip" />
                普通用户：
                <input type="radio" name="type" value="user" />
            </td>
        </tr>
        <tr>
            <td>
                <input type="reset" value="重置">
            </td>
            </t>
            <td>
                <input type="submit" value="提交">
            </td>
        </tr>
    </table>
</form>
</body>
</html>

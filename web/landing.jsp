<%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2019-08-19
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="text-align:center">
    不知名网站——登陆
</h1>
<hr>

<form action="/Landing" method="post">
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
                密码
            </th>
            <td>
                <input type="password" name="pass">
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

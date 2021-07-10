<%--
  Created by IntelliJ IDEA.
  User: 屈嘉栋
  Date: 2021/7/9
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/pages/common/head.jsp" %>
<script type="text/javascript">
    $(function () {
        $("#update_username").change(function () {
            var newName = this.value;
            //查询是否可用
            $.getJSON("http://localhost:8080/Book/user", "action=ajaxExistsUsername&username=" + newName, function (data) {
                if (data.existUsername) {
                    $("span.errorMsg").text(" 用户名已存在！");
                } else {
                    $("span.errorMsg").text(" 用户名可用！");
                }
            })
            if (confirm("是否将用户名【" + ${sessionScope.user.username} + "】修改为" + newName + "?")) {
                location.href = "http://localhost:8080/Book/user?action=updateUser&id=${sessionScope.user.id}&username=" + newName;
            } else {
                this.value = this.defaultValue;
            }
        });
    });
</script>
<html>
<head>
    <title>用户信息</title>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">用户信息</span>
</div>
<div id="main">
    <table>
        <tr>
            <td>姓名</td>
            <td>
                <input class="update" id="update_username" width="80px" value="${sessionScope.user.username}">
            </td>
            <td>
                <span class="errorMsg">
                    ${empty requestScope.msg?"":requestScope.msg}
                </span>
            </td>
        </tr>
        <tr>
            <td>密码</td>
            <td>
                <input class="update" id="update_password" width="80px" value="${sessionScope.user.password}">
            </td>
        </tr>
        <tr>
            <td>邮箱</td>
            <td>
                <input class="update" id="update_email" width="80px" value="${sessionScope.user.email}">
            </td>
        </tr>
    </table>
</div>
</body>
</html>

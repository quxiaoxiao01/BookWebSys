<%--
  Created by IntelliJ IDEA.
  User: 屈嘉栋
  Date: 2021/6/1
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <span>欢迎<span class="um_span">
        ${sessionScope.user.username}
    </span>光临尚硅谷书城</span>
    <a href="orderServlet?action=showMyOrder">我的订单</a>
    <a href="user?action=logout">注销</a>&nbsp;&nbsp;
    <a href="javascript:history.back(-1)">返回</a>
</div>
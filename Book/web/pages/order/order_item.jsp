<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 屈嘉栋
  Date: 2021/6/22
  Time: 8:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单详情</title>
    <%@include file="/pages/common/head.jsp" %>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }
    </style>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="../../static/img/logo.gif">
    <span class="wel_word">订单详情</span>
    <div>
        <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临尚硅谷书城</span>
        <a href="javascript:history.back(-1)">返回</a>
    </div>
</div>
<div id="main">

    <table>
        <tr>
            <td>名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>总价</td>
        </tr>
        <c:forEach items="${sessionScope.orderItems}" var="orderItem">
            <tr>
                <td>${orderItem.name}</td>
                <td>${orderItem.count}</td>
                <td>${orderItem.price}</td>
                <td>${orderItem.totalPrice}</td>
            </tr>
        </c:forEach>

<%--        <td>--%>
<%--            <c:choose>--%>
<%--                ${sessionScope.orderStatus}--%>
<%--                <c:when test="${sessionScope.orderStatus > 1}"></c:when>--%>
<%--                <c:when test="${sessionScope.orderStatus > 0}">--%>
<%--                    <a href="orderServlet?action=receiveOrder&orderId=${sessionScope.orderId}">确认收货</a>--%>
<%--                </c:when>--%>
<%--            </c:choose>--%>

<%--        </td>--%>
        <td><a href="orderServlet?action=receiveOrder&orderId=${sessionScope.orderId}">确认收货</a></td>
    </table>
</div>

</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>我的订单</title>
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
    <span class="wel_word">我的订单</span>
    <div>
        <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临尚硅谷书城</span>
    </div>
</div>

<div id="main">

    <table>
        <tr>
            <td>日期</td>
            <td>金额</td>
            <td>状态</td>
            <td>详情</td>
        </tr>
        <c:forEach items="${sessionScope.myOrders}" var="order">
            <tr>
                <td>${order.creatTime}</td>
                <td>${order.price}</td>
                <td>
                    <c:choose>
                        <c:when test="${order.status > 1}">
                            已收货
                        </c:when>
                        <c:when test="${order.status > 0}">
                            已发货
                        </c:when>
                        <c:otherwise>
                            未发货
                        </c:otherwise>
                    </c:choose>
                </td>
                <td><a href="orderServlet?action=showOrderDetail&orderId=${order.orderId}">查看详情</a></td>
            </tr>
        </c:forEach>
    </table>


</div>

<%@include file="/pages/common/foot.jsp" %>
</body>
</html>
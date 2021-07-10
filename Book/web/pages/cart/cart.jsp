<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <%@include file="/pages/common/head.jsp" %>
    <script type="text/javascript">
        $(function () {
            $("delete_buton").click(function () {
                return confirm("是否删除[" + $(this).parent().find("td:first").text() + "]吗?");
            });

            $("#clearCart").click(function () {
                return confirm("是否清空购物车?");
            });
            $(".updateCount").change(function () {
                var name = $(this).parent().parent().find("td:first").text();
                var id = $(this).attr("bookId");
                var count = this.value;
                if (confirm("你确定要将[" + name + "]的数量修改为" + count + "吗?")) {
                    location.href = "http://localhost:8080/Book/cartServlet?action=updateItem&count=" + count + "&id=" + id;
                } else {
                    this.value = this.defaultValue;
                }
            });
        });

    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">购物车</span>
    <%@include file="/pages/common/loginsuccess.jsp" %>
</div>

<div id="main">

    <td>${requestScope.msg}</td>

    <table>
        <tr>
            <td>商品名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>金额</td>
            <td>操作</td>
        </tr>
        <c:if test="${empty sessionScope.cart.items}">
            <tr>
                <td colspan="5"><a href="index.jsp">购物车空空如也,请选购商品吧!</a></td>
            </tr>
        </c:if>
        <c:if test="${not empty sessionScope.cart.items}">
            <c:forEach items="${sessionScope.cart.items}" var="item">
                <tr>
                    <td>${item.value.name}</td>
                    <td>
                        <input class="updateCount" style="width: 80px;"
                               bookId="${item.value.id}"
                               type="text" value="${item.value.count}">
                    </td>
                    <td>${item.value.price}</td>
                    <td>${item.value.totalPrice}</td>
                    <td id="delete_buton"><a href="cartServlet?action=deleteItem&id=${item.value.id}">删除</a></td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
    <c:if test="${not empty sessionScope.cart.items}">
        <div class="cart_info">
            <span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
            <span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
            <span class="cart_span" id="clearCart"><a href="cartServlet?action=clearItem">清空购物车</a></span>
            <span class="cart_span"><a href="orderServlet?action=creatOrder">去结账</a></span>
        </div>
    </c:if>
</div>

<%@include file="/pages/common/foot.jsp" %>
</body>
</html>
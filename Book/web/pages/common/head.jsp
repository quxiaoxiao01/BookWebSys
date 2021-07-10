<%--
  Created by IntelliJ IDEA.
  User: 屈嘉栋
  Date: 2021/6/1
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<base href="http://localhost:8080/Book/">--%>
<%
    String basePath =
            request.getScheme()
            + "://" +
            request.getServerName()
            + ":" +
            request.getServerPort()
            + request.getContextPath()
            + "/";
%>
<%--<%=basePath%>--%>
<base href="<%=basePath%>">
<link type="text/css" rel="stylesheet" href="static/css/style.css">
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>

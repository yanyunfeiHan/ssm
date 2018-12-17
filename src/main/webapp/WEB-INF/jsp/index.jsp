<%@ taglib prefix="t" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/12/3
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/head.jsp"%>
</head>
<body>
    <h1><t:message code="label.msg3" />：Spring Mvc!</h1>
    <br>
    <h3>WEB-INF<t:message code="lable.msg4"/> </h3>
    <a href="${ctx}/input/book/addBook"><t:message code="lable.msg2"/> </a>
    <a href="${ctx}/book/toAdd"><t:message code="label.msg"/> </a>
    <a href="${ctx}/book/list"><t:message code="label.msg1" /></a>
    <a href="${ctx}/book/list1">分页查询返回json格式</a><br>
    <a href="${ctx}/book/querySingleBook">分页查询返回单个对象</a><br>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/12/3
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/head.jsp"%>
</head>
<body>
    <h1>新增书本</h1>
    ${requestScope.message}
    <f:form modelAttribute="book" action="${ctx}/book/add1" method="post">
        书本名称：<f:input path="bookname"/><f:errors path="bookname"/> <br>
        书本价格：<f:input path="price"/><f:errors path="price"/><br>
        书本类型：<f:select path="booktype"><br>
                        <f:options items="${list}" itemLabel="bType" itemValue="bValue"/>
                  </f:select><br>
        <input type="submit" value="添加" >
    </f:form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/12/7
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/head.jsp"%>
</head>
<body>
${requestScope.bookId}
    <form action="${ctx}/bookFile/bookFileUpload" method="post" enctype="multipart/form-data">
        <input type="hidden" name="bookid" value="${requestScope.bookId}">
        <input type="file" name="img">
        <input type="submit" value="上传">
    </form>
</body>
</html>

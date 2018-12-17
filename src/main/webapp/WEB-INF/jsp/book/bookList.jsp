<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/12/6
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/head.jsp"%>
</head>
<body>
    <table width="100%" border="1">
        <tr>
            <th>书本编号</th>
            <th>书本名称</th>
            <th>书本价格</th>
            <th>书本类别</th>
            <th>书本图片</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${list}" var="book">
        <tr>
                <td>${book.bookid}</td>
                <td>${book.bookname}</td>
                <td>${book.price}</td>
                <td>${book.booktype}</td>
                <td>
                    <c:if test="${empty book.fileId}">
                        没有图片
                    </c:if>
                    <c:if test="${not empty book.fileId}">
                        显示图片
                    </c:if>
                        </td>
                <td>
                    <a href="${ctx}/bookFile/toBookFile?bookId=${book.bookid}">上传图片</a>
                    <c:if test="${not empty book.fileId}">
                    <a href="${ctx}/bookFile/download?fileId=${book.fileId}">下载图片</a>
                    </c:if>

            </c:forEach>
        </tr>
    </table>
${pageBean}
</body>
</html>

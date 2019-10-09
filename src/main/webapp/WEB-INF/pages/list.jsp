<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: moocDarker
  Date: 2019/10/9
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach items="${userlist}" var="item">
        <p></p>
        ${item.id}&nbsp;${item.name}&nbsp;${item.password}<br>
    </c:forEach>
</body>
</html>

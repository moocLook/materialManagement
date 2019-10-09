<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>

<a href="userController/findAll">测试查询</a>

<form action="/userController/save">
    id:<<input type="text" name="id">
    name: <input type="text" name="name">
    password<input type="text" name="password">
    <<input type="submit" value="提交">
</form>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/login.css" type="text/css" />
<title>登录</title>
</head>
<body>
	<h1>物流信息管理系统</h1>
	<form action="../logins" method="POST">
		<table>
			<tr><td>账号：<input type="number" name="username" required="required"></td></tr>
			<tr><td>密码：<input type="password" name="password" required="required"></td></tr>
			<tr>
				<td>类型：<input type="radio" name="only" value="1" checked="checked">管理员<input type="radio" name="only" value="2">商家<input type="radio" name="only"value="3">用户</td>
			</tr>
			<tr><td><input type="submit" value="登录"></td></tr>
			<tr><td>没有账号？&nbsp;<a href="marketEnrolJsp.jsp">商家注册</a>&nbsp;&nbsp;<a href="userEnrolJsp.jsp">用户注册</a></td></tr>
		</table>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/userEnrolJsp.css" type="text/css" />
<title>用户注册</title>
</head>
<body>
	<h1>用户注册</h1>
	<form action="../userEnrol" method="post">
		<table>
			<tr>
				<td>用户账号：</td>
				<td><input type="number" name="uid" required="required"></td>
			</tr>
			<tr>
				<td>用户密码：</td>
				<td><input type="text" name="upwd" required="required"></td>
			</tr>
			<tr>
				<td>用户姓名：</td>
				<td><input type="text" name="uname" required="required"></td>
			</tr>
			<tr>
				<td>用户性别：</td>
				<td><input type="text" name="sex" required="required"></td>
			</tr>
			<tr>
				<td>用户生日：</td>
				<td><input type="text" name="year" required="required"></td>
			</tr>
			<tr>
				<td>用户地址：</td>
				<td><input type="text" name="uaddress" required="required"></td>
			</tr>
			<tr>
				<td><button>注册</button></td>
				<td>
					<button>
						<a href="login.jsp" style="color: black">取消</a>
					</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
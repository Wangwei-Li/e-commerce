<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/marketEnrolJsp.css" type="text/css" />
<title>商家注册</title>
</head>
<body>
	<h1>商家注册</h1>
	<form action="../marketEnrol" method="post">
		<table>
			<tr>
				<td>商家账号：</td>
				<td><input type="number" name="mid" required="required"></td>
			</tr>
			<tr>
				<td>商家密码：</td>
				<td><input type="text" name="mpwd" required="required"></td>
			</tr>
			<tr>
				<td>商家名称：</td>
				<td><input type="text" name="mname" required="required"></td>
			</tr>
			<tr>
				<td>商家地址：</td>
				<td><input type="text" name="maddress" required="required"></td>
			</tr>
			<tr>
				<td><button>注册</button></td>
				<td>
					<button>
						<a href="login.jsp" style="color: black;">取消</a>
					</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
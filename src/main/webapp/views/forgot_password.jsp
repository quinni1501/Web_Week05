<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quên Mật Khẩu</title>
<style>
body {
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	flex-direction: column;
	font-family: Arial, sans-serif;
	background-color: #f0f0f0;
}

form {
	display: flex;
	flex-direction: column;
	width: 300px;
}

input {
	margin-bottom: 10px;
	padding: 10px;
	font-size: 16px;
}

button {
	padding: 10px;
	background-color: #007bff;
	color: white;
	border: none;
	cursor: pointer;
	border-radius: 5px;
	font-size: 16px;
}

button:hover {
	background-color: #0056b3;
}

.error {
	color: red;
}
</style>
</head>
<body>
	<h1>Quên Mật Khẩu</h1>
	<form action="${pageContext.request.contextPath}/forgot-password"
		method="post">
		<input type="text" name="username" placeholder="Tên đăng nhập"
			required> <input type="password" name="newPassword"
			placeholder="Mật khẩu mới" required> <input type="password"
			name="confirmPassword" placeholder="Nhập lại mật khẩu" required>
		<button type="submit">Đặt lại mật khẩu</button>
	</form>
	<c:if test="${not empty error}">
		<div class="error">${error}</div>
	</c:if>
</body>
</html>

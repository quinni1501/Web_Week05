<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome Page</title>
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

h1 {
	color: #333;
}

button {
	margin-top: 20px;
	padding: 10px 20px;
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
</style>
</head>
<body>
	<h1>Welcome To My Web</h1>

	<!-- Nút Đăng xuất -->
	<form action="/logout" method="post">
		<button type="submit">Đăng xuất</button>
	</form>
</body>
</html>

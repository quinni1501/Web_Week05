<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Tạo tài khoản mới</title>
<style>
body {
	font-family: Arial, sans-serif;
}

.form-container {
	width: 300px;
	margin: auto;
	padding: 20px;
	border: 1px solid #ccc;
	background-color: #f9f9f9;
	border-radius: 8px;
}

input[type=text], input[type=password], input[type=email], input[type=tel]
	{
	width: 100%;
	padding: 10px;
	margin: 8px 0;
	box-sizing: border-box;
}

input[type=submit] {
	width: 100%;
	background-color: #007BFF;
	color: white;
	padding: 10px;
	border: none;
	border-radius: 4px;
}

input[type=submit]:hover {
	background-color: #0056b3;
}

.alert {
	color: red;
	text-align: center;
}
</style>
</head>
<body>
	<div class="form-container">
		<h2>Tạo tài khoản mới</h2>

		<c:if test="${not empty alert}">
			<div class="alert">${alert}</div>
		</c:if>

		<form action="${pageContext.request.contextPath}/register"
			method="post">
			<label for="username">Tên tài khoản</label> <input type="text"
				id="username" name="username" required> <label
				for="fullname">Họ tên</label> <input type="text" id="fullname"
				name="fullname" required> <label for="email">Nhập
				Email</label> <input type="email" id="email" name="email" required>

			<label for="phone">Số điện thoại</label> <input type="tel" id="phone"
				name="phone" required> <label for="password">Mật
				khẩu</label> <input type="password" id="password" name="password" required>

			<label for="confirm_password">Nhập lại mật khẩu</label> <input
				type="password" id="confirm_password" name="confirm_password"
				required> <input type="submit" value="Tạo tài khoản">
		</form>
		<p>
			Nếu bạn đã có tài khoản? <a
				href="/Week05/login">Đăng nhập</a>
		</p>

	</div>
</body>
</html>

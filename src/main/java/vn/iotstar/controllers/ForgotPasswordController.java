package vn.iotstar.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IUserService;
import vn.iotstar.services.impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/forgot-password" })
public class ForgotPasswordController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private IUserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("views/forgot_password.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String newPassword = req.getParameter("newPassword");
		String confirmPassword = req.getParameter("confirmPassword");

		if (!newPassword.equals(confirmPassword)) {
			req.setAttribute("error", "Mật khẩu và xác nhận mật khẩu không khớp.");
			req.getRequestDispatcher("forgot_password.jsp").forward(req, resp);
			return;
		}

		UserModel user = userService.findByUserName(username);
		if (user == null) {
			req.setAttribute("error", "Tên đăng nhập không tồn tại.");
			req.getRequestDispatcher("forgot_password.jsp").forward(req, resp);
			return;
		}

		user.setPassword(newPassword);
		userService.restPassword(user);

		resp.sendRedirect(req.getContextPath() + "/login");
	}

}

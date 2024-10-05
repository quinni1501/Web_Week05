package vn.iotstar.controllers.admin;

import java.io.File;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import vn.iotstar.models.CategoryModel;
import vn.iotstar.services.ICategoryService;
import vn.iotstar.services.impl.CategoryServiceImpl;

@MultipartConfig()
@WebServlet(urlPatterns = { "/admin/categories", "/admin/category/add", "/admin/category/insert",
		"/admin/category/delete", "/admin/category/edit", "/admin/category/update" })
public class CategoryController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public ICategoryService cateService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String url = req.getRequestURI();
		if (url.contains("/admin/category/add")) {
			req.getRequestDispatcher("/views/admin/category-add.jsp").forward(req, resp);

		} else if (url.contains("/admin/categories")) {
			List<CategoryModel> list = cateService.findAll();
			req.setAttribute("listcate", list);
			req.getRequestDispatcher("/views/admin/category-list.jsp").forward(req, resp);
		} else if (url.contains("/admin/category/delete")) {
			int id = Integer.parseInt(req.getParameter("id"));
			cateService.delete(id);
			resp.sendRedirect(req.getContextPath() + "/admin/categories");
		} else if (url.contains("/admin/category/edit")) {
			int id = Integer.parseInt(req.getParameter("id"));
			CategoryModel category = cateService.findById(id);
			req.setAttribute("cate", category);
			req.getRequestDispatcher("/views/admin/category-edit.jsp").forward(req, resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String url = req.getRequestURI();
		if (url.contains("/admin/category/insert")) {
			// lay du lieu tu view
			String categoryname = req.getParameter("categoryname");
			int status = Integer.parseInt(req.getParameter("status"));
			String images = req.getParameter("images");

			// dua vao model
			CategoryModel category = new CategoryModel();
			category.setCategoryname(categoryname);
			category.setStatus(status);

			// xu ly upload file
			String fname = "";
			String uploadPath = "C:\\WebProgramming\\upload";
			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists()) {
				uploadDir.mkdir();
			}
			try {
				Part part = req.getPart("images1");
				if (part.getSize() > 0) {
					String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
					// doi ten file
					int index = filename.lastIndexOf(".");
					String ext = filename.substring(index + 1);
					fname = System.currentTimeMillis() + "." + ext;

					// upload file
					part.write(uploadPath + "/" + fname);
					// ghi ten file vao data
					category.setImages(fname);
				} else if (images != null) {
					category.setImages(images);
				} else {
					category.setImages("avata.png");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			// truyen model vao insert
			cateService.insert(category);

			// tra ve view
			resp.sendRedirect(req.getContextPath() + "/admin/categories");

		} else if (url.contains("/admin/category/update")) {
			try {
				// Lấy dữ liệu từ form
				int categoryid = Integer.parseInt(req.getParameter("categoryid"));
				String categoryname = req.getParameter("categoryname");
				int status = Integer.parseInt(req.getParameter("status"));

				// Tạo đối tượng CategoryModel và gán các giá trị
				CategoryModel category = new CategoryModel();
				category.setCategoryid(categoryid);
				category.setCategoryname(categoryname);
				category.setStatus(status);

				// Lấy thông tin danh mục cũ để so sánh
				CategoryModel cateold = cateService.findById(categoryid);
				String fileold = cateold.getImages(); // Lấy tên ảnh cũ để giữ lại nếu không có ảnh mới

				// Kiểm tra nếu có ảnh mới được upload
				Part part = req.getPart("images1");
				if (part != null && part.getSize() > 0) {
					// Xử lý upload file mới
					String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
					int index = filename.lastIndexOf(".");
					String ext = filename.substring(index + 1);
					String fname = System.currentTimeMillis() + "." + ext;

					// Upload file
					String uploadPath = "C:\\WebProgramming\\upload";
					File uploadDir = new File(uploadPath);
					if (!uploadDir.exists()) {
						uploadDir.mkdir();
					}
					part.write(uploadPath + "/" + fname);

					// Ghi tên file mới vào đối tượng danh mục
					category.setImages(fname);
				} else {
					// Nếu không upload ảnh mới, giữ lại ảnh cũ
					category.setImages(fileold);
				}

				// Cập nhật danh mục vào cơ sở dữ liệu
				cateService.update(category);

				// Redirect về trang danh sách danh mục
				resp.sendRedirect(req.getContextPath() + "/admin/categories");
			} catch (Exception e) {
				e.printStackTrace();
				// Bạn có thể xử lý lỗi và trả về thông báo cho người dùng
			}
		}
	}

}

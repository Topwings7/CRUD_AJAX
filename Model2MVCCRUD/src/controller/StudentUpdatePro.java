package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Service;
import service.StudentUpdateService;

public class StudentUpdatePro extends HttpServlet{
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		Service service = new StudentUpdateService();
		service.excecute(req, resp);
		req.getRequestDispatcher("WEB-INF/st/updateResult.jsp").forward(req, resp);
	}
}

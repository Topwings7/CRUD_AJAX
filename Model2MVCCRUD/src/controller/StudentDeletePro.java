package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Service;
import service.StudentDeleteService;

public class StudentDeletePro extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Service service = new StudentDeleteService();
		service.excecute(req, resp);
		req.getRequestDispatcher("WEB-INF/st/deleteResult.jsp").forward(req, resp);
	}
}

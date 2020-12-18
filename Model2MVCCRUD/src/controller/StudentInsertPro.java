package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Service;
import service.StudentInsertService;

public class StudentInsertPro extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Service service = new StudentInsertService();
		service.excecute(req, resp);
		req.getRequestDispatcher("/WEB-INF/st/insertResult.jsp").forward(req, resp);
	}
}

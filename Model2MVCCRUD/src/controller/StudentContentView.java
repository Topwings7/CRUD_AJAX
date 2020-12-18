package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Service;
import service.StudentContentService;

public class StudentContentView extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doAction(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		doAction(req, resp);
	}
	private void doAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Service service = new StudentContentService();
		service.excecute(req, resp);
		req.getRequestDispatcher("WEB-INF/st/contentView.jsp").forward(req, resp);
	}
	
}

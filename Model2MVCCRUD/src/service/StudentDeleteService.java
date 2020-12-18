package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;

public class StudentDeleteService implements Service{

	@Override
	public void excecute(HttpServletRequest req, HttpServletResponse resp) {
		int id = Integer.parseInt(req.getParameter("id"));
		StudentDao dao = StudentDao.getInstance();
		req.setAttribute("deleteResult", dao.deleteStudent(id));
		
	}

}

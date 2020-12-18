package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import dto.StudentDto;

public class StudentContentService implements Service{

	@Override
	public void excecute(HttpServletRequest req, HttpServletResponse resp) {
		int id = Integer.parseInt(req.getParameter("id"));
		StudentDao sDao = StudentDao.getInstance();
		req.setAttribute("st", sDao.getStudent(id));
		
	}
	
}

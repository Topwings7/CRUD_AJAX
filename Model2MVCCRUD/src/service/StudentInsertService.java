package service;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import dto.StudentDto;

public class StudentInsertService implements Service{

	@Override
	public void excecute(HttpServletRequest req, HttpServletResponse resp) {
		int id = 0;
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String address = req.getParameter("address");
		String phone = req.getParameter("phone");
		LocalDate birth_date = LocalDate.parse(req.getParameter("date"));
		int grade = Integer.parseInt(req.getParameter("grade"));
		StudentDto st = new StudentDto(id, name, age, address, phone, birth_date, grade);
		StudentDao dao = StudentDao.getInstance();
		req.setAttribute("insertresult", dao.insertStudent(st));
		
	}
}

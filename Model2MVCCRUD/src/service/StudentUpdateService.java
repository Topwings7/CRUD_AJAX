package service;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import dto.StudentDto;

public class StudentUpdateService implements Service{

	@Override
	public void excecute(HttpServletRequest req, HttpServletResponse resp) {
		StudentDto st = new StudentDto();
		st.setId(Integer.parseInt(req.getParameter("id")));
		st.setName(req.getParameter("name"));
		st.setAge(Integer.parseInt(req.getParameter("age")));
		st.setAddress(req.getParameter("address"));
		st.setPhone(req.getParameter("phone"));
		st.setBirth_date(LocalDate.parse(req.getParameter("birth_date")));
		st.setGrade(Integer.parseInt(req.getParameter("grade")));
		StudentDao dao = StudentDao.getInstance();
		req.setAttribute("updateResult", dao.updateStudent(st));
	}

}

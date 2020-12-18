package service;

import java.util.ArrayList;

import dao.StudentDao;
import dto.StudentDto;

public class StudentService {
	public ArrayList<StudentDto> getStudents(){
		StudentDao stDao = StudentDao.getInstance();
		ArrayList<StudentDto> stlist = stDao.selectStudentList();
		return stlist;
	}
}

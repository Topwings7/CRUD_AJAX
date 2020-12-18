package test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import dao.StudentDao;

class dao {
	@Test
	void test() {
		StudentDao dao = StudentDao.getInstance();
		assertNotNull(dao.getStudent(4)); 
	}
	@Test
	void test1() {
		StudentDao dao = StudentDao.getInstance();
		assertNotNull(dao.getStudent(99)); 
	}
}


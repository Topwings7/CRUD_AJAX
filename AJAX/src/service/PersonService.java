package service;

import java.sql.Connection;
import java.util.Collections;
import java.util.List;

import conn.Conn;
import person.PersonDao;
import person.PersonDto;

public class PersonService {
	private PersonDao personDao;
	
	public PersonService() {
		personDao = PersonDao.getInstance();
	}
	
	public PersonDto getPersonById(int id) {
		PersonDto p = null;
		try (Connection conn = Conn.getConn()){
			p = personDao.selectOne(conn, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	public List<PersonDto> getPersonList() {
		List<PersonDto> pList = Collections.emptyList();
		try (Connection conn = Conn.getConn()){
			pList = personDao.selectPersonAll(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pList;
	}
}

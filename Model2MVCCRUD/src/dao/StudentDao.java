package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

import conn.Conn;
import dto.StudentDto;

public class StudentDao {
	private static StudentDao instance = new StudentDao();
	private  StudentDao() {}
	public static StudentDao getInstance() {
		return instance;
	}
	public ArrayList<StudentDto> selectStudentList(){
		ArrayList<StudentDto> stList = new ArrayList<StudentDto>();
		String sql = "select id, name, age, address, phone, birth_date, grade from student";
		try (Connection conn = Conn.getConn();
			 PreparedStatement pst = conn.prepareStatement(sql);
			 ResultSet rs = pst.executeQuery()){
			while(rs.next()) {
				int 	  id 	 	 = rs.getInt("id");
				String 	  name    	 = rs.getString("name");
				int 	  age     	 = rs.getInt("age");
				String    address 	 = rs.getString("address");
				String    phone   	 = rs.getString("phone");
				LocalDate birth_date = rs.getDate("birth_date").toLocalDate();
				int		  grade      = rs.getInt("grade");
				StudentDto stDto = new  StudentDto(id, name, age, address, phone, birth_date, grade);
				stList.add(stDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stList;
	}
	public int insertStudent(StudentDto st) {
		int result = 0;
		String sql = "insert into student values(?,?,?,?,?,?,?)";
		try (Connection conn = Conn.getConn();
			PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setInt(1, st.getId());
			pst.setString(2, st.getName());
			pst.setInt(3, st.getAge());
			pst.setString(4, st.getAddress());
			pst.setString(5, st.getPhone());
			pst.setDate(6, Date.valueOf(st.getBirth_date()));
			pst.setInt(7, st.getGrade());
			result = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public StudentDto getStudent(int id) {
		StudentDto st = null;
		String sql = "select id, name, age, address, phone, birth_date, grade from student where id=?";
		try(Connection conn = Conn.getConn();
			PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setInt(1, id);
			try (ResultSet rs = pst.executeQuery()){
				st = new StudentDto();
				if(rs.next()) {
					st.setId(id);
					st.setName(rs.getString("name"));
					st.setAge(rs.getInt("age"));
					st.setAddress(rs.getString("address"));
					st.setPhone(rs.getString("phone"));
					st.setBirth_date(rs.getDate("birth_date").toLocalDate());
					st.setGrade(rs.getInt("grade"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return st;
	}
	public int updateStudent(StudentDto st) {
		int result = 0;
		String sql="update student set id=?, name=?, age=?, address=?, phone=?, birth_date=?, grade=? where id=?";
		try (Connection conn = Conn.getConn();
			 PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setInt(1, st.getId());
			pst.setString(2, st.getName());
			pst.setInt(3, st.getAge());
			pst.setString(4, st.getAddress());
			pst.setString(5, st.getPhone());
			pst.setDate(6, Date.valueOf(st.getBirth_date()));
			pst.setInt(7, st.getGrade());
			pst.setInt(8, st.getId());
			result = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public int deleteStudent(int id) {
		int result = 0;
		String sql = "delete from student where id=?";
		try(Connection conn = Conn.getConn();
			PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setInt(1, id);
			result = pst.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}

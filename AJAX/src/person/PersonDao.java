package person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PersonDao {
	private static PersonDao instance = new PersonDao();
	private PersonDao() {}
	public static PersonDao getInstance() {
		return instance;
	}
	//id를 인자로 받아 한명의 정보를 가져오는메서드
	
	public PersonDto selectOne(Connection conn, int id) { //서비스에서 넘겨야한다
		String sql = "select id, name, age from person where id=?";
		PersonDto person = null;
		try(PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setInt(1, id);
			
			try (ResultSet rs = pst.executeQuery()){
				if(rs.next()) {
					person = new PersonDto(rs.getInt("id"),rs.getString("name"),rs.getInt("age"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return person;
	}
	public ArrayList<PersonDto> selectPersonAll(Connection conn) {
		ArrayList<PersonDto> pList = new ArrayList<PersonDto>();
		String sql = "select * from person";
		try(PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery()) {
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				PersonDto p = new PersonDto(id, name, age);
				pList.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pList;
	}
}

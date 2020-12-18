<%@page import="java.io.IOException"%>
<%@page import="crud.UserDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="crud.MyConnector"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		try (Connection conn = MyConnector.getConn(); Statement st = conn.createStatement()) {
		String sql = "select * from user";
		try (ResultSet rs = st.executeQuery(sql)) {
			ArrayList<UserDto> userList = new ArrayList<UserDto>();

			while (rs.next()) {
		userList.add(new UserDto(rs.getInt("id"), rs.getString("user_id"), rs.getString("password"),
				rs.getString("name"), rs.getString("phone"), rs.getString("address"),
				rs.getDate("birth_date").toLocalDate(), rs.getTimestamp("reg_date").toLocalDateTime()));
			}
			//request에 결과를 담음
			request.setAttribute("userList", userList);
			//결과정보를 userList로 보냄
			request.getRequestDispatcher("userList.jsp").forward(request, response);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	%>
</body>
</html>
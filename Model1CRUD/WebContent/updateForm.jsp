<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="crud.MyConnector"%>
<%@page import="crud.UserDto"%>
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
	int id = Integer.parseInt(request.getParameter("id"));
	System.out.print(id);
	UserDto user = new UserDto();
	String sql = "select * from user where id = ?";
	try(Connection conn = MyConnector.getConn();
		PreparedStatement pst = conn.prepareStatement(sql)){
		
		pst.setInt(1, id);
		
		try(ResultSet rs = pst.executeQuery()){
			if(rs.next()){
				user = new UserDto(
						rs.getInt("id"),
						rs.getString("user_id"),
						rs.getString("password"),
						rs.getString("name"),
						rs.getString("phone"),
						rs.getString("address"),
						rs.getDate("birth_date").toLocalDate(),
						rs.getTimestamp("reg_date").toLocalDateTime()
						);
				request.setAttribute("user", user);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
%>
<h3>사용자 정보 수정</h3>
<form action="updateUserProc.jsp" method="post">
	<input type="hidden" name="id" value="${user.id }">
	<input type="text" name="userId" value="${user.userId }">
	<input type="password" name="password" value="${user.password }">
	<input type="text" name="name" value="${user.name }">
	<input type="text" name="phone" value="${user.phone }">
	<input type="text" name="address"  value="${user.address }">
	<input type="date" name="birthDat" value="${user.birthDate }">
	<input type="date" name="regDat" value="${user.regDate }">
	<input type="submit" value="수정">
</form>
</body>
</html>
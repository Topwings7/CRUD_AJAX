<%@page import="crud.UserDto"%>
<%@page import="java.sql.Date"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="crud.MyConnector"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.LocalDate"%>
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
	
	UserDto user = new UserDto();
	user.setUserId(request.getParameter("userId"));
	user.setPassword(request.getParameter("password"));
	user.setName(request.getParameter("name"));
	user.setPhone(request.getParameter("phone"));
	user.setAddress(request.getParameter("address"));
	LocalDate birthDate = LocalDate.parse(request.getParameter("birthDat"));
	LocalDateTime regDate = LocalDateTime.now();
	user.setBirthDate(birthDate);
	user.setRegDate(regDate);
	System.out.println(user);
	String sql = "insert into user(id, user_id, password,"
			+"name, phone, address, birth_date, reg_date)"
			+"values(?,?,?,?,?,?,?,?)";
	
	try(Connection conn = MyConnector.getConn();
			PreparedStatement pst = conn.prepareStatement(sql)){
				
			
			pst.setInt(1, user.getId());
			pst.setString(2, user.getUserId());
			pst.setString(3, user.getPassword());
			pst.setString(4, user.getName());
			pst.setString(5, user.getPhone());
			pst.setString(6, user.getAddress());
			pst.setDate(7, Date.valueOf(user.getBirthDate()));
			pst.setTimestamp(8, Timestamp.valueOf(user.getRegDate()));
			
			pst.execute();
			request.setAttribute("result", "삽입 성공");
			}catch(SQLException e){
				e.printStackTrace();
				request.setAttribute("result", "삽입 실패");
			}
			request.getRequestDispatcher("view.jsp").forward(request, response);
			
%>
</body>
</html>
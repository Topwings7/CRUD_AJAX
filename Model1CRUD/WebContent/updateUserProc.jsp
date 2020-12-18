<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.Date"%>
<%@page import="java.sql.SQLException"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.Catch"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.sql.PreparedStatement"%>
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
	<jsp:useBean id="user" class="crud.UserDto"/>
	<jsp:setProperty property="*" name="user"/>
	<%
	request.setCharacterEncoding("utf-8");
	user.setBirthDate(LocalDate.parse(request.getParameter("birthDat")));
	user.setRegDate(LocalDateTime.now());
		String sql ="update user set user_id=?, password=?, name=?," 
				+" phone=?, address=?, birth_date=?, reg_date=? where id=?";
		try(Connection conn = MyConnector.getConn();
			PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setString(1, user.getUserId());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getName());
			pst.setString(4, user.getPhone());
			pst.setString(5, user.getAddress());
			pst.setDate(6, Date.valueOf(user.getBirthDate()));
			pst.setTimestamp(7, Timestamp.valueOf(user.getRegDate()));
			pst.setInt(8, user.getId());	
			
			int rs = pst.executeUpdate();
			if(rs==1){
				%>
				<script>
				alert("수정성공")
				location.href="index.jsp";
				</script>
			<%}else{%>
				<script>
				alert("수정성공")
				</script>
			<%}
		}catch(SQLException e){
			e.printStackTrace();
		}
	%>
</body>
</html>
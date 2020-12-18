<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<caption>유저정보 리스트</caption>
		<thead>
		<tr>
			<th>id</th>
			<th>유저아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>폰번호</th>
			<th>주소</th>
			<th>생일</th>
			<th>등록날짜</th>
		</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${userList }">
			<tr>
				<td>${user.id }</td>
				<td><a href="updateForm.jsp?id=${user.id }">${user.userId }</a></td>
				<td>${user.password }</td>
				<td>${user.name }</td>
				<td>${user.phone }</td>
				<td>${user.address }</td>
				<td>${user.birthDate }</td>
				<td>${user.regDate }</td>
			</tr>
			 </c:forEach>
		</tbody>
	</table>
</body>
</html>
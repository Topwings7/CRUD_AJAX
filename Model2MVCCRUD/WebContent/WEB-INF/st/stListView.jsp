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
	<c:forEach var="st" items="${stlist }">
	<a href="/contentview.do?&id=${st.id }">${st.id }</a><br>
		${st.name }<br>
		${st.age }<br>
		${st.address }<br>
		${st.phone }<br>
		${st.birth_date }<br>
		${st.grade }<br>
		<hr>
	</c:forEach>
	<a href="/inputView.do">등록폼 </a>
</body>
</html>
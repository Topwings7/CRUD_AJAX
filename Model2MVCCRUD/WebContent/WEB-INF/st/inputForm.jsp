<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/inputPro.do" method="get">
		<input type="text" name="name" placeholder="이름"><br>
		<input type="number" name="age" placeholder="나이"><br>
		<input type="text" name="address" placeholder="주소"><br>
		<input type="text" name="phone" placeholder="전화번호"><br>
		<input type="date" name="date" placeholder="생일"><br>
		<input type="number" name="grade" placeholder="학년"><br>
		<button>전송</button>
	</form>
</body>
</html>
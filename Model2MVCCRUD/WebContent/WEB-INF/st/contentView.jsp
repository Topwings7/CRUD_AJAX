<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/StudentUpdatePro.do" method="post">
	<table>
		<tr>
			<td>아이디</td><td> <input type="number" name="id" value="${st.id }"></td>
		</tr>
		<tr>
			<td>name</td><td> <input type="text" name="name" value="${st.name }"></td>
		</tr>
		<tr>
			<td>age</td><td> <input type="number" name="age" value="${st.age }"></td>
		</tr>
		<tr>
			<td>address</td><td> <input type="text" name="address" value="${st.address }"></td>
		</tr>
		<tr>
			<td>phone</td><td> <input type="text" name="phone" value="${st.phone }"></td>
		</tr>
		<tr>
			<td>birth_date</td><td> <input type="date" name="birth_date" value="${st.birth_date }"></td>
		</tr>
		<tr>
			<td>grade</td><td> <input type="number" name="grade" value="${st.grade }"></td>
		</tr>
		<tr><td> <button>수정</button> </td> </tr>
	</table>
	</form>
		<button onclick="location.href='/delete.do?id=${st.id}'">삭제</button>
		<button onclick="location.href='/main.do'">목록</button>		
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	setTimeout(() => {
		location.href="/contentview.do?id=${param.id}";
	}, 2000);
</script>
</head>
<body>
	${updateResult } :수정성공
	5초후 이동합니다
</body>
</html>
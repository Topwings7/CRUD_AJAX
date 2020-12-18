<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
<script>
	window.addEventListener("DOMContentLoaded", ()=>{
		document.querySelector("button").onclick = function(){
			var xhr = new XMLHttpRequest();
			//xhr.onreadystatechange
				xhr.onload = function(){
					if(xhr.status == 200){
					var text = xhr.responseText;
					var div = document.getElementById("person");
					div.innerHTML += text;
					}	
				}
			xhr.open("get","/ajax/person?id=1", true);
			xhr.send();
		}
		document.querySelectorAll("button")[1].onclick = function(){
			var xhr = new XMLHttpRequest();
			xhr.onreadystatechange = function(){
				if(xhr.readyState == xhr.DONE && xhr.status == 200){
					var jsonText = xhr.responseText;
					//json을 자바스크립트 객체로 변환
					var jsonObject = JSON.parse(jsonText);
					var div = document.getElementById("plist");
					for(var person of jsonObject){
						var s = "id:"+ person.id + ", name :" + person.name+", age"+person.age+"<br>";
						div.innerHTML += s;
					}
				}
			}
				xhr.open("get","/ajax/personList",true);
				xhr.send();
		}
	});
</script>
</head>
<body>
	<a href="${pageContext.request.contextPath }/person?id=1">아이디1</a>
	<button>id가 1인 한명정보 가져오기</button>
	<div id="person"></div>
	<a href="${pageContext.request.contextPath }/personList">리스트</a>
	<button>리스트 가져오기</button><br>
	<div id="plist"></div>
	<a href="${pageContext.request.contextPath }/personList">JSON</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	table, tr, th, td { 
	border: 1px solid black; 
	border-collapse:collapse; 
	padding : 12px 15px;
	
	}
	
	.t { 
	margin : 25px; 
	font-size: 1.5em;
	font-family: sans-serif;
	min-width : 400;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.3);
	
	}
	
	.head {
	background-color : #A48654;
	color : black;
	text-align : center;
	}
	
	.row { background: lightgray; padding: 10px;}
	
</style>
<title>리스트</title>
</head>
<body>
	<h1>로그인 성공</h1>
	<div>${loginUser.unm }님 (${loginUser.uid })환영합니다. 
	<a href="/user/logout">Logout</a>
	</div>
	
	<div>
		<a href="write"><button>글쓰기</button></a>
	</div>
	<div>
		리스트
	</div>
	
	<table class="t">
		<tr class="head">
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
		<c:forEach var="box" items="${data}">
		<tr class="row" onclick="moveToDetail(${box.iboard})">
			<td>${box.iboard }</td>
			<td>${box.title }</td>
			<td>${box.unm }</td>
			<td>${box.regdt }</td>
		</tr>
		</c:forEach>
	</table>
	<script>
		function moveToDetail(ib) {
			location.href = '/board/detail?ib=' + ib;
		}
	</script>
</body>
</html>
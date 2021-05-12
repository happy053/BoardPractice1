<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${dat.title }</title>
</head>
<body>
	<h1>${dat.title}</h1>
	
	<div>작성자 : ${dat.unm }</div>
	<div>작성일 : ${dat.regdt }</div>
	<div>글번호 : ${dat.iboard }</div>
	<div>
		${dat.ctnt }
	</div>
	<a href="/board/list"><button>뒤로가기</button></a>
	
	<c:if test="${loginUser.iuser == dat.iuser }">
	<div>
		<a href="del?ib=${dat.iboard }"><button>글 삭제</button></a>
		<a href="up?ib=${dat.iboard }"><button>글 수정</button></a>
	</div>
	</c:if>
</body>
</html>
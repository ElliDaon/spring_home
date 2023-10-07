<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>인덱스 화면임당</h2>
<a href="<%=request.getContextPath()%>/home.do">hello world</a>
<br>
<a href="<%=request.getContextPath()%>/member/memberJoin.do">회원가입</a>
<br>
<a href="<%=request.getContextPath()%>/member/memberLogin.do">로그인</a>

</body>
</html>
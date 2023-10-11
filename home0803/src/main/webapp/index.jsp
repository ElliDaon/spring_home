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
<%if(session.getAttribute("midx")==null){%>
<a href="<%=request.getContextPath()%>/member/memberLogin.do">로그인 페이지</a>
<%} else{ %>
<a href="<%=request.getContextPath()%>/member/memberLogout.do">로그아웃</a>
<%} %>
<br>
<a href="<%=request.getContextPath()%>/board/boardWrite.do">게시글쓰기</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% boolean flag = (Boolean)request.getAttribute("flag");
	   String uid = (String)session.getAttribute("USERID");
	
	   if(flag==true){
		//게시판 목록을 보여준다%>
			<h1><%= uid%>님의 방문을 환영합니다.<h1>
			<a href="list">게시판 목록 보기</a>
	<% }else if(flag==false){
			//다시 로그인 화면으로 이동시킴(잘못된 아이디라는 것 알려줘도 될 듯!)%>
			<h1>아이디나 비밀번호가 틀렸습니다</h1>
			<a href="index.html">로그인화면으로 돌아가기</a>
	<% }%>
</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<title>게시판 복습 두번째 :: 글쓰기</title>
<meta charset="UTF-8" />
</head>
<body>

<form action="/submitPost" method="post">
	제목 : <input type="text" name="postTitle" required style="width:500px;"><br>
	작성자 : ${loginData.userId} <br>
	<input type="hidden" name="postWriter" value="${loginData.userId}">
	<textarea name="postContent" rows="30" cols="150"></textarea><br>
	<button>게시하기</button>
	<button type="button" onclick="location.href='/'">취소</button>
</form>

</body>
</html>
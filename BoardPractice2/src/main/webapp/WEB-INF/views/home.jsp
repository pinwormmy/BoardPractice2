<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<title>게시판 복습 두번째</title>
<meta charset="UTF-8" />
<style>
	a{text-decoration-line:none; color:black;}
	a:hover{text-decoration-line:underline;}
</style>
</head>
<body>
<h3>
	게시판 복습 두번째
</h3>
<p>구글링 최소한으로 한다!</p>
<p>한줄 한줄 이해하고 간다!</p>
<hr>

<table>
	<thead>
		<tr>
			<th>글번호</th>
			<th>글제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${boardList}" var="boardList">
			<tr>
				<td>${boardList.postNum}</td>
				<td>
				<a href="/readPost?postNum=${boardList.postNum}">${boardList.postTitle}</a>
				</td>
				<td>${boardList.postWriter}</td>
				<td>${boardList.postTime}</td>
				<td>${boardList.viewCount}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<hr>		

<button type="button" onclick="location.href='/writePost'">글쓰기</button>

</body>
</html>
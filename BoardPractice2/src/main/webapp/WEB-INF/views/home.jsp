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
	table {
    width: 100%;
    border-top: 1px solid #444444;
    border-collapse: collapse;
  	}
  	th, td {
    border-bottom: 1px solid #444444;
    padding: 10px;
	}
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
		<c:forEach items="${boardList}" var="boardList" begin="${postStartNum}" end="${postEndNum}">
			<tr>
				<td>${boardList.postNum}</td>
				<td>
				<a href="/readPost?postNum=${boardList.postNum}">${boardList.postTitle}</a>
				<c:if test="${boardList.commentCount > 0}">
				<span style="color:grey;">[${boardList.commentCount}]</span>
				</c:if> 
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
<button type="button" onclick="location.href='/'">글목록</button><br>

<c:if test="${pageStartNum > 10}">
	<a href="/page?pageNum=${pageStartNum - 1}">이전</a>
</c:if>


<c:forEach var="pageNum" begin="${pageStartNum}" end="${pageEndNum}">
	<c:if test="${pageCurrentNum == pageNum}">
		<b>${pageNum}</b>
	</c:if>
	<c:if test="${pageCurrentNum != pageNum}">
		<a href="/page?pageNum=${pageNum}"> ${pageNum} </a>
	</c:if>
</c:forEach>

<c:if test="${pageEndNum < pageMaxNum}">
	<a href="/page?pageNum=${pageEndNum + 1}">다음</a>
</c:if>

<form action="/search">
	<select name="searchOption">
		<option value="searchTitleAndContent">제목+내용</option>
		<option value="searchTitle">제목</option>
		<option value="searchContent">내용</option>
		<option value="searchWriter">작성자</option>
	</select>
	<input type="hidden" name="pageNum" value="1">
	<input type="text" name="searchKeyword">
	<button>검색</button>
</form>
	
</body>
</html>
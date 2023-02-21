<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>animal care</title>
<jsp:include page="/WEB-INF/view/moduel/css_js_boot_import.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="/WEB-INF/view/moduel/header.jsp"></jsp:include>
	<br>
	<br>	
	<div class="container-sm">
	<h5>공지사항</h5>
	<br>
	<br>
	<table class="table">
		 <thead>
		    <tr>
		      <th scope="col">공고 번호</th>
		      <th scope="col">제목</th>
		      <th scope="col">작성자</th>
		      <th scope="col">작성일자</th>
		      <th scope="col">내용</th>
		      <th scope="col">조회수</th>
		    </tr>
		  </thead>
		  <tbody class="table-group-divider">
		  		<tr>
					<td>${detail.noticeNo }</td>
					<td>${detail.noticeTitle }</td>
					<td>${detail.noticeWriter }</td>
					<td>${detail.noticeDate }</td>
					<td>${detail.noticeContent }</td>
					<td>${detail.noticeViewCount }</td>
				</tr>
		  </tbody>
	</table>
	
	<div class="text-center">
		<c:choose>
			<c:when test="${not empty lgnss }">
				<a class="btn btn-outline-secondary" href="<%=request.getContextPath()%>/noticere">수정</a>
				<a class="btn btn-outline-secondary" href="<%=request.getContextPath()%>/noticedelete?noticeNo=${detail.noticeNo}">삭제</a>
			</c:when>
		</c:choose>
			<a class="btn btn-outline-secondary" href="<%=request.getContextPath()%>/notice">목록</a> 
			
	</div>
	
	</div>	
</body>
</html>
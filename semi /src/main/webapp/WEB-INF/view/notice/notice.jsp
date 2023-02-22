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
	<h4>공지사항</h4>
	<div class="text-end fs-6 ">
		<c:choose>
			<c:when test="${not empty lgnss }">
				<a class="btn btn-outline-secondary" href="<%=request.getContextPath()%>/noticewrite">등록</a>
			</c:when>
		</c:choose>
	</div>
	<br>
	<br>	
	<table class="table">
		 <thead>
		    <tr>
		     <!--  <th scope="col">공고 번호</th> -->
		      <th scope="col">제목</th>
		      <th scope="col">작성자</th>
		      <th scope="col">작성일자</th>
		      <th scope="col">내용</th>
		      <th scope="col">조회수</th>
		    </tr>
		  </thead>
		  <tbody class="table-group-divider">
		  	<c:forEach var="selectList" items="${noticeList }">
		  		<tr>
				<%-- 	<td>${selectList.noticeNo }</td> --%>
					<td><a href="<%=request.getContextPath()%>/noticedetail?num=${selectList.noticeNo }">${selectList.noticeTitle }</a></td>
					<td>${selectList.noticeWriter }</td>
					<td>${selectList.noticeDate }</td>
					<td>${selectList.noticeContent }</td>
					<td>${selectList.noticeViewCount }</td>
				</tr>
		  	</c:forEach>
		  </tbody>
	</table>
	
	<ul class="pagination pagination-sm justify-content-center"> 
		 		 <c:set var="pageNumber" value="${empty param.p ? 1: param.p}" />
		 		 
				<c:choose>
		 		 	<c:when test="${pNum eq 1}">
		 		 		<li class="page-item"><a class="page-link" href="#">prev</a></li>
		 		 	</c:when>
		 		 	<c:otherwise>
		 		 		 <li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/notice?p=1">prev</a></li>
		 		 	</c:otherwise>
		 		 </c:choose>
					  
				 <c:forEach var="pNum" items="${requestScope.pageList}">
					 <li class="page-item ${pNum eq pageNumber ? 'active' : '' }"><a class="page-link" href="<%=request.getContextPath()%>/notice?p=${pNum}">${pNum}</a></li>
				</c:forEach>
					  
				<c:choose>
		 		 	<c:when test="${pNum eq 2}">
		 		 		<li class="page-item"><a class="page-link" href="#">next</a></li>
		 		 	</c:when>
		 		 	<c:otherwise>
		 		 		<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/notice?p=2">next</a></li>
		 		 	</c:otherwise>
		 		 </c:choose>
		</ul>	
	
	</div>
</body>
</html>
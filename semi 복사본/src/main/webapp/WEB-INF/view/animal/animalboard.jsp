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
	<h5>보호동물</h5>현재 보호 중인 동물을 소개합니다. 
	<div class="text-end fs-6 ">
		<c:choose>
			<c:when test="${not empty lgnss }">
				<a class="btn btn-outline-secondary" href="<%=request.getContextPath()%>/animalwrite">등록</a>
			</c:when>
		</c:choose>
	</div>
	<br>
	<br>
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">공고 번호</th>
		      <th scope="col">접수 일자</th>
		      <th scope="col">품종</th>
		      <th scope="col">성별</th>
		      <th scope="col">발견 장소</th>
		       <th scope="col">특징</th>
		    </tr>
		  </thead>
		  <tbody class="table-group-divider">
			  <c:forEach var="selectList" items="${selectList }">
					<tr>
						<td><a href="<%=request.getContextPath()%>/animaldetail?num=${selectList.animalNo }">${selectList.animalNo }</a></td>
						<td>${selectList.animalDate }</td>
						<td>${selectList.animalKind }</td>
						<td>${selectList.animalGender }</td>
						<td>${selectList.animalPlace }</td>
						<td>${selectList.animalDetail }</td>
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
		 		 		 <li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/animalboard?p=1">prev</a></li>
		 		 	</c:otherwise>
		 		 </c:choose>
					  
				 <c:forEach var="pNum" items="${requestScope.pageList}">
					 <li class="page-item ${pNum eq pageNumber ? 'active' : '' }"><a class="page-link" href="<%=request.getContextPath()%>/animalboard?p=${pNum}">${pNum}</a></li>
				</c:forEach>
					  
				<c:choose>
		 		 	<c:when test="${pNum eq 2}">
		 		 		<li class="page-item"><a class="page-link" href="#">next</a></li>
		 		 	</c:when>
		 		 	<c:otherwise>
		 		 		<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/animalboard?p=2">next</a></li>
		 		 	</c:otherwise>
		 		 </c:choose>
		</ul>	
	</div>
</body>
</html>
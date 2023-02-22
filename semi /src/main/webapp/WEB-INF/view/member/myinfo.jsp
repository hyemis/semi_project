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
	<div class="container-sm">
		<br>
		<br>
		<h5>내 정보</h5>
		<hr>
		
		
		<ul class="list-group list-group-flush">
		  <li class="list-group-item">name: ${lgnss.name }</li>
		  <li class="list-group-item">email: ${lgnss.email }</li>
		  <li class="list-group-item">address: ${lgnss.address }</li>
		  <li class="list-group-item">phone: ${lgnss.phone }</li>
		</ul>
		
		<div class="text-center">
		<c:choose>
			<c:when test="${not empty lgnss }">
				<a class="btn btn-outline-secondary" href="<%=request.getContextPath()%>/myinfore">수정</a>
			</c:when>
		</c:choose>
			
	</div>
	</div>
</body>
</html>
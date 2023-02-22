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
	<h4>공지사항 수정하기</h4>
	<br>
	<br>
	<c:choose>
		<c:when test="${empty lgnss }">
			Response.Write("<script>alert('로그인 후 확인 가능합니다.');</script>");
				<script>
					location.href="login";
				</script>
		</c:when>
		<c:otherwise>
			 <form class="row g-4"  action="<%=request.getContextPath()%>/animalre" method="post">
			 	<input type="hidden" class="form-control" name="animalNo" value="${detail.animalNo }">
			 	<div class="col-12">
				    <label for="animalKind" class="form-label">품종</label>
				    <input type="text" class="form-control" name="animalKind" placeholder="animalKind">
			 	 </div>
			 	<div class="col-12">
				    <label for="animalGender" class="form-label">성별</label>
				    <input type="text" class="form-control" name="animalGender" placeholder="animalGender">
			 	 </div>
			 	 <div class="col-12">
				    <label for="animalPlace" class="form-label">발견 장소</label>
				    <input type="text" class="form-control" name="animalPlace" placeholder="animalPlace">
			 	 </div>
			 	  <div class="col-12">
				    <label for="animalDetail" class="form-label">특이 사항</label>
				    <input type="text" class="form-control" name="animalDetail" placeholder="animalDetail">
			 	 </div>
						 	 
			 	 <div class="col-12 d-grid gap-2 col-6 mx-auto">
			   		 <button type="submit" class="btn btn-outline-secondary wirte">수정</button>
				 </div>
				</form>	
		</c:otherwise>
	</c:choose>
	</div>
</body>
</html>
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
	<h4>유기동물 등록하기</h4>

	<c:choose>
		<c:when test="${empty lgnss }">
			Response.Write("<script>alert('로그인 후 확인 가능합니다.');</script>");
				<script>
					location.href="login";
				</script>
		</c:when>
		<c:otherwise>
			 <form class="row g-4"  action="<%=request.getContextPath()%>/animalwrite" method="post">
			 	<div class="col-12">
				    <label for="inputAddress" class="form-label">발견 일자</label>
				    <input type="date" class="form-control" name="animalDate" placeholder="animalDate">
			 	 </div>
				 <div class="col-12">
				    <label for="inputAddress" class="form-label">품종</label>
				    <input type="text" class="form-control" name="animalKind" placeholder="animalKind">
			 	 </div>
				<div class="col-12">
				    <label for="inputAddress" class="form-label">성별</label>
				    <input type="text" class="form-control" name="animalGender" placeholder="animalGender">
			 	 </div>
			 	 <div class="col-12">
				    <label for="inputAddress" class="form-label">발견 장소</label>
				    <input type="text" class="form-control" name="animalPlace" placeholder="animalPlace">
			 	 </div>
			 	 <div class="col-12">
				    <label for="inputAddress" class="form-label">특이사항</label>
				    <input type="text" class="form-control" name="animalDetail" placeholder="animalDetail">
			 	 </div>
			 	 
			 	 <div class="col-12 d-grid gap-2 col-6 mx-auto">
			   		 <button type="submit" class="btn btn-outline-secondary wirte">등록</button>
				 </div>
				</form>	
		</c:otherwise>
	</c:choose>
	</div>
</body>
</html>
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

	<div class="row g-1 bg-light position-relative">
	  <div class="col-md-6 mb-md-0 p-md-4">
	    <img src="<%=request.getContextPath() %>/resources/img/dog1.png" class="w-100" alt="...">
	  </div> 
	  <div class="col-md-6 p-4 ps-md-0">
	    <h4 class="mt-0">반려동물 사랑으로 입양하세요. 여러분의 삶이 행복해 집니다.</h4><br>
	    <p>[동물보호법] 등에 따라서 유기, 유실동물의 생 보호, 안전 보장 및 복지 증진을 꾀하고, 건전하고 책임 있는 입양문화를 조성하여 생명 존중에 대한 정서함양과 사람과 동물의 조화로운 공조에 이바지 함을 목적으로 설립되었습니다.</p>
	    <a href="<%=request.getContextPath()+"/"%>" class="stretched-link"></a>
	  </div>
	</div>
	<br>
	<br>
	<div class="container-sm">
		<div class="row">
			<div class="card me-5" style="width: 18rem;">
			  <div class="card-body">
			  		<div class="fw-bold">
			  			보호 중인 동물 
			  		</div>
			  		현재 보호 중인 동물을 소개합니다. 
			    	<a href="<%=request.getContextPath()+"/animalboard"%>" class="stretched-link"></a>
			  </div>
		</div>
			
			<div class="card me-5" style="width: 18rem;">
			  <div class="card-body">
			  		<div class="fw-bold">
			  			입양 후기 
			  		</div>
			  		여러분의 입양 후기를 들려주세요.
			    	<a href="<%=request.getContextPath()+"/repair"%>" class="stretched-link"></a>
			  </div>
			</div>
			
			<div class="card me-5" style="width: 18rem;">
			  <div class="card-body">
			  		<div class="fw-bold">
			  			입양자교육
			  		</div>
			  		사람과 동물의 행복한 동거생활을 위해서는 동물 입양 전 교육을 이수하는 것이 필요합니다. 
			    	<a href="<%=request.getContextPath()+"/repair"%>" class="stretched-link"></a>
			  </div>
			</div>
			
			<div class="card" style="width: 18rem;">
			  <div class="card-body">
			  		<div class="fw-bold">
			  			공지사항 
			  		</div>
			  		새로 업데이트된 공지사항을 확인하세요. 
			    	<a href="<%=request.getContextPath()+"/notice"%>" class="stretched-link"></a>
			  </div>
			</div>
		</div>
	</div>
</body>
</html>
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
		<section>
			<form action="login" method="post">
			  <div class="col-6 mx-auto">
				  	<div class="col-12">
					    <label for="inputAddress" class="form-label">id</label>
					    <input type="text" class="form-control" name="id" placeholder="id">
			 		</div>
			 		
			 		<div class="col-12">
					    <label for="inputAddress" class="form-label">password</label>
					    <input type="password" class="form-control" name="passwd" placeholder="password">
			 		</div>
				</div>
			   <br>
			   <button type="submit" class="btn btn-outline-secondary d-grid gap-2 col-6 mx-auto">log in</button>
			   <div class="text-center">
			   <a href="<%=request.getContextPath()%>/enroll">sing up?</a>
			   </div>
	  	 	</form>
	   	</section>
   	</div>
</body>
</html>
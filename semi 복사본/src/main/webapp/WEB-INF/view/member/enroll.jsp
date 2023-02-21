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
		 <form class="row g-4"  action="<%=request.getContextPath()%>/enroll" method="post">
		  <div class="col-md-6">
		    <label for="inputEmail4" class="form-label">Id</label>
		    <input type="text" class="form-control" name="id">
		  </div>
		  
		  <div class="col-md-6">
		    <label for="inputPassword4" class="form-label">Password</label>
		    <input type="password" class="form-control" name="passwd">
		  </div>
		  
		  <div class="col-6">
		  	 <button type="button" class="btn btn-outline-secondary btn-sm" id="dupId">Id Check</button>
		  	 <span></span>
		  </div>
		  
		  <div class="col-12">
		    <label for="inputAddress" class="form-label">Name</label>
		    <input type="text" class="form-control" name="name" placeholder="name">
		  </div>
		  
		  <div class="col-12">
		    <label for="inputAddress" class="form-label">Email</label>
		    <input type="text" class="form-control" name="email" placeholder="Email@gmail.com">
		  </div>
		  
		  <div class="col-md-6">
		    <label for="inputAddress2" class="form-label">Address</label>
		    <input type="text" class="form-control" name="address" placeholder="Apartment, studio, or floor">
		  </div>
		  
		  <div class="col-md-6">
		    <label for="inputCity" class="form-label">Phone</label>
		    <input type="text" class="form-control"  name="phone">
		  </div>
		  
		  <div class="col-12 d-grid gap-2 col-6 mx-auto">
		    <button type="submit" class="btn btn-outline-secondary enroll">Sign In</button>
		  </div>
		</form>
	 </div>
		
		
		<script>
			
			$("#dupId").click(checkDupId);
			function checkDupId(){
				var id = $("input").first().val();
				console.log($("input").first().val() );
				$.ajax({ 
					url: "<%=request.getContextPath()%>/dupid"
					, type:"post"
					, async:false
					, data: {id: $("input").first().val() }
					, success: function(result){
						console.log(result);	
						if(result == 1){
							$("#dupId").next().html("중복된 아이디가 있습니다. 다시 입력해주세요.");
							$("#dupId").next().css("color", "red");
						} else {
							$("#dupId").next().html("사용 가능한 아이디입니다.");
							$("#dupId").next().css("color", "blue");
						}
					}
					, error: function(request, status, error){
						alert(request.status);
					}
				});	
			}
			

			
		</script>
</body>
</html>
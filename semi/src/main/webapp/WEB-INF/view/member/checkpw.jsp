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
	<div class="container-sm col-6">
		<c:choose>
			<c:when test="${empty lgnss }">
				Response.Write("<script>alert('로그인 후 확인 가능합니다.');</script>");
				<script>
					location.href="login";
				</script>
			</c:when>	
			<c:otherwise>
				<form action="<%=request.getContextPath()%>/myinfo" method="post">
<!-- 				<div class="input-group input-group-sm mb-3">
					<span class="input-group-text" id="inputGroup-sizing-sm">passwd 재확인</span>
					<input type="password" class="form-control" aria-describedby="inputGroup-sizing-sm"  name="checkpasswd">
					</div> -->
					<div class="col-12 mb-3">
					    <label for="inputAddress" class="form-label">password</label>
					    <input type="password" class="form-control" name="checkpasswd" placeholder="password">
			 		</div>
					
					<div class="col-12 d-grid gap-2 col-6 mx-auto">
						<button type="submit" class="btn btn-outline-secondary">확인</button>
					</div>
				</form>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>
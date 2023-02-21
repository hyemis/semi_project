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
	<h5>공지사항 등록하기</h5>
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
			 <form class="row g-4"  action="<%=request.getContextPath()%>/noticewrite" method="post">
			 	<input type="hidden" class="form-control" name="noticeNo" value="${detail.noticeNo }">
			 	<div class="col-12">
				    <label for="inputAddress" class="form-label">제목</label>
				    <input type="text" class="form-control" name="noticeTitle" placeholder="noticeTitle">
			 	 </div>
				 <div class="col-12">
				    <label for="inputAddress" class="form-label">작성자</label>
				    <input type="text" class="form-control" name="noticeWrite" placeholder="noticeWrite">
			 	 </div>
				<div class="col-12">
				    <label for="inputAddress" class="form-label">내용</label>
				    <input type="text" class="form-control" name="noticeContent" placeholder="noticeContent">
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
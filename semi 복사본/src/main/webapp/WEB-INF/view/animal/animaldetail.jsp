<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
		<h5>유기동물 상세보기</h5>
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
				<tr>
					<td>${detail.animalNo }</td>
					<td>${detail.animalDate }</td>
					<td>${detail.animalKind }</td>
					<td>${detail.animalGender }</td>
					<td>${detail.animalPlace }</td>
					<td>${detail.animalDetail }</td>
				</tr>
			  </tbody>
			</table>
			
			<ol class="list-group ">
				<c:forEach var="comment" items="${comment }">
					<fmt:formatDate type="both" pattern="yyyy.MM.dd HH:mm:ss" var="date" value="${comment.commentDate }"/>
			  		<li class="list-group-item d-flex justify-content-between align-items-start">
			   		<div class="ms-2 me-auto">
			      	<div class="fw-bold">${comment. commentWriter} | ${date }</div>
			     	 	${comment. commentcomment}
			     	 	
			     	 	<c:choose>
				     	 	<c:when test="${not empty lgnss }">
					     	 	<form action="<%=request.getContextPath()%>/commentdelete" method="post">
					     	 		<input type="hidden" name="commentNo" value="${comment.commentNo }"/>
					     	 		<%-- <input type="hidden" name="loginId" value="${lgnss.id }"/> --%>
					     	 		<div class="justify-content-md-end col-6">
					     	 			<button type="submit" class="delete btn btn-link btn-sm">삭제</button>
					     	 		</div>
					     	 	</form> 
				     	 	</c:when>
			     	 	</c:choose>
			    	</div>
			 		</li>
			 	 </c:forEach>
			</ol>
		
		
			<c:choose>
				<c:when test="${not empty lgnss }">
					<form action="<%=request.getContextPath()%>/animaldetail?num=${detail.animalNo }" method="post">
						<div class="form-floating row">
							<div class="col-10">
							  <textarea class="form-control" placeholder="comment" name="comment" style="height: 100px"></textarea>
							  <input type="hidden" name="animalNo" value="${detail.animalNo }"/>
							</div>
							<div class="row col-2">
							  <button type="submit" class="add btn  btn-outline-secondary btn-lg">등록</button>
							</div>
						</div>
					</form>
				</c:when>
			</c:choose>
		</div>
</body>
</html>
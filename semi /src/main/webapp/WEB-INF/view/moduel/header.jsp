<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- <script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<link type="text/css" rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script> -->
<script src="/node_modules/jquery/dist/jquery.min.js"></script>
<link rel="stylesheet" href="/node_modules/bootstrap/dist/css/bootstrap.min.css"/>
<link rel="stylesheet" href="/node_modules/font-awesome/css/font-awesome.min.css"/>
<script src="/node_modules/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
<!DOCTYPE html>
<header>	
	<nav class="navbar navbar-expand-lg bg-light justify-content-end">
	      <ul class="navbar-nav">
	      
	      	<div class="dropdown-center">
			  <button class="btn btn-outline-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
			   menu
			  </button>
			  <ul class="dropdown-menu">
			    <li><a class="dropdown-item" href="<%=request.getContextPath()%>/">main</a></li>
			    <li><a class="dropdown-item" href="<%=request.getContextPath()%>/animalboard">보호 중인 동물</a></li>
			    <li><a class="dropdown-item" href="<%=request.getContextPath()%>/repair">입양 후기</a></li>
			    <li><a class="dropdown-item" href="<%=request.getContextPath()%>/edu">입양자 교육</a></li>
			    <li><a class="dropdown-item" href="<%=request.getContextPath()%>/notice">공지사항</a></li>
			  </ul>
			</div>
	      
	 		<c:choose>
				<c:when test="${empty lgnss }">
					<li class="nav-item" ><button type="button" class="btn login">login</button></li>
					<li class="nav-item" ><button type="button" class="btn signup">sing up</button>	</li>
				</c:when>	
				<c:otherwise>
					<li class="nav-item" ><button type="button" class="btn myinfo">my info</button></li>
					<li class="nav-item" ><button type="button" class="btn logout">logout</button></li>
				</c:otherwise>
			</c:choose>
	      </ul>
	</nav>
	<hr>
	
	
	<script>
	
	$("#main").on("click", handlerClickBtnMain);
	$(".btn.main").on("click", handlerClickBtnMain);
	$(".btn.login").on("click", handlerClickBtnLogin);
	$(".btn.logout").on("click", handlerClickBtnLogout);
	$(".btn.signup").on("click", handlerClickBtnSignup);
	$(".btn.myinfo").on("click", handlerClickBtnMyinfo);
	
	function handlerClickBtnMain(){
		console.log("btnLogMain 버튼 눌림");
		location.href="<%=request.getContextPath()%>/";
	}
	
	
	
	function handlerClickBtnLogout(){
		console.log("btnLogout 버튼 눌림");
		location.href="<%=request.getContextPath()%>/logout";
	}
	
	function handlerClickBtnLogin(){
		console.log("btnLogin 버튼 눌림");
		location.href="<%=request.getContextPath()%>/login";
	}
	
	function handlerClickBtnSignup(){
		console.log("btnSingup 버튼 눌림");
		location.href="<%=request.getContextPath()%>/enroll";
	}
	
	function handlerClickBtnMyinfo(){
		console.log("btnMyinfo 버튼 눌림");
		location.href="<%=request.getContextPath()%>/myinfo"
	}

	</script>
</header>

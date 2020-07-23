<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/views/layout/import_css.jsp"></jsp:include>
<div class="container">
	<header class="blog-header py-3">
		<div class="row flex-nowrap justify-content-between align-items-center">
			<div class="col-4 pt-1"></div>
			<div class="col-4 text-center">
				<a class="blog-header-logo text-dark" href="main.co">SJ STORE</a>
			</div>
			<div class="col-4 d-flex justify-content-end align-items-center">
				<a class="text-muted" href="#"> <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="mx-3">
						<circle cx="10.5" cy="10.5" r="7.5"></circle>
						<line x1="21" y1="21" x2="15.8" y2="15.8"></line></svg>
				</a>
				<!-- el문은 char형을 비교할 수 없다. 따라서 비교하는 값에 charAt(0)를 붙여서 비교해야한다. -->
				<c:choose>
					<c:when test="${ loginUser eq null }">
						<a class="btn btn-sm" href="signIn.co">Sign in</a>
						&nbsp;&nbsp;
						<a class="btn btn-sm btn-outline-secondary" href="signUp.co">Sign up</a>
					</c:when>
					<c:when test="${ loginUser ne null && loginUser.member.id eq 'admin'}">
						<a class="btn btn-sm btn-outline-secondary" href="adminPage.ad">관리자페이지</a>&nbsp;&nbsp;
						<a class="btn btn-sm btn-outline-secondary" href="logout.co">로그아웃</a>
					</c:when>
					<c:when test="${ loginUser ne null && loginUser.member.kind eq 'C'.charAt(0)}">
						<a class="btn btn-sm btn-outline-secondary" href="#">최근 본 제품</a>&nbsp;&nbsp;
						<a class="btn btn-sm btn-outline-secondary" href="customerProfile.cu">마이페이지</a>&nbsp;&nbsp;
						<a class="btn btn-sm btn-outline-secondary" href="logout.co">로그아웃</a>
					</c:when>
					<c:when test="${ loginUser ne null && loginUser.member.kind eq 'B'.charAt(0)}">
						<a class="btn btn-sm btn-outline-secondary" href="businessProfile.bu">마이페이지</a>&nbsp;&nbsp;
						<a class="btn btn-sm btn-outline-secondary" href="logout.co">로그아웃</a>
					</c:when>
				</c:choose>
			</div>
		</div>
	</header>

	<div class="nav-scroller py-1 mb-2">
		<nav class="nav d-flex justify-content-between">
			<a class="p-2 text-muted" href="main.co">ALL</a> 
			<a class="p-2 text-muted" href="topPage.co">Top</a>
			<a class="p-2 text-muted" href="pantsPage.co">Pants</a>
			<a class="p-2 text-muted" href="skirtPage.co">Skirt</a>
			<a class="p-2 text-muted" href="onePiecePage.co">OnePiece</a>
			<a class="p-2 text-muted" href="shoesPage.co">Shoes</a>
		</nav>
	</div>
</div>
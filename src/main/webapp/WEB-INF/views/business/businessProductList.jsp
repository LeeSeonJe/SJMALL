<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>SJ MALL</title>
<link href="resources/business/css/businessLayout.css" rel="stylesheet">
<link href="resources/business/css/businessProductList.css" rel="stylesheet">
<!-- Font Awesome JS -->
<script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js" integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ" crossorigin="anonymous"></script>
<script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js" integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY" crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/layout/header.jsp"></jsp:include>
	<div class="wrapper">
		<!-- Sidebar -->
		<nav id="sidebar">
			<ul class="list-unstyled components">
				<p>
					MyPage<br>&nbsp;
				</p>
				<li><a href="businessProfile.bu">회원정보</a><br></li>
				<li><a href="businessProductList.bu" style="color: blue; font-weight: 800;">제품관리</a><br></li>
				<li><a href="businessProductAdd.bu">제품등록</a><br></li>
				<li><a href="#">주문/배송조회</a><br></li>
				<li><a href="#">판매자문의</a><br></li>
				<li><a href="#">관리자문의</a></li>
			</ul>
		</nav>
		<!-- Page Content -->
		<div id="content">
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<div class="container-fluid">
					<table>
						<thead class="thead-area">
							<tr>
								<td colspan="7"><h3 style="text-align: center;">제품관리</h3> <br></td>
							</tr>
							<tr>
								<th>번호</th>
								<th>카테고리</th>
								<th>제품이미지</th>
								<th>제품이름</th>
								<th>가격</th>
								<th>상태</th>
								<th>등록일</th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${ pList == null }">
								<tr>
									<td colspan="7">등록된 제품이 없습니다.</td>
								</tr>
							</c:if>
							<c:if test="${ pList != null }">
								<c:forEach items="${ pList }" var="pl">
									<tr onclick="productUpdate(${pl.productNo})">
										<td>${ pl.productNo }</td>
										<td>${ pl.productCategory }</td>
										<td><img style="width: 150px; height: 150px;" src="resources/business/images/${ pl.productThumbNail }" alt="" /></td>
										<td>${ pl.productName }</td>
										<td>${ pl.productPrice }원</td>
										<c:if test="${ pl.status eq 'Y'.charAt(0) }">
											<td>판매중</td>
										</c:if>
										<c:if test="${ pl.status ne 'Y'.charAt(0) }">
											<td>미판매</td>
										</c:if>
										<td>${ pl.enrollDate }</td>
									</tr>
								</c:forEach>
							</c:if>
						</tbody>
					</table>
				</div>
			</nav>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/layout/footer.jsp"></jsp:include>
	<script src="resources/business/js/businessProductList.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
</body>
</html>
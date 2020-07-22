<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>SJ MALL</title>
<link href="resources/customer/css/customerLayout.css" rel="stylesheet">
<link href="resources/customer/css/customerProfile.css" rel="stylesheet">
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
				<p>MyPage<br>&nbsp;</p>
				<li><a href="customerProfile.cu" style="color: blue; font-weight: 800;">회원정보</a><br></li>
				<li><a href="customerBasket.cu">장바구니</a><br></li>
				<li><a href="customerDelivery.cu">주문/배송조회</a><br></li>
				<li><a href="customerReview.cu">내가 쓴 리뷰</a><br></li>
				<li><a href="customerSellerQnA.cu">판매자문의</a><br></li>
				<li><a href="customerAdminQnA.cu">관리자문의</a></li>
			</ul>
		</nav>
		<!-- Page Content -->
		<div id="content">
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<div class="container-fluid">
					<input type="text" value="${ loginUser.member.id }" />
				</div>
			</nav>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/layout/footer.jsp"></jsp:include>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
</body>
</html>
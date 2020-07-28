<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>SJ MALL</title>
<link href="resources/customer/css/customerLayout.css" rel="stylesheet">
<link href="resources/customer/css/customerBasket.css" rel="stylesheet">
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
				<li><a href="customerProfile.cu">회원정보</a><br></li>
				<li><a href="customerBasket.cu" style="color: blue; font-weight: 800;">장바구니</a><br></li>
				<li><a href="customerDelivery.cu">주문/배송조회</a><br></li>
				<li><a href="customerReview.cu">내가 쓴 리뷰</a><br></li>
				<li><a href="customerSellerQnA.cu">판매자문의</a><br></li>
				<li><a href="customerAdminQnA.cu">관리자문의</a></li>
			</ul>
		</nav>
		<!-- Page Content -->
		<div id="content">
			<h4 style="text-align: center;">장바구니</h4>
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<div class="container-fluid">
					<c:choose>
						<c:when test="${ empty bpList }">
							<h3 style="width: 848px; text-align: center; margin-top: 200px; margin-bottom: 200px;">장바구니가 비어있습니다.</h3>
						</c:when>
						<c:when test="${ !empty bpList }">
							<ul id="ul_area">
								<li id="item_head">
									<div class="item_check">
										<label><input type="checkbox" id="allSel" onclick="allSelect(this);" />&nbsp;&nbsp;&nbsp;전체선택 </label>
									</div>
								</li>
								<c:forEach items="${ bpList }" var="bpl">
									<li>
										<div class="item">
											<div class="item_check">
												<input type="hidden" name="bucketNo" value="${ bpl.bucketNo }" />
												<input type="checkbox" name="productNo" value="${ bpl.product.productNo }" onclick="itemCheck();" />
											</div>
											<div class="item_img">
												<img src="resources/business/images/${ bpl.product.productThumbNail }" alt="${ bpl.product.productThumbNail }" />
											</div>
											<div class="item_info">
												<label class="item_name">${ bpl.product.productName }</label> <br> <label class="item_size">사이즈 : <strong>${ bpl.productSize }</strong></label> <input type="hidden" name="productSize" value="${ bpl.productSize }" /> 개수 :
												<button type="button" onclick="subCount(this, ${bpl.bucketNo}, ${ bpl.product.productNo }, '${ bpl.productSize }', ${ bpl.product.productPrice });">－</button>
												<input class="item_count" type="text" name="productCount" value="${ bpl.productCount }" readonly="readonly" />
												<button type="button" onclick="addCount(this, ${bpl.bucketNo}, ${ bpl.product.productNo }, '${ bpl.productSize }', ${ bpl.product.productPrice });">＋</button>
												<br> <label class="item_price">가격 :&nbsp;</label><Strong>${ bpl.productPrice }</Strong><label>원</label> <input type="hidden" name="productPrice" value="${ bpl.productPrice }" />
											</div>
											<div>
												<label onclick="delectBasket(this, ${bpl.bucketNo});" class="item_cancel">&nbsp;&nbsp;X&nbsp;&nbsp;</label>
											</div>
										</div>
									</li>
								</c:forEach>
							</ul>
							<div id="item_total_info">
								<div id="title-area">
									<p>전체 합계</p>
								</div>
								<div id="item_total_detail">
									<div id="item_total_count">
										<span class="left_area">상품수</span><span class="right_area"><strong id="totalCount">0</strong>개</span><br>
									</div>
									<div id="item_total_price">
										<span class="left_area">상품금액</span><span class="right_area"><strong id="totalPrice">0</strong>원</span>
									</div>
								</div>
								<br>
								<div id="total_price_area">
									<div id="total_price">
										<span class="left_area">전체 주문금액</span><span class="right_area"><strong id="totalPrice2">0</strong>원</span>
									</div>
								</div>
								<div id="item_btn">
									<button type="button" id="item_orderBtn" onclick="customerBuyItem();">주문하기</button>
								</div>
							</div>
						</c:when>
					</c:choose>
				</div>
			</nav>
		</div>
	</div>
	<script type="text/javascript">
		var customerNo = '${ loginUser.member.memberNo }';
	</script>
	<jsp:include page="/WEB-INF/views/layout/footer.jsp"></jsp:include>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
	<script src="resources/customer/js/customerBasket.js"></script>
</body>
</html>
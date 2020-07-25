<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SJ MALL</title>
<link href="resources/common/css/pDetail.css" rel="stylesheet" />
</head>
<body>
	<jsp:include page="/WEB-INF/views/layout/header.jsp"></jsp:include>
	<div class="container">
		<div class="pImg-area">
			<p>Product Photo</p>
			<img src="resources/business/images/${ p.productThumbNail }" alt="" />
		</div>
		<div class="pInfo-area">
			<div class="product info">
				Product Info<label>&nbsp;&nbsp;제품정보</label>
			</div>
			<div class="product brand">
				<p>브랜드&nbsp;&nbsp;</p>${ p.productBrand }</div>
			<div class="product category">
				<p>카테고리&nbsp;&nbsp;</p>${ p.productCategory }</div>
			<div class="product name">
				<p>제품명&nbsp;&nbsp;</p>${ p.productName }</div>
			<div class="product price">
				<p>가격&nbsp;&nbsp;</p><b>${ p.productPrice }&nbsp;</b><label>원</label>
			</div>
			<div class="product Size">
				<p>옵션 선택</p>
				<script type="text/javascript">
					var pSizeList = {};
					var pBuyList = {};
					var pPriceList = {};
				</script>
				<select name="sizeSel">
					<option>옵션을 선택해주세요.</option>
					<c:forEach items="${ pSizeList }" var="psl" varStatus="status">
						<option value="${ status.index + 1 }">SIZE : ${ psl.productSize }&nbsp;&nbsp;/&nbsp;&nbsp;남은수량 : ${ psl.productCount }</option>
						<script type="text/javascript">
							var psl = '${ psl }'
							pSizeList['${ psl.productSize }'] = '${ psl.productCount }';
							pBuyList['${ psl.productSize }'] = 0;
							pPriceList['${ psl.productSize }'] = 0;
						</script>
					</c:forEach>
				</select>
			</div>
			<div class="product option">
				
			</div>
			<div class="product totalPrice">
			
			</div>
			<div class="product btn">
				<c:if test="${ loginUser eq null }">
					<button type="button" id="buy-btn">바로구매</button>
					<button type="button" id="bucket-btn" onclick="noSignIn();">장바구니</button>
				</c:if>
				<c:if test="${ loginUser ne null && loginUser.member.kind eq 'C'.charAt(0) }">
					<button type="button" id="buy-btn">바로구매</button>
					<button type="button" id="bucket-btn" onclick="bucketAdd(${ p.productNo });">장바구니</button>
				</c:if>
			</div>
		</div>
		<div class="pDetail-area">
			<p>상품정보</p>
			${ p.productDetail }
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/layout/footer.jsp"></jsp:include>
	<script type="text/javascript">
		var productPrice = '${ p.productPrice }'		
		productPrice = parseInt(productPrice);
	</script>
	<script src="resources/common/js/pDetail.js"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="resources/customer/css/customerLayout.css" rel="stylesheet">
<link href="resources/customer/css/customerBuyItem.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="/WEB-INF/views/layout/header.jsp"></jsp:include>

	<div class="title_area">
		<h2>주문결제</h2>
	</div>
	<form action="customerPayment.cu" onsubmit="return validate()" method="POST">
		<div class="wrapper" style="min-height: 450px;">
			<div class="address_area">
				<div class="title_header">
					<h5>배송지 입력</h5>
				</div>
				<div class="order_address_div">
					<table class="order_address_table">
						<tr class="name_tr">
							<td><label>이름 : </label></td>
							<td colspan="5"><input type="text" name="orderName" required="required" /></td>
						</tr>
						<tr class="address_tr1">
							<td><label>주소 : </label></td>
							<td colspan="5"><input type="text" id="sample6_postcode" placeholder="우편번호" required="required" name="addressCode">&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" onclick="sample6_execDaumPostcode()" value="주소찾기"></td>
						</tr>
						<tr class="address_tr2">
							<td></td>
							<td colspan="5"><input type="text" id="sample6_address" placeholder="주소" required="required" name="address"></td>
						</tr>
						<tr class="address_tr3">
							<td></td>
							<td colspan="5"><input type="text" id="sample6_detailAddress" placeholder="상세주소" required="required" name="addressDetail"></td>
						</tr>
						<tr class="phone_tr">
							<td><label>연락처 : </label></td>
							<td colspan="5"><select name="orderPhone1">
									<option value="010">010</option>
									<option value="011">011</option>
									<option value="016">016</option>
									<option value="017">017</option>
									<option value="018">018</option>
									<option value="019">019</option>
							</select> <span>&nbsp;-&nbsp;</span> <input type="number" maxlength="4" required="required" oninput="maxLengthCheck(this)" name="orderPhone2" /> <span>&nbsp;-&nbsp;</span> <input type="number" maxlength="4" required="required" oninput="maxLengthCheck(this)" name="orderPhone3" /></td>
						</tr>
						<tr class="memo_tr">
							<td colspan="6"><select name="orderMemo" onclick="optionSelect(this);">
									<option value="0" selected="selected">배송시 요청사항 (선택사항)</option>
									<option value="1">배송전, 연락바랍니다.</option>
									<option value="2">부재시, 전화 또는 문자 주세요.</option>
									<option value="3">부재시, 경비실에 맡겨주세요.</option>
									<option value="4">직접 입력</option>
							</select></td>
						</tr>
					</table>
				</div>
			</div>
			<div class="buyItem_area">
				<div class="title_header">
					<h5>주문상품 정보</h5>
				</div>
				<div class="order_item_div">
					<c:forEach items="${ bIList }" var="bil">
						<table class="order_item_table">
							<tr class="img_tr">
								<td rowspan="4"><input type="hidden" value="${ bil.productNo }" name="productNo" /><img src="resources/business/images/${ bil.productThumNail }" alt="" /></td>
							</tr>
							<tr class="pName_tr">
								<td><span>${ bil.productName }</span></td>
							</tr>
							<tr class="pSize_tr">
								<td>사이즈 : <span>${ bil.productSize }</span><input type="hidden" name="productSize" value="${ bil.productSize }" /></td>
							</tr>
							<tr class="pPrice_pCount_tr">
								<td><input type="hidden" value="${ bil.productPrice }" name="productPrice" /><span>${ bil.productPrice }</span>원&nbsp;&nbsp;/&nbsp;&nbsp;<input type="hidden" value="${ bil.productCount }" name="productCount" /><span>${ bil.productCount }</span>개</td>
							</tr>
						</table>
					</c:forEach>
				</div>
			</div>
		</div>
		<div class="totalPrice_area">
			<input type="hidden" name="totalPrice" />총 결제금액 : <span id="totalPrice"></span>원<br><br>
			<button type="submit">결제하기</button>
		</div>
	</form>

	<script type="text/javascript">
		var status = '${ status }'
	</script>

	<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<jsp:include page="/WEB-INF/views/layout/footer.jsp"></jsp:include>
	<script src="resources/customer/js/customerBuyItem.js"></script>
</body>
</html>
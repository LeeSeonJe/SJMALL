<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>SJ MALL</title>
<link href="resources/business/css/businessLayout.css" rel="stylesheet">
<link href="resources/business/css/businessProductAdd.css" rel="stylesheet">
<!-- Font Awesome JS -->
<script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js" integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ" crossorigin="anonymous"></script>
<script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js" integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY" crossorigin="anonymous"></script>
<script type="text/javascript" src="${ pageContext.request.contextPath }/resources/business/textEditor/js/HuskyEZCreator.js" charset="UTF-8"></script>
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
				<li><a href="#">주문/배송조회</a><br></li>
				<li><a href="#">내가 쓴 리뷰</a><br></li>
				<li><a href="#">판매자문의</a><br></li>
				<li><a href="#">관리자문의</a></li>
			</ul>
		</nav>
		<!-- Page Content -->
		<div id="content">
			<h3>제품등록</h3>
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<div class="container-fluid">
					<form action="productInsert.bu" onsubmit="return submitContents();" method="POST" enctype="multipart/form-data">
						<table>
							<tr>
								<td>카테고리</td>
								<td><select name="productCategory">
										<option value="선택">선택</option>
										<option value="Top">Top</option>
										<option value="Pants">Pants</option>
										<option value="Skirt">Skirt</option>
										<option value="OnePice">OnePice</option>
										<option value="Shoes">Shoes</option>
								</select></td>
							</tr>
							<tr>
								<td>대표이미지</td>
								<td><input type="file" name="uploadFile" required="required"/></td>
							</tr>
							<tr>
								<td>제품이름</td>
								<td><input type="text" name="productName" required="required"/></td>
							</tr>
							<tr>
								<td>제품가격</td>
								<td><input type="number" name="productPrice" required="required"/></td>
							</tr>
							<tr>
								<td>제품상세설명</td>
								<td><textarea name="productDetail" id="productDetail" style="width: 100%; min-height: 500px;"></textarea></td>
							</tr>
							<tr>
								<td>사이즈</td>
								<td id="cateSize">카테고리를 선택해주세요.</td>
							</tr>
							<tr>
								<td><button type="submit">등록</button></td>
								<td><button></button></td>								
							</tr>
						</table>
					</form>
				</div>
			</nav>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/layout/footer.jsp"></jsp:include>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
	<script src="resources/business/js/businessProductAdd.js"></script>
</body>
</html>
<script type="text/javascript">
	var oEditors = [];
	var sLang = "ko_KR";
	nhn.husky.EZCreator
			.createInIFrame({
				oAppRef : oEditors,
				elPlaceHolder : "productDetail",
				sSkinURI : "${ pageContext.request.contextPath }/resources/business/textEditor/SmartEditor2Skin.html",
				htParams : {
					I18N_LOCALE : sLang,
					fOnBeforeUnload : function(){}
				},
				fCreator : "createSEditor2"
			});

	function pasteHTML() {
		var sHTML = '<img src="#">';
		oEditors.getById["productDetail"].exec("PASTE_HTML", [ sHTML ]);
	}

	<!--MainQuilllibrary-->
</script>

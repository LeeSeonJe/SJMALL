<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>SJ MALL</title>

</head>
<body>
	<jsp:include page="/WEB-INF/views/layout/header.jsp"></jsp:include>
	<main role="main">
		<div class="album py-5 bg-light">
			<div class="container">
				<c:if test="${ !empty pOnePieceList }">
					<h6 onclick="location.href=''">OnePiece</h6>
					<div class="row">
						<c:forEach items="${ pOnePieceList }" var="pol">
							<div class="col-md-4">
								<div class="card mb-4 box-shadow">
									<img class="card-img-top" src="resources/business/images/${ pol.productThumbNail }" alt="Card image cap">
									<div class="card-body">
										<p class="card-text">${ pol.productBrand }</p>
										<p class="card-text">${ pol.productName }</p>
										<p class="card-text">${ pol.productPrice }원</p>
										<div class="d-flex justify-content-between align-items-center">
											<div class="btn-group">
												<button type="button" class="btn btn-sm btn-outline-secondary" onclick="pDetailPage(${ pol.productNo });">상세보기</button>
											</div>
											<small class="text-muted">${ pol.enrollDate }</small>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</c:if>
			</div>
		</div>
	</main>

	<jsp:include page="/WEB-INF/views/layout/footer.jsp"></jsp:include>
</body>
</html>

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
				<c:if test="${ !empty pPantsList }">
					<h6 onclick="location.href=''">Pants</h6>
					<div class="row">
						<c:forEach items="${ pPantsList }" var="ppl">
							<div class="col-md-4">
								<div class="card mb-4 box-shadow">
									<img class="card-img-top" src="resources/business/images/${ ppl.productThumbNail }" alt="Card image cap">
									<div class="card-body">
										<p class="card-text">${ ppl.productBrand }</p>
										<p class="card-text">${ ppl.productName }</p>
										<p class="card-text">${ ppl.productPrice }원</p>
										<div class="d-flex justify-content-between align-items-center">
											<div class="btn-group">
												<button type="button" class="btn btn-sm btn-outline-secondary">담기</button>
												<button type="button" class="btn btn-sm btn-outline-secondary" onclick="pDetailPage(${ ptl.productNo });">상세</button>
											</div>
											<small class="text-muted">${ ppl.enrollDate }</small>
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

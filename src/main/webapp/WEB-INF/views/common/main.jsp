<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>SJ MALL</title>

</head>
<body>
	<jsp:include page="/WEB-INF/views/layout/header.jsp"></jsp:include>
	<main role="main">

		<section class="jumbotron text-center">
			<div class="container"></div>
		</section>
		<div class="album py-5 bg-light">
			<div class="container">
				<c:if test="${ !empty pTopList }">
					<h6 onclick="location.href='topPage.co'">Top Add</h6>
					<div class="row">
						<c:forEach items="${ pTopList }" var="ptl">
							<c:if test="${ ptl.status eq 'Y'.charAt(0) }">
								<div class="col-md-4">
									<div class="card mb-4 box-shadow">
										<img class="card-img-top" src="resources/business/images/${ ptl.productThumbNail }" alt="Card image cap">
										<div class="card-body">
											<p class="card-text">${ ptl.productBrand }</p>
											<p class="card-text">${ ptl.productName }</p>
											<p class="card-text">${ ptl.productPrice }원</p>
											<div class="d-flex justify-content-between align-items-center">
												<div class="btn-group">
													<button type="button" class="btn btn-sm btn-outline-secondary" onclick="pDetailPage(${ ptl.productNo });">상세보기</button>
												</div>
												<small class="text-muted">${ ptl.enrollDate }</small>
											</div>
										</div>
									</div>
								</div>
							</c:if>
						</c:forEach>
					</div>
				</c:if>
				<c:if test="${ !empty pPantsList }">
					<h6 onclick="location.href='pantsPage.co'">Pants Add</h6>
					<div class="row">
						<c:forEach items="${ pPantsList }" var="ppl">
							<c:if test="${ ppl.status eq 'Y'.charAt(0) }">
								<div class="col-md-4">
									<div class="card mb-4 box-shadow">
										<img class="card-img-top" src="resources/business/images/${ ppl.productThumbNail }" alt="Card image cap">
										<div class="card-body">
											<p class="card-text">${ ppl.productBrand }</p>
											<p class="card-text">${ ppl.productName }</p>
											<p class="card-text">${ ppl.productPrice }원</p>
											<div class="d-flex justify-content-between align-items-center">
												<div class="btn-group">
													<button type="button" class="btn btn-sm btn-outline-secondary" onclick="pDetailPage(${ ppl.productNo });">상세보기</button>
												</div>
												<small class="text-muted">${ ppl.enrollDate }</small>
											</div>
										</div>
									</div>
								</div>
							</c:if>
						</c:forEach>
					</div>
				</c:if>
				<c:if test="${ !empty pSkirtList }">
					<h6 onclick="location.href='skirtPage.co'">Skirt Add</h6>
					<div class="row">
						<c:forEach items="${ pSkirtList }" var="psl">
							<c:if test="${ psl.status eq 'Y'.charAt(0) }">
								<div class="col-md-4">
									<div class="card mb-4 box-shadow">
										<img class="card-img-top" src="resources/business/images/${ psl.productThumbNail }" alt="Card image cap">
										<div class="card-body">
											<p class="card-text">${ psl.productBrand }</p>
											<p class="card-text">${ psl.productName }</p>
											<p class="card-text">${ psl.productPrice }원</p>
											<div class="d-flex justify-content-between align-items-center">
												<div class="btn-group">
													<button type="button" class="btn btn-sm btn-outline-secondary" onclick="pDetailPage(${ psl.productNo });">상세보기</button>
												</div>
												<small class="text-muted">${ psl.enrollDate }</small>
											</div>
										</div>
									</div>
								</div>
							</c:if>
						</c:forEach>
					</div>
					<br>
				</c:if>
				<c:if test="${ !empty pOnePieceList }">
					<h6 onclick="location.href='onePiecePage.co'">OnePiece Add</h6>
					<div class="row">
						<c:forEach items="${ pOnePieceList }" var="pol">
							<c:if test="${ pol.status eq 'Y'.charAt(0) }">
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
							</c:if>
						</c:forEach>
					</div>
					<br>
				</c:if>
				<c:if test="${ !empty pShoesList }">
					<h6 onclick="location.href='shoesPage.co'">Shoes Add</h6>
					<div class="row">
						<c:forEach items="${ pShoesList }" var="psl">
							<c:if test="${ psl.status eq 'Y'.charAt(0) }">
								<div class="col-md-4">
									<div class="card mb-4 box-shadow">
										<img class="card-img-top" src="resources/business/images/${ psl.productThumbNail }" alt="Card image cap">
										<div class="card-body">
											<p class="card-text">${ psl.productBrand }</p>
											<p class="card-text">${ psl.productName }</p>
											<p class="card-text">${ psl.productPrice }원</p>
											<div class="d-flex justify-content-between align-items-center">
												<div class="btn-group">
													<button type="button" class="btn btn-sm btn-outline-secondary" onclick="pDetailPage(${ psl.productNo });">상세보기</button>
												</div>
												<small class="text-muted">${ psl.enrollDate }</small>
											</div>
										</div>
									</div>
								</div>
							</c:if>
						</c:forEach>
					</div>
				</c:if>
			</div>
		</div>

	</main>

	<jsp:include page="/WEB-INF/views/layout/footer.jsp"></jsp:include>
</body>
</html>

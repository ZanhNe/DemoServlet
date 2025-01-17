<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="container">
	<div class="row">
		<div class="col">
			<div id="carouselExampleIndicators" class="carousel slide"
				data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#carouselExampleIndicators" data-slide-to="0"
						class="active"></li>
					<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
					<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
				</ol>
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img class="d-block w-100"
							src="https://dummyimage.com/855x365/55595c/fff" alt="First slide">
					</div>
					<div class="carousel-item">
						<img class="d-block w-100"
							src="https://dummyimage.com/855x365/a30ca3/fff"
							alt="Second slide">
					</div>
					<div class="carousel-item">
						<img class="d-block w-100"
							src="https://dummyimage.com/855x365/1443ff/fff" alt="Third slide">
					</div>
				</div>
				<a class="carousel-control-prev" href="#carouselExampleIndicators"
					role="button" data-slide="prev"> <span
					class="carousel-control-prev-icon" aria-hidden="true"></span> <span
					class="sr-only">Previous</span>
				</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
					role="button" data-slide="next"> <span
					class="carousel-control-next-icon" aria-hidden="true"></span> <span
					class="sr-only">Next</span>
				</a>
			</div>
		</div>
		<div class="col-12 col-md-3">
			<c:forEach items="${listTop}" var="ltop">
				<div class="card">
					<div class="card-header bg-success text-white text-uppercase">
						<i class="fa fa-heart"></i> Top product
					</div>
					<img class="img-fluid border-0" src="${ltop.imageLink}"
						alt="Card image cap">
					<div class="card-body">
						<h4 class="card-title text-center">
							<a href="product.html" title="View Product">${ltop.productName}</a>
						</h4>
						<div class="row">
							<div class="col">
								<p class="btn btn-danger btn-block">${ltop.price}$</p>
							</div>
							<div class="col">
								<a href="product.html" class="btn btn-success btn-block">View</a>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</div>


<div class="container mt-3">
	<div class="row">
		<div class="col-sm">
			<div class="card">
				<div class="card-header bg-primary text-white text-uppercase">
					<i class="fa fa-star"></i> Last products
				</div>
				<div class="card-body">
					<div class="row">
						<c:forEach items="${listLast}" var="llast">
							<div class="col-sm">
								<div class="card">
									<img class="card-img-top" src="${llast.imageLink}"
										alt="Card image cap">
									<div class="card-body">
										<h4 class="card-title">
											<a href="product.html" title="View Product">${llast.productName}</a>
										</h4>
										<p class="card-text">${llast.description}</p>
										<div class="row">
											<div class="col">
												<p class="btn btn-danger btn-block">${llast.price}$</p>
											</div>
											<div class="col">
												<a href="cart.html" class="btn btn-success btn-block">Add
													to cart</a>
											</div>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>


					</div>
				</div>
			</div>
		</div>
	</div>
</div>


<div class="container mt-3 mb-4">
	<div class="row">
		<div class="col-sm">
			<div class="card">
				<div class="card-header bg-primary text-white text-uppercase">
					<i class="fa fa-trophy"></i> Best products
				</div>
				<div class="card-body">
					<div class="row">
						<c:forEach items="${listBest}" var="lbest">
							<div class="col-sm">
								<div class="card">
									<img class="card-img-top" src="${lbest.imageLink}"
										alt="Card image cap">
									<div class="card-body">
										<h4 class="card-title">
											<a href="product.html" title="View Product">${lbest.productName}</a>
										</h4>
										<p class="card-text">${lbest.description}</p>
										<div class="row">
											<div class="col">
												<p class="btn btn-danger btn-block">${lbest.price}$</p>
											</div>
											<div class="col">
												<a href="cart.html" class="btn btn-success btn-block">Add
													to cart</a>
											</div>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>



					</div>
				</div>
			</div>
		</div>
	</div>
</div>

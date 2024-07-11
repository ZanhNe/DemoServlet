<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<div class="container">
	<div class="row">
		<div class="col">
			<nav aria-label="breadcrumb">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="/">Home</a></li>
					<li class="breadcrumb-item"><a href="category.html">Category</a></li>
					<li class="breadcrumb-item active" aria-current="page">Product</li>
				</ol>
			</nav>
		</div>
	</div>
</div>
<div class="container">
	<c:forEach items="${list}" var="sp">
		<div class="row">
			<!-- Image -->
			<div class="col-12 col-lg-6">
				<div class="card bg-light mb-3">
					<div class="card-body">
						<a href="" data-toggle="modal" data-target="#productModal"> <img
							class="img-fluid" src="${sp.imageLink}" />
							<p class="text-center">Zoom</p>
						</a>
					</div>
				</div>
			</div>

			<!-- Add to cart -->
			<div class="col-12 col-lg-6 add_to_cart_block">
				<div class="card bg-light mb-3">
					<div class="card-body">
						<p class="price">${sp.price}$</p>
						<p class="price_discounted">149.90 $</p>
						<form method="get" action="cart.html">
							<div class="form-group">
								<label for="colors">Color</label> <select class="custom-select"
									id="colors">
									<option selected>Select</option>
									<option value="1">Blue</option>
									<option value="2">Red</option>
									<option value="3">Green</option>
								</select>
							</div>
							<div class="form-group">
								<label>Quantity :</label>
								<div class="input-group mb-3">
									<div class="input-group-prepend">
										<button type="button"
											class="quantity-left-minus btn btn-danger btn-number"
											data-type="minus" data-field="">
											<i class="fa fa-minus"></i>
										</button>
									</div>
									<input type="text" class="form-control" id="quantity"
										name="quantity" min="1" max="100" value="1">
									<div class="input-group-append">
										<button type="button"
											class="quantity-right-plus btn btn-success btn-number"
											data-type="plus" data-field="">
											<i class="fa fa-plus"></i>
										</button>
									</div>
								</div>
							</div>
							<a href="cart.html"
								class="btn btn-success btn-lg btn-block text-uppercase"> <i
								class="fa fa-shopping-cart"></i> Add To Cart
							</a>
						</form>
						<div class="product_rassurance">
							<ul class="list-inline">
								<li class="list-inline-item"><i class="fa fa-truck fa-2x"></i><br />Fast
									delivery</li>
								<li class="list-inline-item"><i
									class="fa fa-credit-card fa-2x"></i><br />Secure payment</li>
								<li class="list-inline-item"><i class="fa fa-phone fa-2x"></i><br />+33
									1 22 54 65 60</li>
							</ul>
						</div>
						<div class="reviews_product p-3 mb-2 ">
							3 reviews <i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
								class="fa fa-star"></i> <i class="fa fa-star"></i> <i
								class="fa fa-star"></i> (4/5) <a class="pull-right"
								href="#reviews">View all reviews</a>
						</div>
						<div class="datasheet p-3 mb-2 bg-info text-white">
							<a href="" class="text-white"><i class="fa fa-file-text"></i>
								Download DataSheet</a>
						</div>
					</div>
				</div>
			</div>
		</div>


		<div class="row">
			<!-- Description -->
			<div class="col-12">
				<div class="card border-light mb-3">
					<div class="card-header bg-primary text-white text-uppercase">
						<i class="fa fa-align-justify"></i> Description
					</div>
					<div class="card-body">
						<p class="card-text">${sp.description}</p>
						
					</div>
				</div>
			</div>

			<!-- Reviews -->
			<div class="col-12" id="reviews">
				<div class="card border-light mb-3">
					<div class="card-header bg-primary text-white text-uppercase">
						<i class="fa fa-comment"></i> Reviews
					</div>
					<div class="card-body">
						<div class="review">
							<span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
							<meta itemprop="datePublished" content="01-01-2016">
							January 01, 2018 <span class="fa fa-star"></span> <span
								class="fa fa-star"></span> <span class="fa fa-star"></span> <span
								class="fa fa-star"></span> <span class="fa fa-star"></span> by
							Paul Smith
							<p class="blockquote">
							<p class="mb-0">Lorem ipsum dolor sit amet, consectetur
								adipiscing elit. Integer posuere erat a ante.</p>
							</p>
							<hr>
						</div>
						<div class="review">
							<span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
							<meta itemprop="datePublished" content="01-01-2016">
							January 01, 2018 <span class="fa fa-star" aria-hidden="true"></span>
							<span class="fa fa-star" aria-hidden="true"></span> <span
								class="fa fa-star" aria-hidden="true"></span> <span
								class="fa fa-star" aria-hidden="true"></span> <span
								class="fa fa-star" aria-hidden="true"></span> by Paul Smith
							<p class="blockquote">
							<p class="mb-0">Lorem ipsum dolor sit amet, consectetur
								adipiscing elit. Integer posuere erat a ante.</p>
							</p>
							<hr>
						</div>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
</div>

<!-- Modal image -->
<c:forEach items="${list}" var="sp">
	<div class="modal fade" id="productModal" tabindex="-1" role="dialog"
		aria-labelledby="productModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="productModalLabel">${sp.productName}</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<img class="img-fluid" src="${sp.imageLink}" />
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
</c:forEach>

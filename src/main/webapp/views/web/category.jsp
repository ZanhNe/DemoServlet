<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="container">
	<div class="row">
		<div class="col">
			<nav aria-label="breadcrumb">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="index.html">Home</a></li>
					<li class="breadcrumb-item"><a href="category.html">Category</a></li>
					<li class="breadcrumb-item active" aria-current="page">Sub-category</li>
				</ol>
			</nav>
		</div>
	</div>
</div>
<div class="container">
	<div class="row">
		<div class="col-12 col-sm-3">
			<div class="card bg-light mb-3">
				<div class="card-header bg-primary text-white text-uppercase">
					<i class="fa fa-list"></i> Categories
				</div>
				<ul class="list-group category_block">
					<c:forEach items="${listCt}" var="ct">
						<li
							class="list-group-item ${cateId == ct.categoryId && cateId != null ? "active" : ""}"><a
							href="${pageContext.request.contextPath}/danh-muc?categoryId=${ct.categoryId}&indexPage=1&limit=6">${ct.icon}
								${ct.categoryName}</a></li>
					</c:forEach>
				</ul>
			</div>
			<c:forEach items="${listLast}" var="plast">
				<div class="card bg-light mb-3">
					<div class="card-header bg-success text-white text-uppercase">Last
						product</div>
					<div class="card-body">
						<img class="img-fluid" src="${plast.imageLink}" />
						<h5 class="card-title">${plast.productName}</h5>
						<p class="card-text">${plast.description}</p>
						<p class="bloc_left_price">${plast.price}$</p>
					</div>
				</div>
			</c:forEach>
		</div>
		<div class="col">
			<div class="row">
				<c:forEach items="${list}" var="p">
					<div class="col-12 col-md-6 col-lg-4">

						<div class="card">
							<img class="card-img-top" src="${p.imageLink}"
								alt="Card image cap">
							<div class="card-body">
								<h4 class="card-title">
									<a
										href="${pageContext.request.contextPath}/danh-muc/san-pham?sp=${p.productId}"
										title="View Product">${p.productName}</a>
								</h4>
								<p class="card-text">${p.description}</p>
								<div class="row">
									<div class="col">
										<p class="btn btn-danger btn-block">${p.price}$</p>
									</div>
									<div class="col">
										<a href="#" class="btn btn-success btn-block">Add to cart</a>
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
<form action='<c:url value="/danh-muc"/>' method="get" id="formSubmit">
	<ul class="pagination" id="pagination"></ul>
	<input type="hidden" value="" id="page" name="indexPage">
	<input type="hidden" value="" id="limit" name="limit">
	<input type="hidden" value="" id="cateId" name="categoryId">
	
</form>
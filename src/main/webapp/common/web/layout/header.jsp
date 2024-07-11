<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
	<div class="container">
		<a class="navbar-brand" href="index.html">Simple Ecommerce</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarsExampleDefault"
			aria-controls="navbarsExampleDefault" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse justify-content-end"
			id="navbarsExampleDefault">
			<ul class="navbar-nav m-auto">
				<li class="nav-item active"><a class="nav-link" href="${pageContext.request.contextPath}/trang-chu">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/danh-muc?indexPage=1&limit=6">Categories</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="product.html">Cart</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="contact.html">Contact</a>
				</li>
				<c:if test="${empty USERMODEL}">
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/login?action=login">Login</a>
				</li>
				</c:if>
				<c:if test="${not empty USERMODEL}">
				<li class="nav-item">Welcome, ${USERMODEL.userName}</a>
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/login?action=logout">Logout</a>
				</c:if>
			</ul>

			<form action="${pageContext.request.contextPath}/danh-muc" method="get" class="form-inline my-2 my-lg-0">
				<div class="input-group input-group-sm">
					<input type="text" name="search" class="form-control" placeholder="Search...">
					<div class="input-group-append">
						<button type="button" class="btn btn-secondary btn-number">
							<i class="fa fa-search"></i>
						</button>
					</div>
				</div>
				<a class="btn btn-success btn-sm ml-3" href="cart.html"> <i
					class="fa fa-shopping-cart"></i> Cart <span
					class="badge badge-light">3</span>
				</a>
			</form>
		</div>
	</div>
</nav>

<section class="jumbotron text-center">
	<div class="container">
		<h1 class="jumbotron-heading">E-COMMERCE BOOTSTRAP THEME</h1>
		<p class="lead text-muted mb-0">Simple theme for e-commerce buid
			with Bootstrap 4.0.0. Pages available : home, category, product, cart
			and contact</p>
	</div>
</section>
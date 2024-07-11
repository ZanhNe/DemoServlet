<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-product"/>
<form id="formSubmit">
	<div class="form-group">
		<label class="col-sm-3 control-label no-padding-right">Category
			name</label>
		<div class="col-sm-9">
			<select class="form-control" id="categoryId" name="categoryId">
				<option value="">Chọn loại sản phẩm</option>
				<c:forEach items="${listCate}" var="item">
					<c:choose>
						<c:when
							test="${not empty productModel && productModel.categoryId == item.categoryId}">
							<option selected="selected" value="${item.categoryId}">${item.categoryName}</option>
						</c:when>
						<c:otherwise>
							<option value="${item.categoryId}">${item.categoryName}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>


			</select>
		</div>
	</div>
	<br /> <br />

	<div class="form-group">
		<label class="col-sm-3 control-label no-padding-right">Product
			Name</label>
		<div class="col-sm-9">
			<input type="text" class="form-control" id="productName" name="productName"
				value="${productModel.productName}" />
		</div>
	</div>
	<br /> <br />

	<div class="form-group">
		<label class="col-sm-3 control-label no-padding-right">Description</label>
		<div class="col-sm-9">
			<input type="text" class="form-control" id="description"
				name="description" value="${productModel.description}" />
		</div>
	</div>
	<br /> <br />

	<div class="form-group">
		<label class="col-sm-3 control-label no-padding-right">Price</label>
		<div class="col-sm-9">
			<input type="text" class="form-control" id="price"
				name="price" value="${productModel.price}" />
		</div>
	</div>
	<br /> <br />

	<div class="form-group">
		<label class="col-sm-3 control-label no-padding-right">Image
			link</label>
		<div class="col-sm-9">
			<input type="text" class="form-control" id="imageLink"
				name="imageLink" value="${productModel.imageLink}" />
		</div>
	</div>
	<br /> <br />
	<div class="form-group">
		<label class="col-sm-3 control-label no-padding-right">Seller</label>
		<div class="col-sm-9">
			<input type="text" class="form-control" id="sellerId"
				name="sellerId" value="${productModel.sellerId}" />
		</div>
	</div>
	<br /> <br />

	<div class="form-group">
		<label class="col-sm-3 control-label no-padding-right">Amount</label>
		<div class="col-sm-9">
			<input type="text" class="form-control" id="amount"
				name="amount" value="${productModel.amount}" />
		</div>
	</div>
	<br /> <br />
	<div class="form-group">
		<div class="col-sm-12">
			<c:choose>
				<c:when test="${not empty productModel}">
					<input type="button" class="btn btn-white btn-warning btn-bold"
						value="Cập nhật bài viết" id="btnUpdateOrAdd" />
				</c:when>
				<c:otherwise>
					<input type="button" class="btn btn-white btn-warning btn-bold"
						value="Thêm bài viết" id="btnUpdateOrAdd" />
					
				</c:otherwise>
			</c:choose>
			<input type="hidden" value="${productModel.productId}" id="productId" name="productId" />
		</div>
	</div>

</form>

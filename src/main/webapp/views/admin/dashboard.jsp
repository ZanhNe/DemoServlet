<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<c:if test="${not empty list}">

	<div class="widget-box table-filter">
		<div class="table-btn-controls">
			<div class="pull-right tableTools-container">
				<div class="dt-buttons btn-overlap btn-group">
					<a flag="info" class="dt-button buttons-colvis btn btn-white btn-primary btn-bold" data-toggle="tooltip" title='Thêm bài viết' href='<c:url value="/admin-home?type=edit"/>'> 
						<span>
							<i class="fa fa-plus-circle bigger-110 purple"></i>
						</span>
					</a>
					<button id="btnDelete" type="button"
						class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
						data-toggle="tooltip" title='Xóa bài viết'>
						<span> <i class="fa fa-trash-o bigger-110 pink"></i>
						</span>
					</button>
				</div>
			</div>
		</div>
	</div>
		
	<table class="table table-striped" border="1">
		<thead>
			<tr>
				<th scope="col"></th>
				<th scope="col">ProductID</th>
				<th scope="col">ProductName</th>
				<th scope="col">Description</th>
				<th scope="col">Price</th>
				<th scope="col">CategoryID</th>
				<th scope="col">SellerID</th>
				<th scope="col">Amount</th>
				<th scope="col">Action</th>
			</tr>
			
		</thead>
		<tbody>
			<c:forEach items="${list}" var="item">
			
				<tr>
					<td><input class="form-check-input" type="checkbox" id="checkbox" name="productId" value="${item.productId}" ></td>
					<th scope="row">${item.productId}</th>
					<td>${item.productName}</td>
					<td>${item.description}</td>
					<td>${item.price}</td>
					<td>${item.categoryId}</td>
					<td>${item.sellerId}</td>
					<td>${item.amount}</td>
					<td><a class="btn btn-sm btn-primary btn-edit"
						data-toggle="tooltip" title="Cập nhật sản phẩm" href="<c:url value="/admin-home?type=edit&productId=${item.productId}"/>"><i
							class="fa fa-pencil-square-o" aria-hidden="true"></i> </a></td>
				</tr>
			</c:forEach>


		</tbody>
	</table>



	<form action="<c:url value="/admin-home"/>" method="get"
		id="formSubmit">
		<ul class="pagination" id="pagination"></ul>
		<input type="hidden" value="" name="limit" id="limit"> 
		<input type="hidden" value="" name="indexPage" id="indexPage">
		<input type="hidden" value="list" name="type">
	</form>

</c:if>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="vn">
<head>
<!-- Site meta -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Free Bootstrap 4 Ecommerce Template</title>
<!-- CSS -->
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="//fonts.googleapis.com/css?family=Open+Sans:400,300,600"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/support_view/css/style.css" />"
	rel="stylesheet" type="text/css">
</head>
<body>
	<!--Header-->
	<%@include file="/common/web/layout/header.jsp"%>
	<!--End  -->

	<!--Content-->
	<dec:body />
	<!--End  -->

	<!--Footer-->
	<%@include file="/common/web/layout/footer.jsp"%>
	<!--End -->

	<!-- JS -->
	<script src="//code.jquery.com/jquery-3.2.1.slim.min.js"
		type="text/javascript"></script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		type="text/javascript"></script>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script
		src="<c:url value="/support_view/js/jquery.twbsPagination.js"/>"
		type="text/javascript"></script>

	<script type="text/javascript">
		//Plus & Minus for Quantity product
		$(document).ready(function() {
			var quantity = 1;

			$('.quantity-right-plus').click(function(e) {
				e.preventDefault();
				var quantity = parseInt($('#quantity').val());
				$('#quantity').val(quantity + 1);
			});

			$('.quantity-left-minus').click(function(e) {
				e.preventDefault();
				var quantity = parseInt($('#quantity').val());
				if (quantity > 1) {
					$('#quantity').val(quantity - 1);
				}
			});

		});
	</script>
	<script type="text/javascript">
		var totalPages = ${paging.totalIndex};
		var limit = 6;
		var cate;
		if (${paging.categoryId != 0}) { 
			cate = ${paging.categoryId};
		}
		
		var currentPage = ${paging.indexPage};
		$(function() {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages : totalPages,
				visiblePages : 3,
				startPage : currentPage,
				onPageClick : function(event, page) {
					if (currentPage != page) 
						{
							$("#cateId").val(cate);
							
							$("#limit").val(limit);
							$("#page").val(page);
							$("#formSubmit").submit();
						}

				}
			})
		});
	</script>

</body>
</html>



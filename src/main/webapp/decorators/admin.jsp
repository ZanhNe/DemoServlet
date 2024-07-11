<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<c:url var="APIurl" value="/api-admin-product"/>
<!DOCTYPE html>
<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>Dashboard - Ace Admin</title>
		<meta name="description" content="overview &amp; stats" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="<c:url value="/support_view/assets/css/bootstrap.min.css"/>" />
		<link rel="stylesheet" href="<c:url value="/support_view/assets/font-awesome/4.2.0/css/font-awesome.min.css"/>" />
		<!-- page specific plugin styles -->
		<!-- text fonts -->
		<link rel="stylesheet" href="<c:url value="/support_view/assets/fonts/fonts.googleapis.com.css"/>" />
		<!-- ace styles -->
		<link rel="stylesheet" href="<c:url value="/support_view/assets/css/ace.min.css"/>" class="ace-main-stylesheet" id="main-ace-style" />
		<script src="<c:url value="/support_view/assets/js/ace-extra.min.js"/>"></script>
		<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.13.3/themes/smoothness/jquery-ui.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.13.3/jquery-ui.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
		<script src="<c:url value="/support_view/assets/js/jquery.2.1.1.min.js"/>"></script>
		<script src="<c:url value="/support_view/js/jquery.twbsPagination.js"/>" type="text/javascript"></script>
</head>
<body class="no-skin">
		
		<!--Header  -->
		<%@include file="/common/admin/layout/header.jsp" %>
		<!--  -->
		
		<!--Content  -->
		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>
			<%@include file="/common/admin/layout/menu.jsp" %>
			
			<div class="main-content">
				<div class="main-content-inner">
					<dec:body />
				</div>
			</div>
			
			
		</div>
		
			<!--Footer  -->
			<%@include file="/common/admin/layout/footer.jsp" %>
			<!--  -->
		<!--End main-container  -->
		
		
		<script src="<c:url value="/support_view/assets/js/bootstrap.min.js"/>"></script>
		<script src="<c:url value="/support_view/assets/js/jquery-ui.custom.min.js"/>"></script>
		<script src="<c:url value="/support_view/assets/js/jquery.ui.touch-punch.min.js"/>"></script>
		<script src="<c:url value="/support_view/assets/js/jquery.easypiechart.min.js"/>"></script>
		<script src="<c:url value="/support_view/assets/js/jquery.sparkline.min.js"/>"></script>
		<script src="<c:url value="/support_view/assets/js/jquery.flot.min.js"/>"></script>
		<script src="<c:url value="/support_view/assets/js/jquery.flot.pie.min.js"/>"></script>
		<script src="<c:url value="/support_view/assets/js/jquery.flot.resize.min.js"/>"></script>
		<script src="<c:url value="/support_view/assets/js/ace-elements.min.js"/>"></script>
		<script src="<c:url value="/support_view/assets/js/ace.min.js"/>"></script>
		
		<script src="<c:url value="/support_view/assets/js/jquery-ui.min.js"/>"></script>
		<script type="text/javascript">
		$(function() {
			var limit = ${paging.limit};
			var totalPages = ${paging.totalIndex};
			var currentPage = ${paging.indexPage};
	
			window.pagObj = $('#pagination').twbsPagination({
				totalPages : totalPages,
				visiblePages : 3,
				startPage : currentPage,
				onPageClick : function(event, page) {
					if (currentPage != page) {
						$('#limit').val(limit);
						$('#indexPage').val(page);
						$('#formSubmit').submit();
					}
				}
			})
		});
	</script>
	
	<script>
		$('#btnDelete').click(function(e){
			e.preventDefault();
			var selectedProducts = [];
			
			$('input[type=checkbox]').each(function(i,v){
				if (this.checked) {
					var data = {};
					console.log(""+v.name+" : "+v.value);
					data[""+v.name+""] = v.value;
					selectedProducts.push(data);
					
				}
			});
			  if (!isEmpty(selectedProducts)) {
				console.log(selectedProducts);
				deleteProduct(selectedProducts);
				
			}  
			
		});
		
		 function isEmpty(data) {
			 return JSON.stringify(data) === '{}';
		}
		function deleteProduct(data) {
			$.ajax({
				url: '${APIurl}',
				type: 'DELETE',
				contentType: 'application/json',
				data: JSON.stringify(data),
				
				success: function(){
					location.reload(true);
				},
				error: function(error){
					console.log(error);
				}
			});
		} 
		
	</script>
	<script>
	$('#btnUpdateOrAdd').click(function(e){
		e.preventDefault();
		var dataForm = $('#formSubmit').serializeArray();
		var data = {};
		$.each(dataForm, function(i,v) {
			data[""+v.name+""] = v.value;
		})
		var id = $('#productId').val();
		if (id == "") {
			Add(data);
		} else {
			Update(data);
		}
	});
	function Add(data){
		$.ajax({
			url: '${APIurl}',
			type: 'POST',
			contentType: 'application/json',
			data: JSON.stringify(data),
			dataType: 'json',
			success: function(result){
				location.reload(true);
			},
			error: function(error){
				console.log(error);
			}
		});
	}
	function Update(data){
		$.ajax({
			url: '${APIurl}',
			type: 'PUT',
			contentType: 'application/json',
			data: JSON.stringify(data),
			dataType: 'json',
			success: function(result){
				location.reload(true);
			},
			error: function(error){
				console.log(error);
			}
		});
	}
</script>
		
</body>

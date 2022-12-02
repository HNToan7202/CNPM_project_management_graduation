<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url value="/resources/" var="URL"></c:url>
<!DOCTYPE html>
<html lang="fr">
<head>
<!-- Site meta -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>QUẢN LÝ ĐỀ TÀI</title>

<!-- CSS -->
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="//fonts.googleapis.com/css?family=Open+Sans:400,300,600"
	rel="stylesheet" type="text/css">

<!-- Custom fonts for this template -->
<link href="/decorators/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/decorators/css/sb-admin-2.min.css" rel="stylesheet">

<!-- Custom styles for this page -->
<link href="/decorators/vendor/datatables/dataTables.bootstrap4.min.css"
	rel="stylesheet">
<link href="${URL}css/styles.css" rel="stylesheet" type="text/css">
<link href="${URL}css/student.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="/common/student/header.jsp"%>

	<div class="d-flex">
		<%@ include file="/common/student/slidebar.jsp"%>
		<!-- body -->
		<sitemesh:write property='body'></sitemesh:write>
		<!-- body -->
	</div>
	<!--=== Footer v4 ===-->
	<jsp:include page="/common/student/footer.jsp"></jsp:include>
	<!--=== End Footer v4 ===-->

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"
		type="text/javascript"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min	.js"
		type="text/javascript"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script src="resources/js/script.js" type="text/javascript"></script>
	<script src="/decorators/vendor/jquery/jquery.min.js"></script>
	<script src="/decorators/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="/decorators/vendor/jquery-easing/jquery.easing.min.js"></script>
	<script src="/decorators/js/sb-admin-2.min.js"></script>
	<script src="/decorators/vendor/datatables/jquery.dataTables.min.js"></script>
	<script
		src="/decorators/vendor/datatables/dataTables.bootstrap4.min.js"></script>
	<script src="/decorators/js/demo/datatables-demo.js"></script>
	<script src="${URL}js/student.js"></script>
</body>
</html>
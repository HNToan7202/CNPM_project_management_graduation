<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url value="/resources" var="URL"></c:url>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0"
    />
    <title>ADMIN</title>

    <meta name="description" content="" />
	<script src="https://kit.fontawesome.com/yourcode.js" crossorigin="anonymous"></script>
    <!-- Favicon -->
    <link rel="icon" type="image/x-icon" href="${URL}/assets/img/favicon/favicon.ico" />

    <!-- Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Public+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap"
      rel="stylesheet"
    />

    <!-- Icons. Uncomment required icon fonts -->
    <link rel="stylesheet" href="${URL}/assets/vendor/fonts/boxicons.css" />

    <!-- Core CSS -->
    <link rel="stylesheet" href="${URL}/assets/vendor/css/core.css" class="template-customizer-core-css" />
    <link rel="stylesheet" href="${URL}/assets/vendor/css/theme-default.css" class="template-customizer-theme-css" />
    <link rel="stylesheet" href="${URL}/assets/css/demo.css" />

    <!-- Vendors CSS -->
    <link rel="stylesheet" href="${URL}/assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.css" />

    <link rel="stylesheet" href="${URL}/assets/vendor/libs/apex-charts/apex-charts.css" />

    <!-- Page CSS -->

    <!-- Helpers -->
    <script src="${URL}/assets/vendor/js/helpers.js"></script>
    <script src="${URL}/assets/js/config.js"></script>
  </head>

<body>

 	
	<%@ include file="/common/AD/slidebar.jsp"%> 
	<%@ include file="/common/AD/header.jsp"%> 


	<!-- body -->
	<sitemesh:write property='body'></sitemesh:write>
	<!-- body -->

	<!--=== Footer v4 ===-->

 	<jsp:include page="/common/AD/footer.jsp"></jsp:include> 

	<!--=== End Footer v4 ===-->
   
 <!-- Core JS -->
    <!-- build:js assets/vendor/js/core.js -->
    <script src="${URL}/assets/vendor/libs/jquery/jquery.js"></script>
    <script src="${URL}/assets/vendor/libs/popper/popper.js"></script>
    <script src="${URL}/assets/vendor/js/bootstrap.js"></script>
    <script src="${URL}/assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.js"></script>

    <script src="${URL}/assets/vendor/js/menu.js"></script>
    <!-- endbuild -->

    <!-- Vendors JS -->
    <script src="${URL}/assets/vendor/libs/apex-charts/apexcharts.js"></script>

    <!-- Main JS -->
    <script src="${URL}/assets/js/main.js"></script>
    <!-- Page JS -->
    <script src="${URL}/assets/js/pages-account-settings-account.js"></script>
    <!-- Page JS -->
    <script src="${URL}/assets/js/dashboards-analytics.js"></script>

    <!-- Place this tag in your head or just before your close body tag. -->
    <script async defer src="https://buttons.github.io/buttons.js"></script>
    
 
</body>

</html>
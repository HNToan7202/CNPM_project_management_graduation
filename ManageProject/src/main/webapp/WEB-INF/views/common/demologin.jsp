
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Login Page</title>
<meta content="" name="description">
<meta content="" name="keywords">

<!-- Favicons -->
<link href="/assets/img/favicon.png" rel="icon">
<link href="/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

<!-- Google Fonts -->
<link href="https://fonts.gstatic.com" rel="preconnect">
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">

<!-- Template Main CSS File -->
<link href="/assets/css/style.css" rel="stylesheet">
<link href="/assets/css/bootstrap.min.css" rel="stylesheet">
<!-- =======================================================
  * Template Name: NiceAdmin - v2.4.1
  * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>
<body>

	<main>

		<div class="container">

			<section
				class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
				<div class="container">
					<div class="row justify-content-center">
						<div
							class="col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center">

							<div class="d-flex justify-content-center py-4">
								<a href="index.html"
									class="logo d-flex align-items-center w-auto"> <img
									src="/assets/img/logospkt.webp" alt=""> <span
									class="d-none d-lg-block">HCMUTE</span>
								</a>
							</div>
							<!-- End Logo -->

							<div class="card mb-3">

								<div class="card-body">

									<div class="pt-4 pb-2">
										<h5 class="card-title text-center pb-0 fs-4">ĐĂNG NHẬP</h5>
										<p class="text-center small">Nhập tài khoản và mật khẩu để
											đăng nhập</p>
									</div>

									<form class="row g-3 needs-validation" novalidate
										action="<c:url value="/login"/>" method="post"
										enctype="multipart/form-data">

										<div class="col-12">
											<label for="yourUsername" class="form-label">Tài
												Khoản</label>
											<div class="input-group has-validation">
												<span class="input-group-text" id="username">MSSV</span> <input
													type="email" name="email" class="form-control"
													value="${user.email}" id="email" required>
												<div class="invalid-feedback">Vui lòng nhập tài khoản.</div>
											</div>
										</div>

										<div class="col-12">
											<label for="yourPassword" class="form-label">Mật Khẩu</label>
											<input type="password" name="password" class="form-control"
												value="${user.password}" id="yourPassword" required>
											<div class="invalid-feedback">Vui lòng nhập mật khẩu !</div>
										</div>

										<div class="col-12">
											<div class="form-check">
												<input class="form-check-input" type="checkbox"
													name="remember" value="true" id="rememberMe"> <label
													class="form-check-label" for="rememberMe">Remember
													me</label>
											</div>
										</div>
										<div class="col-12">
											<button class="btn btn-primary w-100" type="submit">Login</button>
										</div>
									</form>

								</div>
							</div>
						</div>
					</div>
				</div>

			</section>

		</div>
	</main>
	<a href="#"
		class="back-to-top d-flex align-items-center justify-content-center"><i
		class="bi bi-arrow-up-short"></i></a>

	<!-- Template Main JS File -->
	<script src="/assets/js/main.js"></script>
	<script src="/assets/js/bootstrap.min.js"></script>

	<!-- End #main -->
</body>
<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div id="main">

	<div>
		<h2>Thay Đổi Mật Khẩu Mới</h2>
	</div>

	<form action="/reset_password" method="post"
		style="max-width: 350px; margin: 0 auto;">
		<input type="hidden" name="token" value="${token}" />
		<div class="border border-secondary rounded p-3">
			<div>
				<p>
					<input type="password" name="password" id="password"
						class="form-control" placeholder="Enter your new password"
						required autofocus />
				</p>
				<p>
					<input type="password" class="form-control"
						placeholder="Confirm your new password" required
						oninput="checkPasswordMatch(this);" />
				</p>
				<p class="text-center">
					<input type="submit" value="Change Password"
						class="btn btn-primary" />
				</p>
			</div>
		</div>
	</form>

	<script type="text/javascript">
		function checkPasswordMatch(fieldConfirmPassword) {
			if (fieldConfirmPassword.value != $("#password").val()) {
				fieldConfirmPassword
						.setCustomValidity("Passwords do not match!");
			} else {
				fieldConfirmPassword.setCustomValidity("");
			}
		}
	</script>


</div> --%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Bootstrap 5 Forgot Password</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body>
	<div class="container d-flex flex-column">
		<div
			class="row align-items-center justify-content-center
          min-vh-100">
			<div class="col-12 col-md-8 col-lg-4">
				<div class="card shadow-sm">
					<div class="card-body">
						<div class="mb-4">
							<h5>Forgot Password?</h5>
							<p class="mb-2">Enter your registered email ID to reset the
								password</p>
						</div>


						<c:if test="${error != null}">
							<p class="text-danger">${error}</p>
						</c:if>
						<c:if test="${message != null}">
							<p class="text-warning">${message}</p>
						</c:if>
						<form action="/reset_password" method="post"
							style="max-width: 350px; margin: 0 auto;">
							<input type="hidden" name="token" value="${token}" />
							<div class="border border-secondary rounded p-3">
								<div>
									<p>
										<input type="password" name="password" id="password"
											class="form-control" placeholder="Enter your new password"
											required autofocus />
									</p>
									<p>
										<input type="password" class="form-control"
											placeholder="Confirm your new password" required
											oninput="checkPasswordMatch(this);" />
									</p>
									<p class="text-center">
										<input type="submit" value="Change Password"
											class="btn btn-primary" />
									</p>
								</div>
							</div>
						</form>

						<script type="text/javascript">
							function checkPasswordMatch(fieldConfirmPassword) {
								if (fieldConfirmPassword.value != $("#password")
										.val()) {
									fieldConfirmPassword
											.setCustomValidity("Passwords do not match!");
								} else {
									fieldConfirmPassword.setCustomValidity("");
								}
							}
						</script>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>




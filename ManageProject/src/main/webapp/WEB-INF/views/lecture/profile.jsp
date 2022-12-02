<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
</head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<body>

	<div class="container rounded bg-white mt-5 mb-5">
		<div class="row">
			<div class="col-md-3 border-right">
				<div
					class="d-flex flex-column align-items-center text-center p-3 py-5">
					<img class="rounded-circle mt-5" width="150px"
						src="/images/${user.image}"><span
						class="font-weight-bold">Edogaru</span><span class="text-black-50">edogaru@mail.com.my</span><span>
					</span>
				</div>
			</div>
			<div class="col-md-5 border-right">
				<div class="p-3 py-5">
					<div class="d-flex justify-content-between align-items-center mb-3">
						<h4 class="text-right">Profile Settings</h4>
					</div>
					<div class="row mt-3">
						<div class="col-md-12">
							<label class="labels">ID</label><input type="text"
								class="form-control" placeholder="first name" readonly="readonly"
								value="${user.id }">
						</div>
					</div>
					<div class="row mt-3">
						<div class="col-md-12">
							<label class="labels">Name</label><input type="text" readonly="readonly"
								class="form-control" value="${user.name}">
						</div>
						<div class="col-md-12">
							<label class="labels">Date Of Birth</label><input type="date" readonly="readonly"
								class="form-control" value="${user.dateofbirth}">
						</div>
						<div class="col-md-12">
							<label class="labels">Address </label><input type="text"
								class="form-control" value="${user.address}">
						</div>
						<div class="col-md-12">
							<label class="labels">Email</label><input type="text"
								class="form-control" value="${user.email}">
						</div>


					</div>
				</div>

			</div>
		</div>
</body>
</html>
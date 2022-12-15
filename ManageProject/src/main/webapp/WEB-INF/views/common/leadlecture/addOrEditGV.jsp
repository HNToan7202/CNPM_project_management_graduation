
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!doctype html>

<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<title>Giảng Viên</title>
</head>

<body>

	<section class="container">

		<div class="col mt-4">
			<form action=<c:url value="/leadlecture/dsgiangvien/saveofUpdate" />
				method="POST" enctype="multipart/form-data">

				<div class="card-body">

					<div class="mb-3">
						<label for="id" class="form-lablel">Mã số giảng viên:</label> <input
							readonly="readonly" type="text" class="form-control" name="id"
							value="${lecture.id}" id="id" aria-describedby="id"
							placeholder="id" />
						<!-- readonly="readonly" : chỉ cho phép đọc-->
					</div>

					<div class="mb-3">
						<label for="name" class="form-lablel">Họ và tên</label> <input
							type="text" value="${lecture.name}" id="name" name="name"
							readonly="readonly" aria-describedby="name" placeholder="Name">
					</div>

					<div class="mb-3">
						<label for="dateofbirth" class="form-lablel">Ngày sinh:</label> <input
							type="date" value="${lecture.dateofbirth}" id="dateofbirth"
							readonly="readonly" name="dateofbirth">

					</div>
					<div class="mb-3">
						<label for="address" class="form-lablel">Địa chỉ</label> <input
							readonly="readonly" type="text" value="${lecture.address}"
							id="address" name="address" aria-describedby="address"
							placeholder="Address">
					</div>
					<div class="mb-3">
						<input type="text" name="image" value="${lecture.image}"
							readonly="readonly" hidden="hidden" /> <input type="file"
							name="imageFile" />
					</div>
					<div class="mb-3">
						<label for="email" class="form-lablel">email:</label> <input
							readonly="readonly" type="email" value="${lecture.email}"
							id="email" name="email">

					</div>

					<div class="mb-3">
						<label for="storeid" class="form-lablel"> Mã Hội Đồng</label> <br>
						<select class="form-select" name="idhoidong"
							aria-label="idhoidong">
							<c:forEach items="${dshoidong}" var="item">
								<option value="${item.id}"
									selected="${item.id == lecture.idhoidong ? 'selected':'' }">${item.id}</option>
							</c:forEach>

						</select>
					</div>

					<div class="mb-3">
						<label for="idhoidong" class="form-lablel">Trạng Thái</label> <input
							type="text" value="${lecture.isactive}" id="isactive"
							name="isactive">

					</div>


					<button class="btn btn-primary" type="submit">
						<i class="fas fa-save"></i>
						<!-- true là cập nhật -->
						<c:if test="${lecture.isEdit }">
							<span>Xác Nhận</span>
						</c:if>

						<c:if test="${!lecture.isEdit }">
							<span>Save</span>
						</c:if>

					</button>
				</div>
			</form>

		</div>

	</section>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>

</body>

</html>
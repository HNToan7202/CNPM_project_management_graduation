<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/common/taglib.jsp"%>

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

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
	integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

<title>Hello, world!</title>
</head>
<body>



	<section class="row">

		<div class="col mt-4">

			<div class="card">

				<div class="card-header">List Project</div>

				<div class="card-body">

					<!-- Hiển thông báo -->

					<c:if test="${message != null}">

						<div class="alert alert-primary" role="alert">

							<i>${message}</i>

						</div>

					</c:if>

					<!-- Hêt thông báo -->

					<table class="table table-striped table-responsive">

						<thead class="thead-inverse">

							<tr>
								<th></th>
								<th>Name</th>
								<th>Desciption</th>
								<th>yeuCau</th>
								<th>soLuongSV</th>
								<th>is_Faculty</th>
								<th>Faculty</th>
								<th>nienKhoa</th>
								<th>point</th>
								<th>id_TimeProject</th>
								<th>create_at</th>
								<th>update_at</th>
								<th>is_active</th>
							</tr>



						</thead>

						<tbody>

							<c:forEach items="${projects}" var="item">

								<tr>

									<td scope="row">${item.name}</td>
									<td>${item.desciption}</td>
									<td>${item.muctieu}</td>
									<td>${item.yeucau}</td>
									<td>${item.soluongsv}</td>
									<td>${item.isfaculty}</td>
									<td>${item.faculty}</td>
									<td>${item.nienkhoa}</td>
									<td>${item.point}</td>
									<td>${item.idtimeproject}</td>
									<td>${item.create_at}</td>
									<td>${item.update_at}</td>
									<td>${item.is_active ? 'Actived' : 'Not Active'}</td>

									<td><a href="/admin/categories/view/${item.id}"
										class="btn btn-outline-info"><i class="fa fa-info"></i></a> <a
										href="/admin/categories/edit/${item.id}"
										class="btn btn-outline-warning"><i class="fa fa-edit"></i></a>

										<a href="/admin/categories/delete/${item.id}"
										class="btn btn-outline-danger"><i class="fa fa-trash"></i></a></td>

								</tr>

							</c:forEach>

						</tbody>



					</table>



				</div>

			</div>

		</div>

	</section>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Lecture</title>
</head>
<body>
	<!-- Begin Page Content -->
	<div class="container-fluid">

		<!-- Page Heading -->
		<h1 class="h3 mb-2 text-gray-800">Danh sách Giảng Viên</h1>

		<!-- DataTales Example -->
		<div class="card shadow mb-4">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">Xem Danh sách</h6>
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-bordered" id="dataTable" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th>Mã số</th>
								<th>Tên</th>
								<th>Ngày sinh</th>
								<th>Địa chỉ</th>
								<th>Nhận diện</th>
								<th>Email</th>

								<th>Id_hoidong</th>
								<th>Is_active</th>
								<th>Action</th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th>Mã số</th>
								<th>Tên</th>
								<th>Ngày sinh</th>
								<th>Địa chỉ</th>
								<th>Nhận diện</th>
								<th>Email</th>
								<th>Id_project</th>
								<th>Id_hoidong</th>
								<th>Is_active</th>
								<th>Action</th>
							</tr>
						</tfoot>
						<tbody>
							<c:forEach items="${lecture}" var="lecture">
								<tr>
									<td>${lecture.id}</td>
									<td>${lecture.name}</td>
									<td>${lecture.dateofbirth}</td>
									<td>${lecture.address}</td>
									<td>${lecture.image}</td>
									<td>${lecture.email}</td>
									<td>${lecture.idhoidong}</td>
									<td>${lecture.isactive ? 'Actived' : 'Not Active'}</td>
									<td>
										<!-- Button trigger modal --> <a href="Thông tin"
										class="btn btn-outline-info"><i class="fa fa-info"></i></a> <a
										href="chỉnh sửa" class="btn btn-outline-warning"><i
											class="fa fa-edit"></i></a>
										<button type="button" class="btn btn-primary"
											data-bs-toggle="modal"
											data-bs-target="#exampleModal${lecture.id}">
											<i class="fa fa-trash"></i>
										</button>
									</td>
								</tr>
								<!-- Modal -->
								<div class="modal fade" id="exampleModal${lecture.id}"
									tabindex="-1" aria-labelledby="exampleModalLabel${lecture.id}"
									aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<h5 class="modal-title"
													id="exampleModalLabel${category.categoryId}">Delete</h5>
												<button type="button" class="btn-close"
													data-bs-dismiss="modal" aria-label="Close"></button>
											</div>
											<div class="modal-body">Bạn có chắc chắn muốn xóa?</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-secondary"
													data-bs-dismiss="modal">Close</button>
												<!-- <button type="button" class="btn btn-primary" >Yes</button> -->
												<a class="btn btn-primary"
													href="/admin/categories/delete/${lecture.id}"
													class="btn btn-outline-danger">Yes</a>
											</div>
										</div>
									</div>
								</div>

							</c:forEach>


						</tbody>
					</table>
				</div>
			</div>
		</div>

	</div>
</body>
</html>
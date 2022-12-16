<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container rounded bg-white mt-5 mb-5">
	<p>${message}</p>
	<div class="row">
		<div class="col-md-3 border-right">
			<div
				class="d-flex flex-column align-items-center text-center p-3 py-5">
				<img class="rounded-circle mt-5" width="150px"
					src="/images/${user.image}"><span class="font-weight-bold">${user.name}</span><span
					class="text-black-50">${user.email}</span><span> </span>
			</div>
		</div>
		<div class="col-md-5 border-right">
			<div class="p-3 py-5">
				<form action="/student/saveofUpdate" method="POST"
					enctype="multipart/form-data">
					<div class="d-flex justify-content-between align-items-center mb-3">
						<h4 class="text-right">Thông tin cá nhân</h4>
					</div>
					<div class="row mt-3">
						<div class="col-md-12">
							<label class="labels">Mã số sinh viên</label><input type="text"
								class="form-control" name="mssv" value="${user.mssv}"
								readonly="readonly">
						</div>
						<div class="col-md-12">
							<label class="labels">Họ tên</label><input type="text"
								class="form-control" name="name" value="${user.name}">
						</div>
						<div class="col-md-12">
							<label class="labels">Ngày sinh</label><input type="date"
								class="form-control" name="dateofbirth"
								value="${user.dateofbirth}">
						</div>
						<div class="col-md-12">
							<label class="labels">Email:</label><input type="text"
								class="form-control" name="email" value="${user.email}"
								readonly="readonly">
						</div>
						<div class="col-md-12">
							<input type="text" class="form-control" name="image"
								value="${user.image}" hidden="hidden">
						</div>
						<div class="col-md-12">
							<input type="text" class="form-control" name="idproject"
								value="${user.idproject}" hidden="hidden">
						</div>
						<div class="col-md-12">
							<input type="text" class="form-control" name="is_active"
								value="${user.is_active}" hidden="hidden">
						</div>
						<div class="col-md-12">
							<input type="text" class="form-control" name="waitproject"
								value="${user.waitproject}" hidden="hidden">
						</div>
						<div class="col-md-12">
							<input type="text" class="form-control" name=xoaproject
								value="${user.xoaproject}" hidden="hidden">
						</div>
						<div class="col-md-12">
							<label class="labels">Hình ảnh:</label> <input type="file"
								class="form-control" name="imageFile">
						</div>
						<div class="col-md-12">
							<label class="labels">Chuyên ngành</label><input type="text"
								class="form-control" value="${user.faculty} " name="faculty"
								readonly="readonly">
						</div>
						<div class="col-md-12">
							<input type="text" class="form-control" value="${user.isleader} "
								name="isleader" hidden="true">
						</div>
						<div class="mt-5 text-center">
							<input class="btn btn-primary profile-button" type="submit"
								value="Lưu thông tin" />
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
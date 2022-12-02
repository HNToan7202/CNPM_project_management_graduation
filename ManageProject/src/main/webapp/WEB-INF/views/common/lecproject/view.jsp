<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">


<div class="col-lg-6 col-md-6 col-sm-6">
	<h3 class="box-title mt-5">Thông tin đề tài</h3>
	<div class="table-responsive">
		<table class="table table-striped table-product">
			<tbody>


				<tr>
					<td width="390">Tên Đề Tài</td>
					<td>${project.name}</td>
				</tr>
				<tr>
					<td>Chú Thích</td>
					<td>${project.desciption}</td>
				</tr>
				<tr>
					<td>Mục Tiêu</td>
					<td>${project.muctieu}</td>
				</tr>
				<tr>
					<td>Yêu Cầu</td>
					<td>${project.yeucau}</td>
				</tr>
				<tr>
					<td>Số Lượng Thành Viên</td>
					<td>${project.soluongsv}</td>
				</tr>
				<tr>
					<td>Khác Chuyên Ngành</td>
					<td>${project.isfaculty ? 'Được Phép' : 'Không Được Phép' }</td>
				</tr>
				<tr>
					<td>Niên Khóa</td>
					<td>${project.nienkhoa}</td>
				</tr>
				<tr>
					<td>Điểm</td>
					<td>${project.point}</td>
				</tr>
				<tr>
					<td>Chuyên Ngành</td>
					<td>${project.faculty}</td>
				</tr>
			</tbody>
		</table>
		<div class="container bg-light">
			<div class="col-md-12 text-center">
				<a class="btn btn-primary" href="/lecture/project" role="">Trở
					Về</a>
			</div>
		</div>
	</div>
</div>

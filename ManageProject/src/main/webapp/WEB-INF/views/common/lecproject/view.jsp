<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">


<div class="col-lg-12 col-md-12 col-sm-12">
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
					<td>Seat Lock Included</td>
					<td>${project.muctieu}</td>
				</tr>
				<tr>
					<td>Type</td>
					<td>${project.yeucau}</td>
				</tr>
				<tr>
					<td>Style</td>
					<td>${project.soluongsv}</td>
				</tr>
				<tr>
					<td>Wheels Included</td>
					<td>${project.isfaculty}</td>
				</tr>
				<tr>
					<td>Upholstery Included</td>
					<td>${project.nienkhoa}</td>
				</tr>
				<tr>
					<td>Upholstery Type</td>
					<td>${project.point}</td>
				</tr>
				<tr>
					<td>Head Support</td>
					<td>${project.idtimeproject}</td>
				</tr>
				<tr>
					<td>Suitable For</td>
					<td>${project.create_at}</td>
				</tr>
				<tr>
					<td>Adjustable Height</td>
					<td>${project.is_active ? 'Actived' : 'Not Active'}</td>
				</tr>
			</tbody>
		</table>
		<div class="container bg-light">
			<div class="col-md-12 text-center">
				<button type="button" class="btn btn-primary">Submit</button>
			</div>
		</div>
	</div>
</div>

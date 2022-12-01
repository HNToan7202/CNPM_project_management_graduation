<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<!-- DataTales Example -->
<div class="card shadow mb-4">
	<div class="card-header py-3">
		<h6 class="m-0 font-weight-bold text-primary">Xem Danh sách</h6>

	</div>



	<div class="card-body">
		<div class="table-responsive">
			<table class="table table-bordered" id="dataTable" width="100%"
				cellspacing="0">
				<thead class="thead-inverse">

					<tr>
						<th>Name</th>
						<th>Desciption</th>
						<th>Goal</th>
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
						<th>Action</th>
					</tr>



				</thead>

				<tbody>

					<c:forEach items="${project}" var="item">

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

							<td><a href="/lecture/project/edit/${item.id}"
								class="btn btn-outline-warning"><i class="fa fa-edit"></i>Edit</a>
								<a href="/lecture/project/delete/${item.id}"
								class="btn btn-outline-danger"><i class="fa fa-trash"></i>Delete</a></td>

						</tr>

					</c:forEach>

				</tbody>
			</table>
		</div>
	</div>
</div>

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
						<th>Tên Đề Tài</th>
						<th>Điểm</th>
						<th>Ngày Tạo</th>
						<th>Trạng Thái</th>
						<th>Action</th>
					</tr>



				</thead>

				<tbody>

					<c:forEach items="${project}" var="item">

						<tr>
							<td scope="row">${item.name}</td>
							<td>${item.point}</td>
							<td>${item.create_at}</td>
							<td>${item.is_active  == 1? 'Đã Duyệt' : 'Chưa Duyệt'}</td>
							<td><a href="/lecture/project/view/${item.id}"
								class="btn btn-outline-info"><i class="fa fa-info"></i>Detail</a>
								<a href="/lecture/project/edit/${item.id}"
								class="btn btn-outline-warning"><i class="fa fa-edit"></i>Edit</a>
								<a href="/leadlecture/project/delete/${item.id}"
								class="btn btn-outline-danger"><i class="fa fa-trash"></i>Delete</a></td>

						</tr>

					</c:forEach>

				</tbody>
			</table>
		</div>
	</div>
</div>

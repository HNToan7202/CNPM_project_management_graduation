<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<h6>${message}</h6>

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
						<c:if test="${item.is_active.equals(1) }">

							<tr>
								<td scope="row">${item.name}</td>
								<td>${item.point}</td>
								<td>${item.create_at}</td>
								<td>${item.is_active ? 'Actived' : 'Not Active'}</td>

								<td><a href="/lecture/project/rate/${item.id}"
									class="btn btn-outline-primary"><i class="fa fa-edit"></i>Đánh
										Giá</a></td>

							</tr>
						</c:if>

					</c:forEach>

				</tbody>
			</table>
		</div>
	</div>
</div>

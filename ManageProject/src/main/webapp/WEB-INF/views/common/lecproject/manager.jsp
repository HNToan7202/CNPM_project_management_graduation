<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<!-- DataTales Example -->
<div class="card shadow mb-4" style="width: 100%;">
	<div class="card-header py-3">
		<h6 class="m-0 font-weight-bold text-primary">Xem Danh sách</h6>

	</div>



	<div class="card-body">
		<c:if test="${message!= null}">
			<p>${message}</p>
		</c:if>
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

					<c:forEach items="${projects}" var="item">

						<tr>
							<td scope="row">${item.name}</td>
							<td>${item.point}</td>
							<td>${item.create_at}</td>
							<td>${item.is_active==1 ? 'Đã Duyệt' : 'Chưa Duyệt'}</td>
							<td><a href="/lecture/project/view/${item.id}"
								class="btn btn-outline-info"><i class="fa fa-info"></i>Detail</a>
							</td>
							<c:forEach items="${students}" var="student">
								<c:if test="${student.xoaproject.equals(item.id)}">
									<td><a href="/lecture/project/student"
										class="btn btn-outline-info"><i class="fa fa-info"></i>Trưởng
											nhóm yêu cầu xóa thành viên</a></td>
								</c:if>

							</c:forEach>
						</tr>

					</c:forEach>

				</tbody>
			</table>
		</div>
	</div>
</div>

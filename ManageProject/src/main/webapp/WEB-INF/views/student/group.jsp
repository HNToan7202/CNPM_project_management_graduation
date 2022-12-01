<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="card shadow w-100">
	<div class="card-header py-3">
		<h6 class="m-0 font-weight-bold text-primary">Xem Danh sách</h6>
	</div>
	<div class="card-body">
		<div class="table-responsive">
			<table class="table table-bordered" id="dataTable" width="100%"
				cellspacing="0">
				<thead class="thead-inverse">
					<tr>
						<th>STT</th>
						<th>Tên thành viên</th>
						<th>Chuyên ngành</th>
						<th>Chức vụ</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="item" varStatus="STT">
						<tr>
							<td scope="row">${STT.index+1 }</td>

							<td><a href="/student/detail/${item.mssv}">${item.name}</a></td>
							<td>${item.faculty}</td>
							<td>${item.isleader?"Nhóm trưởng": "Thành viên"}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<div class="card-body" style="width: 80%;">
	<div class="table-responsive">
		<table class="table table-bordered" id="dataTable" width="100%"
			cellspacing="0">
			<thead>
				<tr>
					<th>MSSV</th>
					<th>Tên sinh viên</th>
					<th>Chuyên ngành</th>
					<th>Chức năng</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${students}">
					<tr>
						<td>${item.mssv}</td>
						<td><a href="/student/detail/${item.mssv}">${item.name}</a></td>
						<td>${item.faculty}</td>
						<td><a href="/lecture/project/student/motify/${item.mssv}"
							class="btn btn-outline-info"><i class="fa fa-info"></i>Chấp
								nhận yêu cầu</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
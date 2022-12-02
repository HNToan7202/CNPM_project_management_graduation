<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%-- <main class="page-content">
	<table class="table table-striped table-bordered table-hover"
		id="sample_2">
		<thead>
			<tr>
				<th>Tiêu đề</th>
				<th>Ngày gửi</th>
			</tr>
		</thead>
		<tbody>
			${item.create_at}
				<tr class="odd gradeX">
					<td><a href="/lecture/notify/${item.id}">${item.name}</a></td>
					<td>${item.create_at}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</main> --%>

<div class="card-body">
	<div class="table-responsive">
		<table class="table table-bordered" id="dataTable" width="100%"
			cellspacing="0">
			<thead>
				<tr>
					<th>STT</th>
					<th>Thông Báo</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${notifies}">
					<tr>
						<td>${item.id}</td>
						<td><a href="/lecture/notify/${item.id}"
							style="color: rgb(68, 68, 68) !important;">${item.create_at}|${item.name} | Học kỳ 1 (2021-2022)</a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
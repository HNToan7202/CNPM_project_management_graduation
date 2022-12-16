<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="card shadow w-100">

	<div class="card-header py-3">
		<h6 class="m-0 font-weight-bold text-primary">${message}</h6>
	</div>
	<div class="card-header py-3">
		<h6 class="m-0 font-weight-bold text-primary">Thông báo</h6>

	</div>

	<div class="card-body" style="width: 80%;">
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
					<c:forEach var="item" items="${notifications}">
						<tr>
							<td>${item.id}</td>
							<td><a href="/notify/${item.id}"
								style="color: rgb(68, 68, 68) !important;">${item.create_at}|${item.name}</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
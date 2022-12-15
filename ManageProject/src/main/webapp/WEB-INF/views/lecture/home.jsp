<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

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
							style="color: rgb(68, 68, 68) !important;">${item.create_at}|${item.name}</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
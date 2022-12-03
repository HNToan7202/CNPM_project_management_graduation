<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<main class="page-content w-50">
	<table class="table table-striped table-bordered table-hover"
		id="sample_2">
		<thead>
			<tr>
				<th>Tiêu đề</th>
				<th>Ngày gửi</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${notifies}">
				<tr class="odd gradeX">
					<td><a href="/student/notify/${item.id}">${item.name}</a></td>
					<td>${item.create_at}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</main>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="card shadow w-100">

	<div class="card-header py-3">
		<h6 class="m-0 font-weight-bold text-primary">${message}</h6>

	</div>
	<c:if test="${message == null}">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">Xem Danh sách sinh
				viên các khóa</h6>

		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead class="thead-inverse">
						<tr>
							<th>MSSV</th>
							<th>Tên sinh viên</th>
							<th>Chuyên ngành</th>
							<th>Hình ảnh</th>
							<th>Email</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="item" varStatus="STT">
							<tr>
								<td><a href="/detail/${item.mssv}">${item.mssv}</a></td>
								<td>${item.name}</td>
								<td>${item.faculty}</td>
								<td><img alt="" src="/images/${user.image}"></td>
								<td>${item.email}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</c:if>
</div>
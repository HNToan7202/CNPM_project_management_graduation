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
						<th>Tên đề tài</th>
						<th>Giáo viên hướng dẫn</th>
						<th>Chi tiết</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach items="${project}" var="item" varStatus="STT">
						<tr>
							<td scope="row">${STT.index+1 }</td>
							<td>${item.name}</td>
							<c:forEach items="${lectures}" var="lecture">
								<c:if test="${item.idlecture == lecture.id}">
									<td>${lecture.name}</td>
								</c:if>
							</c:forEach>
							<td><a href="/student/project/detail/${item.id}">Chi
									tiết</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
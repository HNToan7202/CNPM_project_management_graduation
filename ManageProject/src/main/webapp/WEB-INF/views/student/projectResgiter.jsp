
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:if
	test="${finish_date.after(getdate) and create_date.before(getdate)}">
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
						<c:forEach items="${projects}" var="item" varStatus="STT">
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
</c:if>
<c:if test="${getdate.before(create_date)}">
	<p>Chưa đến thời gian đăng ký. Vui lòng quay lại sau</p>
</c:if>

<c:if test="${getdate.after(finish_date)}">
	<p>Đã quá thời gian đăng ký</p>
</c:if>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="row" style="margin: 0px;">
	<table class="table table-striped table-bordered table-hover"
		id="sample_2">
		<thead>
			<tr>
				<th>Mã số sinh viên</th>
				<th>Họ tên</th>
				<th>Ảnh đại diện</th>
				<th>Ngày sinh</th>
				<th>Email</th>
				<th>Chuyên ngành</th>
				<th>Trạng thái</th>
				<th>Hành động</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${students}">
				<tr class="odd gradeX">
					<td>${item.mssv}</td>
					<td>${item.name}</td>
					<td><c:url
							value="/image?fname=student/${item.image!=null?item.image:'uploads/abc.jpg'}"
							var="imgUrl"></c:url> <img width="50px" height="50px"
						src="${imgUrl}"></td>
					<td>${item.dateofbirth}</td>
					<td>${item.email}</td>
					<td>${item.deparment}</td>
					<td><c:if test="${item.status == true}">
							<span class="label label-sm label-success"> Hoạt động </span>
						</c:if> <c:if test="${item.status ==false}">
							<span class="label label-sm label-warning"> Khóa</span>
						</c:if></td>
					<td><a
						href="<c:url value='/admin/student/edit?mssv=${item.mssv }'/>"
						class="center">Edit</a> | <a
						href="<c:url value='/admin/student/delete?mssv=${item.mssv }'/>"
						class="center">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
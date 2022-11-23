<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/common/taglib.jsp"%>

<section class="row">

	<div class="col mt-4">

		<div class="card">

			<div class="card-header">List Project</div>

			<div class="card-body">

				<!-- Hiển thông báo -->

				<c:if test="${message != null}">

					<div class="alert alert-primary" role="alert">

						<i>${message}</i>

					</div>

				</c:if>

				<!-- Hêt thông báo -->

				<table class="table table-striped table-responsive">

					<thead class="thead-inverse">

						<tr>

							<th>Id Project</th>

							<th>Name Project</th>

							<th>Desciption</th>

							<th>Active</th>

							<th>Status</th>

						</tr>

					</thead>

					<tbody>

						<c:forEach items="${projects}" var="project">

							<tr class="odd gradeX">

								<td>${project.id}</td>

								<td>${project.name}</td>

								<td>${project.desciption}</td>

								<td><c:if test="${project.is_active == true}">
										<span class="label label-sm label-success"> Actived </span>
									</c:if> <c:if test="${project.is_active ==false}">
										<span class="label label-sm label-warning"> No Active</span>
									</c:if></td>


								<td><c:if test="${project.status == true}">
										<span class="label label-sm label-success"> Hoạt động </span>
									</c:if> <c:if test="${project.status ==false}">
										<span class="label label-sm label-warning"> Khóa</span>
									</c:if></td>

								<td><a
									href="<c:url value='/admin/project/edit?id=${project.id }'/>"
									class="center">Edit</a> | <a
									href="<c:url value='/admin/project/delete?id=${project.id }'/>"
									class="center">Delete</a> | <a
									href="<c:url value='/admin/project/active?id=${project.id }'/>"
									class="center">Active</a></td>
									
									
							</tr>

						</c:forEach>

					</tbody>



				</table>



			</div>

		</div>

	</div>

</section>
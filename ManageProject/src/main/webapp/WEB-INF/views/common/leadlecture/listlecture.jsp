<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<section class="row">

	<div class="col mt-4">

		<div class="card">

			<div class="card-header">List Lecture</div>

			<div class="card-body">

				<!-- Hiển thông báo -->

				<c:if test="${message != null}">

					<div class="alert alert-primary" role="alert">

						<i>${message}</i>

					</div>

				</c:if>
				
				<input type="text" value="${id}" readonly="readonly" name = "id">

				<!-- Hêt thông báo -->

				<table class="table table-striped table-responsive">

					<thead class="thead-inverse">

						<tr>
							<th>Name</th>
							<th>Image</th>
							<th>Date of Birth</th>
							<th>Address</th>
							<th>Email</th>
							<th>Mã Hội Đồng</th>
							<th>Hành động</th>


						</tr>

					</thead>

					<tbody>
						<c:forEach items="${lecture}" var="item">
							 <c:if test="${item.idhoidong == id}"> 

								<tr>

									<td>${item.name}</td>
									<td>${item.image}</td>
									<td>${item.dateofbirth}</td>
									<td>${item.address}</td>
									<td>${item.email}</td>
									<td>${item.idhoidong}</td>

									<td><a href="/leadlecture/dshoidong/edit/${item.id}"
										class="btn btn-outline-warning"><i class="fa fa-edit"></i></a>

									</td>

								</tr>
						</c:if> 

						</c:forEach>
					</tbody>

				</table>



			</div>

		</div>

	</div>

</section>
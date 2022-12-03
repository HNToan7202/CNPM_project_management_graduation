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

				<!-- Search -->
				<div class="row mt-2 mb-2">
					<div class="col-md-6">
						<form action="/lecture/project/search">
							<div class="input-group">
								<input type="text" class="form-control ml-2" name="name"
									id="name" placeholder="Nhap tu khoa tim kiem">
								<button class="btn btn-outline-primary ml-2">Search</button>
							</div>
						</form>
					</div>
				</div>
				<c:if test="${!projectPage.hasContent()}">


					<div class="row">
						<div class="col">
							<div class="arlet arlet-danger">Not Find Category</div>

						</div>

					</div>
				</c:if>


				<c:if test="${projectPage.hasContent()}">
					<!-- List -->

					<table class="table table-bordered" id="dataTable" width="100%"
						cellspacing="0">
						<thead class="thead-inverse">

							<tr>
								<th>Tên Đề Tài</th>
								<th>Chi Tiết</th>
								<th>Mục Tiêu</th>
								<th>Yêu Cầu</th>
								<th>Số Lượng Sinh Viên</th>
								<th>Khác Chuyên Ngành</th>
								<th>Chuyên Ngành</th>
								<th>Niên Khóa</th>
								<th>Điểm</th>
								<th>Ngày Lập</th>
								<th>Trạng Thái</th>
								<th>Action</th>
							</tr>



						</thead>

						<tbody>

							<c:forEach items="${projectPage.content}" var="item">

								<tr>

									<td scope="row">${item.name}</td>
									<td>${item.desciption}</td>
									<td>${item.muctieu}</td>
									<td>${item.yeucau}</td>
									<td>${item.soluongsv}</td>
									<td>${item.isfaculty ? 'Được Phép':'Không Được Phép'}</td>
									<td>${item.faculty}</td>
									<td>${item.nienkhoa}</td>
									<td>${item.point }</td>
									<td>${item.create_at}</td>
									
									<td>${item.is_active ? 'Actived' : 'Not Active'}</td>

									<td><a href="/lecture/project/edit/${item.id}"
										class="btn btn-outline-warning"><i class="fa fa-edit"></i>Edit</a>
										<a href="/lecture/project/delete/${item.id}"
										class="btn btn-outline-danger"><i class="fa fa-trash"></i>Delete</a></td>

								</tr>

							</c:forEach>

						</tbody>
					</table>

				</c:if>


				<!-- Phân trang  -->
				<c:if test="${projectPage.totalPages > 0}">

					<nav aria-label="Page navigation">
						<ul class="pagination">
							<li
								class="${1==projectPage.number + 1  ? 'page-item active' : 'page-item' }">
								<a class="page-link"
								href="<c:url value='/lecture/project/search?name=${name}&size=${projectPage.size}&page=${pageNumber}'/>"
								tabindex="-1" aria-disabled="true">First</a>
							</li>


							<c:forEach items="${pageNumbers}" var="pageNumber">
								<c:if test="${projectPage.totalPages >1}">
									<li
										class="${pageNumber == projectPage.number +1 ? 'page-item active' : 'page-item'}">
										<a class="page-link"
										href="<c:url value='/lecture/project/search?name=${name}&size=${projectPage.size}&page=${pageNumber}'/>">${pageNumber}</a>
									</li>
								</c:if>
							</c:forEach>



							<li
								class="${projectPage.totalPages == projectPage.number + 1 ? 'page-item active' : 'page-item'}">
								<a class="page-link"
								href="<c:url value='/lecture/project/search?name=${name}&size=${projectPage.size}&page=${projectPage.totalPages}'/>">Last</a>
							</li>

						</ul>
					</nav>
				</c:if>

			</div>

		</div>

	</div>

</section>
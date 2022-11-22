<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<div class="page-content-wrapper">
	<div class="page-content">
		<div class="row" style="margin:0px;">
				<!-- BEGIN EXAMPLE TABLE PORTLET-->
				<div class="portlet box grey-cascade">
					<div class="portlet-title">
						<div class="caption">
							<i class="fa fa-globe"></i>Thêm sinh viên 
						</div>
						<div class="tools">
							<a href="javascript:;" class="collapse"> </a> <a
								href="#portlet-config" data-toggle="modal" class="config"> </a>
							<a href="javascript:;" class="reload"> </a> <a
								href="javascript:;" class="remove"> </a>
						</div>
					</div>
					<div class="portlet-body">
						<div class="table-toolbar">
							<!-- Hiển thị thông báo -->
							<%@include file="/common/info.jsp"%>
							<!-- Kết thúc hiển thị thông báo -->
							<div class="row" style="margin:0px;">
								<div class="col-md-3">
									<div class="row" style="margin:0px;">
										<div class="col-md-9">
											<form action="#" method="post" enctype="multipart/form-data">
												<br />
												<div class="form-group" >
													<label for="UserID">Mã số sinh viên:</label> <input type="text"
														name="studentId" value="${student.mssv}"
														id="studentId" class="form-control" />
												</div>
												<div class="form-group">
													<label for="categoryName">Họ và tên:</label> <input
														type="text" class="form-control" name="studentName"
														id="studentName" value="${student.name}" />
												</div>
												<div class="form-group">
													<label for="categoryCode">Ngày sinh:</label> <input
														type="text" class="form-control" name="dateofbirth"
														value="${student.dateofbirth}" id="dateofbirth" />
												</div>
												<div class="form-group">
													<label for="images">Images:</label> <input type="file"
														class="form-control" name="image" id="image"
														value="${student.image}" />
												</div>
												
												<div class="form-group">
													<label for="email">Email sinh viên:</label> <input type="text"
														class="form-control" name="email" id="email"
														value="${student.email}" />
												</div>
												<div class="form-group">
													<label for="deparment">Chuyên ngành sinh viên:</label> <input type="text"
														class="form-control" name="deparment" id="deparment"
														value="${student.deparment}" />
												</div>
												
												<div class="form-check form-check-inline">
													<label for="status">Status:</label> <input id="statuson"
														class="form-check-input" type="radio" name="status"
														${student.status?'checked':''} value="true"> <label
														for="statuson" class="form-check-label">Hoạt động</label>
													<input id="statusoff" class="form-check-input" type="radio"
														name="status" ${!student.status?'checked':''}
														value="false"> <label for="statusoff"
														class="form-check-label">Khóa</label>
												</div>
												<br />
												<hr>
												<div class="form-group">
													<button class="btn green"
														formaction="<c:url value="/admin/student/saveofUpdate"/>">
														Create <i class="fa fa-plus"></i>
													</button>
													<button class="btn btn-warning"
														formaction="<c:url value="/admin/student/saveofUpdate"/>">
														Update <i class="fa fa-edit"></i>
													</button>
												</div>
											</form>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- END EXAMPLE TABLE PORTLET-->
			</div>
		</div>
	</div>
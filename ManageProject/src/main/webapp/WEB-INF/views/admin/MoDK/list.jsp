<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url value="/resources" var="URL"></c:url>

<%@ include file="/common/taglib.jsp"%>
          <div class="content-wrapper">
            <!-- Content -->

            <div class="container-xxl flex-grow-1 container-p-y">
              <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Mở đăng ký đề tài /</span> Sinh Viên</h4>
			<!-- Hiển thông báo -->
						<%@include file="/common/info.jsp"%>
			<!-- Hêt thông báo -->
              <div class="row">
                <div class="col-md-12">
 			<div class="card">
                <h5 class="card-header"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Danh sách đồ án</font></font></h5>
                <div class="table-responsive text-nowrap">
                  <table class="table">
                    <thead>
                      <tr>
                        <th><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Mã số</font></font></th>
                        <th><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Tên</font></font></th>
                        <th><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Trạng thái</font></font></th>
                        <th><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Hành động</font></font></th>
                      </tr>
                    </thead>
                    <tbody class="table-border-bottom-0">
                     <c:forEach items="${project}" var="project">
                     <c:if test="${project.is_active==1}">
                      <tr class="table-success">
                        <td>
                          <strong><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">${project.id}</font></font></strong>
                        </td>
                        <td><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">${project.name}</font></font></td>
                        <td><span class="badge bg-label-success me-1"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Đã mở</font></font></span></td>
                        <td>
                          <div class="dropdown">
                            <button type="button" class="btn p-0 dropdown-toggle hide-arrow" data-bs-toggle="dropdown">
                              <i class="bx bx-dots-vertical-rounded"></i>
                            </button>
                            <div class="dropdown-menu">
                              <a class="dropdown-item" href="/admin/project/time/DDK/${project.id}"><i class="bx bx-edit-alt me-1"></i><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Đóng đăng ký</font></font></a>                           
                            </div>
                          </div>
                        </td>
                      </tr>
                      </c:if>
                      <c:if test="${project.is_active==0}">
                      <tr class="table-danger">
                        <td> <strong><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">${project.id}</font></font></strong></td>
                        <td><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">${project.name}</font></font></td>

                        <td><span class="badge bg-label-danger me-1"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Chưa mở</font></font></span></td>
                        <td>
                          <div class="dropdown">
                            <button type="button" class="btn p-0 dropdown-toggle hide-arrow" data-bs-toggle="dropdown">
                              <i class="bx bx-dots-vertical-rounded"></i>
                            </button>
                            <div class="dropdown-menu">
                              <a class="dropdown-item" href="/admin/project/time/MDK/${project.id}"><i class="bx bx-edit-alt me-1"></i><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Mở đăng ký</font></font></a>

                            </div>
                          </div>
                        </td>
                      </tr>
                      </c:if>
                      </c:forEach>
                     
                    </tbody>
                  </table>
                </div>
              </div>
                </div>
              </div>
            </div>
            <!-- / Content -->

 

            <div class="content-backdrop fade"></div>
          </div>
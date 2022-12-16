<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url value="/resources" var="URL"></c:url>

<%@ include file="/common/taglib.jsp"%>
          <div class="content-wrapper">
            <!-- Content -->

            <div class="container-xxl flex-grow-1 container-p-y">
              <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Quản lý tài khoản /</span> Giảng Viên</h4>
			<!-- Hiển thông báo -->
						<%@include file="/common/info.jsp"%>
			<!-- Hêt thông báo -->
              <div class="row">
                <div class="col-md-12">
 <div class="card">
                <h5 class="card-header"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Danh sách giảng viên</font></font></h5>
                <div class="table-responsive text-nowrap">
                  <table class="table">
                    <thead>
                      <tr>
                        <th><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Mã số</font></font></th>
                        <th><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Tên</font></font></th>
                        <th><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Avata</font></font></th>
                        <th><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Trạng thái</font></font></th>
                        <th><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Hành động</font></font></th>
                      </tr>
                    </thead>
                    <tbody class="table-border-bottom-0">
                     <c:forEach items="${lecture}" var="lecture">
                     <c:if test="${lecture.isactive==true}">
                      <tr class="table-success">
                        <td>
                          <strong><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">${lecture.id}</font></font></strong>
                        </td>
                        <td><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">${lecture.name}</font></font></td>
                        <td>
                          <ul class="list-unstyled users-list m-0 avatar-group d-flex align-items-center">
                            <li data-bs-toggle="tooltip" data-popup="tooltip-custom" data-bs-placement="top" class="avatar avatar-xs pull-up" title="" data-bs-original-title="Lilian Fuller">
                              <c:url value="/images/${lecture.image}" var="imgUrl"></c:url>
                              <img src="${imgUrl}" alt="hình đại diện" class="rounded-circle">
                            </li>               
                          </ul>
                        </td>
                        <td><span class="badge bg-label-success me-1"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Đang hoạt động</font></font></span></td>
                        <td>
                          <div class="dropdown">
                            <button type="button" class="btn p-0 dropdown-toggle hide-arrow" data-bs-toggle="dropdown">
                              <i class="bx bx-dots-vertical-rounded"></i>
                            </button>
                            <div class="dropdown-menu">
                              <a class="dropdown-item" href="/admin/lecture/edit/${lecture.id}"><i class="bx bx-edit-alt me-1"></i><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Chỉnh sửa</font></font></a>
                               <a class="dropdown-item" href="/admin/editAccount/${lecture.id}/1"><i class="bx bxl-baidu mb-2"></i><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Cấp lại tài khoản</font></font></a>                           
                            </div>
                          </div>
                        </td>
                      </tr>
                      </c:if>
                      <c:if test="${lecture.isactive==false}">
                      <tr class="table-danger">
                        <td> <strong><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">${lecture.id}</font></font></strong></td>
                        <td><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">${lecture.name}</font></font></td>
                        <td>
                          <ul class="list-unstyled users-list m-0 avatar-group d-flex align-items-center">
                            <li data-bs-toggle="tooltip" data-popup="tooltip-custom" data-bs-placement="top" class="avatar avatar-xs pull-up" title="" data-bs-original-title="Lilian Fuller">
                              <c:url value="/images/${lecture.image}" var="imgUrl"></c:url>
                              <img src="${imgUrl}" alt="hình đại diện" class="rounded-circle">
                            </li>               
                          </ul> 
                        </td>
                        <td><span class="badge bg-label-danger me-1"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Không hoạt động</font></font></span></td>
                        <td>
                          <div class="dropdown">
                            <button type="button" class="btn p-0 dropdown-toggle hide-arrow" data-bs-toggle="dropdown">
                              <i class="bx bx-dots-vertical-rounded"></i>
                            </button>
                            <div class="dropdown-menu">
                              <a class="dropdown-item" href="/admin/lecture/edit/${lecture.id}"><i class="bx bx-edit-alt me-1"></i><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Chỉnh sửa</font></font></a>
                              <a class="dropdown-item" href="/admin/lecture/delete/${lecture.id}"><i class="bx bx-trash me-1"></i><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Xóa bỏ</font></font></a>
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
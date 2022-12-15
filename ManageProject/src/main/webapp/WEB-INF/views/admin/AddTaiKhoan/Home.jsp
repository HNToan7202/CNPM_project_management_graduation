<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url value="/resources" var="URL"></c:url>
<%@ include file="/common/taglib.jsp"%>
          <div class="content-wrapper">
            <!-- Content -->

            <div class="container-xxl flex-grow-1 container-p-y">
              <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Thêm tài khoản /</span> Dành cho</h4>
			<!-- Hiển thông báo -->
						<%@include file="/common/info.jsp"%>
			<!-- Hêt thông báo -->
             <div class="card-body">
                      <small class="text-light fw-semibold"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Chọn tài khoản</font></font></small>
                      <div class="row mt-3">
                        <div class="d-grid gap-2 col-lg-6 mx-auto">
                           <a class="btn btn-primary btn-lg" type="button" href="/admin/student/add"> Sinh Viên</a>
                    	   <a class="btn btn-primary btn-lg" type="button" href="/admin/lecture/add"> Giảng Viên</a>
                    	    <a class="btn btn-primary btn-lg" type="button" href="javascript:void(0);">Trưởng Bộ Môn</a>
                        </div>
                      </div>
                    </div>
            </div>
            <!-- / Content -->

            <div class="content-backdrop fade"></div>
          </div>
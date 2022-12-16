<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url value="/resources" var="URL"></c:url>
<%@ include file="/common/taglib.jsp"%>

  <div class="content-wrapper">
            <!-- Content -->

            <div class="container-xxl flex-grow-1 container-p-y">
              <h4 class="fw-semibold py-3 mb-4"><span class="text-muted fw-light"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Quản lý thông báo /</font></font></span><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"> Thông báo</font></font></h4>
              <!-- Bootstrap Toasts with Placement -->
              <div class="card mb-4">
                <h5 class="card-header"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">All thông báo</font></font></h5>
                <div class="card-body">
                  <div class="row gx-3 gy-2 align-items-center">

                    <div class="col-md-3">
                      <label class="form-label" for="showToastPlacement">&nbsp;</label>
                      <a href="/notification/addOrEditAdmin" id="showToastPlacement" class="btn btn-primary d-block"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Tạo thông báo</font></font></a>
                    </div>
                  </div>
                </div>
              </div>
              <!--/ Bootstrap Toasts with Placement -->

              <!-- Bootstrap Toasts Styles -->
              <div class="card mb-4">
                <h5 class="card-header"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Thông báo cho Sinh viên/Giảng viên</font></font></h5>
                <div class="row g-0">
                  <div class="col-md-6 p-4">
                    <div class="text-light small fw-semibold mb-3"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Sinh viên</font></font></div>
                    <div class="toast-container">
   					<c:forEach items="${notification}" var="notification">
   					<c:if test="${notification.chosv==true}">
                      <div class="bs-toast toast fade show bg-secondary" role="alert" aria-live="assertive" aria-atomic="true">
                        <div class="toast-header">
                          <i class="bx bx-bell me-2"></i>
                          <div class="me-auto fw-semibold"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">${notification.name}</font></font></div>
                          <small><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">${notification.create_at}</font></font></small>
                          <a href="/notification/delete/${notification.id}/1" type="button" class="btn-close" aria-label="Đóng"></a>
                          <a href="/notification/edit/${notification.id}" type="button" > Sửa</a>
                        </div>
                        <div class="toast-body"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">
                           ${notification.desciption}
                        </font></font></div>
                      </div>
                                             
                      </c:if>
  					</c:forEach>
                    </div>
                  </div>
                  <div class="col-md-6 ui-bg-overlay-container p-4">
                    <div class="ui-bg-overlay bg-dark opacity-75 rounded-end-bottom"></div>
                    <div class="text-white small fw-semibold mb-3"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Giảng viên</font></font></div>

                    <div class="toast-container">
                    <c:forEach items="${notification}" var="notification">
                    <c:if test="${notification.chosv==false}">
                    <c:if test=""></c:if>
                      <div class="bs-toast toast fade show" role="alert" aria-live="assertive" aria-atomic="true">
                        <div class="toast-header">
                          <i class="bx bx-bell me-2"></i>
                          <div class="me-auto fw-semibold"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">${notification.name}</font></font></div>
                          <small><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">${notification.create_at}</font></font></small>
                           <a href="/notification/delete/${notification.id}/1" type="button" class="btn-close"  aria-label="Đóng"></a>
                        <a href="/notification/edit/${notification.id}" type="button" > Sửa</a>
                        </div>
                        <div class="toast-body"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">
                         ${notification.desciption}
                        </font></font></div>                      
                      </div>
                   
                        </c:if>
   					</c:forEach>
                    </div>
                  </div>
                </div>
              </div>
              <!--/ Bootstrap Toasts Styles -->
            </div>
            <!-- / Content -->

    
            <!-- / Footer -->

            <div class="content-backdrop fade"></div>
          </div>
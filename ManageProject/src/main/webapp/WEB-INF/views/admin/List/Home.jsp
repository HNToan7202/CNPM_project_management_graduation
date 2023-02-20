<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url value="/resources" var="URL"></c:url>
<%@ include file="/common/taglib.jsp"%>
          <div class="content-wrapper">
            <!-- Content -->
		<div class="col-md-6 p-4">
                    <div class="text-light small fw-semibold mb-3"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Thông báo</font></font></div>
                    <div class="toast-container"  >
                      <c:forEach items="${notification}" var="notification">
                      <div class="bs-toast toast fade show" role="alert" aria-live="assertive" aria-atomic="true">
                        <div class="toast-header">
                          <i class="bx bx-bell me-2"></i>
                          <div class="me-auto fw-semibold"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">${notification.name}</font></font></div>
                          <small><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">${notification.create_at}</font></font></small>
                          <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Đóng"></button>
                        </div>
                        <div class="toast-body"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">
                         ${notification.desciption}
                        </font></font></div>
                      </div>
   				  </c:forEach>
                    
                  </div>
</div>
</div>
            <!-- / Content -->

            <div class="content-backdrop fade"></div>
          </div>
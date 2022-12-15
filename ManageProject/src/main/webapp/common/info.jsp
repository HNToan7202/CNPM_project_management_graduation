<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<div class="row">
	<div class="col">
		<c:if test="${not empty message}">
			<%-- <div class="alert alert-success">${message}</div> --%>
			<div class="alert alert-success alert-dismissible" role="alert"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">
                       ${message}!
              </font></font><button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Đóng"></button>
            </div>
		</c:if>
		<c:if test="${not empty error}">
			<%-- <div class="alert alert-success">${error}</div> --%>
			<div class="alert alert-danger alert-dismissible" role="alert"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">
                        ${error}!
               </font></font><button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Đóng"></button>
             </div>
		</c:if>
	</div>
</div>
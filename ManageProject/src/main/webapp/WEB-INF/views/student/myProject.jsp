<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div>
	<c:if test="${project.id <1}">
		<h2>
			Bạn chưa đăng ký đề tài, vui lòng đăng ký<a
				href="/student/project/resgiter">Tại đây</a>
		</h2>

	</c:if>
	<c:if test="${project.id > 0}">
		<h2>Bạn đã đăng ký</h2>
	</c:if>
</div>
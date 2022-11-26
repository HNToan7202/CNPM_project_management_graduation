<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div>
	<h2>${lecture.isEdit ? 'Edit lecture' : 'Add New lecture' }</h2>
	<form:form action="/admin/student/saveofUpdate" method="POST"
		modelAttribute="student" enctype="multipart/form-data">
	
	Mã số đề tài: <form:input path="id" />
		<br />
	Họ tên :<form:input path="name" />
		<br />
	Mô tả : <form:input path="desciption" />
		<br />
		<form:radiobutton path="is_active" value="false" />Khóa <form:radiobutton
			path="status" value="true" />Hoạt động 
		<br />
		<button>Save</button>
	</form:form>
</div>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div>
	<h2>${lecture.isEdit ? 'Edit lecture' : 'Add New lecture' }</h2>
	<form:form action="/admin/lecture/saveofUpdate" method="POST"
		modelAttribute="lecture" enctype="multipart/form-data">
	
	Tên giảng viên: <form:input path="name" />
		<br />
	Email : <form:input path="email" />
		<br />
	Ngày sinh : <form:input path="dateofbirth" />
		<br />
	Địa chỉ : <form:input path="address" />
		<br />
		<form:hidden path="image" />
		<input type="file" name="imageFile" />
		<br />
		<form:radiobutton path="status" value="false" />Khóa <form:radiobutton
			path="status" value="true" />Hoạt động 
		<br />
		<button>Save</button>
	</form:form>
</div>
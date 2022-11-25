<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
	<h2>${lecture.isEdit ? 'Edit lecture' : 'Add New lecture' }</h2>
	<form:form action="/admin/student/saveofUpdate" method="POST"
		modelAttribute="student" enctype="multipart/form-data">
	
	Mã số sinh viên: <form:input path="mssv" />
		<br />
	Họ tên :<form:input path="name" />
		<br />
	Email : <form:input path="email" />
		<br />
	Ngày sinh : <form:input path="dateofbirth" />
		<br />
	Chuyên ngành : <form:input path="deparment" />
		<br />
		<form:hidden path="image"/> 
		<input type="file" name="imageFile" />
		<br />
		<form:radiobutton path="status" value="false" />Khóa <form:radiobutton
			path="status" value="true" />Hoạt động 
		<br />
		<button>Save</button>
	</form:form>
</div>
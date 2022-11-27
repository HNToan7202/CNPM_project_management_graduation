<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div style="padding-left: 220px;">
	<h2>${account.isEdit ? 'account lecture' : 'Add New account' }</h2>
	<form:form action="/account/saveofUpdate" method="POST"
		modelAttribute="account" enctype="multipart/form-data">
	Email : <form:input path="email" />
		<br />
	Password:  <form:input path="password" />
		<br />
		<form:radiobutton path="status" value="false" />Khóa <form:radiobutton
			path="status" value="true" />Hoạt động 
		<br />
		<button>Save</button>
	</form:form>
</div>
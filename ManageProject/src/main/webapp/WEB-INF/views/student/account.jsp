<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="w-100">
	<form class="card" action="/student/account" method="POST"
		enctype="multipart/form-data">
		<h5 class="card-title fw-400">Email : ${user.email}</h5>
		<h5 class="card-title fw-400">Đổi mật khẩu</h5>
		<h5 class="card-title fw-400">${message}</h5>
		<div class="card-body d-flex justify-content-center align-self-center"
			style="flex-direction: column;">
			<div class="form-group" style="width: 400px;">
				<input class="form-control" type="text"
					placeholder="Nhập mật khẩu cũ" name="password">
			</div>

			<div class="form-group" style="width: 400px;">
				<input class="form-control" type="password"
					placeholder="Nhập mật khẩu mới" name="mewpassword">
			</div>


			<input class="btn btn-block btn-bold btn-primary" type="submit"
				value="Đổi mật
				khẩu" />
		</div>
	</form>
</div>
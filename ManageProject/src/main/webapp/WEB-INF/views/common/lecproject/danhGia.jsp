<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<form action=<c:url value = "/lecture/project/saveOrUpdate"/>
	method=POST>
	<div class="card-body">

		<div class="mb-3">
			<h2 for="isedit" class="form-lablel">${project.isEdit ? 'Edit Project' : 'Add New Project' }</h2>
		</div>

		<div class="mb-3">
			<label for="categoryname" class="form-lablel">ID:</label> <input
				type="text" value="${project.id}" id="id" name="id" readonly="readonly"
				aria-describedby="Idid">
		</div>

		<div class="mb-3">
			<label for="categoryname" class="form-lablel">Name:</label> <input
				type="text" value="${project.name}" id="name" name="name" readonly="readonly"
				aria-describedby="nameid">
		</div>

		<div class="mb-3">
			<label for="categoryname" class="form-lablel">Desciption:</label> <input
				type="text" value="${project.desciption}" id="desciption"
				name="desciption" aria-describedby="desciptionid">
		</div>



		<div class="mb-3">
			<label for="soluongsv" class="form-lablel">Số Lượng Sinh
				Viên:</label> <input type="text" value="${project.soluongsv}" id="soluongsv" readonly="readonly"
				name="soluongsv" aria-describedby="soluongsvid">
		</div>


		<div class="mb-3">
			<label for="categoryname" class="form-lablel">Điểm:</label> <input
				type="text" value="${project.point}" id="point" name="point"
				aria-describedby="pointid">
		</div>

		<button class="btn btn-primary" type="submit">
			<i class="fas fa-save"></i>
			<c:if test="${project.isEdit}">
				<span>Update</span>
			</c:if>

			<c:if test="${!project.isEdit}">
				<span>Save</span>
			</c:if>

		</button>

	</div>
</form>




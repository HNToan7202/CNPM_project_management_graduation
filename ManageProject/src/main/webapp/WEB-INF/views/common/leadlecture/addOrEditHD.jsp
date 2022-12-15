<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/common/taglib.jsp"%>

<form action=<c:url value = "/leadlecture/dshoidong/saveOrUpdate"/>
	method=POST>
	<div class="card-body">

		<div class="mb-3">
			<h2 for="isedit" class="form-lablel">${council.isEdit ? 'Edit Council' : 'Add New Council' }</h2>
		</div>

		<div class="mb-3">
			<label for="soluongtv" class="form-lablel">ID:</label> <input
				type="text" value="${council.id}" id="id" name="id"
				aria-describedby="Idid">
		</div>

		<div class="mb-3">
			<label for="soluongtv" class="form-lablel">Số Lượng Thành
				Viên:</label> <input type="text" value="${council.soluongtv}" id="soluongtv"
				name="soluongtv" aria-describedby="soluongtvid">
		</div>

		<div class="mb-3">
			<label for="storeid" class="form-lablel"> Mã Đề Tài:</label> <br>
			<select class="form-select" name="idproject" aria-label="idproject">
				<c:forEach items="${projects}" var="item">
					<option value="${item.id}"
						selected="${item.id == council.idproject ? 'selected':'' }">${item.name}</option>
				</c:forEach>

			</select>
		</div>

	<%-- 	<div class="mb-3">
			<label for="categoryname" class="form-lablel">Mã Đề Tài:</label> <input
				type="text" value="${council.idproject}" id="idproject"
				name="idproject" aria-describedby="idprojectid">
		</div> --%>

		<div class="mb-3">
			<label for="muctieu" class="form-lablel">Mã Trưởng Bộ Môn:</label> <input
				type="text" value="${council.idheadlecture}" id="idheadlecture"
				name="idheadlecture" aria-describedby="idheadlectureid">
		</div>

		<div class="mb-3">
			<label for="Satus" class="form-lablel">Status:</label> <select
				class="form-select" name="isactive" aria-describedby="isactiveid"
				id="isactive">
				<option ${council.isactive == true ? 'selected':'' } value="true">Active</option>
				<option ${council.isactive == false ? 'selected':'' } value="false">Not
					Active</option>
			</select>
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




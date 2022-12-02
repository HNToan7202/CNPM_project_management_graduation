<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<form action=<c:url value = "/leadlecture/project/saveOrUpdate"/>
	method=POST>
	<div class="card-body">

		<div class="mb-3">
			<h2 for="isedit" class="form-lablel">${project.isEdit ? 'Edit Project' : 'Add New Project' }</h2>
		</div>

		<div class="mb-3">
			<label for="categoryname" class="form-lablel">ID:</label> <input
				type="text" value="${project.id}" id="id" name="id"
				aria-describedby="Idid">
		</div>

		<div class="mb-3">
			<label for="categoryname" class="form-lablel">Name:</label> <input
				type="text" value="${project.name}" id="name" name="name"
				aria-describedby="nameid">
		</div>

		<div class="mb-3">
			<label for="categoryname" class="form-lablel">Desciption:</label> <input
				type="text" value="${project.desciption}" id="desciption"
				name="desciption" aria-describedby="desciptionid">
		</div>

		<div class="mb-3">
			<label for="muctieu" class="form-lablel">Mục Tiêu:</label> <input
				type="text" value="${project.muctieu}" id="muctieu" name="muctieu"
				aria-describedby="muctieuid">
		</div>

		<div class="mb-3">
			<label for="categoryname" class="form-lablel">Yêu Cầu:</label> <input
				type="text" value="${project.yeucau}" id="yeucau" name="yeucau"
				aria-describedby="yeucauid">
		</div>

		<div class="mb-3">
			<label for="soluongsv" class="form-lablel">Số Lượng Sinh
				Viên:</label> <input type="text" value="${project.soluongsv}" id="soluongsv"
				name="soluongsv" aria-describedby="soluongsvid">
		</div>

		<div class="mb-3">
			<label for="categoryname" class="form-lablel">Chuyên</label> <input
				type="text" value="${project.isfaculty}" id="isfaculty"
				name="isfaculty" aria-describedby="isfacultyid">
		</div>

		<div class="mb-3">
			<label for="categoryname" class="form-lablel">Khoa :</label> <input
				type="text" value="${project.faculty}" id="faculty" name="faculty"
				aria-describedby="facultyid">
		</div>

		<div class="mb-3">
			<label for="nienkhoa" class="form-lablel">Niên Khóa:</label> <input
				type="text" value="${project.nienkhoa}" id="nienkhoa"
				name="nienkhoa" aria-describedby="nienkhoaid">
		</div>

		<div class="mb-3">
			<label for="categoryname" class="form-lablel">Điểm:</label> <input
				type="text" value="${project.point}" id="point" name="point"
				aria-describedby="pointid">
		</div>

		<div class="mb-3">
			<label for="categoryname" class="form-lablel">Mã Thời Gian
				Đăng Ký:</label> <input type="text" value="${project.idtimeproject}"
				id="idtimeproject" name="idtimeproject"
				aria-describedby="idtimeprojectid">
		</div>

		<div class="mb-3">
			<label for="categoryname" class="form-lablel">Ngày Lập:</label> <input
				type="date" value="${project.create_at}" id="create_at"
				name="create_at" aria-describedby="create_atid">
		</div>

		<div class="mb-3">
			<label for="update_at" class="form-lablel">Ngày Cập Nhật :</label> <input
				type="date" value="${project.update_at}" id="update_at"
				name="update_at" aria-describedby="update_atid">
		</div>

		<div class="mb-3">
			<label for="Satus" class="form-lablel">Status:</label> <select
				class="form-select" name="is_active" aria-describedby="is_activeid"
				id="is_active">
				<option ${project.is_active == true ? 'selected':'' } value="true">Đã
					Duyệt</option>
				<option ${project.is_active == false ? 'selected':'' } value="false">
					Chưa được duyệt</option>
			</select>
		</div>


		<button class="btn btn-primary" type="submit">
			<i class="fas fa-save"></i>
			<c:if test="${project.isEdit }">
				<span>Submit</span>
			</c:if>

			<c:if test="${!project.isEdit }">
				<span>Submit</span>
			</c:if>

		</button>

	</div>
</form>




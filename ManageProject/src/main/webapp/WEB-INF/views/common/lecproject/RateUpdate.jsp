<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<form action=<c:url value = "/lecture/project/saveRate"/>
	method=POST>
	<div class="card-body">
		<h3 class="box-title mt-5">Thông tin đề tài</h3>
		<div class="table-responsive">
			<table class="table table-striped table-product">
				<tbody>


					<tr>
						<td width="390">Tên Đề Tài</td>
						<td>${project.name}</td>
					</tr>
					<tr>
						<td>Chú Thích</td>
						<td>${project.desciption}</td>
					</tr>
					<tr>
						<td>Mục Tiêu</td>
						<td>${project.muctieu}</td>
					</tr>
					<tr>
						<td>Yêu Cầu</td>
						<td>${project.yeucau}</td>
					</tr>
					<tr>
						<td>Số Lượng Thành Viên</td>
						<td>${project.soluongsv}</td>
					</tr>
					<tr>
						<td>Khác Chuyên Ngành</td>
						<td>${project.isfaculty ? 'Được Phép' : 'Không Được Phép' }</td>
					</tr>
					<tr>
						<td>Niên Khóa</td>
						<td>${project.nienkhoa}</td>
					</tr>
					<tr>
						<td>Chuyên Ngành</td>
						<td>${project.faculty}</td>
					</tr>
				</tbody>
			</table>


			<div class="mb-3">
				<input type="text" value="${project.id}" id="id" name="id" hidden=""
					aria-describedby="Idid">
			</div>

			<div class="mb-3">
				<input type="text" value="${project.name}" id="name" name="name"
					hidden="" readonly="readonly" aria-describedby="nameid">
			</div>

			<div class="mb-3">
				<input type="text" value="${project.desciption}" id="desciption"
					readonly="readonly" name="desciption" hidden=""
					aria-describedby="desciptionid">
			</div>

			<div class="mb-3">
				<input hidden="" type="text" value="${project.muctieu}" id="muctieu"
					name="muctieu" readonly="readonly" aria-describedby="muctieuid">
			</div>

			<div class="mb-3">
				<input hidden="" type="text" value="${project.yeucau}" id="yeucau"
					name="yeucau" readonly="readonly" aria-describedby="yeucauid">
			</div>

			<div class="mb-3">
				<input type="text" value="${project.soluongsv}" hidden=""
					id="soluongsv" readonly="readonly" name="soluongsv"
					aria-describedby="soluongsvid">
			</div>

			<div class="mb-3">
				<input hidden="" type="text" value="${project.isfaculty}"
					id="isfaculty" readonly="readonly" name="isfaculty"
					aria-describedby="isfacultyid">
			</div>

			<div class="mb-3">
				<input hidden="" type="text" value="${project.faculty}" id="faculty"
					name="faculty" readonly="readonly" aria-describedby="facultyid">
			</div>

			<div class="mb-3">
				<input hidden="" type="text" value="${project.nienkhoa}"
					id="nienkhoa" readonly="readonly" name="nienkhoa"
					aria-describedby="nienkhoaid">
			</div>

			<div class="mb-3">
				<label for="categoryname" class="form-lablel">Nhập Điểm :</label> <input
					type="text" value="${project.point}" id="point" name="point"
					aria-describedby="pointid">
			</div>

			<div class="mb-3">
				<input type="text" value="${project.idtimeproject}"
					id="idtimeproject" name="idtimeproject" hidden=""
					aria-describedby="idtimeprojectid">
			</div>

			<div class="mb-3">
				<input type="date" value="${project.create_at}" id="create_at"
					hidden="" name="create_at" aria-describedby="create_atid">
			</div>

			<div class="mb-3">
				<input type="date" value="${project.update_at}" id="update_at"
					hidden="" name="update_at" aria-describedby="update_atid">
			</div>

			<div class="mb-3">

				<input type="text" value="${project.is_active}" id="is_active"
					name="is_active" hidden="" aria-describedby="is_active">

			</div>


			<button class="btn btn-primary" type="submit">
				<i class="fas fa-save"></i>
				<c:if test="${project.isEdit}">
					<span>Xác Nhận</span>
				</c:if>

				<c:if test="${!project.isEdit}">
					<span>Save</span>
				</c:if>

			</button>

		</div>
</form>




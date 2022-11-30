<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/common/taglib.jsp"%>

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<title>Hello, world!</title>
</head>
<body>

	<section class="row">

		<div class="col mt-4">
			<form action=<c:url value = "/admin/project/saveOrUpdate"/>
				method="POST">
				<div class="card">
					<div class="card-header">
						<h2>${item.isEdit ? 'Edit Project' : 'Add New Project'}</h2>
					</div>

				</div>
				<div class="card-body">

					<div class="mb-3">
						<label for="id" class="form-lablel">ID:</label> <input
							type="hidden" value="${item.isEdit}"> 
							
							
							<input type="text"
							class="form-control" readonly="readonly" name="id"
							value="${item.id}" id="id" aria-describedby="Idid"
							placeholder="Id" />
					</div>

					<div class="mb-3">
						<label for="categoryname" class="form-lablel"> Name:</label> <input
							type="text" value="${item.name}" id="categoryname"
							name="categoryname" aria-describedby="categorynameid"
							placeholder="Name Project">
					</div>

					<div class="mb-3">
						<label for="categoryname" class="form-lablel"> Desciption:</label>
						<input type="text" value="${item.desciption}" id="desciption"
							name="desciption" aria-describedby="desciptionid"
							placeholder="desciption">
					</div>

					<div class="mb-3">
						<label for="muctieu" class="form-lablel"> Desciption:</label> <input
							type="text" value="${item.muctieu}" id="muctieu" name="muctieu"
							aria-describedby="muctieuid" placeholder="muctieu">
					</div>

					<div class="mb-3">
						<label for="muctieu" class="form-lablel"> Desciption:</label> <input
							type="text" value="${item.muctieu}" id="muctieu" name="muctieu"
							aria-describedby="muctieuid" placeholder="muctieu">
					</div>

					<div class="mb-3">
						<label for="yeucau" class="form-lablel"> yeucau:</label> <input
							type="text" value="${item.muctieu}" id="yeucau" name="yeucau"
							aria-describedby="yeucauid" placeholder="yeucau">
					</div>

					<div class="mb-3">
						<label for="soluongsv" class="form-lablel"> soluongsv:</label> <input
							type="text" value="${item.soluongsv}" id="soluongsv"
							name="soluongsv" aria-describedby="soluongsvid"
							placeholder="soluongsv">
					</div>

					<div class="mb-3">
						<label for="isfaculty" class="form-lablel"> isfaculty:</label> <input
							type="text" value="${item.soluongsv}" id="isfaculty"
							name="isfaculty" aria-describedby="isfaculty"
							placeholder="isfaculty">
					</div>

					<div class="mb-3">
						<label for="faculty" class="form-lablel"> faculty:</label> <input
							type="text" value="${item.faculty}" id="faculty"
							name="faculty" aria-describedby="faculty"
							placeholder="faculty">
					</div>

					<div class="mb-3">
						<label for="nienkhoa" class="form-lablel"> nienkhoa:</label> <input
							type="text" value="${item.nienkhoa}" id="nienkhoa"
							name="nienkhoa" aria-describedby="nienkhoa"
							placeholder="nienkhoa">
					</div>

					<div class="mb-3">
						<label for="point" class="form-lablel"> point:</label> <input
							type="text" value="${item.soluongsv}" id="point"
							name="point" aria-describedby="point"
							placeholder="point">
					</div>

					<div class="mb-3">
						<label for="idtimeproject" class="form-lablel"> idtimeproject:</label> <input
							type="text" value="${item.idtimeproject}" id="idtimeproject"
							name="idtimeproject" aria-describedby="idtimeproject"
							placeholder="idtimeproject">
					</div>

					<div class="mb-3">
						<label for="create_at" class="form-lablel"> create_at:</label> <input
							type="text" value="${item.create_at}" id="create_at"
							name="create_at" aria-describedby="create_at"
							placeholder="create_at">
					</div>

					<div class="mb-3">
						<label for="update_at" class="form-lablel"> update_at:</label> <input
							type="text" value="${item.update_at}" id="update_at"
							name="update_at" aria-describedby="update_at"
							placeholder="update_at">
					</div>

					<div class="mb-3">
						<label for="Satus" class="form-lablel">Status:</label> <select
							class="form-select" name="status"
							aria-describedby="categorycodeid" id="status">

							<option ${item.is_active == true ? 'selected':'' } value="true">Active</option>
							<option ${item.is_active == false ? 'selected':'' } value="false">Not
								Active</option>
						</select>

					</div>

					<div class="card-footer text-muted">
						<a href=<c:url value="/admin/project/add"/>
							class="btn btn-secondary"><i class="fas fa-new"></i>New</a> <a
							href=<c:url value="/admin/project"/> class="btn btn-success"><i
							class="fas bars"></i>List Project</a>
						<button class="btn btn-primary" type="submit">
							<i class="fas fa-save"></i>
							<c:if test="${item.isEdit}">
								<span>Update</span>
							</c:if>

							<c:if test="${!item.isEdit}">
								<span>Save</span>
							</c:if>

						</button>
					</div>
			</form>

		</div>

	</section>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>

</body>
</html> --%>

<%-- 
									<td scope="row">${item.name}</td>
									<td>${item.desciption}</td>
									<td>${item.muctieu}</td>
									<td>${item.yeucau}</td>
									<td>${item.soluongsv}</td>
									<td>${item.isfaculty}</td>
									<td>${item.faculty}</td>
									<td>${item.nienkhoa}</td>
									<td>${item.point}</td>
									<td>${item.idtimeproject}</td>
									<td>${item.create_at}</td>
									<td>${item.update_at}</td>
									<td>${item.is_active ? 'Actived' : 'Not Active'}</td> --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<div class="" style="">
	<h2>${project.isEdit ? 'Edit Project' : 'Add New Project' }</h2>
	<form:form action= "/admin/project/saveOrUpdate" method="POST"
		modelAttribute="project" enctype="multipart/form-data">
	
	ID: <form:input path="id" />
		<br />
	 tên :<form:input path="name" />
		<br />
	desciption : <form:input path="desciption" />
		<br />
	muctieu : <form:input path="muctieu" />
		<br />
	yeucau: <form:input path="yeucau" />
		<br />
	soluongsv : <form:input path="soluongsv" />
		<br />
		
			isfaculty : <form:input path="isfaculty" />
		<br />
			faculty : <form:input path="faculty" />
		<br />
			nienkhoa : <form:input path="nienkhoa" />
		<br />
			point : <form:input path="point" />
		<br />
		
					idtimeproject : <form:input path="idtimeproject" />
		<br />
					create_at : <form:input path="create_at" />
		<br />
					update_at : <form:input path="update_at" />
		<br />

		<form:radiobutton path="is_active" value="false" />Khóa <form:radiobutton
			path="is_active" value="true" />Hoạt động 
		<br />
		<button>Save</button>
	</form:form>
</div>
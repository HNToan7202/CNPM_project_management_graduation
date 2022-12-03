<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div>
	<h2>${item.isEdit ? 'Edit lecture' : 'Add New lecture' }</h2>
	<form:form action="/admin/lecture/saveofUpdate" method="POST"
		modelAttribute="lecture" enctype="multipart/form-data">
		<form:hidden path="id" />
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

		<form:radiobutton path="is_truongbomon" value="false" />Lecture <form:radiobutton
			path="status" value="true" />Head Lecture
		<br/> 
		<button>Save</button>
	</form:form>
</div>
 --%>
 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!doctype html>

<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>Giảng Viên </title>
</head>

<body>

    <section class="container">

        <div class="col mt-4">
            <form action=<c:url value="/admin/lecture/saveofUpdate" /> method="POST" enctype="multipart/form-data">
            <div class="card">
                <div class="card-header">
                    <h2>${lecture.isEdit ? 'Edit Giảng Viên' : 'Add Giảng Viên'}</h2>
                </div>

            </div>
            <div class="card-body">

                <div class="mb-3">
                    <label for="id" class="form-lablel">Mã số giảng viên:</label>   
                    <input type="text" class="form-control" name="id" value="${lecture.id}" id="id" aria-describedby="id" placeholder="id" />
                    <!-- readonly="readonly" : chỉ cho phép đọc-->
                </div>

                <div class="mb-3">
                    <label for="name" class="form-lablel">Họ và tên</label>
                    <input type="text" value="${lecture.name}" id="name" name="name" aria-describedby="name" placeholder="Name">
                </div>

                <div class="mb-3">
                    <label for="dateofbirth" class="form-lablel">Ngày sinh:</label>
                    <input type="date" value="${lecture.dateofbirth}" id="dateofbirth" name="dateofbirth">

                </div>
                <div class="mb-3">
                    <label for="address" class="form-lablel">Địa chỉ</label>
                    <input type="text" value="${lecture.address}" id="address" name="address" aria-describedby="address" placeholder="Address">
                </div>
               <div class="mb-3">
                <input type="text" name="image"  value="${lecture.image}"hidden="hidden"/>
                <input type="file" name="imageFile" />
				</div>
                <div class="mb-3">
                    <label for="email" class="form-lablel">email:</label>
                    <input type="email" value="${lecture.email}" id="email" name="email">

                </div>
                <div class="mb-3">
                    <label for="idhoidong" class="form-lablel">Idhoidong</label>
                    <input type="text" value="${lecture.idhoidong}" id="idhoidong" name="idhoidong">

                </div>


                <div class="mb-3">
                    <label for="isactive" class="form-lablel"> Is_active:</label>
                    <select class="form-select" name="isactive" aria-describedby="isactive" id="isactive">
						
						<option ${lecture.isactive == true ? 'selected':'' } value = "true">Yes</option>
						<option ${lecture.isactive == false ? 'selected':'' } value = "false" >No</option>
						</select>
                </div>
                <div class="card-footer text-muted">
                    <a href=<c:url value="/admin/lecture/add" /> class="btn btn-secondary"><i class="fas fa-new"></i>New</a> 
                    <a href=<c:url value="/admin/lecture" /> class="btn btn-success"><i class="fas bars"></i>List Student</a>
                    <button class="btn btn-primary" type="submit">
						<i class="fas fa-save"></i>
						<!-- true là cập nhật -->
						<c:if test="${lecture.isEdit }">
							<span>Update</span>
						</c:if>
						
						<c:if test="${!lecture.isEdit }">
							<span>Save</span>
						</c:if>

					</button>
                </div>

                </form>

            </div>

    </section>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</body>

</html>
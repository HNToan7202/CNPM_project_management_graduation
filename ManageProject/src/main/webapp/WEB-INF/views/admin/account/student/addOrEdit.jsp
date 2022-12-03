
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

    <title>Tài Khoản Giảng Viên </title>
</head>

<body>

    <section class="container">

        <div class="col mt-4">
            <form action=<c:url value="/admin/account/saveofUpdate/4" /> method="GET" enctype="multipart/form-data">
            <div class="card">
                <div class="card-header">
                    <h2>${account.isEdit ? 'Edit Tài Khoản' : 'Add Tài Khoản'}</h2>
                </div>

            </div>
            <div class="card-body">
               <div class="mb-3">
               		<c:if test="${!account.isEdit }">
					<label for="email" class="form-lablel">email:</label>
                    <input type="email" value="${email}" id="email" name="email">
					</c:if>
                  <c:if test="${account.isEdit }">
					<label for="email" class="form-lablel">email:</label>
                    <input type="email" value="${email}" id="email" name="email" readonly="readonly">
					</c:if>

                 <div class="mb-3">
                    <label for="roleid" class="form-lablel"> Bộ Phận:</label>
                    <select class="form-select" name="roleid" aria-describedby="roleid" id="roleid" >
						<option selected="selected" value = "4" >Sinh Viên</option>
					</select>
                </div>
               <div class="mb-3">
                    <label for="password" class="form-lablel">Password:</label>
                    <input type="text" value="${account.password}" id="password" name="password" >

                </div>
               
                <div class="mb-3">
                    <label for="isactive" class="form-lablel"> Is_active:</label>
                    <select class="form-select" name="isactive" aria-describedby="isactive" id="isactive">
						
						<option ${account.isactive == true ? 'selected':'' } value = "true">Yes</option>
						<option ${account.isactive == false ? 'selected':'' } value = "false" >No</option>
						</select>
                </div>
                <div class="card-footer text-muted">
                    <a href=<c:url value="/admin/account/listStudent" /> class="btn btn-success"><i class="fas bars"></i>List Account</a>
                    <button class="btn btn-primary" type="submit">
						<i class="fas fa-save"></i>
						<!-- true là cập nhật -->
						<c:if test="${account.isEdit }">
							<span>Update</span>
						</c:if>
						
						<c:if test="${!account.isEdit }">
							<span>Save</span>
						</c:if>

					</button>
                </div>
 </div>
                </form>

            </div>

    </section>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</body>

</html>
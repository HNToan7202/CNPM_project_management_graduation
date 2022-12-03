<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/common/taglib.jsp"%>
<!doctype html>

<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>Hello, world!</title>
</head>

<body>

    <section class="container">

        <div class="col mt-4">
            <form action=<c:url value="/notification/saveOrUpdateLecture" /> method="POST">
            <div class="card">
                <div class="card-header">
                    <h2>${notification.isEdit ? 'Edit Thông Báo' : 'Add New Thông Báo'}</h2>
                </div>

            </div>
            <div class="card-body">

                <div class="mb-3">
                    <label for="id" class="form-lablel">notification ID:</label> <input type="hidden" value="${notification.isEdit}">
                    <input readonly="readonly" type="text" class="form-control" name="id" value="${notification.id}" id="id" aria-describedby="id" placeholder="id" />
                    <!-- readonly="readonly" : chỉ cho phép đọc-->
                </div>

                <div class="mb-3">
                    <label for="name" class="form-lablel">notification Name:</label>
                    <input type="text" value="${notification.name}" id="notificationname" name="name" aria-describedby="name" placeholder="notification Name">
                </div>

                <div class="mb-3">
                    <label for="create_at" class="form-lablel">Create At:</label>
                    <input type="date" value="${notification.create_at}" id="create_at" name="create_at">

                </div>
                <div class="mb-3">
                    <label for="update_at" class="form-lablel">Update_At:</label>
                    <input type="date" value="${notification.create_at}" id="update_at" name="update_at">

                </div>
                <div class="mb-3">
                    <label for="desciption" class="form-lablel">Desciption</label>
                    <input type="text" value="${notification.desciption}" id="desciption" name="desciption">

                </div>

                <div class="mb-3">
                    <label for="for_student" class="form-lablel">For student:</label>
                    <select class="form-select" name="for_student" aria-describedby="for_student" id="for_student">
						
						<option ${notification.for_student == true ? 'selected':'' } value = "true"> Có</option>
						<option ${notification.for_student == false ? 'selected':'' } value = "false" >Không dành cho sinh viên</option>
						</select>

                </div>
                <div class="mb-3">
                    <label for="is_active" class="form-lablel"> Is_active:</label>
                    <select class="form-select" name="is_active" aria-describedby="notificationcodeid" id="is_active">
						
						<option ${notification.is_active == true ? 'selected':'' } value = "true">Yes</option>
						<option ${notification.is_active == false ? 'selected':'' } value = "false" >No</option>
						</select>
                </div>
                <div class="card-footer text-muted">
                    <a href=<c:url value="/notification/addOrEditAdmin" /> class="btn btn-secondary"><i class="fas fa-new"></i>New</a> 
                    <a href=<c:url value="/notification/admin" /> class="btn btn-success"><i class="fas bars"></i>List notification</a>
                    <button class="btn btn-primary" type="submit">
						<i class="fas fa-save"></i>
						<!-- true là cập nhật -->
						<c:if test="${notification.isEdit }">
							<span>Update</span>
						</c:if>
						
						<c:if test="${!notification.isEdit }">
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
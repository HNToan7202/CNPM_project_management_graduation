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
            <form action=<c:url value="/admin/timeResgiter/saveOrUpdate" /> method="POST">
            <div class="card">
                <div class="card-header">
                    <h2>${notification.isEdit ? 'Edit Thời gian ĐK' : 'Add Thời gian ĐK'}</h2>
                </div>

            </div>
            <div class="card-body">

                <div class="mb-3">
                   
                    <input  type="text" class="form-control" name="id" value="${timeResgiter.id}" id="id" aria-describedby="id" placeholder="id" />
                    <!-- readonly="readonly" : chỉ cho phép đọc-->
                </div>

                <div class="mb-3">
                    <label for="createat" class="form-lablel">Create at:</label>
                    <input type="date" value="${timeResgiter.createat}" id="createat" name="createat" aria-describedby="createat" placeholder="Create at">
                </div>
    				<div class="mb-3">
                    <label for="finishat" class="form-lablel">Finish at:</label>
                    <input type="date" value="${timeResgiter.finishat}" id="finishat" name="finishat" aria-describedby="finishat" placeholder="Finish at">
                </div>
                
                <div class="card-footer text-muted">
                    <a href=<c:url value="/admin/timeResgiter/addOrEdit" /> class="btn btn-secondary"><i class="fas fa-new"></i>New</a> 
                    <a href=<c:url value="/admin/timeResgiter" /> class="btn btn-success"><i class="fas bars"></i>List notification</a>
                    <button class="btn btn-primary" type="submit">
						<i class="fas fa-save"></i>
						<!-- true là cập nhật -->
						<c:if test="${timeResgiter.isEdit }">
							<span>Update</span>
						</c:if>
						
						<c:if test="${!timeResgiter.isEdit }">
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

    <%@ include file="/common/taglib.jsp"%>

        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="ISO-8859-1">
            <title>List Giảng Viên</title>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        </head>

        <body>
            <!-- Begin Page Content -->
            <!-- Begin Page Content -->
            <div class="container-fluid">

                <!-- Page Heading -->
                <h1 class="h3 mb-2 text-gray-800">Danh sách Tài Khoản Sinh Viên</h1>

                <!-- DataTales Example -->
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">Xem Danh sách</h6>
                    </div>
              <!-- Hiển thông báo -->
						<%@include file="/common/info.jsp"%>
			<!-- Hêt thông báo -->
                        <div class="card-footer text-muted">
                      <a href=<c:url value="/admin/account/add/4"/>
						class="btn btn-dark"><i class="fa fa-new"></i>Tạo Tài Khoản Sinh Viên</a> 
						</div>
                   <%--  <a href="/admin/account/add/${student.email}" class="btn btn-primary"><i class="fa fa-plus-square"></i></a> --%>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th>Mã số</th>
                                        <th>Tên</th>
                                        <th>Nhận diện</th>
                                        <th>Email</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tfoot>

                                    <tr>
                                        <th>Mã số</th>
                                        <th>Tên</th>
                                        <th>Nhận diện</th>
                                        <th>Email</th>
                                        <th>Action</th>
                                    </tr>

                                </tfoot>
                                <tbody>
                                    <c:forEach items="${student}" var="student">
                                        <tr>
                                            <td>${student.mssv}</td>
                                            <td>${student.name}</td>
                                            <td>
                                                <c:url value="/images/${student.image}" var="imgUrl"></c:url>
                                                <img width="100px" height="100px" name="imageFile" src="${imgUrl}"></td>
                                            <td>${student.email}</td>

                                            <td>
                                                <!-- Button trigger modal -->
                                                <a href="/admin/account/edit/${student.email}/4" class="btn btn-outline-warning"><i class="fa fa-edit"></i></a>                                   
                                              </td>

                                    </c:forEach>


                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

            </div>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        </body>

        </html>
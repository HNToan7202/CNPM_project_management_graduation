<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/common/taglib.jsp"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Thông báo</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
               <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Danh sách Thông báo</h1>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Xem Danh sách</h6>
                        </div>
                        <div class="card-footer text-muted">
                         <a href=<c:url value="/notification/addOrEditAdmin"/>
						class="btn btn-dark"><i class="fa fa-new"></i>Tạo thông báo</a> 
						</div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Mã số</th>
                                            <th>Tên Thông Báo</th>
                                            <th>Ngày khởi tạo</th>
                                            <th>Ngày kết thúc</th>
                                            <th>Nội dung thông báo</th>
                                            <th>Dành cho sinh viên</th>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Mã số</th>
                                            <th>Tên Thông Báo</th>
                                            <th>Ngày khởi tạo</th>
                                            <th>Ngày kết thúc</th>
                                            <th>Nội dung thông báo</th>
                                            <th>Dành cho sinh viên</th>
                                            <th>Action</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <c:forEach items="${notification}" var="notification">
                                            <tr>
                                                <td>${notification.id}</td>
                                                <td>${notification.name}</td>
                                                <td>${notification.create_at}</td>
                                                <td>${notification.update_at}</td>
                                                <td>${notification.desciption}</td>
                                                <td>${notification.for_student}</td>
                                               <%--  <td>${notification.is_active}</td>  --%>
                                                <td>
                                                    <!-- Button trigger modal -->
                                                    <a href="Thông tin" class="btn btn-outline-info"><i class="fa fa-info"></i></a>

                                                    <a href="/notification/edit/${notification.id}" class="btn btn-outline-warning"><i class="fa fa-edit"></i></a>
                                                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal${notification.id}">
                                                      <i class="fa fa-trash"></i>
                                                    </button>
                                                </td>
                                            </tr>
                                            <!-- Modal -->
                                            <div class="modal fade" id="exampleModal${notification.id}" tabindex="-1" aria-labelledby="exampleModalLabel${notification.id}" aria-hidden="true">
                                                <div class="modal-dialog">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <h5 class="modal-title" id="exampleModalLabel${notification.id}">Delete</h5>
                                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                        </div>
                                                        <div class="modal-body">
                                                            Bạn có chắc chắn muốn xóa?
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                                            <!-- <button type="button" class="btn btn-primary" >Yes</button> -->
                                                            <a class="btn btn-primary" href="/notification/delete/${notification.id}/1" class="btn btn-outline-danger">Yes</a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            </tr>
                                        </c:forEach>


                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
                 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>  
</body>
</html>
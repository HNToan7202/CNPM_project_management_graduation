<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Danh sách Trưởng bộ môn</h1>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Xem Danh sách</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Mã số</th>
                                            <th>Tên</th>
                                            <th>Ngày sinh</th>
                                            <th>Nhận diện</th>
                                            <th>Email</th>
                                            <th>Địa chỉ</th>
                                            <th>Is_active</th>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Mã số</th>
                                            <th>Tên</th>
                                            <th>Ngày sinh</th>
                                            <th>Nhận diện</th>
                                            <th>Email</th>
                                            <th>Địa chỉ</th>
                                            <th>Is_active</th>
                                            <th>Action</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <c:forEach items="${leaderLecture}" var="leaderLecture">
                                            <tr>
                                                <td>${leaderLecture.id}</td>
                                                <td>${leaderLecture.name}</td>
                                                <td>${leaderLecture.dateofbirth}</td>
                                                <td>${leaderLecture.image}</td>
                                                <td>${leaderLecture.email}</td>
                                                <td>${leaderLecture.address}</td>
                                                <td>${leaderLecture.isactive ? 'Actived' : 'Not Active'}</td> 
                                                <td>
                                                    <!-- Button trigger modal -->
                                                    <a href="Thông tin" class="btn btn-outline-info"><i class="fa fa-info"></i></a>

                                                    <a href="chỉnh sửa" class="btn btn-outline-warning"><i class="fa fa-edit"></i></a>
                                                    
                                                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal${leaderLecture.id}">
                                                      <i class="fa fa-trash"></i>
                                                    </button>
                                                </td>
                                            </tr>
                                            <!-- Modal -->
                                            <div class="modal fade" id="exampleModal${leaderLecture.id}" tabindex="-1" aria-labelledby="exampleModalLabel${leaderLecture.id}" aria-hidden="true">
                                                <div class="modal-dialog">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <h5 class="modal-title" id="exampleModalLabel${leaderLecture.id}">Delete</h5>
                                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                        </div>
                                                        <div class="modal-body">
                                                            Bạn có chắc chắn muốn xóa?
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                                            <!-- <button type="button" class="btn btn-primary" >Yes</button> -->
                                                            <a class="btn btn-primary" href="/leaderLecture/delete/${leaderLecture.id}" class="btn btn-outline-danger">Yes</a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            
                                        </c:forEach>


                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

          <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>  
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List</title>
</head>
<body>
                         <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Danh sách Time Resgiter</h1>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Xem Danh sách</h6>
                        </div>
                        <div class="card-footer text-muted">
                         <a href=<c:url value="/admin/categories/add"/>
						class="btn btn-dark"><i class="fa fa-new"></i>Tạo đợt đăng ký mới</a> 
						</div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Mã số</th>
                                            <th>Ngày khởi tạo</th>
                                            <th>Ngày kết thúc</th>
                                            <th>Admin thực hiện</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Mã số</th>
                                            <th>Ngày khởi tạo</th>
                                            <th>Ngày kết thúc</th>
                                            <th>Admin thực hiện</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <c:forEach items="${timeResgiter}" var="timeResgiter">
                                            <tr>
                                                <td>${timeResgiter.id}</td>
                                                <td>${timeResgiter.create_at}</td>
                                                <td>${timeResgiter.finish_at}</td>
                                                <td>${timeResgiter.id_admin}</td>

                                                <td>
                                                    <!-- Button trigger modal -->
                                                    <a href="Thông tin" class="btn btn-outline-info"><i class="fa fa-info"></i></a>

                                                    <a href="chỉnh sửa" class="btn btn-outline-warning"><i class="fa fa-edit"></i></a>
                                                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal${lecture.id}">
                                                      <i class="fa fa-trash"></i>
                                                    </button>
                                                </td>
                                            </tr>
                                            <!-- Modal -->
                                            <div class="modal fade" id="exampleModal${lecture.id}" tabindex="-1" aria-labelledby="exampleModalLabel${lecture.id}" aria-hidden="true">
                                                <div class="modal-dialog">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <h5 class="modal-title" id="exampleModalLabel${category.categoryId}">Delete</h5>
                                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                        </div>
                                                        <div class="modal-body">
                                                            Bạn có chắc chắn muốn xóa?
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                                            <!-- <button type="button" class="btn btn-primary" >Yes</button> -->
                                                            <a class="btn btn-primary" href="/admin/categories/delete/${lecture.id}" class="btn btn-outline-danger">Yes</a>
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
                <!-- /.container-fluid -->

         
</body>
</html>
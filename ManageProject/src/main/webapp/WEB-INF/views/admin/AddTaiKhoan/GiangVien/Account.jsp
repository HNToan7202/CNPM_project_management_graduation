<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url value="/resources" var="URL"></c:url>

<%@ include file="/common/taglib.jsp"%>
          <div class="content-wrapper">
            <!-- Content -->

            <div class="container-xxl flex-grow-1 container-p-y">
              <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Thêm tài khoản /</span> Giảng Viên</h4>

              <div class="row">
                <div class="col-md-12">
                  <ul class="nav nav-pills flex-column flex-md-row mb-3">
                    <li class="nav-item">
                      <a class="nav-link " href="javascript:void(0);"><i class="bx bx-user me-1"></i> Account</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link active" href="pages-account-settings-connections.html"
                        ><i class="bx bx-link-alt me-1"></i>Mật khẩu</a >
                    </li>
                  </ul>
                    <div class="alert alert-danger alert-dismissible" role="alert"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">
                       Thận trọng: Bạn phải hoàn tất bước này trước khi rời khỏi trang!
                        </font></font><button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Đóng"></button>
                      </div>
                  <div class="card mb-4">
                    <h5 class="card-header">Thêm tài khoản dành cho giảng viên</h5>
                    <!-- Account -->
  					<div class="progress">
                      <div class="progress-bar progress-bar-striped progress-bar-animated bg-primary" role="progressbar" style="width: 75%" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                    <hr class="my-0" />
                    <div class="card-body card mb-4  than" >
     					<style>
						.than {
						  width: 50%;
						  margin: auto;
						  margin-top: 20px;
						}
						</style>
                       <form action=<c:url value="/admin/saveoAccount/1" /> method="POST" enctype="multipart/form-data">   
                        <div class="mb-3">
                          <label class="form-label" for="basic-default-email"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">E-mail</font></font></label>
                          <div class="input-group input-group-merge">
                            <input readonly="readonly" type="text" id="basic-default-email" class="form-control"  aria-describedby="basic-default-email2" value="${lecture.email}" name="email">
                            <span class="input-group-text" id="basic-default-email2"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">@gmail.com</font></font></span>
                          </div>
                          <div class="form-text"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Bạn không thể chỉnh sửa nội dung này!</font></font></div>
                        </div>
                        <div class="mb-3">
                          <label class="form-label" for="basic-default-phone"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Password</font></font></label>
                          <input type="text" id="basic-default-phone" class="form-control phone-mask" value="${pass}" name="password">
                          <div class="form-text"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Lưu ý tài khoản sẽ không được xác thực cho đến khi có sự thay đổi mật khẩu</font></font></div>
                        </div>           
                        <button type="submit" class="btn btn-primary"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Tạo</font></font></button>
                      </form>
                    
                    </div>
                    <!-- /Account -->
                  </div>
                </div>
              </div>
            </div>
            <!-- / Content -->

 

            <div class="content-backdrop fade"></div>
          </div>
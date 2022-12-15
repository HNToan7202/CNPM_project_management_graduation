<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url value="/resources" var="URL"></c:url>
<%@ include file="/common/taglib.jsp"%>
          <div class="content-wrapper">
            <!-- Content -->

            <div class="container-xxl flex-grow-1 container-p-y">
              <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Edit tài khoản /</span> Sinh Viên</h4>

              <div class="row">
                <div class="col-md-12">
                  <ul class="nav nav-pills flex-column flex-md-row mb-3">
                    <li class="nav-item">
                      <a class="nav-link active" href="/admin/student/add"><i class="bx bx-user me-1"></i> Account</a>
                    </li>
                  </ul>
                  <div class="card mb-4">
                    <h5 class="card-header">Edit tài khoản sinh viên</h5>
                    <!-- Account -->
                    <hr class="my-0" />
                    <div class="card-body">
                     <form action=<c:url value="/admin/student/saveofUpdate1" /> method="POST" enctype="multipart/form-data">
                      <div class="card-body">
                      <div class="d-flex align-items-start align-items-sm-center gap-4">
                        <c:url value="/images/${student.image}" var="imgUrl"></c:url>
                        <img
                          src="${imgUrl}"
                          alt="user-avatar"
                          class="d-block rounded"
                          height="100"
                          width="100"
                          id="uploadedAvatar"
                        />
                        <div class="button-wrapper">
                          <label for="upload" class="btn btn-primary me-2 mb-4" tabindex="0">
                            <span class="d-none d-sm-block">Upload new photo</span>
                            <i class="bx bx-upload d-block d-sm-none"></i>
                            <input
                              value="${student.image}"
                              name="imageFile"
                              type="file"
                              id="upload"
                              class="account-file-input"
                              hidden
                              accept="image/png, image/jpeg"
                              
                            />
                         
                			<input type="text" name="image"  value="${student.image}" hidden/>
 
                          </label>
                          <button type="button" class="btn btn-outline-secondary account-image-reset mb-4">
                            <i class="bx bx-reset d-block d-sm-none"></i>
                            <span class="d-none d-sm-block">Reset</span>
                          </button>

                          <p class="text-muted mb-0">Allowed JPG, GIF or PNG. Max size of 800K</p>
                        </div>
                      </div>
                    </div>
                        <div class="row">
                          <div class="mb-3 col-md-6">
                            <label for="firstName" class="form-label">Mã số</label>
                            <input
                              class="form-control"
                              type="text"
                              id="Maso"
                              name="mssv"
                              value="${student.mssv}"
                              autofocus
                               placeholder="123456"
                            />
                          </div>
                          <div class="mb-3 col-md-6">
                            <label for="lastName" class="form-label">Name</label>
                            <input  placeholder="Công Thành" class="form-control" type="text" name="name" id="lastName" value="${student.name}" />
                          </div>
                          <div class="mb-3 col-md-6">
                            <label for="email" class="form-label">E-mail</label>
                            <input
                              class="form-control"
                              type="text"
                              id="email"
                              name="email"
                              value="${student.email}" 
                              placeholder="NguyenCongThanh@gmail.com"
                            />
                          </div>
                           <script language="javascript">
            			// Lấy đối tượng
           				 var input = document.getElementById("Maso");
             
           					 // Thêm sự kiện cho đối tượng
          				  input.onkeyup = function()
          				  {
          					 var maso = document.getElementById('Maso').value
          					 document.getElementById('email').value = maso+ "@gmail.com";
           				 };
        					</script>
                          <div class="mb-3 col-md-6">
                            <label for="address" class="form-label">Address</label>
                            <input value="" type="text" class="form-control" id="address" name="address" placeholder="Address" />
                          </div>
                          <div class="mb-3 col-md-6">
                            <label for="state" class="form-label">Ngày sinh</label>
                            <input value="${student.dateofbirth}" class="form-control" type="date" id="state" name="dateofbirth" placeholder="California" />
                          </div>
                          <div class="mb-3 col-md-6">
                       		 <label for="largeSelect" class="form-label">Khoa</label>
                       		 <select name="faculty" id="largeSelect" class="form-select form-select-lg">
								<option  value = "Công nghệ thông tin">Công nghệ thông tin</option>	
								<option  value = "Kỹ thuật dữ liệu">Kỹ thuật dữ liệu</option>
								<option  value = "An toàn thông tin">An toàn thông tin</option>							
								<option  value = "khác">Khác</option>	
                        	</select>
                     		</div>
                          
                            <div class="mb-3 col-md-6">
                       		 <label for="largeSelect" class="form-label">Xác thực tài khoản</label>
                       		 <select name="is_active" id="largeSelect" class="form-select form-select-lg">
                         		<option ${student.is_active == true ? 'selected':'' } value = "true">Yes</option>
								<option ${student.is_active == false ? 'selected':'' } value = "false" >No</option>							
                        	</select>
                     		 </div>
                          
                          
                        </div>
                        <div class="mt-2">
                          <button type="submit" class="btn btn-primary me-2">Save changes</button>
                          <button type="reset" class="btn btn-outline-secondary">Cancel</button>
                        </div>
                      </form>
                    </div>
                    <!-- /Account -->
                  </div>
                  <c:if test="${student.is_active == true}">
                  <div class="card">
                    <h5 class="card-header">Delete Account</h5>
                    <div class="card-body">
                      <div class="mb-3 col-12 mb-0">
                        <div class="alert alert-warning">
                          <h6 class="alert-heading fw-bold mb-1">Bạn có chắc rằng bạn muốn xóa tài khoản này?</h6>
                          <p class="mb-0">Sau khi bạn xóa tài khoản này, người dùng này sẽ không thể truy cập vào hệ thống. Hãy chắc chắn.</p>
                        </div>
                      </div>
                      
                        <div class="form-check mb-3">
                          <input
                            class="form-check-input"
                            type="checkbox"
                            name="accountActivation"
                            id="accountActivation"
                          />
                          <label class="form-check-label" for="accountActivation"
                            >Tôi xác nhận hủy kích hoạt tài khoản này</label
                          >
                        </div>
                        <a href="/admin/student/delete/${student.mssv}" type="submit" class="btn btn-danger deactivate-account">Xóa</a>
                     
                    </div>
                  </div>
                  </c:if>
                </div>
              </div>
            </div>
            <!-- / Content -->



            <div class="content-backdrop fade"></div>
          </div>
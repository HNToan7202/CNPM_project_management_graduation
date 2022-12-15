<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url value="/resources" var="URL"></c:url>
<%@ include file="/common/taglib.jsp"%>
          <div class="content-wrapper">
            <!-- Content -->

            <div class="container-xxl flex-grow-1 container-p-y">
              <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Edit tài khoản /</span> Giảng Viên</h4>

              <div class="row">
                <div class="col-md-12">
                  <ul class="nav nav-pills flex-column flex-md-row mb-3">
                    <li class="nav-item">
                      <a class="nav-link active" href="/admin/lecture/edit${lecture.id}"><i class="bx bx-user me-1"></i> Account</a>
                    </li>
                  </ul>
                  <div class="card mb-4">
                    <h5 class="card-header">Edit giảng viên</h5>
                    <!-- Account -->
   				<div class="progress">
                      <div class="progress-bar progress-bar-striped progress-bar-animated bg-primary" role="progressbar" style="width: 25%" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                    <hr class="my-0" />
                    <div class="card-body">
                     <form action=<c:url value="/admin/lecture/saveofUpdate2" /> method="POST" enctype="multipart/form-data">
                      <div class="card-body">
                      <div class="d-flex align-items-start align-items-sm-center gap-4">
                      <c:url value="/images/${lecture.image}" var="imgUrl"></c:url>
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
                              value="${lecture.image}"
                              name="imageFile"
                              type="file"
                              id="upload"
                              class="account-file-input"
                              hidden
                              accept="image/png, image/jpeg"
                              
                            />
                         
                			<input type="text" name="image"  value="${lecture.image}" hidden/>
 
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
                              name="id"
                              value="${lecture.id}"
                              autofocus
                               placeholder="123456"
                            />
                          </div>
                          <div class="mb-3 col-md-6">
                            <label for="lastName" class="form-label">Name</label>
                            <input  placeholder="Công Thành" class="form-control" type="text" name="name" id="lastName" value="${lecture.name}" />
                          </div>
                          <div class="mb-3 col-md-6">
                            <label for="email" class="form-label">E-mail</label>
                            <input
                              class="form-control"
                              type="text"
                              id="email"
                              name="email"
                              value="${lecture.email}" 
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
                            <input value="${lecture.address}" type="text" class="form-control" id="address" name="address" placeholder="Address" />
                          </div>
                          <div class="mb-3 col-md-6">
                            <label for="state" class="form-label">Ngày sinh</label>
                            <input value="${lecture.dateofbirth}" class="form-control" type="date" id="state" name="dateofbirth" placeholder="California" />
                          </div>
                          <div class="mb-3 col-md-6">
                       		 <label for="largeSelect" class="form-label">Thuộc hội đồng</label>
                       		 <select name="idhoidong" id="largeSelect" class="form-select form-select-lg">
                         	 <c:forEach items="${hoidong}" var="hoidong">
								<option  value = "${hoidong.id}">${hoidong.id}</option>								
							 </c:forEach>
							 <option  value = "0">Không thuộc hội đồng nào</option>	
                        	</select>
                     		</div>
                          
                            <div class="mb-3 col-md-6">
                       		 <label for="largeSelect" class="form-label">Xác thực tài khoản</label>
                       		 <select name="isactive" id="largeSelect" class="form-select form-select-lg">
                         		<option ${lecture.isactive == true ? 'selected':'' } value = "true">Yes</option>
								<option ${lecture.isactive == false ? 'selected':'' } value = "false" >No</option>							
                        	</select>
                     		 </div>
                          
                          
                        </div>
                        <div class="mt-2">
                          <button type="submit" class="btn btn-primary me-2">Save changes</button>
                          <a href="/admin/addacount" type="reset" class="btn btn-outline-secondary">Cancel</a>
                        </div>
                      </form>
                    </div>
                    <!-- /Account -->
                  </div>
                   <c:if test="${lecture.isactive == true}">
                  <div class="card">
                    <h5 class="card-header">Delete Account</h5>
                    <div class="card-body">
                      <div class="mb-3 col-12 mb-0">
                        <div class="alert alert-warning">
                          <h6 class="alert-heading fw-bold mb-1">Bạn có chắc rằng bạn muốn xóa tài khoản này?</h6>
                          <p class="mb-0">Sau khi bạn xóa tài khoản này, người dùng này sẽ không thể truy cập vào hệ thống. Hãy chắc chắn.</p>
                        </div>
                      </div>
                      <form id="formAccountDeactivation" onsubmit="return false">
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
                        <a href="/admin/lecture/delete/${lecture.id}" type="submit" class="btn btn-danger deactivate-account">Xóa</a>                    
                      </form>
                    </div>
                  </div>
                   </c:if>
                </div>
              </div>
            </div>
            <!-- / Content -->



            <div class="content-backdrop fade"></div>
          </div>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url value="/resources" var="URL"></c:url>

<%@ include file="/common/taglib.jsp"%>
          <div class="content-wrapper">
            <!-- Content -->

            <div class="container-xxl flex-grow-1 container-p-y">
              <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Thông báo /</span> Thông báo</h4>

              <div class="row">
                <div class="col-md-12">

                  <div class="card mb-4">
                 
                    <!-- Account -->
 
                    <hr class="my-0" />
                    <div class="card-body card mb-4  than" >
     					<style>
						.than {
						  width: 50%;
						  margin: auto;
						  margin-top: 20px;
						}
						</style>
                       <form action=<c:url value="/notification/saveOrUpdateAdmin" /> method="POST">  
                        <div class="mb-3">
                          <label class="form-label" for="basic-default-email"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Mã số thông báo</font></font></label>
                          <div class="input-group input-group-merge">
                            <input  type="text" id="basic-default-email" class="form-control"  aria-describedby="basic-default-email2" value="${notification.id}" name="email">
                             </div>
                         
                        </div>
                         <div class="mb-3">
                          <label class="form-label" for="basic-default-email"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Tên thông báo</font></font></label>
                          <div class="input-group input-group-merge">
                            <input  type="text" id="basic-default-email" class="form-control"  aria-describedby="basic-default-email2" value="${notification.name}" name="name">
                          </div>
                          
                        </div>
                           <div class="mb-3">
                          <label class="form-label" for="basic-default-email"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Mô tả thông báo</font></font></label>
                          <div class="input-group input-group-merge">
                            <input  type="text" id="basic-default-email" class="form-control"  aria-describedby="basic-default-email2" value="${notification.desciption}" name="desciption">
                           
                          </div>                    
                        </div>
                         <div class="mb-3 col-md-6">
                       		 <label for="largeSelect" class="form-label">Dành cho sinh viên</label>
                       		 <select name="chosv" id="largeSelect" class="form-select form-select-lg">
                         		<option ${notification.chosv == true ? 'selected':'' } value = "true">Yes</option>
								<option ${notification.chosv == false ? 'selected':'' } value = "false" >No</option>							
                        	</select>
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
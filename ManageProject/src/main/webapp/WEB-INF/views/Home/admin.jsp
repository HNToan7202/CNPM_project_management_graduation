<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
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
                      
                            	
                                        <c:forEach items="${notification}" var="notification">
                                        
                                      
											  <div  class="toast1" role="alert" aria-live="assertive" aria-atomic="true">
											  <div class="toast-header">
											    <img src="..." class="rounded mr-2" alt="...">
											    <strong class="mr-auto">${notification.name}</strong>
											    <small>${notification.create_at}</small>
											    <button type="button" class="ml-2 mb-1 close" data-dismiss="toast" aria-label="Close">
											      <span aria-hidden="true">&times;</span>
											    </button>
											  </div>
											  <div class="toast-body">
											    ${notification.desciption}
											  </div>
											</div>
									</c:forEach>
											
							                                    
                         
                    </div>
                </div>
<script >
$('#element').toast('show')

</script> 
 <script src="/Home/util.js"></script>              
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>  
</body>
</html>

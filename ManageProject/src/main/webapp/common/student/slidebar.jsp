<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url value="/student/project/resgiter" var="Resgiter"></c:url>
<!-- Sidebar -->
<ul
	class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
	id="accordionSidebar">

	<!-- Sidebar - Brand -->
	<a
		class="sidebar-brand d-flex align-items-center justify-content-center"
		href="/student/home">
		<div class="sidebar-brand-icon rotate-n-15">
			<i class="fas fa-laugh-wink"></i>
		</div>
		<div class="sidebar-brand-text mx-3">
			Student <sup></sup>
		</div>
	</a>



	<!-- Divider -->
	<hr class="sidebar-divider">

	<!-- Heading -->
	<div class="sidebar-heading">Quản lý thông tin</div>

	<li class="nav-item "><a class="nav-link" href="/student/profile">
			<i class="fas fa-fw fa-table"></i> <span>Thông tin cá nhân</span>
	</a></li>

	<!-- Divider -->
	<hr class="sidebar-divider">

	<!-- Heading -->
	<div class="sidebar-heading">Quản lý nhóm</div>
	<li class="nav-item "><a class="nav-link" href="/student/group">
			<i class="fas fa-fw fa-chart-area"></i> <span>Thông tin nhóm</span>
	</a></li>
	<!-- Nav Item - Pages Collapse Menu -->
	<div class="sidebar-heading">Đề tài</div>
	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapsePages"
		aria-expanded="true" aria-controls="collapsePages"> <i
			class="fas fa-fw fa-folder"></i> <span>Quản lý đề tài</span>
	</a>
		<div id="collapsePages" class="collapse"
			aria-labelledby="headingPages" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<a class="collapse-item active" href="/student/project">Danh
					sách đề tài</a> <a class="collapse-item" href="${Resgiter}">Đăng ký
					đề tài</a> <a class="collapse-item"
					href="/student/project/my/${user.idproject}">Xem thông tin đề
					tài</a>
			</div>
		</div></li>
	<!-- Divider -->
	<hr class="sidebar-divider">
	<div class="sidebar-heading">Quản lý tài khoản</div>
	<!-- Nav Item - Charts -->
	<li class="nav-item"><a class="nav-link" href="/student/account">
			<i class="fas fa-fw fa-chart-area"></i> <span>Đổi mật khẩu</span>
	</a></li>

	<!-- Nav Item - Tables  active-->
	<li class="nav-item "><a class="nav-link" href="/logout"> <i
			class="fas fa-fw fa-table"></i> <span>Đăng xuất</span>
	</a></li>

	<!-- Sidebar Toggler (Sidebar) -->
	<div class="text-center d-none d-md-inline">
		<button class="rounded-circle border-0" id="sidebarToggle"></button>
	</div>

</ul>
<!-- End of Sidebar -->
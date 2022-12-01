<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!-- Footer -->

<!-- Sidebar -->
<ul
	class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
	id="accordionSidebar">

	<!-- Sidebar - Brand -->
	<a
		class="sidebar-brand d-flex align-items-center justify-content-center"
		href="index.html">
		<div class="sidebar-brand-icon rotate-n-15">
			<i class="fas fa-laugh-wink"></i>
		</div>
		<div class="sidebar-brand-text mx-3">
			Trang Admin <sup></sup>
		</div>
	</a>



	<!-- Divider -->
	<hr class="sidebar-divider">

	<!-- Heading -->
	<div class="sidebar-heading">Thêm Tài Khoản</div>

	<!-- Nav Item - Utilities Collapse Menu -->
	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapseUtilities"
		aria-expanded="true" aria-controls="collapseUtilities"> <i
			class="fas fa-fw fa-wrench"></i> <span>Loại tài khoản</span>
	</a>
		<div id="collapseUtilities" class="collapse"
			aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<h6 class="collapse-header">Dành cho:</h6>
				<a class="collapse-item " href="utilities-color.html">Giảng viên</a>
				<a class="collapse-item" href="utilities-border.html">Sinh Viên</a>

			</div>
		</div></li>

	<!-- Divider -->
	<hr class="sidebar-divider">

	<!-- Heading -->

	<!-- Nav Item - Pages Collapse Menu -->
	<!-- Divider -->

	<div class="sidebar-heading">Đề tài</div>
	<!-- Nav Item - Charts -->
	<li class="nav-item"><a class="nav-link"
		href="/project/lecture/add"> <i class="fas fa-fw fa-chart-area"></i>
			<span>Đăng Ký Đề Tài</span>
	</a></li>

	<!-- Nav Item - Tables  active-->
	<hr class="sidebar-divider">
	<li class="nav-item "><a class="nav-link" href="/project/lecture">
			<i class="fas fa-fw fa-table"></i> <span>Danh Sách Đề Tài</span>
	</a></li>
	<!-- Divider -->
	<hr class="sidebar-divider">
	<div class="sidebar-heading">Thông báo</div>
	<!-- Nav Item - Charts -->
	<li class="nav-item"><a class="nav-link" href="charts.html"> <i
			class="fas fa-fw fa-chart-area"></i> <span>Quản lý thông báo</span>
	</a></li>
	<!-- Divider -->
	<hr class="sidebar-divider d-none d-md-block">

	<!-- Sidebar Toggler (Sidebar) -->
	<div class="text-center d-none d-md-inline">
		<button class="rounded-circle border-0" id="sidebarToggle"></button>
	</div>

</ul>
<!-- End of Sidebar -->
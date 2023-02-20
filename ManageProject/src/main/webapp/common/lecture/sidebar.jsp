
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
		href="/lecture/home">
		<div class="sidebar-brand-icon rotate-n-15">
			<i class="fas fa-laugh-wink"></i>
		</div>
		<div class="sidebar-brand-text mx-3">
			Trang Giảng Viên <sup></sup>
		</div>
	</a>

	<!-- Divider -->
	<hr class="sidebar-divider">

	<!-- Heading -->
	<div class="sidebar-heading">Thêm Tài Khoản</div>

	<!-- Nav Item - Utilities Collapse Menu -->

	<!-- Nav Item - Charts -->
	<li class="nav-item"><a class="nav-link" href="/lecture/profile">
			<i class="fas fa-fw fa-chart-area"></i> <span>Thông Tin</span>
	</a></li>
	<!-- Divider -->
	<hr class="sidebar-divider">

	<!-- Heading -->

	<!-- Nav Item - Pages Collapse Menu -->
	<!-- Divider -->

	<div class="sidebar-heading">Đề tài</div>
	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapsePages"
		aria-expanded="true" aria-controls="collapsePages"> <i
			class="fas fa-fw fa-folder"></i> <span>Danh sách</span>
	</a>
		<div id="collapsePages" class="collapse"
			aria-labelledby="headingPages" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<h6 class="collapse-header">Xem</h6>
				<a class="collapse-item" href="/lecture/project/add">Đăng Ký Đề
					Tài</a> <a class="collapse-item" href="/lecture/project"> Danh Sách
					Đề Tài</a> <a class="collapse-item" href="/lecture/project/search">Tìm
					Kiếm Đề Tài</a>
			</div>
		</div></li>
	<li class="nav-item"><a class="nav-link"
		href="/lecture/project/manager"> <i
			class="fas fa-fw fa-chart-area"></i> <span>Quản lý đề tài</span>
	</a></li>
	<!-- Nav Item - Charts -->

	<!-- Divider -->
	<hr class="sidebar-divider">
	<div class="sidebar-heading">Hội Đồng</div>
	<!-- Nav Item - Charts -->
	<li class="nav-item"><a class="nav-link"
		href="/lecture/project/rate"> <i class="fas fa-fw fa-chart-area"></i>
			<span>Đánh giá</span>
	</a></li>


	<!-- Divider -->
	<hr class="sidebar-divider">

	<div class="sidebar-heading">Thông Báo</div>
	<!-- Nav Item - Charts -->
	<li class="nav-item"><a class="nav-link"
		href="/lecture/notification"> <i class="fas fa-fw fa-chart-area"></i>
			<span>Quản Lý Thông Báo</span>
	</a></li>


	<hr class="sidebar-divider">
	<div class="sidebar-heading">Thống Kê</div>
	<!-- Nav Item - Charts -->
	<li class="nav-item"><a class="nav-link"> <i
			class="fas fa-fw fa-chart-area"></i> <span>Đang online : 1</span>

	</a></li>

	<li class="nav-item"><a class="nav-link"> <i
			class="fas fa-fw fa-chart-area"></i> <span>Lượt truy cập :
				${count}</span>

	</a></li>
	<li class="nav-item"><a class="nav-link" href="/logout"> <i
			class="fas fa-fw fa-chart-area"></i> <span>Đăng xuất</span>
	</a></li>

	<!-- Divider -->
	<hr class="sidebar-divider d-none d-md-block">

	<!-- Sidebar Toggler (Sidebar) -->
	<div class="text-center d-none d-md-inline">
		<button class="rounded-circle border-0" id="sidebarToggle"></button>
	</div>

</ul>
<!-- End of Sidebar -->


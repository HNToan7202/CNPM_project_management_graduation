<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<div class="d-flex">
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

		<li class="nav-item "><a class="nav-link" href="/"> <i
				class="fas fa-fw fa-table"></i> <span>Trang chủ</span>
		</a></li>

		<!-- Divider -->
		<hr class="sidebar-divider">

		<!-- Heading -->
		<!-- Nav Item - Pages Collapse Menu -->
		<div class="sidebar-heading">Đề tài</div>
		<li class="nav-item"><a class="nav-link" href="/project"> <i
				class="fas fa-fw fa-chart-area"></i> <span>Đề tài</span>
		</a></li>
		<!-- Divider -->
		<hr class="sidebar-divider">
		<div class="sidebar-heading">Danh sách</div>
		<li class="nav-item"><a class="nav-link" href="/liststudent">
				<i class="fas fa-fw fa-chart-area"></i> <span>Sinh viên</span>
		</a></li>
		<li class="nav-item "><a class="nav-link" href="/listlecture">
				<i class="fas fa-fw fa-table"></i> <span>Giảng viên</span>
		</a></li>

		<!-- Nav Item - Tables  active-->
		<li class="nav-item "><a class="nav-link" href="/login"> <i
				class="fas fa-fw fa-table"></i> <span>Đăng nhập</span>
		</a></li>

		<!-- Sidebar Toggler (Sidebar) -->
		<div class="text-center d-none d-md-inline">
			<button class="rounded-circle border-0" id="sidebarToggle"></button>
		</div>

	</ul>
	<!-- End of Sidebar -->




</div>
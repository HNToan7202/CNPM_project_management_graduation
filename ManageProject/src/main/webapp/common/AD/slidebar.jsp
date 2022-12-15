<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
 <div class="layout-wrapper layout-content-navbar">
 	<div class="layout-container">
 	<aside id="layout-menu" class="layout-menu menu-vertical menu bg-menu-theme" data-bg-class="bg-menu-theme">
                <div class="app-brand demo">
                    <a href="/admin/trangchu" class="app-brand-link">
                        <span class="app-brand-logo demo">
          
              </span>
                        <span class="app-brand-text demo menu-text fw-bolder ms-2">Admin</span>
                    </a>

                    <a href="javascript:void(0);" class="layout-menu-toggle menu-link text-large ms-auto d-xl-none">
                        <i class="bx bx-chevron-left bx-sm align-middle"></i>
                    </a>
                </div>

                <div class="menu-inner-shadow"></div>
                    <li class="menu-header small text-uppercase">
                        <span class="menu-header-text">Quản lý</span>
                    </li>
                <ul class="menu-inner py-1 ps ps--active-y">
                    <!-- Dashboard -->
                    <li class="menu-item">
                        <a href="/admin/addacount" class="menu-link">
                          <i class='fas fa-user-plus'></i>
                            <div data-i18n="Analytics"> Thêm tài khoản</div>
                        </a>
                    </li>

                    <!-- Layouts -->
                    <li class="menu-item">
                        <a href="javascript:void(0);" class="menu-link menu-toggle">
                          <i class='fas fa-user-edit'></i>
                            <div data-i18n="Layouts">Quản lý tài khoản</div>
                        </a>

                        <ul class="menu-sub">
                            <li class="menu-item">
                                <a href="layouts-without-menu.html" class="menu-link">
                                    <div data-i18n="Without menu">Trưởng bộ môn</div>
                                </a>
                            </li>
                            <li class="menu-item">
                                <a href="/admin/student" class="menu-link">
                                    <div data-i18n="Without navbar">Sinh viên</div>
                                </a>
                            </li>
                            <li class="menu-item">
                                <a href="/admin/lecture" class="menu-link">
                                    <div data-i18n="Container">Giảng viên</div>
                                </a>
                            </li>
                            
                        </ul>
                    </li>

                    <li class="menu-header small text-uppercase">
                        <span class="menu-header-text">Mở đăng ký đề tài</span>
                    </li>
                    <li class="menu-item">
                        <a href="javascript:void(0);" class="menu-link menu-toggle">
                            <i class="fas fa-users"></i>
                            <div data-i18n="Layouts">Dành cho</div>
                        </a>
                        <ul class="menu-sub">
                            <li class="menu-item">
                                <a href="pages-account-settings-account.html" class="menu-link">
                                    <div data-i18n="Account">Cho giảng viên</div>
                                </a>
                            </li>
                            <li class="menu-item">
                                <a href="pages-account-settings-notifications.html" class="menu-link">
                                    <div data-i18n="Notifications">Cho sinh viên</div>
                                </a>
                            </li>
                        </ul>
                    </li>
                    
                    <!-- Components -->
                    <li class="menu-header small text-uppercase"><span class="menu-header-text">Quản lý thông báo</span></li>
                    <!-- Cards -->
                    <li class="menu-item">
                        <a href="cards-basic.html" class="menu-link">
                            <i class="fas fa-bullhorn"></i>
                            <div data-i18n="Basic">Thông báo</div>
                        </a>
                    </li>
                    
                <div class="ps__rail-x" style="left: 0px; bottom: 0px;"><div class="ps__thumb-x" tabindex="0" style="left: 0px; width: 0px;"></div></div><div class="ps__rail-y" style="top: 0px; height: 370px; right: 4px;"><div class="ps__thumb-y" tabindex="0" style="top: 0px; height: 132px;"></div></div></ul>
            </aside>
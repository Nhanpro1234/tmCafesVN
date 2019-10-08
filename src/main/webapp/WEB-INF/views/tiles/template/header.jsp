<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<!--header start-->
<header class="header white-bg">
	<div class="sidebar-toggle-box">
		<div data-original-title="Toggle Navigation" data-placement="right"
			class="fa fa-bars tooltips"></div>
	</div>
	<!--logo start-->
	<a href="<c:url value='/trang-chu' />" class="logo">404<span>NotFound</span></a>
	<!--logo end-->
	<div class="top-nav ">
		<ul class="nav pull-right top-menu">
			<li><input type="text" class="form-control search"
				placeholder="Search"></li>
			<!-- user login dropdown start-->
			<li class="dropdown"><a data-toggle="dropdown"
				class="dropdown-toggle" href="#"> 
				<span class="username">
					<security:authorize access="isAuthenticated()">
					    Xin chào: <security:authentication property="principal.username" /> 
					</security:authorize>
				</span>
				<b class="caret"></b>
			</a>
				<ul class="dropdown-menu extended logout">
					<li><a style="width: 100%;" href="#"><i class="fa fa-cog"></i> Đổi mật khẩu</a></li>
					<li><a href="<c:url value='/logout' />"><i class="fa fa-key"></i> Đăng xuất</a></li>
				</ul></li>
			<!-- user login dropdown end -->
			<li class="sb-toggle-right"><i class="fa  fa-align-right"></i></li>
		</ul>
	</div>
</header>
<!--header end-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<aside>
    <div id="sidebar" class="nav-collapse ">
        <!-- sidebar menu start-->
        <ul class="sidebar-menu" id="nav-accordion">
            <li>
                <a href="<c:url value='/trang-chu' />"> <i class="fa fa-dashboard"></i> <span>Màn
						hình chính</span>
                </a>
            </li>
            <security:authorize access="hasAnyRole('ADMIN', 'THU_NGAN')">
                <li>
                    <a href="<c:url value='/thu-ngan/so-do-ban' />"> <i class="fa fa-dashboard"></i> <span>Thu
						ngân</span>
                    </a>
                </li>
            </security:authorize>
            <security:authorize access="hasAnyRole('ADMIN', 'THU_NGAN', 'KE_TOAN')">
           	 	<li class="sub-menu">
                	<a href="javascript:;"> <i class=" fa fa-bar-chart-o"></i> <span>Báo cáo</span>
                	</a>
                	<ul class="sub">
                    	<li><a href="<c:url value='/quan-li/doanh-thu' />">Doanh thu</a></li>
                    	<li><a href="#">Hóa đơn</a></li>
                    	<li><a href="#">Phiếu thu</a></li>
                    	<li><a href="#">Phiếu nhập</a></li>
                	</ul>
            	</li>
            </security:authorize>
            <!--  -->
            <security:authorize access="hasAnyRole('ADMIN', 'KE_TOAN')">
                <li>
                    <a href="<c:url value='/quan-li/danh-muc' />"> <i class="fa fa-laptop"></i> <span>Danh mục</span>
                    </a>
                </li>
	            <li>
	                <a href="<c:url value='/quan-li/nhan-vien' />"> <i class="fa fa-user"></i> <span>Nhân viên</span>
	                </a>
	            </li>
            </security:authorize>
            <security:authorize access="hasRole('ADMIN')">
            <!--  -->
            <li>
                <a href="<c:url value='/quan-li/san-ban-phong' />"> <i class="fa fa-book"></i> <span>Danh sách bàn, phòng</span>
                </a>
            </li>
            <li>
                <a href="<c:url value='/quan-li/khach-hang' />"> <i class="fa fa-users"></i> <span>Khách hàng, nhà cung cấp</span>
                </a>
            </li>
            <li>
                <a href="<c:url value='/quan-li/tai-khoan' />"> <i class="fa fa-user"></i> <span>Tài khoản</span>
                </a>
            </li>
            <li class="sub-menu">
                <a href="javascript:;"> <i class=" fa fa-envelope"></i> <span>Hộp thư</span>
                </a>
            </li>
            <li>
                <a href="<c:url value='/quan-li/san-pham' />"> <i class="fa fa-shopping-cart"></i> <span>Sản phẩm</span>
                </a>
            </li>
            <li class="sub-menu">
                <a href="javascript:;"> <i class="fa fa-cog"></i> <span>Cài đặt</span>
                </a>
                <ul class="sub">
                    <li><a href="#">Máy in</a></li>
                    <li><a href="#">Mẫu in</a></li>
                </ul>
            </li>
			</security:authorize>
        </ul>
        <!-- sidebar menu end-->
    </div>
</aside>
<!--sidebar end-->
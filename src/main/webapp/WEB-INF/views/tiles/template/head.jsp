<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>


<!-- Bootstrap core CSS -->
<link href='<c:url value="/static/css/bootstrap.min.css"/>' rel="stylesheet">
<link href="<c:url value='/static/css/bootstrap-reset.css'/>" rel="stylesheet">
<!--external css-->
<link href="<c:url value='/static/assets/font-awesome/css/font-awesome.css'/>" rel="stylesheet" />
<!--dynamic table-->
<link href="<c:url value='/static/assets/advanced-datatable/media/css/demo_page.css'/>"
	rel="stylesheet" />
<link href="<c:url value='/static/assets/advanced-datatable/media/css/demo_table.css'/>"
	rel="stylesheet" />
<link rel="stylesheet" href="<c:url value='/static/assets/data-tables/DT_bootstrap.css'/>" />
<!--  -->
<link href="<c:url value='/static/assets/fancybox/source/jquery.fancybox.css" rel="stylesheet'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/static/css/gallery.css'/>" />
<!--right slidebar-->
<link href="<c:url value='/static/css/slidebars.css'/>" rel="stylesheet">
<!--toastr-->
<link href="<c:url value='/static/assets/toastr-master/toastr.css'/>" rel="stylesheet"
	type="text/css" />
<!-- Custom styles for this template -->
<link href="<c:url value='/static/css/style.css'/>" rel="stylesheet">
<link href="<c:url value='/static/css/style-responsive.css'/>" rel="stylesheet" />
<link href="<c:url value='/static/js/dist/themes/default/style.min.css'/>" rel="stylesheet" />

<script>
	var BASE_MAIN_URL = '<%=request.getRequestURL().toString().substring(0, request.getRequestURL().toString().length() - request.getRequestURI().length()) + request.getContextPath() + "/"%>';
</script>
<!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
<!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
  <![endif]-->
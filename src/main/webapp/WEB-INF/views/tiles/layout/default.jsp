<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Mosaddek">
    <meta name="keyword" content="Quản lí cafe, phần mềm quản lí cafe, quản lí quán cafe cafe quản lí...">
    <c:set var="sidePanelName"><tiles:getAsString name='titles'/></c:set>
	<title>${sidePanelName}</title>
    <style type="text/css">
    	#sidebar{
    		overflow: hidden; outline: currentcolor none medium; margin-left: -210px;
    	}
    </style>
    <tiles:insertAttribute name="head" />
</head>
<body>
	<section id="container" class="">
		<tiles:insertAttribute name="header" />
		<tiles:insertAttribute name="aside" />
		<tiles:insertAttribute name="body" />
		<tiles:insertAttribute name="footer" />		
	</section>
	<tiles:insertAttribute name="js" />
</body>
</html>

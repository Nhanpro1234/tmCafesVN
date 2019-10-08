<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<title>HÓA ĐƠN</title>
</head>
	<link href="https://fonts.googleapis.com/css?family=Noto+Sans:400,400i,700,700i&display=swap&subset=vietnamese" rel="stylesheet">
	<style type="text/css">
		*{
			font-family: 'Noto Sans', sans-serif;
		}
		#root {
		 	text-align: center;
		}
	</style>
<body>
	<div id="root">
		<div style="width: 100%; text-align: right;">
			<span style="font-weight: 700; font-size: 25px;">COFFEE FASTTRACK</span><br>
			<span>Ngũ Hành Sơn, Đà Nẵng</span>
		</div>
		<h1 style="text-transform: uppercase;"></h1>
		<hr>
		<h2 style="text-transform: uppercase;">HÓA ĐƠN BÀN <span id="soBan">${chungTu.soBan}</span></h2>
		<span>Mã: <span id="soCT">${chungTu.soCT}</span></span>
		<div style="width: 100%;">
			<div style="font-weight: 400; width: 100%;">
				<label style="float: left">Giờ bắt đầu: </label>
				<jsp:useBean id="dateObject" class="java.util.Date" />
				<span style="float: right;"><span id="thoiGianVao">${giovao}</span>
			</div>
			<div style="width: 100%;">
				<table style="width: 100%;" border="1">
					<thead>
						<tr>
							<th>Tên</th>
							<th>SL</th>
							<th>Giá</th>
							<th>Giảm</th>
							<th>Tổng</th>
						</tr>
					</thead>
					<tbody id="dongChungTu">
						<c:forEach var="data" items="${dongChungTu}">
						<tr>
							<td style="text-align: left;">${data.tenSP}</td>
							<td><fmt:formatNumber value='${data.soLuong}'/></td>
							<td><fmt:formatNumber value='${data.donGia}'/>đ</td>
							<td><fmt:formatNumber value='${data.giam}'/>đ</td>
							<td><fmt:formatNumber value='${(data.soLuong * (data.donGia - data.giam))}'/>đ</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div style="width: 100%;">
				<table style="width: 100%;">
					<tbody style="font-weight: 700;">
						<tr>
							<td style="text-align: left;">Thu ngân</td>
							<td style="text-align: right">${nhanVienThuNgan.hoTen}</td>
						</tr>
						<tr>
							<td style="text-align: left;">Tiền hàng</td>
							<td style="text-align: right"><span id="thanhTien"><fmt:formatNumber value='${thanhTien}'/></span>đ</span></td>
						</tr>
						<tr>
							<td style="text-align: left;">Giảm giá %</td>
							<td style="text-align: right"><span id="giamGia">${chungTu.giam} %</span></td>
						</tr>
						<tr>
							<td style="text-align: left;">VAT %</td>
							<td style="text-align: right"><span id="thueVAT">${chungTu.thueVAT} %</span></td>
						</tr>
						<tr>
							<td style="text-align: left;">Tiền thanh toán</td>
							<td style="text-align: right"><span id="tienThanhToan"><fmt:formatNumber value='${tongTien}'/></span>đ</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div>
				<h5>XIN CHÂN THÀNH CẢM ƠN, HẸN GẶP LẠI QUÝ KHÁCH !</h5>
			</div>
		</div>
	</div>
</body>
</html>
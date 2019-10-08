<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!--main content end-->
<!--main content start-->
<section id="main-content">
	
	<security:authorize access="isAuthenticated()">
	    <input type="hidden" id="role" value="<security:authentication property='principal.authorities' />">
	</security:authorize>
    <section class="wrapper">
        <!-- page start-->
        <div class="row">
            <div class="col-md-12">
                <section class="panel">
                    <div class="panel-body row">
                        <div class="col-md-4 form-group">
                            <label>Từ</label>
                            <input type="date" class="form-control" style="line-height: 21px;" id="timeS">
                        </div>
                        <div class="col-md-4 form-group">
                            <label>Đến</label>
                            <input type="date" class="form-control" style="line-height: 21px;" id="timeE">
                        </div>
                        <div class="col-md-4 form-group">
                            <label>Thu ngân</label>
                            <select id="nhanVien" class="c-select form-control">
                                <option value="ALL">Tất cả</option>
                            </select>
                        </div>
                    </div>
                </section>
            </div>
            <div class="col-md-12">
                <section class="panel">
                    <div class="panel-body">
                        <button type="button" onclick="taiLai()" class="btn btn-shadow btn-success"><i class="fa fa-rotate-right"></i> Tải lại</button>
                        <button type="button" class="btn btn-shadow btn-info"><i class="fa  fa-file-o"></i> Thực đơn</button>
                        <button type="button" class="btn btn-shadow btn-success"><i class="fa  fa-file-o"></i> Hóa đơn</button>
                    </div>
                </section>
            </div>
            <div class="col-md-12">
                <section class="panel">
                	<header class="panel-heading">
	                  Doanh thu thực đơn (Tổng doanh số: <span id="sumDoanhThu"></span>)
	              </header>
                    <div class="panel-body">
                        <div class="adv-table" id="table-doanh-thu">
                            
                        </div>
                    </div>
                </section>
            </div>
        </div>
        <!-- page end-->
    </section>
</section>
<script>
	function taiLai(){
		var timeS = $("#timeS").val();
		var timeE = $("#timeE").val();
		doanhThu.getThucDon(getTime.timeS(new Date(timeS)), getTime.timeE(new Date(timeE)), $("#nhanVien").val());
		//doanhThu.getThucDon(getTime.timeS, getTime.timeE, "ALL");
	}
	window.doanhThu = {
		getThucDon: function (ts, te, nv){
			$("#table-doanh-thu").html('\
					<table class="table table-bordered" id="doanh-thu-thuc-don">\
	                    <thead>\
	                        <tr>\
	                            <th>#</th>\
	                            <th>Tên</th>\
	                            <th>Đơn vị tính</th>\
	                            <th>Tổng số lượng</th>\
	                            <th>Tổng giảm</th>\
	                            <th>Tổng đơn giá</th>\
	                            <th>Doanh số (GIA - GIAM) * SL)</th>\
	                            <th>Giá trị trung bình</th>\
	                        </tr>\
	                    </thead>\
	                    <tbody>\
	                    </tbody>\
	                </table>');
			$.ajax({
				url : BASE_MAIN_URL + '/api/doanhThu/getThucDon',
				type : 'POST',
				data : {
					time_start: ts,
					time_ends: te,
					nhanVien: nv
				},
			}).done(function(data) {
				var sum = 0;
				for (var i = 0; i < data.length; i++) {
					$("#doanh-thu-thuc-don tbody").append("\
					<tr>\
						<td>"+(i+1)+"</td>\
						<td>"+data[i].tenSP+"</td>\
						<td>"+data[i].maDVT+"</td>\
						<td>"+data[i].soLuong+"</td>\
						<td>"+data[i].giamGia.toLocaleString('it-IT', {style : 'currency', currency : 'VND'})+"</td>\
						<td>"+data[i].donGia.toLocaleString('it-IT', {style : 'currency', currency : 'VND'})+"</td>\
						<td>"+data[i].doanhSo.toLocaleString('it-IT', {style : 'currency', currency : 'VND'})+"</td>\
						<td>"+data[i].trungBinh.toLocaleString('it-IT', {style : 'currency', currency : 'VND'})+"</td>\
					</tr>");
					sum = sum + data[i].doanhSo;
				}
				$("#sumDoanhThu").html(sum.toLocaleString('it-IT', {style : 'currency', currency : 'VND'}));
				$("#doanh-thu-thuc-don").dataTable();
			})
			
		}
	}
	window.nhanVien = {
		get: function(){
			$.ajax({
				url : '../api/nhanVien',
				type : 'POST'
			}).done(function(data) {
				for (var i = 0; i < data.length; i++) {
					$("#nhanVien").append(new Option(data[i].hoTen, data[i].maNV))
				}
			});
		}
	}
	window.getTime = {
		timeS: function(e){
			e.setHours(0,0,0,0);
			return e.getTime();
		},
		timeE: function(e){
			e.setHours(23,59,59,999);
			return e.getTime();
		}
	}
	window.onload = function() {
		nhanVien.get();
		document.getElementById("timeS").valueAsDate = new Date();
		document.getElementById("timeE").valueAsDate = new Date();
		doanhThu.getThucDon(getTime.timeS(new Date()), getTime.timeE(new Date), "ALL");
	};
</script>
<style>
	#sidebar{
		 margin-left: 0px;
 	}
</style>
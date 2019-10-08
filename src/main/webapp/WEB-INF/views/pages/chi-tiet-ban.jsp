<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!--main content start-->
<section id="main-content" style="margin-left: 0;">
    <section class="wrapper">
        <!-- page start-->
        <div class="row">
            <div class="col-md-4">
                <!--widget start-->
                <section class="panel">
                    <header class="panel-heading tab-bg-dark-navy-blue">
                        <ul class="nav nav-tabs nav-justified ">
                            <li class="active">
                                <a href="#info" data-toggle="tab" aria-expanded="true"> Thông tin</a>
                            </li>
                            <li class="">
                                <a href="#menu" data-toggle="tab" aria-expanded="false"> Thực đơn </a>
                            </li>
                        </ul>
                    </header>
                    <div class="panel-body">
                        <div class="tab-content tasi-tab">
                            <div class="tab-pane active" id="info">
                                <div class="panel panel-info">
				                    <div class="panel-heading">
				                        <h4 class="panel-title">
				                            <a href="#accordion1_1" data-parent="#accordion1" data-toggle="collapse" class="accordion-toggle">
				                                <h4 id="chungTuView" style="text-transform: uppercase; margin: 0; width: 100%; text-align: center;"></h4>
				                            </a>
				                        </h4>
				                    </div>
				                 	<div class="panel-collapse collapse in" id="accordion1_1" aria-expanded="true" style="">
				                        <div class="panel-body">
				                            <div class="row">
										        <div class="col-md-6">
									              	<div class="form-group">
							                            <label for="formGroupExampleInput">Giờ vào </label>
							                            <input type="text" class="form-control" id="thoiGianView" readonly>
						                        	</div>
										        </div>
				                                <div class="col-md-6">
				                                	<div class="form-group">
							                            <label for="formGroupExampleInput">Số lượng khách </label>
										              	<div class="input-group m-bot15">
					                                       	<input type="number" class="form-control" id="soLuongKhachView">
					                                        <span class="input-group-btn">
					                                            <button class="btn btn-white" onclick="soLuongKhachView()" type="button">
					                                            	<i class="fa fa-save"></i>
					                                            </button>
					                                        </span>     
							                        	</div>
						                        	</div>
										        </div>
				                                <script type="text/javascript">
				                                	function soLuongKhachView(){
				                                		var obj = _data_chung_tu;
				                        	    		if(obj.trangThai == -1 || obj.trangThai == 1){
				                        	    			toastr.info("Không thể thay đổi dữ liệu");
				                        	    			return;
				                        	    		}
				                                		
				                                		var _obj = _data_chung_tu;
				                                		var c = $("#soLuongKhachView").val();
				                                		if(c == 0 || c.trim() == ""){
				                                			toastr.info("Vui lòng nhập đầy đủ và lớn hơn 0");
				                                			return;
				                                		}
				
														if(isNaN(c)){
															toastr.info("Vui lòng nhập số");
															return;
														}
														
														call_ajax('soCT', _obj.soCT, 'soKhach', c);
				                                	}
				                                </script>
										        <div class="col-md-12">
									              	<div class="form-group">
							                            <label for="formGroupExampleInput">Ghi chú </label>
						                             	<div class="input-group m-bot15">
					                                       	<input type="text" class="form-control" id="noteView">
					                                        <span class="input-group-btn">
					                                            <button class="btn btn-white" onclick="noteView()" type="button">
					                                            	<i class="fa fa-save"></i>
					                                            </button>
					                                        </span>     
							                        	</div>
						                        	</div>
										        </div>
										        <script type="text/javascript">
				                                	function noteView(){
				                                		var obj = _data_chung_tu;
				                        	    		if(obj.trangThai == -1 || obj.trangThai == 1){
				                        	    			toastr.info("Không thể thay đổi dữ liệu");
				                        	    			return;
				                        	    		}
				                                		
				                                		var _obj = _data_chung_tu;
				                                		var c = $("#noteView").val();
														call_ajax('soCT', _obj.soCT, 'noiDung', c);
				                                	}
				                                </script>
				                                <div class="col-md-6">
									              	<div class="form-group text-center">
							                            <label for="formGroupExampleInput">VAT %</label>
							                            <div class="input-group m-bot15">
					                                       	<input type="text" class="form-control" id="vatView">
					                                        <span class="input-group-btn">
					                                            <button class="btn btn-white" onclick="vatView()" type="button">
					                                            	<i class="fa fa-save"></i>
					                                            </button>
					                                        </span>     
							                        	</div>
						                        	</div>
										        </div>
										        <script type="text/javascript">
				                                	function vatView(){
				                                		var obj = _data_chung_tu;
				                        	    		if(obj.trangThai == -1 || obj.trangThai == 1){
				                        	    			toastr.info("Không thể thay đổi dữ liệu");
				                        	    			return;
				                        	    		}
				                                		
				                                		var _obj = _data_chung_tu;
				                                		var c = $("#vatView").val();
														call_ajax('soCT', _obj.soCT, 'thueVAT', c);
				                                	}
				                                </script>
										        <div class="col-md-6">
									              	<div class="form-group text-center">
							                            <label for="formGroupExampleInput">Giảm %</label>
							                            <div class="input-group m-bot15">
					                                       	<input type="text" class="form-control" id="giamGiaView">
					                                        <span class="input-group-btn">
					                                            <button class="btn btn-white" onclick="giamGiaView()" type="button">
					                                            	<i class="fa fa-save"></i>
					                                            </button>
					                                        </span>     
							                        	</div>
						                        	</div>
										        </div>
										        <script type="text/javascript">
				                                	function giamGiaView(){
				                                		var obj = _data_chung_tu;
				                        	    		if(obj.trangThai == -1 || obj.trangThai == 1){
				                        	    			toastr.info("Không thể thay đổi dữ liệu");
				                        	    			return;
				                        	    		}
				                                		
				                                		var _obj = _data_chung_tu;
				                                		var c = $("#giamGiaView").val();
														call_ajax('soCT', _obj.soCT, 'giam', c);
				                                	}
				                                </script>
										        <div class="col-md-12">
									              	<div class="form-group text-center">
							                            <label for="formGroupExampleInput">Tổng tiền </label>
							                            <p style="color: #2ecc71; font-size: 30px; font-weight: bold;" id="tongTienView"></p>
						                        	</div>
										        </div>
												<div class="col-md-4">
													<div class="form-group">
														<button data-toggle="modal" onclick="get_chuyenBan()" href="#chuyenBan"
															style="width: 100%;" type="button"
															class="btn btn-shadow btn-info">Chuyển bàn</button>
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group">
														<button style="width: 100%;" type="button"
															class="btn btn-shadow btn-warning">Ghép bàn</button>
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group">
														<button data-toggle="modal" href="#huyBan"
															style="width: 100%;" type="button"
															class="btn btn-shadow btn-danger">Hủy bàn</button>
													</div>
												</div>
												<div class="col-md-6">
													<div class="form-group">
														<button data-toggle="modal" onclick="chungTu.get()" href="#thanhToan"
															style="width: 100%;" type="button"
															class="btn btn-shadow btn-success">Thanh toán</button>
													</div>
												</div>
												<div class="col-md-6">
					                              	<button class="btn btn-shadow btn-primary" type="button" onclick="hoaDon.show()"  style="width: 100%;">In hóa đơn</button>
					                         	</div>	
											</div>
				                        </div>
				                    </div>
				                </div>    
                            </div>
                            <div class="tab-pane" id="menu">
                              	<div id="table-thuc-don" class="adv-table"></div>
                            </div>
                        </div>
                    </div>
                </section>
                <!--widget end-->
            </div>
            <div class="col-md-4">
                
            </div>
            <div class="col-md-8">
                <section class="panel" style="max-height: 600px; overflow: auto;">
                    <header class="panel-heading">
                      	Danh sách
                    </header>
                    <div class="panel-body">
                        <div id="table-dong-chung-tu" class="adv-table">
                            
                        </div>
                    </div>
                </section>
            </div>
        </div>
        <div class="modal fade" id="thanhToan" tabindex="-1" role="dialog" aria-labelledby="thucDon" aria-hidden="true">
            <div class="modal-dialog modal-md">
                <div class="modal-content-wrap">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title">Thanh toán</h4>
                        </div>
                        <form class="modal-body">
                        	<div class="row">
	                        	<div class="form-group col-md-12">
	                              	<label>Tổng tiền</label>
	                              	<input style="display: none;" id="tongTien" type="text" value="0" readonly="readonly">
	                              	<input style="display: block; width: 100%; color: #e74c3c; font-size: 40px; font-weight: bold; border: none; text-align: center;" id="CalTongTien" type="text" value="0" readonly="readonly">
	                         	</div>
	                         	<div class="form-group col-md-6">
	                              	<button class="btn btn-primary btn-sm" type="button" onclick="hoaDon.show()"  style="width: 100%;">In hóa đơn</button>
	                         	</div>	
	                         	<div class="form-group col-md-6">
	                              	<button class="btn btn-success btn-sm" type="button" onclick="chungTu.thanhToan()" style="width: 100%;">Thanh toán</button>
	                         	</div>
                        	</div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade" id="chuyenBan" tabindex="-1" role="dialog" aria-labelledby="thucDon" aria-hidden="true">
            <div class="modal-dialog modal-sm">
                <div class="modal-content-wrap">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title">Chuyển bàn</h4>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <label>Khu vực</label>
                                <select onchange="get_ban()" id="chuyenBanKhuVuc" class="form-control"></select>
                            </div>
                            <div class="form-group">
                                <label>Bàn mới</label>
                                <select id="chuyenBanBanMoi" class="form-control"></select>
                            </div>
                            <div class="form-group">
                                <button onclick="chuyenBan()" class="btn btn-success" style="width: 100%;">Đồng ý</button>
                            </div>  
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade" id="huyBan" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-sm">
                <div class="modal-content-wrap">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title">Thông báo</h4>
                        </div>
                        <div class="modal-body">
                            <h4>Bạn có chắc hủy bàn ?</h4>
                        </div>
                        <div class="modal-footer">
                            <button onclick="huyBan()" class="btn btn-warning" type="button"> Đồng ý</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
		<!-- page end-->
    </section>
</section>
<ul class="dropdown-menu extended tasks-bar" id="tac-dong" style="position: absolute; display: none;">
    <li>
    	<input type="hidden" id="EditIdDCT" value="0" />
    	<span style="display: none;" id="EditTinhTrangDCT"></span>
        <p class="green">Bạn đang chọn: <span id="EditTenDCT"></span></p>
    </li>
    <li style=" padding: 8px;">
	    <button onclick="get_suaSoLuong()" class="btn btn-primary" style="width: 100%;"><i class="fa fa-pencil"></i> Số lượng</button>
		<script>
			function get_suaSoLuong(){
				$("#suaSoLuong").modal("show");
			}
			
			function suaSoLuong(){
				var obj = _data_chung_tu;
	    		if(obj.trangThai == -1 || obj.trangThai == 1){
	    			toastr.info("Không thể thay đổi dữ liệu");
	    			return;
	    		}
				
				var c = $("#EditSoLuong").val();
				if(c <= 0 || c.trim() == ""){
        			toastr.info("Vui lòng nhập đầy đủ và lớn hơn 0");
        			return;
        		}

				if(isNaN(c)){
					toastr.info("Vui lòng nhập số");
					return;
				}
				
				call_ajax_dong_chung_tu('id', $("#EditIdDCT").val(), 'soLuong', c);
				$("#suaSoLuong").modal("hide")
			}
		</script>
	</li>
    <li style=" padding: 8px;">
	    <button onclick="suaGhiChu()" class="btn btn-success" style="width: 100%;"><i class="fa fa-check"></i> Xác nhận đã làm</button>
		<script>
			function suaGhiChu(){
				var obj = _data_chung_tu;
	    		if(obj.trangThai == -1 || obj.trangThai == 1){
	    			toastr.info("Không thể thay đổi dữ liệu");
	    			return;
	    		}
				
				call_ajax_dong_chung_tu('id', $("#EditIdDCT").val(), 'ghiChu', 'Đã làm');
			}
		</script>
	</li>
    <li style=" padding: 8px;">
	    <button onclick="get_xoaSanPham()" class="btn btn-danger" style="width: 100%;"><i class="fa fa-trash-o"></i> Xóa</button>
	    <script>
	    	function get_xoaSanPham(){
	    		$("#xoaMon").modal("show");
	    	}
	    
	    	function xoaSanPham(){
	    		var obj = _data_chung_tu;
	    		if(obj.trangThai == -1 || obj.trangThai == 1){
	    			toastr.info("Không thể thay đổi dữ liệu");
	    			return;
	    		}
	    		
	    		if($("#EditTinhTrangDCT").html() == "Đã làm"){
	    			toastr.info("Xin lỗi món đã làm nên không thể xóa");
	    			$("#xoaMon").modal("hide");
	    			return;
	    		}
	    		
	    		call_ajax_dong_chung_tu('id', $("#EditIdDCT").val(), 'status', '1');
	    		$("#EditIdDCT").val("")
	    		$("#xoaMon").modal("hide");
	    	}
	    </script>
	</li>
</ul>
<div class="modal fade" id="xoaMon" tabindex="-1" role="dialog" aria-labelledby="cc" aria-hidden="true">
    <div class="modal-dialog modal-sm">
        <div class="modal-content-wrap">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Xóa món</h4>
                </div>
                <div class="modal-body">
					<h4>Bạn có chắc ?</h4>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-warning" onclick="xoaSanPham()" type="button"> Đồng ý</button>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="suaSoLuong" tabindex="-1" role="dialog" aria-labelledby="cc" aria-hidden="true">
    <div class="modal-dialog modal-sm">
        <div class="modal-content-wrap">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Sửa số lượng</h4>
                </div>
                <div class="modal-body">
                	<div class="row">
                	<div class="form-group  col-md-12">
                        <label>Số lượng mới</label>
                        <input class="form-control" id="EditSoLuong" value="" placeholder="Mời bạn nhập" />
                    </div>
                    <div class="form-group  col-md-12">
                        <button onclick="suaSoLuong()" class="btn btn-success" style="width: 100%;">Đồng ý</button>
                    </div>  
                	</div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
	var _soCT = ${soCT};
	var _data_chung_tu;

	function onload_all(){
		loadChungTu();
	}
	
	window.hoaDon = {
		show: function (){
			var obj = _data_chung_tu;
			var url = BASE_MAIN_URL + "thu-ngan/hoa-don-thanh-toan/" + obj.soCT;
			var myWindow = window.open(url, "Mã hóa đơn #" + obj.soCT, "width=500, height=673");
		}
	}
	
	window.chungTu = {
		get: function (){
			$.ajax({
	            url: BASE_MAIN_URL + '/api/chungTu/tongTien',
	            type: 'POST',
	            data: {
	            	soCT: _soCT
	            },
	        })
	        .done(function(data) {
	        	$("#tongTien").val(Number(data))
	        	$("#CalTongTien").val(Number(data).toLocaleString('it-IT', {style : 'currency', currency : 'VND'}))
	        })
		},
		thanhToan: function (){
			var obj = _data_chung_tu;
		  	if (!confirm("Bạn chắc chắn chưa, bạn đã nhận tiền chưa ?")) {
		    	return;
		  	}
			
			$.ajax({
	            url: BASE_MAIN_URL + '/api/chungTu/thanhToan',
	            type: 'POST',
	            data: {
	            	soCT: obj.soCT
	            },
	        })
	        .done(function(data) {
	        	if(data == "Thành công"){
	    			window.location.href = BASE_MAIN_URL + "/thu-ngan/so-do-ban";
	        		toastr.success("Thành công, vui lòng click in hóa đơn để xem");
	        	}else{
	            	toastr.error(data);
	        	}
	        })
		},
		sum: function() {
			var obj = _data_chung_tu;
			$.ajax({
	            url: BASE_MAIN_URL + '/api/chungTu/tongTien',
	            type: 'POST',
	            data: {
	            	soCT: obj.soCT
	            },
	        })
	        .done(function(data) {
	        	$("#tongTienView").html(Number(data).toLocaleString('it-IT', {style : 'currency', currency : 'VND'}));
	        })
		}
	}
	
	window.onload = function() {
		onload_all();
		loadThucDon();
	};
	
	function huyBan(){
		var obj = _data_chung_tu;
		if(obj.trangThai == -1 || obj.trangThai == 1){
			toastr.info("Không thể thay đổi dữ liệu");
			return;
		}
		
		$.ajax({
            url: BASE_MAIN_URL + '/api/chungTu/huyBan',
            type: 'POST',
            data: {
            	soCT: obj.soCT
            },
        })
        .done(function(data) {
        	if(data == "Thành công"){
        		toastr.success(data);
        		window.location.href = BASE_MAIN_URL + "/thu-ngan/so-do-ban";
        	}else{
            	toastr.error(data);
        	}
        	$("#huyBan").modal("hide");
        })
	}
	
	function chuyenBan(){
		var obj = _data_chung_tu;
		if(obj.trangThai == -1 || obj.trangThai == 1){
			toastr.info("Không thể thay đổi dữ liệu");
			return;
		}
		
		var _obj = _data_chung_tu;
		if($("#chuyenBanBanMoi").val() == ""){
			return;
		}
		
		$.ajax({
            url: BASE_MAIN_URL + '/api/chungTu/chuyenBan',
            type: 'POST',
            data: {
            	soCT: _obj.soCT,
            	soBan: $("#chuyenBanBanMoi").val()
            },
        })
        .done(function(data) {
        	toastr.info(data);
        	loadChungTu();
        	$("#chuyenBan").modal("hide");
        })
	}
	
	function get_ban(){
		$("#chuyenBanBanMoi").html("")
		if($("#chuyenBanKhuVuc").val() == ""){
			return;
		}

		$.ajax({
            url: BASE_MAIN_URL + '/api/soDoBan',
            type: 'POST',
            data: {
            	khuVuc: $("#chuyenBanKhuVuc").val()
            },
        })
        .done(function(data) {
        	for (var i = 0; i < data.length; i++) {
        		if(data[i].tinhTrang == 1){
        			$("#chuyenBanBanMoi").append(new Option(data[i].soBan, data[i].soBan));
        		}
			}
        })
	}
	
	function get_chuyenBan(){
		$("#chuyenBanKhuVuc").html("")
		$("#chuyenBanKhuVuc").append(new Option("Mời bạn chọn", ""));
		
		$.ajax({
            url: BASE_MAIN_URL + '/api/khuVuc',
            type: 'POST',
            data: {
            	
            },
        })
        .done(function(data) {
        	var obj = JSON.parse(data)
        	for (var i = 0; i < obj.length; i++) {
				$("#chuyenBanKhuVuc").append(new Option(obj[i].tenKV, obj[i].maKV));
			}
        })
	}
	
	
	function loadThucDon(){
		$.ajax({
            url: BASE_MAIN_URL + '/api/sanPham',
            type: 'POST',
            data: {
            	
            },
        })
        .done(function(data) {
        	$("#table-thuc-don").html('\
    				<table class="display table table-bordered table-striped" id="thuc-don">\
    	                <thead>\
    	                    <tr>\
    	                        <th>Tên</th>\
    	                        <th>Giá</th>\
    	                        <th>Giảm</th>\
    	                        <th></th>\
    	                    </tr>\
    	                </thead>\
    	                <tbody>\
    	                </tbody>\
    	            </table>');
        	
        	for (var i= 0; i < data.length; i++) {
        		if(data[i].isMenu == 1){
        		$("#thuc-don tbody").append('\
    					<tr class="gradeX">\
                            <td><b>'+data[i].tenSP+'</b></td>\
                            <td><b>'+Number(data[i].giaBan).toLocaleString('it-IT', {style : 'currency', currency : 'VND'})+'</b></td>\
                            <td><b>'+Number(data[i].giam).toLocaleString('it-IT', {style : 'currency', currency : 'VND'})+'</b></td>\
                            <td>\
                           	 	<button style="width: 100%;" onclick="themDongChungTu(this)" data-id="'+data[i].maSP+'" class="btn btn-info btn-xs"><i class="fa fa-plus"></i></button>\
                            </td>\
                        </tr>');
        		}
			}
        	$('#thuc-don').dataTable();
        })
	}
	
	function themDongChungTu(e){
		var obj = _data_chung_tu;
		if(obj.trangThai == -1 || obj.trangThai == 1){
			toastr.info("Không thể thay đổi dữ liệu");
			return;
		}
		
		var _maSP = $(e).attr("data-id");
		$.ajax({
            url: BASE_MAIN_URL + '/api/dongChungTu/add',
            type: 'POST',
            data: {
            	soCT: obj.soCT,
            	maSP: _maSP
            },
        })
        .done(function(data) {
        	toastr.info(data);
        	onload_all()
        })
	}
		
	
	function loadDongChungTu(){
		var _obj = _data_chung_tu;
		$.ajax({
            url: BASE_MAIN_URL + '/api/dongChungTu/getBySoCT',
            type: 'POST',
            data: {
            	soCT: _obj.soCT
            },
        })
        .done(function(data) {
        	$("#table-dong-chung-tu").html('\
        			<table class="display table table-bordered table-striped" id="dong-chu-tu">\
		        	<thead> \
			        	<tr> \
			        		<th>Id</th> \
				        	<th>Thời gian</th> \
				        	<th>Tên món</th> \
				        	<th>Số lượng</th> \
				        	<th>Đơn giá</th> \
				        	<th>Giảm giá</th> \
				        	<th>Thành tiền</th> \
				        	<th>Tình trạng</th> \
			        	</tr> \
		        	</thead> \
		        	<tbody> \
		        	</tbody> \
		        	</table>');
        	if(data.length == 0){
        		$('#dong-chu-tu').dataTable();
        		return;
        	}
        	
        	for (var i = 0; i < data.length; i++) {
        		var date = new Date(Number(data[i].gioVao));
        		var tinhTrang = '<td><span class="label label-danger label-mini">'+data[i].ghiChu+'</span></td>';
        		if(data[i].ghiChu == 'Đã làm'){
        			tinhTrang = '<td><span class="label label-success label-mini">'+data[i].ghiChu+'</span></td>';
        		}
        		
        		$("#dong-chu-tu tbody").append('<tr>\
        				<td><b>'+data[i].id+'</b></td>\
	                    <td><b>'+date.getDate()+'-'+date.getMonth()+' '+date.getHours()+':'+date.getMinutes()+'</b></td>\
	                    <td><b>'+data[i].tenSP+'</b></td>\
	                    <td><b>'+data[i].soLuong+'</b></td>\
	                    <td><b>'+data[i].donGia.toLocaleString('it-IT', {style : 'currency', currency : 'VND'})+'</b></td>\
	                    <td><b>'+data[i].giam.toLocaleString('it-IT', {style : 'currency', currency : 'VND'})+'</b></td>\
	                    <td><b>'+(data[i].soLuong * (data[i].donGia - data[i].giam)).toLocaleString('it-IT', {style : 'currency', currency : 'VND'})+'</b></td>\
	                    '+tinhTrang+'\
	                </tr>');
			}
        	$('#dong-chu-tu').dataTable();
        	$('#dong-chu-tu tbody').on('contextmenu', 'tr', function(e) {
				e.preventDefault();
				var id = this.children[0].innerText;
				var ten = this.children[2].innerText;
				var tinhTrang = this.children[7].innerText;
				$("#EditIdDCT").val(id);
				$("#EditTenDCT").html(ten);
				$("#EditTinhTrangDCT").html(tinhTrang);
				$('#tac-dong').css({
					display : "block",
					left : e.pageX,
					top : e.pageY,
				});
			});

			$("html").click(function() {
				$("#tac-dong").css({
					display : "none",
				});
			});
        })
	}
	
	function setChungTu(_data){
		var _obj = _data;
		var d = new Date(Number(_obj.ngayCT));
		var trangThai = "";
		if(_obj.trangThai == 0){
			trangThai = "Chưa thanh toán";
		}else if(_obj.trangThai == 1){
			trangThai = "Đã thanh toán";
		}else{
			trangThai = "Đã huỷ";
		}
		
		$("#chungTuView").html("#" + _obj.soCT + " - " + _obj.soBan + " - " + trangThai);
		$("#thoiGianView").val(d.getDate() + "/" + (d.getMonth() + 1) + "/" + d.getFullYear() + " - " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds())
		$("#soLuongKhachView").val(_obj.soKhach)
		$("#noteView").val(_obj.noiDung)
		$("#vatView").val(_obj.thueVAT);
		$("#giamGiaView").val(_obj.giam);
		
		$.ajax({
            url: BASE_MAIN_URL + '/api/chungTu/tongTien',
            type: 'POST',
            data: {
            	soCT: _soCT
            },
        })
        .done(function(data) {
        	$("#tongTienView").html(Number(data).toLocaleString('it-IT', {style : 'currency', currency : 'VND'}));
        })
	}
	
	
	function loadChungTu(){
		$.ajax({
            url: BASE_MAIN_URL + '/api/chungTu/getBySoCT',
            type: 'POST',
            data: {
            	soCT: _soCT
            },
        })
        .done(function(data) {
        	_data_chung_tu = data;
        	setChungTu(_data_chung_tu);
        	loadDongChungTu();
        })
	}
	
	function call_ajax(_colum_key, _value_key, _colum_data, _value_data){
		$.ajax({
            url: BASE_MAIN_URL + '/api/chungTu/update_by_sql',
            type: 'POST',
            data: {
            	colum_key: _colum_key,
            	value_key: _value_key,
            	colum_data: _colum_data,
            	value_data: _value_data
            },
        })
        .done(function(data) {
        	toastr.info(data);
        	chungTu.sum();
        })
	}
	
	function call_ajax_dong_chung_tu(_colum_key, _value_key, _colum_data, _value_data){
		$.ajax({
            url: BASE_MAIN_URL + '/api/dongChungTu/update_by_sql',
            type: 'POST',
            data: {
            	colum_key: _colum_key,
            	value_key: _value_key,
            	colum_data: _colum_data,
            	value_data: _value_data
            },
        })
        .done(function(data) {
        	toastr.info(data);
        	onload_all();
        })
	}
</script>
<!--main content end-->
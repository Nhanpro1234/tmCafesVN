<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!--main content start-->
<section id="main-content" style="margin-left: 0px;">
	<section class="wrapper">
		<!-- page start-->
		<div class="row">
			<div class="col-md-3">
				<section class="panel">
					<div class="panel-body">
						<input type="text" placeholder="Keyword Search"
							class="form-control">
					</div>
				</section>
				<section class="panel">
					<header class="panel-heading"> Danh sác món đã gọi chưa làm </header>
					<div class="panel-body">
						<section id="danh-sach-mon-da-goi" class="panel">
							
						</section>
					</div>
				</section>
			</div>
			<script type="text/javascript">
				function loadDanhSachMonDaGoi(){
					$("#danh-sach-mon-da-goi").html('\
						<table class="table table-striped table-advance table-hover">\
							<thead>\
								<tr>\
									<th>Tên</th>\
									<th>Số lượng</th>\
									<th></th>\
								</tr>\
							</thead>\
							<tbody>\
							</tbody>\
						</table>');
					
					$.ajax({
			            url: BASE_MAIN_URL + '/api/danhSachMonDaGoi',
			            type: 'POST',
			            data: {
			            	
			            },
			        })
			        .done(function(data) {
			        	for (var i = 0; i < data.length; i++) {
			        		$("#danh-sach-mon-da-goi table tbody").append('\
		        				<tr>\
									<td><a href="#">'+data[i].tenSP+'</a></td>\
									<td><a href="#">'+data[i].soLuong+'</a></td>\
									<td>\
										<button onclick="suaGhiChu('+data[i].id+')" class="btn btn-success btn-xs">\
											<i class="fa fa-check"></i>\
										</button>\
									</td>\
								</tr>');
						}
			        })
				}
				
				function suaGhiChu(val){
					call_ajax_dong_chung_tu('id', val, 'ghiChu', 'Đã làm');
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
			        	loadDanhSachMonDaGoi();
			        })
				}
			</script>
			<div class="col-md-9">
				<section class="panel">
					<div class="panel-body">
						<div class="pro-sort">
							<label class="pro-lab">Tình trạng</label> 
							<select onchange="timKiemSanBanPhong()" id="timKiem_tinhTrang" class="styled form-control">
								<option value="">Tất cả</option>
								<option value="0">Bàn kín</option>
								<option value="1">Bàn trống</option>
							</select>
						</div>

						<div class="pro-sort">
							<label class="pro-lab">Khu vực</label> 
							<select onchange="timKiemSanBanPhong()" id="timKiem_khuVuc" class="styled form-control">
								<option value="">Tất cả</option>
							</select>
						</div>

						<div class="pull-right">
							<ul class="pagination pagination-sm pro-page-list">

								<li><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">»</a></li>
							</ul>
						</div>
					</div>
				</section>
				<style type="text/css">
					.table-coffee {
						text-align: center;
					}
					
					.table-coffee ul {
						margin: 0;
						padding: 0;
					}
					
					.status-table-coffee {
						position: absolute;
						top: 0;
						right: 0;
					}
				</style>
				<div id="danhSachBan" class="row product-list">
					
				</div>
			</div>
		</div>
		<!-- page end-->
	</section>
</section>
<!--main content end-->
<script type="text/javascript">
	function timKiemSanBanPhong(){
		var timKiem_tinhTrang = $("#timKiem_tinhTrang").val();
		var timKiem_khuVuc = $("#timKiem_khuVuc").val();
		//alert(timKiem_khuVuc);
		loadSanBanPhong(timKiem_khuVuc, timKiem_tinhTrang);
	}

	function loadSanBanPhong(KV, TT){
		$("#danhSachBan").html();
		$.ajax({
            url: BASE_MAIN_URL + '/api/soDoBan',
            type: 'POST',
            data: {
            	khuVuc: KV
           	},
        })
        .done(function(obj) {
        	var html_default = "";
			for (var i = 0; i < obj.length; i++) {
				if(TT == ""){
					var tinhTrang;
					if (obj[i].tinhTrang == 1){
						tinhTrang = "Bàn trống";
						$(".tinhTrang").addClass("label label-mini label-info");
						$(".tinhTrang").removeClass("label-success");
						$(".set-url-chi-tiet-ban b").text("Bắt đầu bàn");
						
					}else{
						tinhTrang = "Bàn kín";
						$(".tinhTrang").addClass("label label-mini label-success");
						$(".tinhTrang").removeClass("label-info");
						$(".set-url-chi-tiet-ban b").text("Xem chi tiết");
					}
					
					$(".soBan").html(obj[i].soBan);
					$(".thoiGianVao").html(obj[i].thoiGianVao);
					//$(".tongTien").html(obj[i].tongTien);
					$(".tinhTrang").html(tinhTrang);
					$(".set-url-chi-tiet-ban").attr("data-id", obj[i].soBan);
					
					
					var html = $("#ban_mac_dinh").html();
					html_default += html; 
				}else{
					if(obj[i].tinhTrang == TT){
						var tinhTrang;
						if (obj[i].tinhTrang == 1){
							tinhTrang = "Bàn trống";
							$(".tinhTrang").addClass("label label-mini label-info");
							$(".tinhTrang").removeClass("label-success");
							$(".set-url-chi-tiet-ban b").text("Bắt đầu bàn");
							
						}else{
							tinhTrang = "Bàn kín";
							$(".tinhTrang").addClass("label label-mini label-success");
							$(".tinhTrang").removeClass("label-info");
							$(".set-url-chi-tiet-ban b").text("Xem chi tiết");
						}
						
						$(".soBan").html(obj[i].soBan);
						$(".thoiGianVao").html(obj[i].thoiGianVao);
						$(".tongTien").html(obj[i].tongTien);
						$(".tinhTrang").html(tinhTrang);
						$(".set-url-chi-tiet-ban").attr("data-id", obj[i].soBan);
						
						var html = $("#ban_mac_dinh").html();
						html_default += html; 
					}
				}
			}
		 	$("#danhSachBan").html(html_default);
        })
	}
	
	function loadKhuVuc(){
		$.ajax({
            url: '/tmCafes/api/khuVuc',
            type: 'POST',
            data: {
            	
            },
        })
        .done(function(data) {
        	var obj = JSON.parse(data);
			for (var i = 0; i < obj.length; i++) {
				$("#timKiem_khuVuc").append(new Option(obj[i].tenKV, obj[i].maKV));
			}
        })
	}
	window.onload = function() {
		loadSanBanPhong("","");
		loadKhuVuc();
		loadDanhSachMonDaGoi();
	};
	function start(e){
		if(e.getAttribute("data-id") == ""){
			return;
		}
		
		$.ajax({
            url: BASE_MAIN_URL + '/api/thu-ngan/soDoban',
            type: 'POST',
            data: {
            	soBan: e.getAttribute("data-id")
            },
        })
        .done(function(data) {
        	window.location.href = BASE_MAIN_URL + "/thu-ngan/chi-tiet-ban/" + data.soCT;
        }) 
	}
	
</script>
<div style="display: none;" id="ban_mac_dinh">
	<div class="col-md-3 col-sm-3 col-xs-6">
	    <section class="panel" style="position: relative; padding-top: 30px;">
	        <div class="table-coffee">
	            <ul>
	                <li>
	                    <h4 style="text-transform: uppercase;"><b class="soBan">N/A</b></h4>
	                </li>
	                <li>
	                    <span style="color: #3498db">
	                    	<b class="thoiGianVao">N/A</b>
	                    </span>
	                </li>
	                <!-- <li>
	                    <h4><span style="color: #3498db"><b class="tongTien">N/A</b></span></h4>
	                </li> -->
	                <!-- <li>
	                    <div class="btn-group">
	                        <button data-toggle="dropdown" class="btn btn-success dropdown-toggle btn-xs" type="button" aria-expanded="false">Tuỳ chọn <span class="caret"></span></button>
	                        <ul role="menu" class="dropdown-menu">
	                              <li><a href="#">Thannh toán</a></li>
	                              <li><a href="#">Chuyển bàn</a></li>
	                              <li><a href="#">Ghép bàn</a></li>
	                              <li><a href="#">Hủy</a></li>
	                        </ul>
	                    </div>
	                </li> -->
	            </ul>
	        </div>
	        <div class="panel-body text-center" style="padding: 0; padding-bottom: 10px;">
	            <h4>
	                <button onclick="start(this)" data-id="" class="btn btn-success set-url-chi-tiet-ban pro-title text-white" style="text-transform: uppercase;"><b>Xem chi tiết</b></button>
	            </h4>
	        </div>
	        <div class="status-table-coffee">
	            <span  class="tinhTrang">N/A</span>
	        </div>
	    </section>
	</div>
</div>
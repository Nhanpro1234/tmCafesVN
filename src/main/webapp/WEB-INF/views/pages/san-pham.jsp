<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!--main content start-->
<section id="main-content">
    <section class="wrapper">
        <!-- page start-->
        <div class="row">
            <div class="col-md-12">
                <section class="panel" style="max-height: 600px; overflow: auto;">
                    <header class="panel-heading">
                        Hành động
                    </header>
                    <div class="panel-body">
                        <input type="hidden" id="checkMaCha" value="0" />		
                        <button type="button" onclick="get_themNhom()" class="btn btn-shadow btn-info">Thêm nhóm</button>
                        <button type="button" onclick="get_suaNhom()" class="btn btn-shadow btn-success">Sửa nhóm</button>
                        <button type="button" onclick="get_xoaNhom()" class="btn btn-shadow btn-danger">Xóa nhóm</button>
                        <button type="button" onclick="get_chuyenNhom()" class="btn btn-shadow btn-warning">Chuyển nhóm</button>
                    </div>
                </section>
            </div>
            <div id="templateNhomHang" class="col-md-3">
                <div style="overflow: auto;" class="panel">
                    <div class="panel-heading">
                        Loại nhóm hàng
                        <span class="tools pull-right">
                    </span>
                    </div>
                    <div class="panel-body">
                        <div id="evts"></div>
                    </div>
                </div>
            </div>
            <div class="col-md-9">
                <section class="panel">
                    <header class="panel-heading">
                    	Danh sách sản phẩm <button onclick="get_themSanPham()" class="btn btn-success"><i class="fa fa-plus"></i> Thêm</button>
                        <span class="tools pull-right">
                            <a href="javascript:;" class="fa fa-chevron-down"></a>
                        </span>
                    </header>
                    <div class="panel-body">
                        <div id="table-san-pham" style="overflow-x:auto;">
                             
                        </div>
                    </div>
                </section>
            </div>
        </div>
        <!-- page end-->
    </section>
</section>
<div class="modal fade" id="them" tabindex="-1" role="dialog" aria-labelledby="cc" aria-hidden="true">
    <div class="modal-dialog modal-sm">
        <div class="modal-content-wrap">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Thêm mới khu vực</h4>
                </div>
                <div class="modal-body">
                	<div class="form-group">
                        <input class="form-control" id="AddMaCha" type="hidden" value="0" />
                    </div>
                    <div class="form-group">
                        <label>Tên mới</label>
                        <input class="form-control" id="AddTenNhom" value="" placeholder="Mời bạn nhập" />
                    </div>
                    <div class="form-group">
                        <label>Loại</label>
                       	<select class="form-control" id="AddLoaiNhom">
                       		<option value="0">Mời bạn chọn</option>
                       		<option value="1">Nguyên liệu</option>
                       		<option value="2">Hàng hóa</option>
                       		<option value="3">Sản phẩm pha chế</option>
                       		<option value="4">Dịch vụ theo giờ</option>
                       	</select>
                    </div>
                    <div class="form-group">
                        <button onclick="themNhom()" class="btn btn-success" style="width: 100%;">Đồng ý</button>
                    </div>  
                </div>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="sua" tabindex="-1" role="dialog" aria-labelledby="cc" aria-hidden="true">
    <div class="modal-dialog modal-sm">
        <div class="modal-content-wrap">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Sửa nhóm hàng</h4>
                </div>
                <div class="modal-body">
                    <input class="form-control" id="EditMaNhom" type="hidden" value="" />
                    <input class="form-control" id="EditMaCha" type="hidden" value="" />
                    <div class="form-group">
                        <label>Tên</label>
                        <input class="form-control" id="EditTenNhom" value="" placeholder="Mời bạn nhập" />
                    </div>
                    <div class="form-group">
                        <label>Loại</label>
                       	<select class="form-control" id="EditLoaiNhom">
                       		<option value="1">Nguyên liệu</option>
                       		<option value="2">Hàng hóa</option>
                       		<option value="3">Sản phẩm pha chế</option>
                       		<option value="4">Dịch vụ theo giờ</option>
                       	</select>
                    </div>
                    <div class="form-group">
                        <button onclick="sua()" class="btn btn-success" style="width: 100%;">Đồng ý</button>
                    </div>  
                </div>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="xoa" tabindex="-1" role="dialog" aria-labelledby="cc" aria-hidden="true">
    <div class="modal-dialog modal-sm">
        <div class="modal-content-wrap">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Xóa nhóm</h4>
                </div>
                <div class="modal-body">
					<h4>Bạn có chắc ?</h4>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-warning" onclick="xoa()" type="button"> Đồng ý</button>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="chuyen" tabindex="-1" role="dialog" aria-labelledby="cc" aria-hidden="true">
    <div class="modal-dialog modal-sm">
        <div class="modal-content-wrap">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Chuyển nhóm</h4>
                </div>
                <div class="modal-body">
					<input id="MoveMaNhom" value="" type="hidden"/>
					<div class="form-group">
                        <label>Loại</label>
                       	<select class="form-control" id="MoveMaCha">
                       	</select>
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-warning" onclick="chuyen()" type="button"> Đồng ý</button>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="themSanPham" tabindex="-1" role="dialog" aria-labelledby="cc" aria-hidden="true">
    <div class="modal-dialog modal-md">
        <div class="modal-content-wrap">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Thêm sản phẩm</h4>
                </div>
                <div class="modal-body">
                	<form class="row">
						<input id="AddMaNhomSP" value="" type="hidden"/>
						<div class="form-group col-md-6">
	                        <label>Tên *</label>
	                        <input class="form-control" id="AddTenSPSP" value="" placeholder="Mời bạn nhập" />
	                    </div>
	                    <div class="form-group col-md-6">
	                        <label>Mã đơn vị tính  *</label>
	                        <select class="form-control" style="text-transform: uppercase;" id="AddMaDVTSP">
	                       	</select>
	                    </div>
	                    <div class="form-group col-md-6">
	                        <label>SLDK  *</label>
	                        <input class="form-control" type="number" id="AddSLDKSP" value="0" placeholder="Mời bạn nhập" />
	                    </div>
	                    <div class="form-group col-md-6">
	                        <label>GTDK  *</label>
	                        <input class="form-control" type="number" id="AddGTDKSP" value="0" placeholder="Mời bạn nhập" />
	                    </div>
	                    <div class="form-group col-md-6">
	                        <label>Giá vốn  *</label>
	                        <input class="form-control" type="number" id="AddGiaVonSP" value="0" placeholder="Mời bạn nhập"/>
	                    </div>
	                    <div class="form-group col-md-6">
	                        <label>Giá Bán  *</label>
	                        <input class="form-control" type="number" id="AddGiaBanSP" value="0" placeholder="Mời bạn nhập"/>
	                    </div>
	                    <div class="form-group col-md-6">
	                        <label>Giảm  *</label>
	                        <input class="form-control" type="number" id="AddGiamSP" value="0" placeholder="Mời bạn nhập"/>
	                    </div>
	                    <div class="form-group col-md-6">
	                        <label>Không nhập</label>
	                        <input class="form-control" id="AddKhongNhap" value="" type="checkbox"/>
	                    </div>
	                    <div class="form-group col-md-6">
	                        <label>Không xuất</label>
	                        <input class="form-control" id="AddKhongXuat" value="" type="checkbox"/>
	                    </div>
	                    <div class="form-group col-md-6">
	                        <label>Thêm vào menu</label>
	                        <input class="form-control" id="AddIsMenu" value="" type="checkbox"/>
	                    </div>
                	</form>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-warning" onclick="themNhanVien()" type="button"> Đồng ý</button>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="suaSanPham" tabindex="-1" role="dialog" aria-labelledby="cc" aria-hidden="true">
    <div class="modal-dialog modal-md">
        <div class="modal-content-wrap">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Sửa sản phẩm</h4>
                </div>
                <div class="modal-body">
                	<form class="row">
                        <input id="EditMaNhomSP" value="" type="hidden"/>
						<div class="form-group col-md-6">
	                        <label>Tên *</label>
	                        <input class="form-control" id="EditTenSPSP" value="" placeholder="Mời bạn nhập" />
	                    </div>
	                    <div class="form-group col-md-6">
	                        <label>Mã đơn vị tính  *</label>
	                        <select class="form-control" style="text-transform: uppercase;" id="EditMaDVTSP">
	                       	</select>
	                    </div>
	                    <div class="form-group col-md-6">
	                        <label>SLDK  *</label>
	                        <input class="form-control" type="number" id="EditSLDKSP" value="" placeholder="Mời bạn nhập" />
	                    </div>
	                    <div class="form-group col-md-6">
	                        <label>GTDK  *</label>
	                        <input class="form-control" type="number" id="EditGTDKSP" value="" placeholder="Mời bạn nhập" />
	                    </div>
	                    <div class="form-group col-md-6">
	                        <label>Giá vốn  *</label>
	                        <input class="form-control" type="number" id="EditGiaVonSP" value="" placeholder="Mời bạn nhập"/>
	                    </div>
	                    <div class="form-group col-md-6">
	                        <label>Giá Bán  *</label>
	                        <input class="form-control" type="number" id="EditGiaBanSP" value="" placeholder="Mời bạn nhập"/>
	                    </div>
	                    <div class="form-group col-md-6">
	                        <label>Giảm  *</label>
	                        <input class="form-control" type="number" id="EditGiamSP" value="" placeholder="Mời bạn nhập"/>
	                    </div>
	                    <div class="form-group col-md-6">
	                        <label>Không nhập</label>
	                        <input class="form-control" id="EditKhongNhap" value="" type="checkbox"/>
	                    </div>
	                    <div class="form-group col-md-6">
	                        <label>Không xuất</label>
	                        <input class="form-control" id="EditKhongXuat" value="" type="checkbox"/>
	                    </div>
	                    <div class="form-group col-md-6">
	                        <label>Thêm vào menu</label>
	                        <input class="form-control" id="EditIsMenu" value="" type="checkbox"/>
	                    </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-warning" onclick="suaSanPham()" type="button"> Đồng ý</button>
                </div>
            </div>
        </div>
    </div>
</div>
<style>
	#sidebar{
		 margin-left: 0px;
 	}
</style>
<ul class="dropdown-menu extended tasks-bar" id="tac-dong" style="position: absolute; display: none;">
  	 	<div class="notify-arrow notify-arrow-green"></div>
    <li>
    	<input type="hidden" id="EditMaSP" value="0" />
        <p class="green">Bạn đang chọn: <span id="EditTenSP"></span></p>
    </li>
    <li style=" padding: 8px;">
	    <button onclick="get_suaSanPham()" class="btn btn-primary" style="width: 100%;"><i class="fa fa-pencil"></i> Sửa</button>
	</li>
    <li style=" padding: 8px;">
	    <button onclick="xoaSanPham()" class="btn btn-danger" style="width: 100%;"><i class="fa fa-trash-o"></i> Xóa</button>
	</li>
</ul>
<script>
	function suaSanPham(){
		var _isMenu = "0";
        var _khongNhap = "0";
        var _khongXuat = "0";
        if($('#EditIsMenu').prop('checked')) {
            _isMenu = "1";
        }
        if($('#EditKhongNhap').prop('checked')) {
            _khongNhap = "1";
        }
        if($('#EditKhongXuat').prop('checked')) {
            _khongXuat = "1";
        }
        
        $.ajax({
            url : BASE_MAIN_URL + '/api/sanPham/update',
            type : 'POST',
            data : {
                maSP: $("#EditMaSP").val(),
                maNhom: $("#EditMaNhomSP").val(),
                tenSP: $("#EditTenSPSP").val(),
                maDVT: $("#EditMaDVTSP").val(),
                SLDK: $("#EditSLDKSP").val(),
                GTDK: $("#EditGTDKSP").val(),
                giaVon: $("#EditGiaVonSP").val(),
                giaBan: $("#EditGiaBanSP").val(),
                giam: $("#EditGiamSP").val(),
                khongNhap: _khongNhap,
                khongXuat: _khongNhap,
                isMenu: _isMenu
            },
        })
        .done(function(data) {
            if(data == "Thành công"){
                loadSanPham($("#checkMaCha").val());
                $("#suaSanPham").modal("hide");
            }else{
                toastr.error(data);
            }
        })
	}

	function get_suaSanPham(){
		if($("#EditMaSP").val() == 0){
			return;
		}
		
		$("#EditMaDVTSP").html("");
		
		$.ajax({
			url : BASE_MAIN_URL + '/api/sanPham/maSP',
			type : 'POST',
			data : {
				maSP: $("#EditMaSP").val()
			},
		})
		.done(function(data) {
			$("#EditMaNhomSP").val(data.maNhom);
			$("#EditTenSPSP").val(data.tenSP);
			
			$("#EditMaDVTSP").append(new Option(data.tenDVT, data.maDVT, true, true));
			
			$("#EditSLDKSP").val(data.SLDK);
			$("#EditGTDKSP").val(data.GTDK);
			$("#EditGiaVonSP").val(data.giaVon);
			$("#EditGiaBanSP").val(data.giaBan);
			$("#EditGiamSP").val(data.giam);
			if(data.khongNhap == 1){
				$("#EditKhongNhap").prop('checked', true)
			}else{
				$("#EditKhongNhap").prop('checked', false)
			}
			if(data.khongXuat == 1){
				$("#EditKhongXuat").prop('checked', true)
			}else{
				$("#EditKhongXuat").prop('checked', false)
			}
			if(data.isMenu == 1){
				$("#EditIsMenu").prop('checked', true)
			}else{
				$("#EditIsMenu").prop('checked', false)
			}
		})
		
		$.ajax({
            url: BASE_MAIN_URL + '/api/donViTinh',
            type: 'POST',
            data: {
            	
            },
        })
        .done(function(data) {
        	var obj = JSON.parse(data)
        	for (var i = 0; i < obj.length; i++) {
        		$("#EditMaDVTSP").append(new Option(obj[i].tenDVT, obj[i].maDVT));
			}
        })
		
        $("#suaSanPham").modal("show");
	}

	function themNhanVien(){
		var _isMenu = "0";
		var _khongNhap = "0";
		var _khongXuat = "0";
		if($('#AddIsMenu').prop('checked')) {
			_isMenu = "1";
		}
		if($('#AddKhongNhap').prop('checked')) {
			_khongNhap = "1";
		}
		if($('#AddKhongXuat').prop('checked')) {
			_khongXuat = "1";
		}
		
		$.ajax({
			url : BASE_MAIN_URL + '/api/sanPham/add',
			type : 'POST',
			data : {
				maNhom: $("#AddMaNhomSP").val(),
				tenSP: $("#AddTenSPSP").val(),
				maDVT: $("#AddMaDVTSP").val(),
				SLDK: $("#AddSLDKSP").val(),
				GTDK: $("#AddGTDKSP").val(),
				giaVon: $("#AddGiaVonSP").val(),
				giaBan: $("#AddGiaBanSP").val(),
				giam: $("#AddGiamSP").val(),
				khongNhap: _khongNhap,
				khongXuat: _khongNhap,
				isMenu: _isMenu
			},
		})
		.done(function(data) {
			if(data == "Thành công"){
				loadSanPham($("#checkMaCha").val());
				$("#themSanPham").modal("hide");
			}else{
				toastr.error(data);
			}
		})
	}

	function get_themSanPham(){
		var checkMaCha = $("#checkMaCha").val();
		if(checkMaCha == "" || checkMaCha == 0){
			toastr.error("Bạn chưa chọn nhóm");
			return;
		}
		
		$("#AddMaNhomSP").val(checkMaCha)
		$("#AddMaDVTSP").html("")		
		$.ajax({
            url: BASE_MAIN_URL + '/api/donViTinh',
            type: 'POST',
            data: {
            	
            },
        })
        .done(function(data) {
        	var obj = JSON.parse(data)
        	for (var i = 0; i < obj.length; i++) {
        		$("#AddMaDVTSP").append(new Option(obj[i].tenDVT, obj[i].maDVT));
			}
        })
		
		$("#themSanPham").modal("show");
	}

	function xoaSanPham(){
		$.ajax({
            url: BASE_MAIN_URL + '/api/sanPham/del',
            type: 'POST',
            data: {
            	maSP: $("#EditMaSP").val()
            },
        })
        .done(function(data) {
            if(data == "Thành công"){
            	loadSanPham($("#checkMaCha").val())
            	toastr.success(data);
            }else{
            	toastr.error(data);
            }
        })
	}

		

	var dataSet = "";
	function loadSanPham(value){
		$("#table-san-pham").html("");
		$("#table-san-pham").html('<table class="table table-bordered table-striped" id="danh-sach-san-pham">\
						                <thead>\
							                <tr>\
							                </tr>\
							            </thead>\
							            <tbody>\
							            </tbody>\
							        </table>');	
		var html = "<th>Mã</th>\
            <th>Tên</th>\
            <th>Đơn vị tính</th>\
            <th>SLDK</th>\
            <th>GTDK</th>\
            <th>Giá vốn</th>\
            <th>Giá bán</th>\
            <th>Giảm</th>\
            <th>Không nhập</th>\
            <th>Không xuất</th>\
            <th>Menu</th>\
            ";
		$("#danh-sach-san-pham thead tr").append(html);
		
		$.ajax({
            url: BASE_MAIN_URL + '/api/sanPham/maNhom',
            type: 'POST',
            data: {
            	maNhom: value
            },
        })
        .done(function(result) {
        	for (var i = 0; i < result.length; i++) {
        		var isMenu = "✗";
        		var khongNhap = "✗";
        		var khongXuat = "✗";
        		if(result[i].isMenu == 1){
        			isMenu = "✓";
        		}
        		if(result[i].khongNhap == 1){
        			khongNhap = "✓";
        		}
        		if(result[i].khongXuat == 1){
        			khongXuat = "✓";
        		}
        		
	        	var dataHTML = '<tr>\
					                <th>'+result[i].maSP+'</th>\
					                <th>'+result[i].tenSP+'</th>\
					                <th>'+result[i].tenDVT+'</th>\
					                <th>'+result[i].SLDK+'</th>\
					                <th>'+result[i].GTDK+'</th>\
					                <th>'+result[i].giaVon+'</th>\
					                <th>'+result[i].giaBan+'</th>\
					                <th>'+result[i].giam+'</th>\
					                <th>'+khongNhap+'</th>\
					                <th>'+khongXuat+'</th>\
					                <th>'+isMenu+'</th>\
					            </tr>';
				$("#danh-sach-san-pham tbody").append(dataHTML);
        	}
        	$('#danh-sach-san-pham').dataTable();
        	
        	$('#danh-sach-san-pham tbody').on('contextmenu', 'tr', function(e) {
				e.preventDefault();
				var maSP = this.children[0].innerText;
				var tenSP = this.children[1].innerText;
				
				$("#EditTenSP").html(tenSP);
				$("#EditMaSP").val(maSP);
				
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

	window.onload = function() {
		var jtree;
		loadNhomHang();
		loadSanPham("0");
	};
	

	function get_xoaNhom(){
		var checkMaCha = $("#checkMaCha").val();
		if(checkMaCha == "" || checkMaCha == 0){
			toastr.error("Bạn chưa chọn nhóm");
			return;
		}
		
		$("#xoa").modal("show");
	}
	
	function get_chuyenNhom() {
		var checkMaCha = $("#checkMaCha").val();
		if(checkMaCha == "" || checkMaCha == 0){
			toastr.error("Bạn chưa chọn nhóm");
			return;
		}
		
		$("#MoveMaNhom").val(checkMaCha);
		
		$.ajax({
		    url: BASE_MAIN_URL + '/api/nhomHang',
		    type: 'POST',
		    data: {
		    	
		    },
		})
		.done(function(data) {
			$("#MoveMaCha").html(new Option("Nhóm riêng biệt", "0"));
			for (var i = 0; i < data.length; i++) {
				if(checkMaCha != data[i].maNhom){
					$("#MoveMaCha").append(new Option(data[i].tenNhom, data[i].maNhom));
				}
			}
		})
		
		$("#chuyen").modal("show");
	}
	

	function get_suaNhom() {
		var checkMaCha = $("#checkMaCha").val();
		if(checkMaCha == "" || checkMaCha == 0){
			toastr.error("Bạn chưa chọn nhóm");
			return;
		}
		
		
		
		$.ajax({
            url: BASE_MAIN_URL + '/api/nhomHang',
            type: 'POST',
            data: {
            	maNhom: checkMaCha
            },
        })
        .done(function(data) {
        	if(data == "Lỗi phát sinh"){
        		toastr.error(data);
        	}else{
        		$("#EditMaNhom").val(data[0].maNhom);
        		$("#EditMaCha").val(data[0].maCha);
        		$("#EditTenNhom").val(data[0].tenNhom);
        		$("#EditLoaiNhom").html('<option value="1">Nguyên liệu</option>\
                   		<option value="2">Hàng hóa</option>\
                   		<option value="3">Sản phẩm pha chế</option>\
                   		<option value="4">Dịch vụ theo giờ</option>');
        		var EditLoaiNhom;
        		if(data[0].loaiNhom == 1){
        			EditLoaiNhom = new Option('Nguyên liệu', data[0].loaiNhom, true, true);
        		}else if(data[0].loaiNhom == 2){
        			EditLoaiNhom = new Option('Hàng hóa', data[0].loaiNhom, true, true);
        		}else if(data[0].loaiNhom == 3){
        			EditLoaiNhom = new Option('Sản phẩm pha chế', data[0].loaiNhom, true, true);
        		}else if(data[0].loaiNhom == 4){
        			EditLoaiNhom = new Option('Dịch vụ theo giờ', data[0].loaiNhom, true, true);
        		}
        		$('#EditLoaiNhom').append(EditLoaiNhom);
        	}
        })
        $("#sua").modal("show");
	}

	function get_themNhom(){
		var checkMaCha = $("#checkMaCha").val();
		if(checkMaCha == ""){
			toastr.error("Bạn chưa chọn nhóm");
			return;
		}
		$("#AddMaCha").val(checkMaCha);
		$("#them").modal("show");
	}
	
	function xoa(){
		$.ajax({
            url: BASE_MAIN_URL + '/api/nhomHang/del',
            type: 'POST',
            data: {
            	maNhom: $("#checkMaCha").val(),
            },
        })
        .done(function(data) {
        	if(data == "Thành công"){
        		$("#checkMaCha").val(0)
        		toastr.success(data);
        		$("#xoa").modal("hide");
        		location.reload();
        	}else{
        		toastr.error(data);
        	}
        })
	}	
	
	function chuyen() {
		$.ajax({
		    url: BASE_MAIN_URL + '/api/nhomHang/moveNhom',
		    type: 'POST',
		    data: {
		    	maNhom: $("#MoveMaNhom").val(),
		    	maCha: $("#MoveMaCha").val()
		    },
		})
		.done(function(data) {
			if(data == "Thành công"){
				toastr.success(data);
				$("#chuyen").modal("hide");
				location.reload();
			}else{
				toastr.error(data);
			}
		})
	}
	
	function sua() {
		$.ajax({
            url: BASE_MAIN_URL + '/api/nhomHang/update',
            type: 'POST',
            data: {
            	maNhom: $("#EditMaNhom").val(),
            	maCha: $("#EditMaCha").val(),
            	tenNhom: $("#EditTenNhom").val(),
            	loaiNhom: $("#EditLoaiNhom").val()
            },
        })
        .done(function(data) {
        	if(data == "Thành công"){
        		toastr.success(data);
        		$("#sua").modal("hide");
            	location.reload();
        	}else{
        		toastr.error(data);
        	}
        })
	}
	
	function themNhom(){
		$.ajax({
            url: BASE_MAIN_URL + '/api/nhomHang/add',
            type: 'POST',
            data: {
            	maCha: $("#AddMaCha").val(),
            	tenNhom: $("#AddTenNhom").val(),
            	loaiNhom: $("#AddLoaiNhom").val()
            },
        })
        .done(function(data) {
        	if(data == "Thành công"){
        		toastr.success(data);
        		location.reload();
        	}else{
        		toastr.error(data);
        	}
        })
	}
	
	var c;
	function loadNhomHang(){
		$("#evts").removeClass();
		$.ajax({
		    url: BASE_MAIN_URL + '/api/nhomHang',
		    type: 'POST',
		    data: {
		    	
		    },
		})
		.done(function(data) {
			loadJTree(data);
		})
	}
	
	function loadJTree(data){
		jtree = [];
		c = data;
		call(jtree, null);
		sml();
	}
	
	
	function call(jtree, maCha) {
		for (var i = 0; i < c.length; i++) {
			if(maCha == null && c[i].maCha == "null"){
				var hehe = [];
				var add = {
					        "id": c[i].maNhom,
					        "text": c[i].tenNhom,
					        "children" : hehe
					    }
				jtree.push(add);
				call(hehe, c[i].maNhom);
			}

			if(maCha != null){
				if(c[i].maCha == maCha){
					var haha = [];
					var add = {
					        "id": c[i].maNhom,
					        "text": c[i].tenNhom,
					        "children" : haha
					    }
					jtree.push(add);
					call(haha, c[i].maNhom);
				}
			}
		}
	}
	
	function sml(){
		// interaction and events
		$('#evts_button').on("click", function () {
			var instance = $('#evts').jstree(true);
			instance.deselect_all();
			instance.select_node('1');
		});
		$('#evts')
			.on("changed.jstree", function (e, data) {
				if(data.selected.length) {
					$("#checkMaCha").val(data.selected[0]);
					loadSanPham(data.selected[0]);
				}
			})
			.jstree({
				'core' : {
					'multiple' : false,
					'data' : 
						[{
						    "id": "0",
						    "state" : { "opened" : true },
						    "text": "Nhóm",
						    "children" : jtree
						}]
				}
			});
	}
</script>
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
                        <button type="button" onclick="get_themBP()" class="btn btn-shadow btn-info">Thêm BP</button>
                        <button type="button" onclick="get_suaBP()" class="btn btn-shadow btn-success">Sửa BP</button>
                        <button type="button" onclick="get_xoaBP()" class="btn btn-shadow btn-danger">Xóa BP</button>
                        <button type="button" onclick="get_chuyenBP()" class="btn btn-shadow btn-warning">Chuyển BP</button>
                    </div>
                </section>
            </div>
            <div id="templateNhomHang" class="col-md-3">
                <div style="overflow: auto;" class="panel">
                    <div class="panel-heading">
                       	Bộ phận
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
                    	Danh sách khách hàng
                    	<button onclick="get_themNhanVien()" class="btn btn-success"><i class="fa fa-plus"></i> Thêm</button>
                        <span class="tools pull-right">
                            <a href="javascript:;" class="fa fa-chevron-down"></a>
                        </span>
                    </header>
                    <div class="panel-body">
                        <div id="table-khach-hang" style="overflow-x:auto;">
                             
                        </div>
                    </div>
                </section>
            </div>
        </div>
        <!-- page end-->
    </section>
</section>
<div class="modal fade" id="them" tabindex="-1" role="dialog" aria-labelledby="cc" aria-hidden="true">
    <div class="modal-dialog modal-md">
        <div class="modal-content-wrap">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Thêm nhóm</h4>
                </div>
                <form id="AddNhomKhachHang" class="modal-body row">
                	<input class="form-control" name="maNhom" type="hidden" value="0" />
                    <input class="form-control" name="maCha" type="hidden" value="" />
                    <div class="form-group  col-md-12">
                        <label>Tên nhóm</label>
                        <input class="form-control" name="tenNhom" value="" />
                    </div>
                    <div class="form-group  col-md-12">
                   		<label>Loại nhóm</label>
                       	<select class="form-control" name="loaiNhom">
                       		<option value="1">Khách hàng</option>
                       		<option value="2">Nhà cung cấp</option>
                       	</select>
                    </div>
                    <div class="form-group  col-md-12">
                        <button onclick="themBP()" type="button" class="btn btn-success" style="width: 100%;">Đồng ý</button>
                    </div>  
                </form>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="sua" tabindex="-1" role="dialog" aria-labelledby="cc" aria-hidden="true">
    <div class="modal-dialog modal-md">
        <div class="modal-content-wrap">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Sửa nhóm</h4>
                </div>
                <form id="EditNhomKhachHang" class="modal-body row">
                	<input class="form-control" name="maNhom" type="hidden" value="0" />
                    <input class="form-control" name="maCha" type="hidden" value="" />
                    <div class="form-group  col-md-12">
                        <label>Tên nhóm</label>
                        <input class="form-control" name="tenNhom" value="" />
                    </div>
                    <div class="form-group  col-md-12">
                   		<label>Loại nhóm</label>
                       	<select class="form-control" name="loaiNhom">
                       	</select>
                    </div>
                    <div class="form-group  col-md-12">
                        <button onclick="suaBP()" type="button" class="btn btn-success" style="width: 100%;">Đồng ý</button>
                    </div>  
                </form>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="xoa" tabindex="-1" role="dialog" aria-labelledby="cc" aria-hidden="true">
    <div class="modal-dialog modal-md">
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
    <div class="modal-dialog modal-md">
        <div class="modal-content-wrap">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Chuyển nhóm</h4>
                </div>
                <form id="MoveNhomKhachHang" class="modal-body row">
                	<input class="form-control" name="maNhom" type="hidden" value="0" />
                    <div class="form-group  col-md-12">
                   		<label>Mã cha mới ( có nghĩ là nó sẽ là con của mã đó )</label>
                       	<select class="form-control" name="maCha">
                       	</select>
                    </div>
                    <input class="form-control" type="hidden" name="tenNhom" value="" />
                    <input class="form-control" type="hidden" name="loaiNhom" value="" />
                    <div class="form-group  col-md-12">
                        <button onclick="chuyenBP()" type="button" class="btn btn-success" style="width: 100%;">Đồng ý</button>
                    </div>  
                </form>
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
    	<input type="hidden" id="EditMaKH" value="0" />
        <p class="green">Bạn đang chọn: <span id="EditTenKH"></span></p>
    </li>
    <li style=" padding: 8px;">
	    <button onclick="get_suaNhanVien()" class="btn btn-primary" style="width: 100%;"><i class="fa fa-pencil"></i> Sửa</button>
	</li>
    <li style=" padding: 8px;">
	    <button onclick="get_xoaNhanVien()" class="btn btn-danger" style="width: 100%;"><i class="fa fa-trash-o"></i> Xóa</button>
	</li>
</ul>
<div class="modal fade" id="themNhanVien" tabindex="-1" role="dialog" aria-labelledby="cc" aria-hidden="true">
    <div class="modal-dialog modal-md">
        <div class="modal-content-wrap">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Thêm nhân viên</h4>
                </div>
                <div class="modal-body">
                 	<form id="AddKhachHang" class="row">
					 	<input class="form-control" name="maKH" type="hidden" value="0" placeholder="Mời bạn nhập" />
					 	<input class="form-control" name="maNhom" type="hidden" value="0" placeholder="Mời bạn nhập" />
						<div class="form-group  col-md-6">
	                        <label>Họ tên *</label>
	                        <input class="form-control" name="tenKH" value="" placeholder="Mời bạn nhập" />
	                    </div>
	                    <div class="form-group  col-md-6">
	                        <label>Địa chỉ</label>
	                        <input class="form-control" name="diaChi" value="Không tiếc lộ" placeholder="Mời bạn nhập" />
	                    </div>
	                    <div class="form-group  col-md-6">
	                        <label>Số điện thoại</label>
	                        <input class="form-control" name="dienThoai" value="Không tiếc lộ" placeholder="Mời bạn nhập" />
	                    </div>
	                    <div class="form-group  col-md-6">
	                        <label>Mã số thuế *</label>
	                        <input class="form-control" name="maSoThue" value="" placeholder="Mời bạn nhập" />
	                    </div>
	                    <div class="form-group  col-md-6">
	                        <label>Thu đầu kỳ *</label>
	                        <input class="form-control" name="thuDK" value="0" placeholder="Mời bạn nhập" />
	                    </div>
	                    <div class="form-group  col-md-6">
	                        <label>Trả đầu kì *</label>
	                        <input class="form-control" name="traDK" value="0" placeholder="Mời bạn nhập" />
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
<div class="modal fade" id="suaNhanVien" tabindex="-1" role="dialog" aria-labelledby="cc" aria-hidden="true">
    <div class="modal-dialog modal-md">
        <div class="modal-content-wrap">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Thêm nhân viên</h4>
                </div>
                <div class="modal-body">
                 	<form id="EditKhachHang" class="row">
					 	<input class="form-control" name="maKH" type="hidden" value="0" placeholder="Mời bạn nhập" />
					 	<input class="form-control" name="maNhom" type="hidden" value="0" placeholder="Mời bạn nhập" />
						<div class="form-group  col-md-6">
	                        <label>Họ tên *</label>
	                        <input class="form-control" name="tenKH" value="" placeholder="Mời bạn nhập" />
	                    </div>
	                    <div class="form-group  col-md-6">
	                        <label>Địa chỉ</label>
	                        <input class="form-control" name="diaChi" value="Không tiếc lộ" placeholder="Mời bạn nhập" />
	                    </div>
	                    <div class="form-group  col-md-6">
	                        <label>Số điện thoại</label>
	                        <input class="form-control" name="dienThoai" value="Không tiếc lộ" placeholder="Mời bạn nhập" />
	                    </div>
	                    <div class="form-group  col-md-6">
	                        <label>Mã số thuế *</label>
	                        <input class="form-control" name="maSoThue" value="" placeholder="Mời bạn nhập" />
	                    </div>
	                    <div class="form-group  col-md-6">
	                        <label>Thu đầu kỳ *</label>
	                        <input class="form-control" name="thuDK" value="0" placeholder="Mời bạn nhập" />
	                    </div>
	                    <div class="form-group  col-md-6">
	                        <label>Trả đầu kì *</label>
	                        <input class="form-control" name="traDK" value="0" placeholder="Mời bạn nhập" />
	                    </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-warning" onclick="suaNhanVien()" type="button"> Đồng ý</button>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="xoaNhanVien" tabindex="-1" role="dialog" aria-labelledby="cc" aria-hidden="true">
    <div class="modal-dialog modal-md">
        <div class="modal-content-wrap">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Xóa khách hàng</h4>
                </div>
                <div class="modal-body">
					<h4>Bạn có chắc ?</h4>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-warning" onclick="xoaNhanVien()" type="button"> Đồng ý</button>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
	function xoaNhanVien(){
		$.ajax({
			url : BASE_MAIN_URL + '/api/khachHang/delete',
			type : 'POST',
			data : {
				maKH : $("#EditMaKH").val()
			},
		})
		.done(function(data) {
			if (data == "Thành công") {
				loadNhanVien($("#checkMaCha").val());
				$("#xoaNhanVien").modal("hide");
			} else {
				toastr.error(data);
			}
		})
	}

	function get_xoaNhanVien(){
		if($("#EditMaKH").val() == "0"){
			return;
		}
		
		$("#xoaNhanVien").modal("show");
	}

	function themNhanVien(){
		var data_post = $("#AddKhachHang").serialize();
		
		if(data_post.indexOf('=&') > -1){
			toastr.error("Vui lòng nhập đầy đủ");
			return;
		}
		
		$.ajax({
			url : BASE_MAIN_URL + '/api/khachHang/add',
			type : 'POST',
			data : data_post,
		}).done(function(data) {
			if (data == "Thành công") {
				loadNhanVien($("#checkMaCha").val());
				$("#themNhanVien").modal("hide");
			} else {
				toastr.error(data);
			}
		})
	}

	function get_themNhanVien(){
		var checkMaCha = $("#checkMaCha").val();
		if (checkMaCha == "" || checkMaCha == 0) {
			toastr.error("Bạn chưa chọn bộ phận");
			return;
		}
		
		$('#AddKhachHang input[name="maNhom"]').val(checkMaCha);
		$("#themNhanVien").modal("show");
	}


	function suaNhanVien(){
		var data_post = $("#EditKhachHang").serialize();
		
		if(data_post.indexOf('=&') > -1){
			toastr.error("Vui lòng nhập đầy đủ");
			return;
		}
		
		$.ajax({
			url : BASE_MAIN_URL  + '/api/khachHang/update',
			type : 'POST',
			data : data_post,
		}).done(function(data) {
			if (data == "Thành công") {
				loadNhanVien($("#checkMaCha").val());
				$("#suaNhanVien").modal("hide");
			} else {
				toastr.error(data);
			}
		})
	}

	function get_suaNhanVien(){
		if($("#EditMaKH").val() == "0"){
			return;
		}
		
		$.ajax({
			url : BASE_MAIN_URL  + '/api/khachHang/getByMaKhachHang',
			type : 'POST',
			data : {
				maKH: $("#EditMaKH").val()
			},
		})
		.done(function(data) {
			$('#EditKhachHang input[name="maKH"]').val(data.maKH);
			$('#EditKhachHang input[name="maNhom"]').val(data.maNhom);
			$('#EditKhachHang input[name="tenKH"]').val(data.tenKH);
			$('#EditKhachHang input[name="diaChi"]').val(data.diaChi);
			$('#EditKhachHang input[name="dienThoai"]').val(data.dienThoai);
			$('#EditKhachHang input[name="maSoThue"]').val(data.maSoThue);
			$('#EditKhachHang input[name="thuDK"]').val(data.thuDK);
			$('#EditKhachHang input[name="traDK"]').val(data.traDK);
			
			$("#suaNhanVien").modal("show");
		})
	}

	function loadNhanVien(maNhom){
		$("#table-khach-hang").html("");
		$("#table-khach-hang").html('<table class="table table-bordered table-striped" id="danh-sach-khach-hang">\
						                <thead>\
							                <tr>\
							                </tr>\
							            </thead>\
							            <tbody>\
							            </tbody>\
							        </table>');	
		$("#danh-sach-khach-hang thead tr").html("");
		var html = "<th>Mã</th>\
		            <th>Họ tên</th>\
		            <th>Địa chỉ</th>\
		            <th>Điện thoại</th>\
		            <th>Mã thuế</th>\
		            <th>Thu đầu kỳ</th>\
		            <th>Khu cuối kì</th>\
		            ";
        $("#danh-sach-khach-hang thead tr").append(html);
		
        $.ajax({
			url : BASE_MAIN_URL + '/api/khachHang/getByMaNhom',
			type : 'POST',
			data : {
				maNhom: maNhom
			},
		}).done(function(result) {
			for (var i = 0; i < result.length; i++) {
				var dataHTML = '<tr>\
					                <th>'+result[i].maKH+'</th>\
					                <th>'+result[i].tenKH+'</th>\
					                <th>'+result[i].diaChi+'</th>\
					                <th>'+result[i].dienThoai+'</th>\
					                <th>'+result[i].maSoThue+'</th>\
					                <th>'+result[i].thuDK+'</th>\
					                <th>'+result[i].traDK+'</th>\
					            </tr>';
				$("#danh-sach-khach-hang tbody").append(dataHTML);
			}
			
			$('#danh-sach-khach-hang').dataTable();
			
			$('#danh-sach-khach-hang tbody').on('contextmenu', 'tr', function(e) {
				e.preventDefault();
				var maKH = this.children[0].innerText;
				var tenKH = this.children[1].innerText;
				$("#EditMaKH").val(maKH);
				$("#EditTenKH").html(tenKH);
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

	function chuyenBP() {
		var data_post = $("#MoveNhomKhachHang").serialize();
		
		if(data_post.indexOf('=&') > -1){
			toastr.error("Vui lòng nhập đầy đủ");
			return;
		}
		
		$.ajax({
			url : BASE_MAIN_URL  + '/api/nhomKhachHang/update',
			type : 'POST',
			data : data_post,
		}).done(function(data) {
			if (data == "Thành công") {
				location.reload();
			} else {
				toastr.error(data);
			}
		})
	}

	function get_chuyenBP() {
		var checkMaCha = $("#checkMaCha").val();
		if (checkMaCha == "" || checkMaCha == 0) {
			toastr.error("Bạn chưa chọn bộ phận");
			return;
		}
		
		$('#MoveNhomKhachHang select[name="maCha"]').html(new Option("Nhóm riêng biệt", 0));
		$.ajax({
			url : BASE_MAIN_URL  + '/api/nhomKhachHang',
			type : 'POST',
			data : {

			},
		}).done(function(data) {
			for (var i = 0; i < data.length; i++) {
				if(checkMaCha != data[i].maNhom){
					$('#MoveNhomKhachHang select[name="maCha"]').append(new Option(data[i].tenNhom, data[i].maNhom));
				}
			}
		})
		
		$.ajax({
			url : '../api/nhomKhachHang/getByMaNhom',
			type : 'POST',
			data : {
				maNhom: checkMaCha
			},
		}).done(function(data) {
			$('#MoveNhomKhachHang input[name="maNhom"]').val(data.maNhom);
			$('#MoveNhomKhachHang input[name="tenNhom"]').val(data.tenNhom);
			$('#MoveNhomKhachHang input[name="loaiNhom"]').val(data.loaiNhom);
			
			
			$("#chuyen").modal("show");
		})
	}

	function xoa() {
		$.ajax({
			url : '../api/nhomKhachHang/delete',
			type : 'POST',
			data : {
				maNhom : $("#checkMaCha").val()
			},
		}).done(function(data) {
			if (data == "Thành công") {
				location.reload();
			} else {
				toastr.error(data);
			}
		})
	}

	function get_xoaBP() {
		var checkMaCha = $("#checkMaCha").val();
		if (checkMaCha == "" || checkMaCha == 0) {
			toastr.error("Bạn chưa chọn bộ phận");
			return;
		}
		
		$("#xoa").modal("show");
	}

	function suaBP() {
		var data_post = $("#EditNhomKhachHang").serialize();
		
		if(data_post.indexOf('=&') > -1){
			toastr.error("Vui lòng nhập đầy đủ");
			return;
		}
		
		$.ajax({
			url : BASE_MAIN_URL + '/api/nhomKhachHang/update',
			type : 'POST',
			data : data_post,
		}).done(function(data) {
			if (data == "Thành công") {
				location.reload();
			} else {
				toastr.error(data);
			}
		})
	}

	function get_suaBP() {
		var checkMaCha = $("#checkMaCha").val();
		if (checkMaCha == "" || checkMaCha == 0) {
			toastr.error("Bạn chưa chọn bộ phận");
			return;
		}
		
		$.ajax({
			url : '../api/nhomKhachHang/getByMaNhom',
			type : 'POST',
			data : {
				maNhom: checkMaCha
			},
		}).done(function(data) {
			$('#EditNhomKhachHang input[name="maNhom"]').val(data.maNhom);
			$('#EditNhomKhachHang input[name="maCha"]').val(data.maCha == null ? 0 : data.maCha);
			$('#EditNhomKhachHang input[name="tenNhom"]').val(data.tenNhom);
			if(data.loaiNhom == 1){
				tenLoaiNhom = "Khách hàng";
				$('#EditNhomKhachHang select[name="loaiNhom"]').html(new Option(tenLoaiNhom, data.loaiNhom, true, true));
				$('#EditNhomKhachHang select[name="loaiNhom"]').append(new Option("Nhà cung cấp", 2));
			}else{
				tenLoaiNhom = "Nhà cung cấp";
				$('#EditNhomKhachHang select[name="loaiNhom"]').html(new Option(tenLoaiNhom, data.loaiNhom, true, true));
				$('#EditNhomKhachHang select[name="loaiNhom"]').append(new Option("Khách hàng", 1));
			}
			
			$("#sua").modal("show");
		})
		
		
	}

	function themBP() {
		var data_post = $("#AddNhomKhachHang").serialize();
		
		if(data_post.indexOf('=&') > -1){
			toastr.error("Vui lòng nhập đầy đủ");
			return;
		}
		
		$.ajax({
			url : '../api/nhomKhachHang/add',
			type : 'POST',
			data : data_post,
		}).done(function(data) {
			if (data == "Thành công") {
				location.reload();
			} else {
				toastr.error(data);
			}
		})
	}

	function get_themBP() {
		var checkMaCha = $("#checkMaCha").val();
		if (checkMaCha == "") {
			toastr.error("Bạn chưa chọn bộ phận");
			return;
		}
		
		$('#AddNhomKhachHang input[name="maCha"]').val(checkMaCha);
		$("#them").modal("show");
	}

	window.onload = function() {
		var c;
		var jtree;
		loadBoPhan();
		loadNhanVien("0")
	};

	function loadBoPhan() {
		$("#evts").removeClass();
		$.ajax({
			url : BASE_MAIN_URL  + '/api/nhomKhachHang',
			type : 'POST',
			data : {

			},
		}).done(function(data) {
			loadJTree(data);
		})
	}

	function loadJTree(data) {
		jtree = [];
		c = data;
		call(jtree, null);
		sml();
	}

	function call(jtree, maCha) {
		for (var i = 0; i < c.length; i++) {
			if (maCha == null && c[i].maCha == null) {
				var hehe = [];
				var add = {
					"id" : c[i].maNhom,
					"text" : c[i].tenNhom,
					"children" : hehe
				}
				jtree.push(add);
				call(hehe, c[i].maNhom);
			}

			if (maCha != null) {
				if (c[i].maCha == maCha) {
					var haha = [];
					var add = {
						"id" : c[i].maNhom,
						"text" : c[i].tenNhom,
						"children" : haha
					}
					jtree.push(add);
					call(haha, c[i].maNhom);
				}
			}
		}
	}

	function sml() {
		// interaction and events
		$('#evts_button').on("click", function() {
			var instance = $('#evts').jstree(true);
			instance.deselect_all();
			instance.select_node('1');
		});
		$('#evts').on("changed.jstree", function(e, data) {
			if (data.selected.length) {
				$("#checkMaCha").val(data.selected[0]);
				loadNhanVien(data.selected[0]);
			}
		}).jstree({
			'core' : {
				'multiple' : false,
				'data' : [ {
					"id" : "0",
					"state" : {
						"opened" : true
					},
					"text" : "Nhóm",
					"children" : jtree
				} ]
			}
		});
	}
</script>
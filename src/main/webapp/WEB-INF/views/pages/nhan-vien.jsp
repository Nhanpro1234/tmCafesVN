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
                        <input type="hidden" id="checkMaCha" value="" />		
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
                    	Danh sách nhân viên
                    	<button onclick="get_themNhanVien()" class="btn btn-success"><i class="fa fa-plus"></i> Thêm</button>
                        <span class="tools pull-right">
                            <a href="javascript:;" class="fa fa-chevron-down"></a>
                        </span>
                    </header>
                    <div class="panel-body">
                        <div id="table-nhan-vien" style="overflow-x:auto;">
                             
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
                    <h4 class="modal-title">Thêm mới </h4>
                </div>
                <div class="modal-body row">
                	<div class="form-group  col-md-12">
                        <input class="form-control" id="AddMaCha" type="hidden" value="0" />
                    </div>
                    <div class="form-group  col-md-12">
                        <label>Tên mới *</label>
                        <input class="form-control" id="AddTenBP" value="" placeholder="Mời bạn nhập" />
                    </div>
                    <div class="form-group  col-md-12">
                        <button onclick="themBP()" class="btn btn-success" style="width: 100%;">Đồng ý</button>
                    </div>  
                </div>
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
                    <h4 class="modal-title">Sửa </h4>
                </div>
                <div class="row modal-body">
                    <input class="form-control" id="EditMaBP" type="hidden" value="0" />
                     <input class="form-control" id="EditMaCha" type="hidden" value="0" />
                    <div class="form-group  col-md-12">
                        <label>Tên</label>
                        <input class="form-control" id="EditTenBP" value="" placeholder="Mời bạn nhập" />
                    </div>
                    <div class="form-group  col-md-12">
                        <button onclick="suaBP()" class="btn btn-success" style="width: 100%;">Đồng ý</button>
                    </div>  
                </div>
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
                    <h4 class="modal-title">Xóa bộ phận</h4>
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
                    <h4 class="modal-title">Bộ phận nhóm</h4>
                </div>
                <div class="modal-body row">
					<input id="MoveMaBP" value="" type="hidden"/>
					<div class="form-group  col-md-6">
                        <label>Bộ phận mới</label>
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
<div class="modal fade" id="suaNhanVien" tabindex="-1" role="dialog" aria-labelledby="cc" aria-hidden="true">
    <div class="modal-dialog modal-md">
        <div class="modal-content-wrap">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Sửa nhân viên</h4>
                </div>
                <div class="modal-body">
	                <form class="row">
						<input id="EditMaNV" value="" type="hidden"/>
						<input id="EditMaBoPhanNV" value="" type="hidden"/>
						<div class="form-group  col-md-6 col-md-6">
	                        <label>Họ tên *</label>
	                        <input class="form-control" id="EditTenNV" value="" placeholder="Mời bạn nhập" />
	                    </div>
	                    <div class="form-group  col-md-6 col-md-6">
	                        <label>Địa chỉ</label>
	                        <input class="form-control" id="EditDiaChiNV" value="" placeholder="Mời bạn nhập" />
	                    </div>
	                    <div class="form-group  col-md-6">
	                        <label>Điện thoại</label>
	                        <input class="form-control" id="EditDienThoaiNV" value="" placeholder="Mời bạn nhập" />
	                    </div>
	                    <div class="form-group  col-md-6">
	                        <label>Mã thuế</label>
	                        <input class="form-control" id="EditMaThueNV" value="" placeholder="Mời bạn nhập" />
	                    </div>
	                    <div class="form-group  col-md-6">
	                        <label>Kế toán</label>
	                        <input class="form-control" id="EditKeToanNV" value="" type="checkbox"/>
	                    </div>
	                    <div class="form-group  col-md-6">
	                        <label>Thu ngân</label>
	                        <input class="form-control" id="EditThuNganNV" value="" type="checkbox"/>
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
<div class="modal fade" id="themNhanVien" tabindex="-1" role="dialog" aria-labelledby="cc" aria-hidden="true">
    <div class="modal-dialog modal-md">
        <div class="modal-content-wrap">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Thêm nhân viên</h4>
                </div>
                <div class="modal-body">
                 	<form class="row">
						<input id="AddMaBoPhanNV" value="" type="hidden"/>
						<div class="form-group  col-md-6">
	                        <label>Họ tên *</label>
	                        <input class="form-control" id="AddTenNV" value="" placeholder="Mời bạn nhập" />
	                    </div>
	                    <div class="form-group  col-md-6">
	                        <label>Địa chỉ</label>
	                        <input class="form-control" id="AddDiaChiNV" value="" placeholder="Mời bạn nhập" />
	                    </div>
	                    <div class="form-group  col-md-6">
	                        <label>Điện thoại</label>
	                        <input class="form-control" id="AddDienThoaiNV" value="" placeholder="Mời bạn nhập" />
	                    </div>
	                    <div class="form-group  col-md-6">
	                        <label>Mã thuế</label>
	                        <input class="form-control" id="AddMaThueNV" value="" placeholder="Mời bạn nhập" />
	                    </div>
	                    <div class="form-group  col-md-6">
	                        <label>Kế toán</label>
	                        <input class="form-control" id="AddKeToanNV" value="" type="checkbox"/>
	                    </div>
	                    <div class="form-group  col-md-6">
	                        <label>Thu ngân</label>
	                        <input class="form-control" id="AddThuNganNV" value="" type="checkbox"/>
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
<style>
	#sidebar{
		 margin-left: 0px;
 	}
</style>
<ul class="dropdown-menu extended tasks-bar" id="tac-dong" style="position: absolute; display: none;">
  	 	<div class="notify-arrow notify-arrow-green"></div>
    <li>
    	<input type="hidden" id="EditMaNV" value="0" />
        <p class="green">Bạn đang chọn: <span id="EditTenNV"></span></p>
    </li>
    <li style=" padding: 8px;">
	    <button onclick="get_suaNhanVien()" class="btn btn-primary" style="width: 100%;"><i class="fa fa-pencil"></i> Sửa</button>
	</li>
    <li style=" padding: 8px;">
	    <button onclick="xoaNhanVien()" class="btn btn-danger" style="width: 100%;"><i class="fa fa-trash-o"></i> Xóa</button>
	</li>
</ul>
<script>
	function get_themNhanVien(){
		if($("#checkMaCha").val() == 0){
			toastr.error("Bạn chưa chọn bộ phận");
			return;
		}
		
		$("#AddMaBoPhanNV").val($("#checkMaCha").val());
		
		$("#themNhanVien").modal("show");
	}
	
	function themNhanVien(){
		var AddKeToanNV = 0;
		var AddThuNganNV = 0;
		if($('#AddKeToanNV').prop('checked')) {
			AddKeToanNV = 1;
		}
		
		if($('#AddThuNganNV').prop('checked')) {
			AddThuNganNV = 1;
		}
		
		$.ajax({
			url : '../api/nhanVien/add',
			type : 'POST',
			data : {
				maBP: $("#AddMaBoPhanNV").val(),
				hoTen: $("#AddTenNV").val(),
				diaChi: $("#AddDiaChiNV").val(),
				dienThoai: $("#AddDienThoaiNV").val(),
				maSoThue: $("#AddMaThueNV").val(),
				isKeToan: AddKeToanNV,
				isThuNgan: AddThuNganNV
			},
		})
		.done(function(data) {
			if (data == "Thành công") {
				toastr.success(data);
				loadNhanVien($("#checkMaCha").val());
			} else {
				toastr.error(data);
			}
		})
	}


	function suaNhanVien(){
		if ($("#checkMaCha").val() == "") {
			toastr.error("Bạn chưa chọn bộ phận");
			return;
		}
		
		var EditKeToanNV = 0;
		var EditThuNganNV = 0;
		if($('#EditKeToanNV').prop('checked')) {
			EditKeToanNV = 1;
		}
		
		if($('#EditThuNganNV').prop('checked')) {
			EditThuNganNV = 1;
		}
		
		
		$.ajax({
			url : '../api/nhanVien/update',
			type : 'POST',
			data : {
				maNV: $("#EditMaNV").val(),
				maBP: $("#EditMaBoPhanNV").val(),
				hoTen: $("#EditTenNV").val(),
				diaChi: $("#EditDiaChiNV").val(),
				dienThoai: $("#EditDienThoaiNV").val(),
				maSoThue: $("#EditMaThueNV").val(),
				isKeToan: EditKeToanNV,
				isThuNgan: EditThuNganNV
			},
		})
		.done(function(data) {
			if (data == "Thành công") {
				toastr.success(data);
				loadNhanVien($("#checkMaCha").val());
			} else {
				toastr.error(data);
			}
		})
	}

	function get_suaNhanVien(){
		if($("#EditMaNV").val() == "0"){
			return;
		}
		
		$.ajax({
			url : '../api/nhanVien/' + $("#EditMaNV").val(),
			type : 'POST',
			data : {
				
			},
		})
		.done(function(data) {
			$("#EditMaNV").val(data.maNV);
			$("#EditTenNV").val(data.hoTen);
			$("#EditDiaChiNV").val(data.diaChi);
			$("#EditDienThoaiNV").val(data.dienThoai);
			$("#EditMaThueNV").val(data.maSoThue);
			$("#EditMaBoPhanNV").val(data.maBP)
			if(data.isKeToan == 1){
				$("#EditKeToanNV").prop('checked', true)
			}else{
				$("#EditKeToanNV").prop('checked', false)
			}
			if(data.isThuNgan == 1){
				$("#EditThuNganNV").prop('checked', true)
			}else{
				$("#EditThuNganNV").prop('checked', false)
			}
		})
		
		$("#suaNhanVien").modal("show");
	}

	function xoaNhanVien(){
		$.ajax({
			url : '../api/nhanVien/delete',
			type : 'POST',
			data : {
				maNV : $("#EditMaNV").val()
			},
		})
		.done(function(data) {
			if (data == "Thành công") {
				toastr.success(data);
				loadNhanVien($("#checkMaCha").val());
			} else {
				toastr.error(data);
			}
		})
	}

	function loadNhanVien(maBP){
		$("#table-nhan-vien").html("");
		$("#table-nhan-vien").html('<table class="table table-bordered table-striped" id="danh-sach-nhan-vien">\
						                <thead>\
							                <tr>\
							                </tr>\
							            </thead>\
							            <tbody>\
							            </tbody>\
							        </table>');	
		$("#danh-sach-nhan-vien thead tr").html("");
		var html = "<th>Mã</th>\
		            <th>Họ tên</th>\
		            <th>Địa chỉ</th>\
		            <th>Điện thoại</th>\
		            <th>Mã thuế</th>\
		            <th>Kế toán</th>\
		            <th>Thu ngân</th>\
		            ";
        $("#danh-sach-nhan-vien thead tr").append(html);
        
		$.ajax({
			url : '../api/nhanVien/getByMaBP',
			type : 'POST',
			data : {
				maBP: maBP
			},
		}).done(function(result) {
			
			for (var i = 0; i < result.length; i++) {
				var keToan = "Có"
				var thuNgan = "Có";
				if(result[i].isKeToan == 0){
					keToan = "Không";
				}
				if(result[i].isThuNgan == 0){
					thuNgan = "Không";
				}
				var dataHTML = '<tr>\
					                <th>'+result[i].maNV+'</th>\
					                <th>'+result[i].hoTen+'</th>\
					                <th>'+result[i].diaChi+'</th>\
					                <th>'+result[i].dienThoai+'</th>\
					                <th>'+result[i].maSoThue+'</th>\
					                <th>'+keToan+'</th>\
					                <th>'+thuNgan+'</th>\
					            </tr>';
				$("#danh-sach-nhan-vien tbody").append(dataHTML);
			}
			
			$('#danh-sach-nhan-vien').dataTable();
			
			$('#danh-sach-nhan-vien tbody').on('contextmenu', 'tr', function(e) {
				e.preventDefault();
				var maNV = this.children[0].innerText;
				var tenNV = this.children[1].innerText;
				$("#EditMaNV").val(maNV);
				$("#EditTenNV").html(tenNV);
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

	function chuyen() {
		$.ajax({
			url : '../api/boPhan/moveBoPhan',
			type : 'POST',
			data : {
				maBP : $("#MoveMaBP").val(),
				maCha : $("#MoveMaCha").val()
			},
		}).done(function(data) {
			if (data == "Thành công") {
				location.reload();
			} else {
				toastr.error(data);
			}
		})
	}

	function get_chuyenBP() {
		if ($("#checkMaCha").val() == "") {
			toastr.error("Bạn chưa chọn bộ phận");
			return;
		}

		$("#MoveMaBP").val($("#checkMaCha").val());

		$.ajax({
			url : '../api/boPhan',
			type : 'POST',
			data : {

			},
		}).done(
				function(data) {
					for (var i = 0; i < data.length; i++) {
						$("#MoveMaCha")
								.html(new Option("Nhóm riêng biệt", "0"));
						for (var i = 0; i < data.length; i++) {
							if ($("#checkMaCha").val() != data[i].maBP) {
								$("#MoveMaCha")
										.append(
												new Option(data[i].tenBP,
														data[i].maBP));
							}
						}
					}
				})

		$("#chuyen").modal("show");
	}

	function xoa() {
		$.ajax({
			url : '../api/boPhan/delete',
			type : 'POST',
			data : {
				maBP : $("#checkMaCha").val()
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
		if ($("#checkMaCha").val() == "") {
			toastr.error("Bạn chưa chọn bộ phận");
			return;
		}

		$("#xoa").modal("show");
	}

	function suaBP() {
		if ($("#EditTenBP").val() == "") {
			toastr.error("Bạn chưa nhập !");
			return;
		}

		$.ajax({
			url : '../api/boPhan/update',
			type : 'POST',
			data : {
				maBP : $("#EditMaBP").val(),
				maCha : $("#EditMaCha").val(),
				tenBP : $("#EditTenBP").val()
			},
		}).done(function(data) {
			if (data == "Thành công") {
				location.reload();
			} else {
				toastr.error(data);
			}
		})

		$("#sua").modal("show");
	}

	function get_suaBP() {
		if ($("#checkMaCha").val() == "") {
			toastr.error("Bạn chưa chọn bộ phận");
			return;
		}

		$.ajax({
			url : '../api/boPhan/getByMaBP',
			type : 'POST',
			data : {
				maBP: $("#checkMaCha").val()
			},
		}).done(function(data) {
			$("#EditMaBP").val(data.maBP);
			$("#EditMaCha").val(data.maCha);
			$("#EditTenBP").val(data.tenBP);
		})

		$("#sua").modal("show");
	}

	function themBP() {
		if ($("#AddTenBP").val() == "") {
			toastr.error("Bạn nhập thiếu");
			return;
		}

		$.ajax({
			url : '../api/boPhan/add',
			type : 'POST',
			data : {
				maCha : $("#AddMaCha").val(),
				tenBP : $("#AddTenBP").val(),
			},
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
		$("#AddMaCha").val(checkMaCha);
		$("#them").modal("show");
	}

	window.onload = function() {
		var c;
		var jtree;
		loadBoPhan();
		loadNhanVien("0");
	};

	function loadBoPhan() {
		$("#evts").removeClass();
		$.ajax({
			url : '../api/boPhan',
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
			if (maCha == null && c[i].maCha == "null") {
				var hehe = [];
				var add = {
					"id" : c[i].maBP,
					"text" : c[i].tenBP,
					"children" : hehe
				}
				jtree.push(add);
				call(hehe, c[i].maBP);
			}

			if (maCha != null) {
				if (c[i].maCha == maCha) {
					var haha = [];
					var add = {
						"id" : c[i].maBP,
						"text" : c[i].tenBP,
						"children" : haha
					}
					jtree.push(add);
					call(haha, c[i].maBP);
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
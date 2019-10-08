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
                        <button type="button" onclick="get_themNhanVien()" class="btn btn-shadow btn-info">Thêm tài khoản</button>
                    </div>
                </section>
            </div>
            <div class="col-md-12">
                <section class="panel">
                    <header class="panel-heading">
                    	Danh sách tài khoản
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
<div class="modal fade" id="suaNhanVien" tabindex="-1" role="dialog" aria-labelledby="cc" aria-hidden="true">
    <div class="modal-dialog modal-md">
        <div class="modal-content-wrap">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Sửa tài khoản</h4>
                </div>
                <div class="modal-body">
	                <form class="row">
						<div class="form-group  col-md-12 ">
	                        <label>Tài khoản *</label>
	                        <input class="form-control" id="EditTaiKhoanNV" value="" placeholder="Mời bạn nhập" disabled="disabled" />
	                    </div>
	                    <div class="form-group  col-md-12">
	                        <label>Mật khẩu *</label>
	                        <input class="form-control" id="EditMatKhauNV" value="" placeholder="Mời bạn nhập" />
	                    </div>
	                    <div class="form-group  col-md-12">
	                        <label>Mã nhân viên *</label>
	                        <input class="form-control" id="EditMaNV" value="" placeholder="Mời bạn nhập" disabled="disabled" />
	                    </div>
	                    <div class="form-group  col-md-12">
	                        <label>Quyền *</label>
	                    	<select class="form-control" id="EditRoleNV"> 
						  		<!-- <option value="ROLE_ADMIN">Admin</option> -->
						 	 	<option value="ROLE_KE_TOAN">Thu ngân</option>
						  		<option value="ROLE_THU_NGAN">Kế toán</option>
							</select> 
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
                    <h4 class="modal-title">Thêm tài khoản</h4>
                </div>
                <div class="modal-body">
                 	<form class="row">
						<div class="form-group  col-md-12 ">
	                        <label>Tài khoản *</label>
	                        <input class="form-control" id="AddTaiKhoanNV" value="" placeholder="Mời bạn nhập"/>
	                    </div>
	                    <div class="form-group  col-md-12">
	                        <label>Mật khẩu *</label>
	                        <input class="form-control" id="AddMatKhauNV" value="" placeholder="Mời bạn nhập" />
	                    </div>
	                    <div class="form-group  col-md-12">
	                        <label>Mã nhân viên *</label>
	                        <select class="form-control" id="AddMaNV"> 
							</select> 
	                    </div>
	                    <div class="form-group  col-md-12">
	                        <label>Quyền *</label>
                       		<select class="form-control" id="AddRoleNV"> 
						  		<!-- <option value="ROLE_ADMIN">Admin</option> -->
						  		<option value="ROLE_KE_TOAN">Thu ngân</option>
						  		<option value="ROLE_THU_NGAN">Kế toán</option>
							</select> 
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
        <p class="green">Bạn đang chọn: <span id="EditTaiKhoan"></span></p>
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
		$("#AddMaNV").html("");
		$.ajax({
			url : '../api/nhanVien',
			type : 'POST',
			data : {
				
			},
		}).done(function(result) {
			for (var i = 0; i < result.length; i++) {
				$("#AddMaNV").append(new Option(result[i].hoTen, result[i].maNV))
			}
		})
		$("#themNhanVien").modal("show");
	}
	
	function themNhanVien(){
		$.ajax({
			url : '../api/taiKhoan/add',
			type : 'POST',
			data : {
				taiKhoan: $("#AddTaiKhoanNV").val(),
				matKhau: $("#AddMatKhauNV").val(),
				maNV: $("#AddMaNV").val(),
				role: $("#AddRoleNV").val()
			},
		}).done(function(result) {
			if (result == "Thành công") {
				toastr.success(result);
				loadNhanVien();
				$("#themNhanVien").modal("hide");
			} else {
				toastr.error(result);
			}
		})
	}


	function suaNhanVien(){
		$.ajax({
			url : '../api/taiKhoan/update',
			type : 'POST',
			data : {
				taiKhoan: $("#EditTaiKhoanNV").val(),
				matKhau: $("#EditMatKhauNV").val(),
				maNV: $("#EditMaNV").val(),
				role: $("#EditRoleNV").val()
			},
		}).done(function(result) {
			if (result == "Thành công") {
				toastr.success(result);
				loadNhanVien();
				$("#suaNhanVien").modal("hide");
			} else {
				toastr.error(result);
			}
		})
	}

	function get_suaNhanVien(){
		$("#EditRoleNV").html("");
		
		$.ajax({
			url : BASE_MAIN_URL + '/api/taiKhoan/getByTaiKhoan',
			type : 'POST',
			data : {
				taiKhoan: $("#EditTaiKhoan").html()
			},
		})
		.done(function(data) {
			$("#EditTaiKhoanNV").val(data.taiKhoan);
			$("#EditMatKhauNV").val(data.matKhau);
			$("#EditMaNV").val(data.maNV);
			var name_role = "";
			if(data.role == "ROLE_THU_NGAN"){
				name_role = "Thu ngân";
				$("#EditRoleNV").append(new Option("Kế toán", "ROLE_KE_TOAN"));
			}else if(data.role == "ROLE_KE_TOAN"){
				name_role = "Kế toán";
				$("#EditRoleNV").append(new Option("Thu ngân", "ROLE_THU_NGAN"));
			}else if(data.role == "ROLE_ADMIN"){
				name_role = "Quản trị viên";
				$("#EditRoleNV").prop('disabled', false);
			}else{
				name_role = "Chưa xác định";
			}
			$("#EditRoleNV").append(new Option(name_role, data.role, true, true));
		})
		
		$("#suaNhanVien").modal("show");
	}

	function xoaNhanVien(){
		$.ajax({
			url : BASE_MAIN_URL + '/api/taiKhoan/delete',
			type : 'POST',
			data : {
				taiKhoan : $("#EditTaiKhoan").html()
			},
		})
		.done(function(data) {
			if (data == "Thành công") {
				toastr.success(data);
				loadNhanVien();
			} else {
				toastr.error(data);
			}
		})
	}

	function loadNhanVien(){
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
		var html = "<th>Tài khoản</th>\
		            <th>Mật khẩu</th>\
		            <th>Mã nhân viên</th>\
		            <th>Tên nhân viên</th>\
		            <th>Quyền</th>\
		            ";
        $("#danh-sach-nhan-vien thead tr").append(html);
        
		$.ajax({
			url : '../api/taiKhoan/getAll',
			type : 'POST',
			data : {

			},
		}).done(function(result) {
			for (var i = 0; i < result.length; i++) {
				var name_role = "";
				if(result.role == "ROLE_THU_NGAN"){
					name_role = "Thu ngân";
				}else if(result.role == "ROLE_KE_TOAN"){
					name_role = "Kế toán";
				}else if(result.role == "ROLE_ADMIN"){
					name_role = "Quản trị viên";
				}else{
					name_role = "Chưa xác định";
				}
				var dataHTML = '<tr>\
					                <th>'+result[i].taiKhoan+'</th>\
					                <th>'+result[i].matKhau+'</th>\
					                <th>'+result[i].maNV+'</th>\
					                <th>'+result[i].hoTen+'</th>\
					                <th>'+result[i].role+'</th>\
					            </tr>';
				$("#danh-sach-nhan-vien tbody").append(dataHTML);
			}
			
			$('#danh-sach-nhan-vien').dataTable();
			
			$('#danh-sach-nhan-vien tbody').on('contextmenu', 'tr', function(e) {
				e.preventDefault();
				var taiKhoan = this.children[0].innerText;
				$("#EditTaiKhoan").html(taiKhoan);
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
		var c;
		var jtree;
		loadNhanVien();
	};
</script>
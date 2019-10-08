<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!--main content start-->
<section id="main-content">
	<section class="wrapper">
		<!-- page start-->
		<div class="row">
			<div class="col-md-12">
				<section class="panel">
					<header class="panel-heading"> Hành động </header>
					<div class="panel-body">
						<button onclick="get_themBan()" class="btn btn-success"> <i class="fa fa-plus"></i> Thêm mới </button>
					</div>
				</section>
			</div>
			<div class="col-md-12">
				<section class="panel">
					<header class="panel-heading">
						Sản phòng bàn
					</header>
					<div class="panel-body">
						<div id="san-ban-phong" class="adv-table">
							
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
                    <h4 class="modal-title">Thêm bàn mới</h4>
                </div>
                <div class="modal-body">
                	<form id="form-them-ban" class="row">
	                    <div class="form-group col-md-12">
	                        <label>Khu vực của bàn *</label>
	                        <select class="form-control" style="text-transform: uppercase;" name="maKV" id="maKV"  required="required">
	                       	</select>
	                    </div>
	                    <div class="form-group col-md-12">
	                        <label>Bảng giá của bàn *</label>
	                        <select class="form-control" style="text-transform: uppercase;" name="maBG" id="maBG" required="required">
	                       	</select>
	                    </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-warning" onclick="themBan()" type="button"> Đồng ý</button>
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
                    <h4 class="modal-title">Sửa bàn</h4>
                </div>
                <div class="modal-body">
                	<form id="form-sua-ban" class="row">
                		<input type="hidden" value="" name="soBan" id="EditSoBan">
	                    <div class="form-group col-md-12">
	                        <label>Khu vực của bàn *</label>
	                        <select class="form-control" style="text-transform: uppercase;" name="maKV" id="EditMaKV"  required="required">
	                       	</select>
	                    </div>
	                    <div class="form-group col-md-12">
	                        <label>Bảng giá của bàn *</label>
	                        <select class="form-control" style="text-transform: uppercase;" name="maBG" id="EditMaBG" required="required">
	                       	</select>
	                    </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-warning" onclick="suaBan()" type="button"> Đồng ý</button>
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
                    <h4 class="modal-title">Xóa bàn</h4>
                </div>
                <div class="modal-body">
					<h4>Bạn có chắc ?</h4>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-warning" onclick="xoaBan()" type="button"> Đồng ý</button>
                </div>
            </div>
        </div>
    </div>
</div>
<ul class="dropdown-menu extended tasks-bar" id="tac-dong" style="position: absolute; display: none;">
  	 	<div class="notify-arrow notify-arrow-green"></div>
    <li>
    	<input type="hidden" id="SoBan" value="" />
    	<p class="green">Bạn đang chọn: <span id="TenSoBan"></span></p>
    </li>
    <li style=" padding: 8px;">
	    <button onclick="get_suaBan()" class="btn btn-primary" style="width: 100%;"><i class="fa fa-pencil"></i> Sửa</button>
	</li>
    <li style=" padding: 8px;">
	    <button onclick="get_xoaBan()" class="btn btn-danger" style="width: 100%;"><i class="fa fa-trash-o"></i> Xóa</button>
	</li>
</ul>
<!--main content end-->
<style>
#sidebar {
	margin-left: 0px;
}
</style>
<script>
	function xoaBan(){
		$.ajax({
		  	url: '../api/sanBanPhong/delete',
	        type: 'POST',
	        data: {
	        	soBan: $("#SoBan").val()
	        },
	    })
	    .done(function(data) {
	    	if(data == "Thành công"){
        		toastr.success(data);
        		$("#them").modal("hide");
        		$("#SoBan").val("")
        		$("#xoa").modal("hide");	
        		loadSanBanPhong()
        	}else{
        		toastr.error(data);
        	}
	    })
	}
	
	function get_xoaBan(){
		$("#xoa").modal("show");	
	}

	function suaBan(){
		$.ajax({
		  	url: '../api/sanBanPhong/update',
	        type: 'POST',
	        data: $("#form-sua-ban").serialize(),
	    })
	    .done(function(data) {
	    	if(data == "Thành công"){
        		toastr.success(data);
        		$("#them").modal("hide");
        		loadSanBanPhong()
        	}else{
        		toastr.error(data);
        	}
	    })
	}

	function get_suaBan(){
		if($("#SoBan").val() == 0 || $("#SoBan").val() == ""){
			toastr.error("Lỗi");
			return;
		}
		
		$("#EditSoBan").val("");
		$("#EditMaKV").html("");
		$("#EditMaBG").html("");
		
		$.ajax({
	        url: '../api/sanBanPhong/getBySoBan',
	        type: 'POST',
	        data: {
	        	soBan: $("#SoBan").val()
	        },
	    })
	    .done(function(data) {
	    	$("#EditSoBan").val(data.soBan);
	    	$("#EditMaKV").append(new Option(data.tenKV, data.maKV, true, true));
	    	$("#EditMaBG").append(new Option(data.tenBG, data.maBG, true, true));
	    })
		//
		$.ajax({
	        url: '../api/khuVuc',
	        type: 'POST',
	        data: {
	        	
	        },
	    })
	    .done(function(data) {
	    	var obj = JSON.parse(data);
	        for (var i = 0; i < obj.length; i++) {
	        	$("#EditMaKV").append(new Option(obj[i].tenKV, obj[i].maKV));
			}
	    })
	    //
	    $.ajax({
	        url: '../api/loaiBangGia',
	        type: 'POST',
	        data: {
	        	
	        },
	    })
	    .done(function(data) {
	        for (var i = 0; i < data.length; i++) {
	        	$("#EditMaBG").append(new Option(data[i].tenBG, data[i].maBG));
			}
	    })
	
		$("#sua").modal("show");
	}


	function themBan(){
		$.ajax({
		  	url: '../api/sanBanPhong/add',
	        type: 'POST',
	        data: $("#form-them-ban").serialize(),
	    })
	    .done(function(data) {
	    	if(data == "Thành công"){
        		toastr.success(data);
        		$("#them").modal("hide");
        		loadSanBanPhong()
        	}else{
        		toastr.error(data);
        	}
	    })
	}
	
	function get_themBan(){
		$("#maKV").html("");
		$("#maBG").html("");
		
		$.ajax({
	        url: '../api/khuVuc',
	        type: 'POST',
	        data: {
	        	
	        },
	    })
	    .done(function(data) {
	    	var obj = JSON.parse(data);
	        for (var i = 0; i < obj.length; i++) {
	        	$("#maKV").append(new Option(obj[i].tenKV, obj[i].maKV));
			}
	    })
	    
	    $.ajax({
	        url: '../api/loaiBangGia',
	        type: 'POST',
	        data: {
	        	
	        },
	    })
	    .done(function(data) {
	        for (var i = 0; i < data.length; i++) {
	        	$("#maBG").append(new Option(data[i].tenBG, data[i].maBG));
			}
	    })

		$("#them").modal("show");
	}

	window.onload = function() {
		loadSanBanPhong();
	};
	
	function loadSanBanPhong(){
		var html = '<table class="display table table-bordered table-striped" id="san-phong-ban-table">\
						<thead>\
							<tr>\
								<th>Mã bàn</th>\
								<th>Tên khu vực</th>\
								<th>Tên bảng giá</th>\
							</tr>\
						</thead>\
						<tbody>\
						</tbody>\
					</table>';
		$("#san-ban-phong").html(html);
		$.ajax({
	        url: '../api/sanBanPhong',
	        type: 'POST',
	        data: {
	        	
	        },
	    })
	    .done(function(data) {
	    	for (var i = 0; i < data.length; i++) {
	    		var dataHTML = '<tr>\
					                <th>'+data[i].soBan+'</th>\
					                <th>'+data[i].tenKV+'</th>\
					                <th>'+data[i].tenBG+'</th>\
					            </tr>';
		    	$("#san-phong-ban-table tbody").append(dataHTML);
			}
	    	
			$('#san-phong-ban-table').dataTable();
        	
        	$('#san-phong-ban-table tbody').on('contextmenu', 'tr', function(e) {
				e.preventDefault();
				var soBan = this.children[0].innerText;
				$("#SoBan").val(soBan);
				$("#TenSoBan").text(soBan);
				
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
</script>















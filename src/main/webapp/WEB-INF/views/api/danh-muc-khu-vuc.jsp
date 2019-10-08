<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<section class="panel" style="max-height: 600px; overflow: auto;">
    <header class="panel-heading">
        Khu vực <button data-toggle="modal" href="#themMoi" class="btn btn-success"><i class="fa fa-plus"></i> Thêm mới</button>
    </header>
    <div class="panel-body">
        <div class="adv-table">
            <table class="display table table-bordered table-striped" id="danh-muc-table">
                <thead>
                    <tr>
                        <th>Mã</th>
                        <th>Tên</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody id="data">
                    
                </tbody>
            </table>
        </div>
    </div>
</section>
<div class="modal fade" id="themMoi" tabindex="-1" role="dialog" aria-labelledby="thucDon" aria-hidden="true">
    <div class="modal-dialog modal-sm">
        <div class="modal-content-wrap">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Thêm mới khu vực</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Tên mới</label>
                        <input class="form-control" id="tenMoi" value="" placeholder="Mời bạn nhập" />
                    </div>
                    <div class="form-group">
                        <button onclick="add()" class="btn btn-success" style="width: 100%;">Đồng ý</button>
                    </div>  
                </div>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="sua" tabindex="-1" role="dialog" aria-labelledby="thucDon" aria-hidden="true">
    <div class="modal-dialog modal-sm">
        <div class="modal-content-wrap">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Sửa khu vực</h4>
                </div>
                <div class="modal-body">
                	<div class="form-group">
                        <label>Mã khu vực</label>
                        <input class="form-control" id="EditMaKV" value="" disabled="disabled" />
                    </div>
                    <div class="form-group">
                        <label>Tên sửa mới</label>
                        <input class="form-control" id="EditTenKV" value="" placeholder="Mời bạn nhập" />
                    </div>
                    <div class="form-group">
                        <button onclick="update()" class="btn btn-success" style="width: 100%;">Đồng ý</button>
                    </div>  
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
	$(document).ready(function() {
		load();
	});
	
	function get_update(e){
		var c = e.getAttribute("data");
		$("#EditMaKV").val(c);
		$("#sua").modal("show");
	}
	
	function update(){
		$.ajax({
            url: '../api/khuVuc/update',
            type: 'POST',
            data: {
            	maKV: $("#EditMaKV").val(),
            	tenKV: $("#EditTenKV").val()
            },
        })
        .done(function(data) {
        	if(data == "Thành công"){
        		toastr.success(data);
        		$("#sua").modal('hide');
        		$("#data").empty();
            	load();
        	}else{
        		toastr.error(data);
        	}
        })
	}
	
	function del(e){
		var c = e.getAttribute("data");
		$.ajax({
            url: '../api/khuVuc/del',
            type: 'POST',
            data: {
            	maKV: c
            },
        })
        .done(function(data) {
        	if(data == "Thành công"){
        		toastr.success(data);
        		$("#data").empty();
            	load();
        	}else{
        		toastr.error(data);
        	}
        })
	}

	function add(){
		$("#data").empty();
		$.ajax({
            url: '../api/khuVuc/add',
            type: 'POST',
            data: {
            	tenKV: $("#tenMoi").val()
            },
        })
        .done(function(data) {
        	if(data == "Thành công"){
        		toastr.success(data);
        		$("#themMoi").modal('hide');
        		$("#data").empty();
            	load();
        	}else{
        		toastr.error(data);
        	}
        })
	}
	
	function load(){
		$.ajax({
            url: '../api/khuVuc',
            type: 'POST',
            data: {
            	
            },
        })
        .done(function(data) {
        	var obj = JSON.parse(data);
        	for (var i = 0; i < obj.length; i++) {
        		var html = '<tr>\
				                <td><b>'+obj[i].maKV+'</b></td>\
				                <td><b>'+obj[i].tenKV+'</b></td>\
				                <td><b>\
				                    <a role="button" onclick="get_update(this)" data="'+obj[i].maKV+'" class="btn btn-info btn-xs"><i class="fa fa-pencil"></i> Sửa </a>\
				                    <a role="button" onclick="del(this)" data="'+obj[i].maKV+'" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i> Xóa </a>\
				                </b></td>\
				            </tr>';
        		$("#data").append(html);
			}
        	$('#danh-muc-table').dataTable();
        })
	}
</script>
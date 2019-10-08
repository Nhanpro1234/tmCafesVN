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
                        Danh mục
                    </header>
                    <div class="panel-body">
                        <select onchange="chonDanhMuc()" id="chonDanhMuc" class="form-control m-bot15">
                        	<option value="">Mời bạn chọn</option>
                            <option value="danh-muc-loai-bang-gia">Loại bảng giá</option>
                            <option value="danh-muc-khu-vuc">Khu vực</option>
                            <option value="danh-muc-don-vi-tinh">Đơn vị tính</option>
                        </select>
                        <script type="text/javascript">
                            function chonDanhMuc(){
                                var c = $("#chonDanhMuc").val();
                                if(c == ""){
                                	return;
                                }
                                $.ajax({
                                    url: "../quan-li/" + c,
                                    type: 'POST',
                                    data: {
										
                                    },
                                })
                                .done(function(data) {
                                   $("#danhMuc").html(data);
                                })
                            }
                        </script>
                    </div>
                </section>
            </div>
            <div id="danhMuc" class="col-md-12">
                
            </div>
        </div>
        <!-- page end-->
    </section>
</section>
<!--main content end-->
<style>
	#sidebar{
		 margin-left: 0px;
 	}
</style>
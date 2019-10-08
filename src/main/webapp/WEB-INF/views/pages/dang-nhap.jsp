<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="container">
	<c:url var="c" value="/login" />
    <form class="form-signin" name="user" action="${c}" method="POST">
        <h2 class="form-signin-heading" style="text-transform: uppercase;">đăng nhập hệ thống</h2>
        <div class="login-wrap">
            <input type="text" id="user" name="username" class="form-control" placeholder="Tên đăng nhập" required="required">
            <input type="password" id="pass" name="password" class="form-control" placeholder="Mật khẩu">
            <p style="color: red; font-size: 16px;">${message}</p>
            <button class="btn btn-lg btn-login btn-block" type="submit">Đăng nhập</button>
        </div>
    </form>
</div>
<script type="text/javascript">
	/* function login(){
		if($("#user").val() == ""){
			toastr.error("Bạn chưa nhập tài khoản", "Thông báo");
			return;
		}
		
		$.ajax({
		    url: 'api/dang-nhap',
		    type: 'POST',
		    data: {
				user: $("#user").val(),
				pass: $("#pass").val()
		    }
		})
		.done(function(data) {
		    if(data.status == 1){
		    	location.reload();
		    }else{
		    	toastr.error(data.message, "Thông báo");
		    }
		});
	}
	window.onload = function() {
		$(".form-signin").keyup(function(event) {
		    if (event.keyCode === 13) {
		    	login();
		    }
		});
	}; */
</script>
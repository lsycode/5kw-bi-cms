<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>游戏产品提交审核系统</title>
<style type="text/css">
	body{margin-left: 0px;margin-top: 0px;margin-right: 0px;margin-bottom: 0px;background-color: #1B3142;}
	.header{width:100%;height:41px;background: url(images/login-top-bg.gif) repeat-x;}
	.center{width:100%;height:532px;background: url(images/login_bg.jpg) repeat-x;}
	.login_right{float:left;width:50%;height:100%;background: url(images/login-wel.gif) bottom no-repeat;}
	.login_left{float:left;width:295px;height:100%;background: url(images/login-content-bg.gif) no-repeat;}
	.login_title{margin-left:35px;font-family: Arial, Helvetica, sans-serif;font-size: 30px;height:36px;line-height: 36px;color: #666666;font-weight: bold;}
	.login_info{margin-left:35px;font-family: Arial, Helvetica, sans-serif;font-size: 12px;height:36px;line-height: 36px;color: #333333;}
	.login_input{width:150px;height:20px;margin-left:30px;border:1px solid #7F9DB9;vertical-align: middle;}
	.login_code{width:70px;height:20px;margin-left:30px;border:1px solid #7F9DB9;vertical-align: middle;}
	.btn{width:60px;height:25px;border-width:0px;background-image: url(images/btn-bg2.gif);letter-spacing: 3px;margin-right:30px;cursor: pointer;}
	.login_info img{vertical-align: middle;cursor: pointer;}
	
	.errInfo{display:none;color:red;}
	
	.logo{width:100%;height:108px;background: url(images/logo.png) no-repeat center;_background:none;_filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src='images/logo.png';)}
	.left_txt{font-family: Arial, Helvetica, sans-serif;font-size: 24px;line-height: 80px;color: #000; text-align:center; font-weight:bold;}
	
	.bottom{width:100%;height:auto;text-align:center;font-family: Arial, Helvetica, sans-serif;font-size: 10px;color: #ABCAD3;text-decoration: none;line-height: 20px;}
</style>
<script type="text/javascript" src="js/jquery-1.5.1.min.js"></script>
</head>
<body>
<div style="width:100%;height:645px;position: absolute;top:50%;left:50%;margin-top:-320px;margin-left:-50%;">
	<div class="header"></div>
<div class="center">
		<div class="login_right">
			<div style="width:100%;height:auto;margin-top:150px;">
			<form action="login.html" method="post" name="loginForm" onsubmit="return check();">
				<div class="login_title">
					新开发商注册
				</div>
				<div class="login_info">
					<label>开发账号：</label><input type="text" name="loginname" id="loginname" class="login_input" value="${loginname }"/>
					&nbsp;<span id="nameerr" class="errInfo"></span>
				</div>
				<div class="login_info">
					<label>账号密码：</label><input type="password" name="password" id="password" class="login_input" value="${password }"/>
					&nbsp;<span id="pwderr" class="errInfo"></span>
				</div>
				<div class="login_info">
					<label>重复密码：</label><input type="password" name="password" id="password" class="login_input" value="${password }"/>
					&nbsp;<span id="pwderr" class="errInfo"></span>
				</div>
				<div class="login_info">
					<input type="button" value="注册" class="btn" onclick="javascrtpt:window.location.href='test.html'">
				</div>
			</form>
			</div>
		</div>
   </div>
</div>
</body>
</html>
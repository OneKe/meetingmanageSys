<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CoolMeeting会议管理系统</title>
		<link rel="stylesheet" href="styles/common.css" />
		<script type="text/javascript" src="js/jquery.js" ></script>
		<script type="text/javascript" src="js/checkroleid.js"></script>
	</head>
	<body>
		<div class="page-header">
			<div class="header-banner">
				<img src="images/header.png" alt="CoolMeeting" />
			</div>
			<div class="header-title">
				欢迎访问Cool-Meeting会议管理系统
			</div>
		</div>
		<div class="page-body">
			<div class="page-sidebar">
				<div class="sidebar-menugroup">
					<div class="sidebar-grouptitle">个人中心</div>
					<ul class="sidebar-menu">
						<li class="sidebar-menuitem">
							<a href="beforelogin.jsp">最新通知</a>
						</li>
						<li class="sidebar-menuitem active">
							<a href="beforelogin.jsp">我的预定</a>
						</li>
						<li class="sidebar-menuitem">
							<a href="beforelogin.jsp">我的会议</a>
						</li>
					</ul>
				</div>
				<div class="sidebar-menugroup">
					<div class="sidebar-grouptitle">人员管理</div>
					<ul class="sidebar-menu">
						<li class="sidebar-menuitem">
							<a class="checkroleid" href="beforelogin.jsp">部门管理</a>
						</li>
						<li class="sidebar-menuitem">
							<a href="register.jsp">员工注册</a>
						</li>
						<li class="sidebar-menuitem">
							<a class="checkroleid" href="beforelogin.jsp">注册审批</a>
						</li>
						<li class="sidebar-menuitem">
							<a class="checkroleid" href="beforelogin.jsp">搜索员工</a>
						</li>
					</ul>
				</div>
				<div class="sidebar-menugroup">
					<div class="sidebar-grouptitle">会议预定</div>
					<ul class="sidebar-menu">
						<li class="sidebar-menuitem">
							<a class="checkroleid" href="beforelogin.jsp">添加会议室</a>
						</li>
						<li class="sidebar-menuitem">
							<a class="checkroleid" href="beforelogin.jsp">查看会议室</a>
						</li>
						<li class="sidebar-menuitem">
							<a class="checkroleid" href="beforelogin.jsp">预定会议</a>
						</li>
						<li class="sidebar-menuitem">
							<a class="checkroleid" href="beforelogin.jsp">搜索会议</a>
						</li>
					</ul>
				</div>
			</div>
			<div class="page-content">
				<div id="hidebox" style="width: 400px;height: 180px;background-color:lightgray;position: fixed;left: 40%;top: 200px;border-radius: 10px;border: 1px solid #A52A2A">
					<p style="width: 25px;height: 25px;border-radius: 50%;float: right;background-color: #696969;text-align: center" id="closehidebox">X</p>
					<p style="margin-top: 50px;font-size: 22px;text-align: center">登陆后才能操作，请登录！</p>
					<p style="margin-top: 10px;font-size: 13px;text-align: center;color: red;">如果没有账号，请先注册！</p>
					<div id="btnplace" style="margin-top: 30px;height: 40px;left: auto;right: auto;margin-left: 50px">
						<input type="button" id="querenbtn" value="登录" style="display: inline-block; width:100px; height:40px" />
						<input type="button" id="registbtn" value="注册" style="display: inline-block; width:100px; height:40px;margin-left: 80px" />
					</div>
				</div>
			</div>
		</div>
		<div class="page-footer">
			<hr/> 更多问题，欢迎联系
			<a href="mailto:webmaster@eeg.com">管理员</a>
			<img src="images/footer.png" alt="CoolMeeting" />
		</div>
	</body>
	<script>
		$("#closehidebox").click(function(){
			window.location.href="login.jsp";
		});
		$("#querenbtn").click(function(){
			window.location.href="login.jsp";
		});
		$("#registbtn").click(function(){
			window.location.href="register.jsp";
		});
		
	</script>
</html>
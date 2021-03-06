<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html" charset="utf-8">
<title>CoolMeeting会议管理系统</title>
<link rel="stylesheet" href="styles/common.css" />
<link rel="stylesheet" href="styles/registercss.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/register.js"></script>
<!-- <script type="text/javascript" src="js/checkroleid.js"></script> -->
</head>

<body>
	<div class="page-header">
		<div class="header-banner">
			<img src="images/header.png" alt="CoolMeeting" />
		</div>
		<div class="header-title">欢迎访问Cool-Meeting会议管理系统</div>
		<div class="header-quicklink">
			欢迎！<strong><label id="labelusername">${loginUserName }</label><span id="roleid" style="display:none">${roleid }</span></strong> <a href="changepassword.jsp">[修改密码]</a>
		</div>
	</div>
	<div class="page-body">
		<div class="page-sidebar">
			<div class="sidebar-menugroup">
				<div class="sidebar-grouptitle">个人中心</div>
				<ul class="sidebar-menu">
					<li class="sidebar-menuitem"><a href="notification.action">最新通知</a></li>
					<li class="sidebar-menuitem active"><a href="mybooking.action">我的预定</a></li>
					<li class="sidebar-menuitem"><a href="mymeeting.action">我的会议</a></li>
				</ul>
			</div>
			<div class="sidebar-menugroup">
				<div class="sidebar-grouptitle">人员管理</div>
				<ul class="sidebar-menu">
					<li class="sidebar-menuitem"><a class="checkroleid" class="ooop" href="departments.jsp">部门管理</a>
					</li>
					<li class="sidebar-menuitem"><a href="register.jsp">员工注册</a></li>
					<li class="sidebar-menuitem"><a class="checkroleid" href="searchempbystatus.action">注册审批</a>
					</li>
					<li class="sidebar-menuitem"><a class="checkroleid" href="searchemployees.jsp">搜索员工</a>
					</li>
				</ul>
			</div>
			<div class="sidebar-menugroup">
				<div class="sidebar-grouptitle">会议预定</div>
				<ul class="sidebar-menu">
					<li class="sidebar-menuitem"><a class="checkroleid" href="addmeetingroom.jsp">添加会议室</a>
					</li>
					<li class="sidebar-menuitem"><a class="checkroleid" href="findMeetingRoom.action">查看会议室</a>
					</li>
					<li class="sidebar-menuitem"><a class="checkroleid" href="bookmeeting.jsp">预定会议</a>
					</li>
					<li class="sidebar-menuitem"><a class="checkroleid" href="searchmeetings.jsp">搜索会议</a>
					</li>
				</ul>
			</div>
		</div>
		<div class="page-content">
			<div class="content-nav">人员管理 > 员工注册</div>
			<form id="registerform" action="register.action" method="post">
				<fieldset>
					<legend>员工信息</legend>
					<table class="formtable" style="width: 50%">
						<tr>
							<td style="width: 100px">姓名：</td>
							<td class="inp"><input type="text" id="employeename"
								name="employeename" maxlength="20" /> <span id="empnamespan">请输入姓名！</span><span id="empnamereg">请输入中文！</span>
							</td>
						</tr>
						<tr>
							<td>账户名：</td>
							<td class="inp" style="width: 500px"><input type="text"
								id="username" name="username" maxlength="20" /> <span
								id="usernamespan">请输入账户名！</span><span id="usernamemessage"></span>
							</td>
						</tr>
						<tr>
							<td>密码：</td>
							<td class="inp"><input type="password" id="userpwd"
								name="userpwd" maxlength="20" placeholder="请输入6位以上的密码" /> <span
								id="passwordspan">请输入密码！</span><span id="pwdreg">请输入长度为6~16的密码！</span></td>
						</tr>
						<tr>
							<td>确认密码：</td>
							<td class="inp"><input type="password" id="repassword"
								name="repassword" maxlength="20" /> <span id="repasswordspan">两次输入密码不一致！</span>
							</td>
						</tr>
						<tr>
							<td>部门：</td>
							<td class="inp"><select id="departmentid"
								name="departmentid" style="width: 154px; height: 22px">

							</select> <span id="departmentidspan">请选择部门！</span></td>
						</tr>
						<tr>
							<td>角色：</td>
							<td class="inp"><select id="roleid" name="roleid"
								style="width: 154px; height: 22px">
									<option id="rid" value="2">普通用户</option>
							</select></td>
						</tr>
						<tr>
							<td>联系电话：</td>
							<td class="inp"><input type="text" id="phone" name="phone"
								maxlength="20" /> <span id="phonespan"> 请输入联系电话！</span><span id="phonereg">请输入正确电话号码！</span></td>
						</tr>
						<tr>
							<td>电子邮箱：</td>
							<td><input type="text" id="email" name="email"
								maxlength="20" /> <span id="emailspan"> 请输入邮箱！ </span><span id="emailreg">请输入正确邮箱！</span></td>
						</tr>
						<tr>
							<td colspan="3"><label style="color: red">${message}</label></td>
						</tr>
						<tr>
							<td colspan="3" class="command "><input type="button"
								class="clickbutton" id="register" value="注册" /> <input
								type="reset" class="clickbutton" value="重置" /></td>
						</tr>
					</table>
				</fieldset>
			</form>
		</div>
	</div>
	<div class="page-footer ">
		<hr />
		更多问题，欢迎联系 <a href="mailto:webmaster@eeg.com ">管理员</a> <img
			src="images/footer.png " alt="CoolMeeting " />
	</div>
</body>

</html>
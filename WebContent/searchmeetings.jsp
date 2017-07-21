<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html" charset="utf-8">
<title>CoolMeeting会议管理系统</title>
<link rel="stylesheet" href="styles/common.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/searchmeeting.js"></script>
<style type="text/css">
</style>
</head>
<body>
	<div class="page-header">
		<div class="header-banner">
			<img src="images/header.png" alt="CoolMeeting" />
		</div>
		<div class="header-title">欢迎访问Cool-Meeting会议管理系统</div>
		<div class="header-quicklink">
			欢迎！<strong>${loginUserName }</strong> <a href="changepassword.jsp">[修改密码]</a>
			<a href="loginoff.action">[退出登录]</a>
		</div>
	</div>
	<div class="page-body">
		<div class="page-sidebar">
			<div class="sidebar-menugroup">
				<div class="sidebar-grouptitle">个人中心</div>
				<ul class="sidebar-menu">
					<li class="sidebar-menuitem"><a href="notifications.jsp">最新通知</a></li>
					<li class="sidebar-menuitem active"><a href="mybookings.jsp">我的预定</a></li>
					<li class="sidebar-menuitem"><a href="mymeetings.jsp">我的会议</a></li>
				</ul>
			</div>
			<div class="sidebar-menugroup">
				<div class="sidebar-grouptitle">人员管理</div>
				<ul class="sidebar-menu">
					<li class="sidebar-menuitem"><a href="departments.jsp">部门管理</a></li>
					<li class="sidebar-menuitem"><a href="register.jsp">员工注册</a></li>
					<li class="sidebar-menuitem"><a href="approveaccount.jsp">注册审批</a></li>
					<li class="sidebar-menuitem"><a href="searchemployees.jsp">搜索员工</a></li>
				</ul>
			</div>
			<div class="sidebar-menugroup">
				<div class="sidebar-grouptitle">会议预定</div>
				<ul class="sidebar-menu">
					<li class="sidebar-menuitem"><a href="addmeetingroom.jsp">添加会议室</a></li>
					<li class="sidebar-menuitem"><a href="meetingrooms.jsp">查看会议室</a></li>
					<li class="sidebar-menuitem"><a href="bookmeeting.jsp">预定会议</a></li>
					<li class="sidebar-menuitem"><a href="searchmeetings.jsp">搜索会议</a></li>
				</ul>
			</div>
		</div>
		<div class="page-content">
			<div class="content-nav">会议预定 > 搜索会议</div>
			<form action="searchmeeting.action" method="post"
				id="searchmeetingform">
				<fieldset>
					<legend>搜索会议</legend>
					<table class="formtable">
						<tr>
							<td>会议名称：</td>
							<td><input type="text" id="meetingname" name="meetingname"
								maxlength="20" /></td>
							<td>会议室名称：</td>
							<td><input type="text" id="roomname" name="roomname"
								maxlength="20" /></td>
							<td>预定者姓名：</td>
							<td><input type="text" id="reservername" name="reservername"
								maxlength="20" /></td>
						</tr>
						<tr>
							<td>预定日期：</td>
							<td colspan="5">从&nbsp;<input type="date"
								id="reservefromdate" name="reservefromdate"
								placeholder="例如：2013-10-20" /> 到&nbsp;<input type="date"
								id="reservetodate" name="reservetodate"
								placeholder="例如：2013-10-22" />
							</td>
						</tr>
						<tr>
							<td>会议日期：</td>
							<td colspan="5">从&nbsp;<input type="date"
								id="meetingfromdate" name="meetingfromdate"
								placeholder="例如：2013-10-20" /> 到&nbsp;<input type="date"
								id="meetingtodate" name="meetingtodate"
								placeholder="例如：2013-10-22" />
							</td>
						</tr>
						<tr>
							<td colspan="6" class="command"><input type="button" id="querymeet" class="clickbutton" value="查询" /> <input type="reset"
								class="clickbutton" value="重置" /></td>
						</tr>
					</table>
				</fieldset>
			</form>
			<div>
				<h3 style="text-align: center; color: black">查询结果</h3>
				<div class="pager-header">
					<div class="header-info">
						共<span class="info-number">${list.size() }</span>条结果， 分成<span
							class="info-number">6</span>页显示， 当前第<span class="info-number">1</span>页
					</div>
					<div class="header-nav">
						<input type="button" class="clickbutton" value="首页" /> <input
							type="button" class="clickbutton" value="上页" /> <input
							type="button" class="clickbutton" value="下页" /> <input
							type="button" class="clickbutton" value="末页" /> 跳到第<input
							type="text" id="pagenum" class="nav-number" />页 <input
							type="button" class="clickbutton" value="跳转" />
					</div>
				</div>
			</div>
			<table class="listtable">
				<thead>
					<tr class="listheader">
						<th>会议名称</th>
						<th>会议室名称</th>
						<th>会议开始时间</th>
						<th>会议结束时间</th>
						<th>会议预定时间</th>
						<th>预定者</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody id="qmt"></tbody>
			</table>
		</div>
	</div>
	<div class="page-footer">
		<hr />
		更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a> <img
			src="images/footer.png" alt="CoolMeeting" />
	</div>
</body>
</html>
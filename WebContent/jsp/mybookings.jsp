<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html" charset="utf-8">
<title>CoolMeeting会议管理系统</title>
<link rel="stylesheet" href="styles/common.css" />
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
			欢迎！<strong>${loginUserName }</strong> <a href="jsp/changepassword.jsp">[修改密码]</a><a href="loginoff.action">[退出登录]</a>
		</div>
	</div>
	<div class="page-body">
		<div class="page-sidebar">
			<div class="sidebar-menugroup">
				<div class="sidebar-grouptitle">个人中心</div>
				<ul class="sidebar-menu">
					<li class="sidebar-menuitem"><a href="notification.action">最新通知</a></li>
					<li class="sidebar-menuitem active"><a href="mybooking.action">我的预定</a></li>
					<li class="sidebar-menuitem"><a
						href="meetingparticipants.action">我的会议</a></li>
				</ul>
			</div>
			<div class="sidebar-menugroup">
				<div class="sidebar-grouptitle">人员管理</div>
				<ul class="sidebar-menu">
					<li class="sidebar-menuitem"><a href="jsp/departments.jsp">部门管理</a></li>
					<li class="sidebar-menuitem"><a href="jsp/register.jsp">员工注册</a></li>
					<li class="sidebar-menuitem"><a href="jsp/approveaccount.jsp">注册审批</a></li>
					<li class="sidebar-menuitem"><a href="jsp/searchemployees.jsp">搜索员工</a></li>
				</ul>
			</div>
			<div class="sidebar-menugroup">
				<div class="sidebar-grouptitle">会议预定</div>
				<ul class="sidebar-menu">
					<li class="sidebar-menuitem"><a href="jsp/addmeetingroom.jsp">添加会议室</a></li>
					<li class="sidebar-menuitem"><a href="jsp/meetingrooms.jsp">查看会议室</a></li>
					<li class="sidebar-menuitem"><a href="jsp/bookmeeting.jsp">预定会议</a></li>
					<li class="sidebar-menuitem"><a href="jsp/searchmeetings.jsp">搜索会议</a></li>
				</ul>
			</div>
		</div>
		<div class="page-content">
			<div class="content-nav">个人中心 > 我的预定</div>
			<table class="listtable">
				<caption>我预定的会议：</caption>
				<tr class="listheader">
					<th>会议名称</th>
					<th>会议室名称</th>
					<th>会议开始时间</th>
					<th>会议结束时间</th>
					<th>会议预定时间</th>
					<th>操作</th>
				</tr>
				<c:forEach var="meeting" items="${bookinglist}">
					<tr>
						<td>${meeting.getMeetingname() }</td>
						<td>${meetingRoom.selectByRoomId(meeting.getRoomid()).getRoomname()}</td>
						<td>${meeting.getBegintime()}</td>
						<td>${meeting.getEndtime()}</td>
						<td>${meeting.getReservationtime()}</td>
						<td><a class="clickbutton" href=" cancelmeeting.jsp?meetingid=${meeting.getMeetingid()}">查看/撤销</a>
						</td>
					</tr>
				</c:forEach>


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
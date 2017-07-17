<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html" charset="utf-8">
<title>CoolMeeting会议管理系统</title>
<link rel="stylesheet" href="styles/common.css" />
</head>
<body>
	<div class="page-header">
		<div class="header-banner">
			<img src="images/header.png" alt="CoolMeeting" />
		</div>
		<div class="header-title">欢迎访问Cool-Meeting会议管理系统</div>
		<div class="header-quicklink">
			欢迎！<strong>${loginUserName }</strong> <a href="changepassword.jsp">[修改密码]</a><a href="loginoffaction">[退出登录]</a>
		</div>
	</div>
	<div class="page-body">
		<div class="page-sidebar">
			<div class="sidebar-menugroup">
				<div class="sidebar-grouptitle">个人中心</div>
				<ul class="sidebar-menu">
					<li class="sidebar-menuitem"><a href="notificationaction">最新通知</a></li>
					<li class="sidebar-menuitem active"><a href="mybookingaction">我的预定</a></li>
					<li class="sidebar-menuitem"><a
						href="meetingparticipantsaction">我的会议</a></li>
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
			<div class="content-nav">
				个人中心 > <a href="notifications">最新通知</a>
			</div>
			<table class="listtable">
				<caption>未来7天我要参加的会议:</caption>
				<tr class="listheader">
					<th style="width: 300px">会议名称</th>
					<th>会议室</th>
					<th>起始时间</th>
					<th>结束时间</th>
					<th style="width: 100px">操作</th>
				</tr>
				<c:forEach var="comemeeting" items="${meetinglist}">
					<tr>
						<td>${comemeeting.getMeetingName()}</td>
						<td>${meetingRoom.selectByRoomId(comemeeting.getRoomID()).getRoomName()}</td>
						<td>${comemeeting.getStartTime()}</td>
						<td>${comemeeting.getEndTime()}</td>
						<td><a class="clickbutton" href="meetingdetailsaction?meetingid=${meeting.getMeetingID()}">查看详情</a>
						</td>
					</tr>
				</c:forEach>



			</table>
			<table class="listtable">
				<caption>已取消的会议:</caption>
				<tr class="listheader">
					<th style="width: 300px">会议名称</th>
					<th>会议室</th>
					<th>起始时间</th>
					<th>结束时间</th>
					<th>取消原因</th>
					<th style="width: 100px">操作</th>
				</tr>
				<c:forEach var="cancelmeeting" items="${cancellist}">
					<tr>
						<td>${cancelmeeting.getMeetingName()}</td>
						<td>${meetingRoom.selectByRoomId(cancelmeeting.getRoomID()).getRoomName()}</td>
						<td>${cancelmeeting.getStartTime()}</td>
						<td>${cancelmeeting.getEndTime()}</td>
						<td>${cancelmeeting.getDescription()}</td>
						<td><a class="clickbutton" href="meetingdetails.jsp">查看详情</a>
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
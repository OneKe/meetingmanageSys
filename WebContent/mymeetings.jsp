<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
<meta http-equiv="content-type" content="text/html" charset="utf-8">
        <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="styles/common.css"/>
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/checkroleid.js"></script>
        <style type="text/css">
            
        </style>
    </head>
    <body>
        <div class="page-header">
            <div class="header-banner">
                <img src="images/header.png" alt="CoolMeeting"/>
            </div>
            <div class="header-title">
                欢迎访问Cool-Meeting会议管理系统
            </div>
            <div class="header-quicklink">
                欢迎！<strong><label id="labelusername">${loginUserName }</label> <span id="roleid" style="display:none">${roleid }</span></strong>
                <a href="changepassword.jsp">[修改密码]</a>
                <a href="loginoff.action">[退出登录]</a>
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
                        <li class="sidebar-menuitem"><a class="checkroleid" href="departments.jsp">部门管理</a></li>
                        <li class="sidebar-menuitem"><a href="register.jsp">员工注册</a></li>
                        <li class="sidebar-menuitem"><a class="checkroleid" href="approveaccount.jsp">注册审批</a></li>
                        <li class="sidebar-menuitem"><a class="checkroleid" href="searchemployees.jsp">搜索员工</a></li>
                    </ul>
                </div>
                <div class="sidebar-menugroup">
                    <div class="sidebar-grouptitle">会议预定</div>
                    <ul class="sidebar-menu">
                        <li class="sidebar-menuitem"><a class="checkroleid" href="addmeetingroom.jsp">添加会议室</a></li>
                        <li class="sidebar-menuitem"><a class="checkroleid" href="findMeetingRoom.action">查看会议室</a></li>
                        <li class="sidebar-menuitem"><a class="checkroleid" href="bookmeeting.jsp">预定会议</a></li>
                        <li class="sidebar-menuitem"><a class="checkroleid" href="searchmeetings.jsp">搜索会议</a></li>
                    </ul>
                </div>
            </div>
            <div class="page-content">
                <div class="content-nav">
                    个人中心 > 我的会议
                </div>
                <table class="listtable">
                    <caption>我将参加的会议：</caption>
                    <tr class="listheader">
                        <th>会议名称</th>
                        <th>会议室名称</th>
                        <th>会议开始时间</th>
                        <th>会议结束时间</th>
                        <th>会议预定时间</th>
                        <th>预定者</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach var="map" items="${meetings}">
                    <tr>
                        <td>${map.get("meetingname")}</td>
						<td>${map.get("roomname")}</td>
						<td>${map.get("begintime")}</td>
						<td>${map.get("endtime")}</td>
						<td>${map.get("ReservationTime")}</td>
						<td>${map.get("EmployeeName")}</td>
						<td>
                            <a class="clickbutton" href="querymeetingdetails.action?meetingid=${map.get('meetingid')}">查看详情</a>
                        </td>
                    </tr>
                    </c:forEach>
                    
                </table>
            </div>
        </div>
        <div class="page-footer">
            <hr/>
            更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a>
            <img src="images/footer.png" alt="CoolMeeting"/>
        </div>
    </body>
</html>
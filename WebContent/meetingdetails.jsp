<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
<meta http-equiv="content-type" content="text/html"  charset="utf-8">
        <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="styles/common.css"/>
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/searchmeeting.js"></script>
        <style type="text/css">
            #divfrom{
                float:left;
                width:200px;
            }
            #divto{
                float:left;
                width:200px;
            }
            #divoperator{
                float:left;
                width:50px;
                padding:60px 5px;
            }
            #divoperator input[type="button"]{
                margin:10px 0;
            }
            #selDepartments{
                display:block;
                width:100%;
            }
            #selEmployees{
                display:block;
                width:100%;
                height:200px;
            }
            #selSelectedEmployees{
                display:block;
                width:100%;
                height:225px;
            }
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
                欢迎！<strong>${loginUserName }</strong>
                <a href="changepassword.jsp">[修改密码]</a>
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
                        <li class="sidebar-menuitem"><a href="mymeeting.action">我的会议</a></li>
                    </ul>
                </div>
                <div class="sidebar-menugroup">
                    <div class="sidebar-grouptitle">人员管理</div>
                    <ul class="sidebar-menu">
                        <li class="sidebar-menuitem"><a href="departments.jsp">部门管理</a></li>
                        <li class="sidebar-menuitem"><a href="register.jsp">员工注册</a></li>
                        <li class="sidebar-menuitem"><a href="searchempbystatus.action">注册审批</a></li>
                        <li class="sidebar-menuitem"><a href="searchemployees.jsp">搜索员工</a></li>
                    </ul>
                </div>
                <div class="sidebar-menugroup">
                    <div class="sidebar-grouptitle">会议预定</div>
                    <ul class="sidebar-menu">
                        <li class="sidebar-menuitem"><a href="addmeetingroom.jsp">添加会议室</a></li>
                        <li class="sidebar-menuitem"><a href="findMeetingRoom.action">查看会议室</a></li>
                        <li class="sidebar-menuitem"><a href="bookmeeting.jsp">预定会议</a></li>
                        <li class="sidebar-menuitem"><a href="searchmeetings.jsp">搜索会议</a></li>
                    </ul>
                </div>
            </div>
            <div class="page-content">
                <div class="content-nav">
                    会议预定 > 修改会议预定
                </div>
                <form>
                    <fieldset>
                        <legend>会议信息</legend>
                        <table class="formtable">
                            <tr>
                                <td>会议名称：</td>
                                <td>${meeting.meetingname}</td>
                            </tr>
                            <tr>
                                <td>预计参加人数：</td>
                                <td>${meeting.numofparticipants}</td>
                            </tr>
                            <tr>
                                <td>预计开始时间：</td>
                                <td>${begintime}</td>
                            </tr>
                            <tr>
                                <td>预计结束时间：</td>
                                <td>${endtime}</td>
                            </tr>
                            <tr>
                                <td>会议说明：</td>
                                <td>
                                    <textarea id="description" rows="5" readonly>${meeting.description}</textarea>
                                </td>
                            </tr>
                            <tr>
                                <td>参会人员：</td>
                                <td>
                                    <table class="listtable">
                                    <tr class="listheader">
                                            <th>姓名</th>
                                            <th>联系电话</th>
                                            <th>电子邮件</th>
                                        </tr>
                                    <c:forEach var ="employee" items="${list }">
                                    	<tr>
                                            <td>${employee.employeename }</td>
                                            <td>${employee.phone }</td>
                                            <td>${employee.email }</td>
                                        </tr>
                                    </c:forEach>
                                    </table>
                                </td>
                            </tr>
                            <tr>
                                <td class="command" colspan="2">
                                    <input type="button" class="clickbutton" value="返回" onclick="window.history.back();"/>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </form>
            </div>
        </div>
        <div class="page-footer">
            <hr/>
            更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a>
            <img src="images/footer.png" alt="CoolMeeting"/>
        </div>
    </body>
</html>
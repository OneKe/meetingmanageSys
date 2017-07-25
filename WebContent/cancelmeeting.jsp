
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="content-type" content="text/html"  charset="utf-8">
        <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="styles/common.css"/>
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
            #hidebox{
            display:none;
            }
        </style>
    </head>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/cancelmeeting.js"></script>
    
    <body onload="body_load()">
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
                        <li class="sidebar-menuitem"><a href="notification.action">最新通知</a></li>
                        <li class="sidebar-menuitem active"><a href="mybooking.action">我的预定</a></li>
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
                        <li class="sidebar-menuitem"><a href="meetingrooms.jsp">查看会议室</a></li>
                        <li class="sidebar-menuitem"><a href="bookmeeting.jsp">预定会议</a></li>
                        <li class="sidebar-menuitem"><a href="searchmeetings.jsp">搜索会议</a></li>
                    </ul>
                </div>
            </div>
            <div class="page-content">
                <div class="content-nav">
                    会议预定 > 撤销会议预定
                </div>
                <form action="cancelmeeting.action" method="post" id="cancelmeetingform">
                    <fieldset>
                        <legend>撤销预定</legend>
                        <table class="formtable">
                            <tr>
                                <td>会议名称：</td>
                                <input type="text" style="display:none" value="${meetings.meetingid}" name="meetingid"/>
                                <td>${meetings.meetingname}</td>
                            </tr>
                            <tr>
                                <td>参加人数：</td>
                                <td>${meetings.numofparticipants}</td>
                            </tr>
                            <tr>
                                <td>撤销理由：</td>
                                <td> <textarea id=canceledreson name="canceledreson" rows="5"></textarea></td>
                            </tr>
                            <tr>
                                <td class="command" colspan="2">
                                    <input type="button" class="clickbutton" id="firstbtn" value="确认撤销"/>
                                    <input type="button" class="clickbutton" value="返回" onclick="window.history.back();"/>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </form>
            </div>
        </div>
        <div id="hidebox" style="width: 400px;height: 160px;background-color:lightgray;position: fixed;left: 40%;top: 200px;border-radius: 10px;border: 1px solid #A52A2A">
    		<p style="width: 25px;height: 25px;border-radius: 50%;float: right;background-color: #696969;text-align: center" id="closehidebox">X</p>
    		<p style="margin-top: 50px;font-size: 20px;text-align: center">是否确认删除？</p>
    		<div id="btnplace" style="margin-top: 30px;height: 40px;left: auto;right: auto;margin-left: 50px">
        		<input type="button" id="querenbtn" value="确认" style="display: inline-block; width:100px; height:40px" />
        		<input type="button" id="backbtn" value="取消" style="display: inline-block; width:100px; height:40px;margin-left: 80px" />
    </div>
    </div>
    <p>${message}</p>
        <div class="page-footer">
            <hr/>
            更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a>
            <img src="images/footer.png" alt="CoolMeeting"/>
        </div>
    </body>
    <script type="text/javascript">
    $("#querenbtn").click(function(){
		$("#hidebox").hide();
		window.location.href = "cancelmeeting.action?meetingid=${meetings.meetingid}";
	});
    </script>
</html>
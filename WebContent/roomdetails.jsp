<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
<meta http-equiv="content-type" content="text/html"  charset="utf-8">
        <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="styles/common.css"/>
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
                <a href="changepassword.jsp">[修改密码]</a><a href="loginoff.action">[退出登录]</a>
            </div>
        </div>
        <div class="page-body">
            <div class="page-sidebar">
                <div class="sidebar-menugroup">
                    <div class="sidebar-grouptitle">个人中心</div>
                    <ul class="sidebar-menu">
                        <li class="sidebar-menuitem"><a href="notification.action">最新通知</a></li>
                        <li class="sidebar-menuitem active"><a href="mybooking.action">我的预定</a></li>
                        <li class="sidebar-menuitem"><a href="meetingparticipants.action">我的会议</a></li>
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
                        <li class="sidebar-menuitem"><a href="findMeetingRoom.action">查看会议室</a></li>
                        <li class="sidebar-menuitem"><a href="bookmeeting.jsp">预定会议</a></li>
                        <li class="sidebar-menuitem"><a href="searchmeetings.jsp">搜索会议</a></li>
                    </ul>
                </div>
            </div>
            <div class="page-content">
                <div class="content-nav">
                    会议预定 > 修改会议室信息
                </div>
                <form action="ConfirmTheChange.action"  id ="editmeetingroomform"  method="post"> 
                    <fieldset>
                        <legend>会议室信息</legend>
                        <table class="formtable">
                            <tr>
                                <td>门牌号:</td>
                                <td>
                                <input name = "roomid"  type="text"  value = "${meetingroom.getRoomid() }" style="display:none"/>
                                    <input id="roomnumber"  name="roomnumber"    type="text" value="${meetingroom.getRoomcode() }" maxlength="10"/>
                                </td>
                            </tr>
                            <tr>
                                <td>会议室名称:</td>
                                <td>
                                    <input id="roomname"  name="roomname"  type="text" value="${meetingroom.getRoomname() }" maxlength="20"/>
                                </td>
                            </tr>
                            <tr>
                                <td>最多容纳人数：</td>
                                <td>
                                    <input id="roomcapacity"  name="roomcapacity"   type="text" value="${meetingroom.getRoomcapacity() }"/>
                                </td>
                            </tr>
                            <tr>
                                <td>当前状态：</td>
                                <td>
	                                <c:if test = "${meetingroom.getRoomstatus()  == 0 }">
	                        			<c:set var = "using" value = "checked='checked'"></c:set>
	                        		</c:if>
	                        		<c:if test = "${meetingroom.getRoomstatus()  == 1 }">
	                        			<c:set var = "stop" value = "checked='checked'"></c:set>
	                        		</c:if>
	                        		<c:if test = "${meetingroom.getRoomstatus()  == 2 }">
	                        			<c:set var = "delete" value = "checked='checked'"></c:set>
	                        		</c:if>
                                    <input type="radio" id="status" name="status"  ${using} value="0"/><label for="status">启用</label>
                                    <input type="radio" id="status" name="status"  ${stop} value="1"/><label for="status">停用</label>
                                    <input type="radio" id="status" name="status"  ${delete} value="2"/><label for="status" >删除</label>
                                </td>
                            </tr>
                            <tr>
                                <td>备注：</td>
                                <td>
                                    <textarea id="description"  name ="description"  maxlength="200" rows="5" cols="60"  >${meetingroom.getDescription()}</textarea>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" class="command">
                                    <input type="submit" value="确认修改" class="clickbutton" />
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
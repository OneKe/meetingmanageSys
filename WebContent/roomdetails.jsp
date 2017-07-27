<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
<meta http-equiv="content-type" content="text/html"  charset="utf-8">
        <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="styles/common.css"/>
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/checkroleid.js"></script>
        <style>
        	#hidebox{
        		display: none;
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
                欢迎！<strong><label id="labelusername">${loginUserName }</label> <span id="roleid" style="display:none">${roleid }</span></strong>
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
	                        			<c:set var = "delete" value = "checked='checked'"></c:set>
	                        		</c:if>
	                        		<c:if test = "${meetingroom.getRoomstatus()  == 1 }">
	                        			<c:set var = "using" value = "checked='checked'"></c:set>
	                        		</c:if>
	                        		<c:if test = "${meetingroom.getRoomstatus()  == 2 }">
	                        			<c:set var = "stop" value = "checked='checked'"></c:set>
	                        		</c:if>
                                    <input type="radio" id="status" name="status"  ${using} value="0"/><label for="status">删除</label>
                                    <input type="radio" id="status" name="status"  ${stop} value="1"/><label for="status">启用</label>
                                    <input type="radio" id="status" name="status"  ${delete} value="2"/><label for="status" >停用</label>
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
                                    <input type="button" value="确认修改" class="clickbutton" id="clickbtn" />
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
			<p style="margin-top: 50px;font-size: 20px;text-align: center">是否确认修改？</p>
			<div id="btnplace" style="margin-top: 30px;height: 40px;left: auto;right: auto;margin-left: 50px">
				<input type="button" id="querenbtn" value="确认" style="display: inline-block; width:100px; height:40px" />
				<input type="button" id="backbtn" value="取消" style="display: inline-block; width:100px; height:40px;margin-left: 80px" />
			</div>
		</div>
        <div class="page-footer">
            <hr/>
            更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a>
            <img src="images/footer.png" alt="CoolMeeting"/>
        </div>
    </body>
    <script>
    	$("#clickbtn").click(function(){
    		$("#hidebox").show();
    	});
    	$("#closehidebox").click(function(){
    		$("#hidebox").hide();
    	});
    	$("#backbtn").click(function(){
    		$("#hidebox").hide();
    	});
    	$("#querenbtn").click(function(){
    		$("#hidebox").hide();
    		$("#editmeetingroomform").submit();
    	});
    </script>
</html>
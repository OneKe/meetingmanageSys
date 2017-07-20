
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
      <meta http-equiv="content-type" content="text/html" charset="utf-8">
        <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="styles/common.css"/>
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/departments.js"></script>
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
                        <li class="sidebar-menuitem"><a href="meetingrooms.jsp">查看会议室</a></li>
                        <li class="sidebar-menuitem"><a href="bookmeeting.jsp">预定会议</a></li>
                        <li class="sidebar-menuitem"><a href="searchmeetings.jsp">搜索会议</a></li>
                    </ul>
                </div>
            </div>
            <div class="page-content">
                <div class="content-nav">
                    人员管理 > 部门管理
                </div>
                <form id = "adddepartmentform" method="post" action="adddepartmen.action">
                    <fieldset>
                        <legend>添加部门</legend>
                        部门名称:
                        <input type="text" id="departmentname" name = "departmentname" maxlength="20"/>
                        <input type="button" id="adddepartmentformbutton" class="clickbutton" value="添加"/>
                        <span style="color: red; display: none;" id="departmentnamespan">部门名为空！</span>
                        <span style="color:red">${message }</span>
                    </fieldset>
                </form>
                <table class="listtable">
                    <caption>所有部门:</caption>
                    <tr class="listheader">
                        <th width="60px">部门编号</th>
                        <th width="240">部门名称</th>
                        <th width="240">部门介绍</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach var = "department" items = "${departmentlist}">
                   	<form id = "${department.getDepartmentId()}form" method="post"  action="editdepartmentaction">
                   	<tr>
                        <td>
                        	<span>${department.getDepartmentId()}</span>
                        	<input type="text"  name="departmentid" value ="${department.getDepartmentId()}" style="display:none;">
                       	</td>
                        <td><span id = "${department.getDepartmentId()}namespan">${department.getDepartmentName()}</span>
                        		<input name ="departmentname"  style="display:none ;text-align:center" type="text" id = "${department.getDepartmentId()}nametext" value="${department.getDepartmentName()}"/>
                        </td>
                        <td>
                        	<span id = "${department.getDepartmentId()}remarkspan">${department.getRemark()}</span>
                        	<input name ="departmentremark"  style="display:none;text-align:center" type="text" id = "${department.getDepartmentId()}remarktext" value="${department.getRemark()}"/>
                        </td>
                        <td>
                            <input type="button" class="clickbutton" onclick="editclick(${department.getDepartmentId()})" name = "editbtn" id = "${department.getDepartmentId()}editbtn" value="编辑">
                            <input type="button"  class="clickbutton" onclick="editconfirmclick(${department.getDepartmentId()})" name= "editconfirmbtn"  id = "${department.getDepartmentId()}editconfirmbtn" style="display:none" value="确认">
                            <input type="button"  class="clickbutton" onclick="editcancelclick(${department.getDepartmentId()})" name= "editcancelbtn" id = "${department.getDepartmentId()}editcancelbtn" style="display:none" value="取消">
                            <input type="button"  class="clickbutton" onclick="deleteclick(${department.getDepartmentId()})"  name="deletebtn" id = "${department.getDepartmentId()}deletebtn" value="删除">
                            <a class="clickbutton"  style ="display:none;background-color: rgb(221,221,221);color: black;"  href="/mms/removedepartmentaction?departmentid=${department.getDepartmentId()}"  style="display:none"  id = "${department.getDepartmentId()}deleteconfirmbtn">确认</a>
                            <input type="button"  class="clickbutton" onclick="deletecancelclick(${department.getDepartmentId()})" name="deletecancelbtn" id = "${department.getDepartmentId()}deletecancelbtn" style="display:none" value="取消">
                        </td>
                        </tr>
                    </form>
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
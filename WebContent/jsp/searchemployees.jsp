<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
<meta http-equiv="content-type" content="text/html"  charset="utf-8">
        <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="../styles/common.css"/>
        <script type="text/javascript"  src="../js/jquery.js"></script>
        <script type="text/javascript"  src="../js/searchemployees.js"></script>
    </head>
    <body>
        <div class="page-header">
            <div class="header-banner">
                <img src="../images/header.png" alt="CoolMeeting"/>
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
                    会议预定 > 搜索员工
                </div>
                <form action = "searchemployees.action"  method ="post"  id="searchform">
                    <fieldset>
                        <legend>搜索会议</legend>
                        
                        <table class="formtable">
                            <tr>
                                <td >姓名：</td>
                                <td>
                                    <input type="text" id="employeename"  name="employeename"  maxlength="20"/>
                                </td>
                                <td>账号名：</td>
                                <td>
                                    <input type="text" id="accountname"  name="accountname"  maxlength="20"/>
                                </td>
                                <td>状态：</td>
                                <td>
                                    <input type="radio"  name="status"  value="1"  checked="checked"/><label>已批准</label>
                                    <input type="radio"  name="status"  value="0"/><label>待审批</label>
                                    <input type="radio"  name="status"  value="3"/><label>已关闭</label>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="6" class="command">
                                    <input type="button" id="submitbutton" class="clickbutton" value="查询"/>
                                    <input type="reset" class="clickbutton" value="重置"/>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </form>
                <div>
                    <h3 style="text-align:center;color:black">查询结果</h3>
                    <div class="pager-header">
                        <div class="header-info">
                            共<span class="info-number">&nbsp; ${list.size()} &nbsp;</span>条结果，
                            每页显示<input type="text" id="pagesize" name = "pagesize" style="width:25px" value="${pagesize}"> 条结果，
                            当前第<span class="info-number">${pageindex }</span>页
                        </div>
                        <div class="header-nav">
                            <input type="button" class="clickbutton" value="首页" id="headpage"/>
                            <input type="button" class="clickbutton" value="上页" id = "pagefront"/>
                            <input type="button" class="clickbutton" value="下页" id = "pagenext"/>
                            <input type="button" class="clickbutton" value="末页" id = "pageend"/>
                            跳到第<input type="text" id="pagenum" class="nav-number"/>页
                            <input type="button" class="clickbutton" value="跳转" id="goto"/>
                        </div>
                    </div>
                </div>
                <table class="listtable">
                    <tr class="listheader">
                        <th width="">姓名</th>
                        <th>账号名</th>
                        <th>联系电话</th>
                        <th>电子邮件</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach var = "employee" items = "${list }">
                    	<tr>
                        <td>${employee.getEmployeeName() }</td>
                        <td>${employee.getUserName() }</td>
                        <td>${employee.getPhone() }</td>
                        <td>${employee.getEmail() }</td>
                        <td>
                            <a class="clickbutton" href="closeemployee?employeeid=${employee.getEmployeeId() }">关闭账号</a>
                        </td>
                    </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
        <div class="page-footer">
            <hr/>
            更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a>
            <img src="../images/footer.png" alt="CoolMeeting"/>
        </div>
    </body>
</html>
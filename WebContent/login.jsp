<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
<meta http-equiv="content-type" content="text/html" charset="utf-8">
        <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="styles/common.css"/>
        <script type="text/javascript" src="js/jquery.js"></script>
        <!-- <script type="text/javascript" src="js/checkroleid.js"></script> -->
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
                欢迎！<strong><label id="labelusername">${loginUserName }</label><span id="roleid" style="display:none">${roleid }</span></strong>
                <a href="beforelogin.jsp">[修改密码]</a>
            </div>
        </div>
        <div class="page-body">
            <div class="page-sidebar">
                <div class="sidebar-menugroup">
                    <div class="sidebar-grouptitle">个人中心</div>
                    <ul class="sidebar-menu">
                        <li class="sidebar-menuitem"><a href="beforelogin.jsp">最新通知</a></li>
                        <li class="sidebar-menuitem active"><a href="beforelogin.jsp">我的预定</a></li>
                        <li class="sidebar-menuitem"><a href="beforelogin.jsp">我的会议</a></li>
                    </ul>
                </div>
                <div class="sidebar-menugroup">
                    <div class="sidebar-grouptitle">人员管理</div>
                    <ul class="sidebar-menu">
                        <li class="sidebar-menuitem"><a class="checkroleid" href="beforelogin.jsp">部门管理</a></li>
                        <li class="sidebar-menuitem"><a href="register.jsp">员工注册</a></li>
                        <li class="sidebar-menuitem"><a class="checkroleid" href="beforelogin.jsp">注册审批</a></li>
                        <li class="sidebar-menuitem"><a class="checkroleid" href="beforelogin.jsp">搜索员工</a></li>
                    </ul>
                </div>
                <div class="sidebar-menugroup">
                    <div class="sidebar-grouptitle">会议预定</div>
                    <ul class="sidebar-menu">
                        <li class="sidebar-menuitem"><a class="checkroleid" href="beforelogin.jsp">添加会议室</a></li>
                        <li class="sidebar-menuitem"><a class="checkroleid" href="beforelogin.jsp">查看会议室</a></li>
                        <li class="sidebar-menuitem"><a class="checkroleid" href="beforelogin.jsp">预定会议</a></li>
                        <li class="sidebar-menuitem"><a class="checkroleid" href="beforelogin.jsp">搜索会议</a></li>
                    </ul>
                </div>
            </div>
            <div class="page-content">
                <div class="content-nav">
                    登录 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<span style="color:red">${loginMessage}</span>
                </div>
                <form id="loginform"  method="post"  action="login.action">
                    <fieldset>
                        <legend>登录信息</legend>
                        <table class="formtable" style="width:50%">
                            <tr>
                                <td>账号名:</td>
                                <td>
                                    <input id="username"  name="username" type="text" />
                                </td>
                            </tr>
                            <tr>
                                <td>密码:</td>
                                <td>
                                    <input id="userpwd"  name="userpwd"  type="password" />
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" class="command">
                                    <input type="submit" value="登录" class="clickbutton" onclick="window.location.href='notifiactions.jsp';"/>
                                    <input type="button" value="注册" class="clickbutton" onclick="window.location.href='register.jsp';"/>
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
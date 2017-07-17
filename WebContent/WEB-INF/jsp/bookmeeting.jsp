<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
<meta http-equiv="content-type" content="text/html"  charset="utf-8">
        <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="styles/common.css"/>
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/bookmeeting.js"></script>
        <style type="text/css">
            #divfrom{
                float:left;
                width:150px;
            }
            #divto{
                float:left;
                width:150px;
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
                <a href="loginoffaction">[退出登录]</a>
            </div>
        </div>
        <div class="page-body">
            <div class="page-sidebar">
                <div class="sidebar-menugroup">
                    <div class="sidebar-grouptitle">个人中心</div>
                    <ul class="sidebar-menu">
                        <li class="sidebar-menuitem"><a href="notificationaction">最新通知</a></li>
                        <li class="sidebar-menuitem active"><a href="mybookingaction">我的预定</a></li>
                        <li class="sidebar-menuitem"><a href="meetingparticipantsaction">我的会议</a></li>
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
                    会议预定 > 预定会议 <span>${message }</span>
                </div>
                <form action="bookingmeetingaction"  method="post"  id="bookingmeetingform">
                    <fieldset>
                        <legend>会议信息</legend>
                        <table class="formtable">
                            <tr>
                                <td>会议名称：</td>
                                <td>
                                    <input type="text"  id="meetingname"  name="meetingname"  maxlength="20"/>
                                </td>
                            </tr>
                            <tr>
                                <td>预计参加人数：</td>
                                <td>
                                    <input type="number"  id="numofparticipants"  name="numofparticipants"  />
                                </td>
                            </tr>
                            <tr>
                                <td>会议室：</td>
                                <td>
                                    <select id = "roomid" name = "roomid" >
										<c:forEach var ="room" items="${roomlist }">
											<option value ="${room.getRoomId() }">${room.getRoomName()} 容量 ：${room.getRoomCapacity()} 人</option>
										</c:forEach>
									</select>
                                </td>
                            </tr>
                            <tr>
                                <td>预计开始时间：</td>
                                <td>
                                    <input type="datetime-local" id="startdatetime"   name="startdatetime" />
                                </td>
                            </tr>
                            <tr>
                                <td>预计结束时间：</td>
                                <td>
                                    <input type="datetime-local"  id="enddatetime"  name="enddatetime" />
                                </td>
                            </tr>
                            <tr>
                                <td>会议说明：</td>
                                <td>
                                    <textarea id="description"  name="description"  rows="5"></textarea>
                                </td>
                            </tr>
                            <tr>
                                <td>选择参会人员：</td>
                                <td>
                                    <div id="divfrom">
                                        <select id="selDepartments"  onclick="changeemployees()">
                                        	<c:forEach var ="department" items = "${departmentlist }">
                                        		<option value = "${department.getDepartmentId()}">${department.getDepartmentName()}</option>
                                        	</c:forEach>
                                        </select>
                                        
                                        <c:forEach var ="department" items = "${departmentlist}">
                                        	<select id="sel${department.getDepartmentId()}Employees"  class="selEmployees" multiple="true"  style="width:150px;height:200px;display:none">
                                        		<c:forEach var ="employee" items = "${employeeService.selectByDepartmetId(department.getDepartmentId()) }">
                                        			<option value = "${employee.getEmployeeId()}">${employee.getEmployeeName() }</option>
                                        		</c:forEach>
                                        	</select>
                                        </c:forEach>
                                    </div>
                                    <div id="divoperator">
                                        <input type="button" class="clickbutton" value="&gt;" onclick="selectEmployees()"/>
                                        <input type="button" class="clickbutton" value="&lt;" onclick="deSelectEmployees()"/>
                                    </div>
                                    <div id="divto">
                                        <select id="selSelectedEmployees" name="selSelectedEmployees" multiple="true">
                                        </select>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td class="command" colspan="2">
                                    <input type="button" id="bookingbtn" class="clickbutton" value="预定会议"/>
                                    <input type="reset" class="clickbutton" value="重置"/>
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
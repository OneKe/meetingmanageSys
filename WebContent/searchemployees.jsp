<%@page import="com.chinasofti.mms.pojo.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="content-type" content="text/html" charset="utf-8">
		<title>CoolMeeting会议管理系统</title>
		<link rel="stylesheet" href="styles/common.css" />
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/searchemployees.js"></script>
		<style>
			#hidebox{
				display: none;
			}
		</style>
	</head>

	<body>
		<div class="page-header">
			<div class="header-banner">
				<img src="images/header.png" alt="CoolMeeting" />
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
						<li class="sidebar-menuitem">
							<a href="notification.action">最新通知</a>
						</li>
						<li class="sidebar-menuitem active">
							<a href="mybooking.action">我的预定</a>
						</li>
						<li class="sidebar-menuitem">
							<a href="mymeeting.action">我的会议</a>
						</li>
					</ul>
				</div>
				<div class="sidebar-menugroup">
					<div class="sidebar-grouptitle">人员管理</div>
					<ul class="sidebar-menu">
						<li class="sidebar-menuitem">
							<a href="departments.jsp">部门管理</a>
						</li>
						<li class="sidebar-menuitem">
							<a href="register.jsp">员工注册</a>
						</li>
						<li class="sidebar-menuitem">
							<a href="searchempbystatus.action">注册审批</a>
						</li>
						<li class="sidebar-menuitem">
							<a href="searchemployees.jsp">搜索员工</a>
						</li>
					</ul>
				</div>
				<div class="sidebar-menugroup">
					<div class="sidebar-grouptitle">会议预定</div>
					<ul class="sidebar-menu">
						<li class="sidebar-menuitem">
							<a href="addmeetingroom.jsp">添加会议室</a>
						</li>
						<li class="sidebar-menuitem">
							<a href="meetingrooms.jsp">查看会议室</a>
						</li>
						<li class="sidebar-menuitem">
							<a href="bookmeeting.jsp">预定会议</a>
						</li>
						<li class="sidebar-menuitem">
							<a href="searchmeetings.jsp">搜索会议</a>
						</li>
					</ul>
				</div>
			</div>
			<div class="page-content">
				<div class="content-nav">
					人员管理 > 搜索员工
				</div>
				<form action="searchemployees.action" method="post" id="searchform">
					<fieldset>
						<legend>搜索会议</legend>

						<table class="formtable">
							<tr>
								<td>姓名：</td>
								<td>
									<input type="text" id="employeename" name="employeename" maxlength="20" />
								</td>
								<td>账号名：</td>
								<td>
									<input type="text" id="accountname" name="accountname" maxlength="20" />
								</td>
								<td>状态：</td>
								<td>
									<input type="radio" name="status" value="1" checked="checked" /><label>已批准</label>
									<input type="radio" name="status" value="0" /><label>待审批</label>
									<input type="radio" name="status" value="3" /><label>已关闭</label>
								</td>
							</tr>
							<tr>
								<td colspan="6" class="command">
									<input type="button" id="submitbutton" class="clickbutton" value="查询" />
									<input type="reset" class="clickbutton" value="重置" />
								</td>
							</tr>
						</table>
					</fieldset>
				</form>
				<div>
					<h3 style="text-align:center;color:black">查询结果</h3>
					<div class="pager-header">
						<div class="header-info">
							共<span class="info-number">&nbsp; ${list.size()} &nbsp;</span>条结果， 每页显示
							<input type="text" id="pagesize" name="pagesize" style="width:25px" value="${pagesize}"> 条结果， 当前第
							<span class="info-number">${pageindex}</span>页
						</div>
						<div class="header-nav">
							<input type="button" class="clickbutton" value="首页" id="headpage" />
							<input type="button" class="clickbutton" value="上页" id="pagefront" />
							<input type="button" class="clickbutton" value="下页" id="pagenext" />
							<input type="button" class="clickbutton" value="末页" id="pageend" /> 跳到第
							<input type="text" id="pagenum" class="nav-number" />页
							<input type="button" class="clickbutton" value="跳转" id="goto" />
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
					<c:forEach var="employee" items="${list}">
						<tr id="${employee.employeeid}">
							<td>${employee.employeename}</td>
							<td>${employee.username}</td>
							<td>${employee.phone}</td>
							<td>${employee.email}</td>
							<td>
								<a class="clickbutton clickbutton1"  onclick="doclick('${employee.employeeid}')">关闭账号</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<div id="hidebox" style="width: 400px;height: 160px;background-color:lightgray;position: fixed;left: 40%;top: 200px;border-radius: 10px;border: 1px solid #A52A2A">
			<p style="width: 25px;height: 25px;border-radius: 50%;float: right;background-color: #696969;text-align: center" id="closehidebox">X</p>
			<p style="margin-top: 50px;font-size: 20px;text-align: center">请确认是否要关闭此账号？</p>
			<div id="btnplace" style="margin-top: 30px;height: 40px;left: auto;right: auto;margin-left: 50px">
				<input type="button" id="querenbtn" value="确认" style="display: inline-block; width:100px; height:40px" />
				<input type="button" id="backbtn" value="取消" style="display: inline-block; width:100px; height:40px;margin-left: 80px" />
			</div>
		</div>
		<div class="page-footer">
			<hr/> 更多问题，欢迎联系
			<a href="mailto:webmaster@eeg.com">管理员</a>
			<img src="images/footer.png" alt="CoolMeeting" />
		</div>
	</body>
	<script>
		var myid;
			
// 		$(".clickbutton1").click(function() {
// 			$("#hidebox").show();
// 		});
		function doclick(id){
			$("#hidebox").show();
			myid = id;
		}
			
		$("#closehidebox").click(function() {
			$("#hidebox").hide();
		});
	
		$("#backbtn").click(function() {
			$("#hidebox").hide();
		});
		
		$("#querenbtn").click(function(){
			alert(myid);
			$("#hidebox").hide();
			$.ajax({
				type:"post",
				url:"closeemployee.action",
				async:true,
				data:{id:myid},
				success:function(data){
					//alert($("#myid"));
					
				
				$("#"+myid).remove();
				window.location.reload();
				
				}
			});
			//window.location.href = "closeemployee.action?employeeid=${employee.employeeid}";
		});
	</script>

</html>
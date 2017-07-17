$(document).ready(function(){
	var employeename = $("#employeename").val();
	var accountname= $("#accountname").val();
	var status = $("[checked='checked']").val();
	var pageindex = 1;
	var pagesize = $("#pagesize").val();
	
	$("#submitbutton").click(function(){
		employeename = $("#employeename").val();
		accountname = $("#accountname").val();
		status = $("[checked='checked']").val();
		$("#searchform").submit();
	});
	
	$("#headpage").click(function(){
		window.location.href = "searchemployeesaction?employeename=" + employeename
		+ "accountname=" + accountname 
		+ "status=" + status
		+"pagesize=" + pagesize
		+"pageindex＝" +1;
	});
	
	
})

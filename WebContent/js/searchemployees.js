$(document).ready(function(){
	var countnum =$("#countnum").val();
	var employeename = $("#employeename").val();
	var accountname= $("#accountname").val();
	var status = $("[checked='checked']").val();
	var pageindex = 1;
	var pagesize = $("#pagesize").val();
	var pagenum = $("#pagenum").val();
	var startnum=0;
	
	$("#submitbutton").click(function(){
		employeename = $("#employeename").val();
		accountname = $("#accountname").val();
		status = $("[checked='checked']").val();
		$("#searchform").submit();
	});
	
})
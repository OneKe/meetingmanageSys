$("document").ready(function() {
	
	//判断姓名
	$("#employeename").blur(function() {
		if($("#employeename").val().trim().length == 0) {
			$("#empnamespan").show();
		} else {
			$("#empnamespan").hide();
		}
	});
	
	//判断账户名
	$("#username").blur(function(){
		if($("#username").val().trim().length==0){
			$("#usernamespan").show();
		}else{
			$("#usernamespan").hide();
			$.ajax({
				type:"post",
				url:"testusername.action",
				async:true,
				success:function(data){
					
				}
			});
		}
	});
	
	//判断密码
	$("#password").blur(function() {
		if($("#password").val().trim().length == 0) {
			$("#passwordspan").show();
		} else {
			$("#passwordspan").hide();
		}
		if($("#repassword").val().trim() != $("#password").val().trim()) {
			$("#repasswordspan").show();
		} else {
			$("#repasswordspan").hide();
		}
	});
	
	
	//判断重复密码
	$("#repassword").blur(function() {
		if($("#repassword").val().trim() != $("#password").val().trim()) {
			$("#repasswordspan").show();
		} else {
			$("#repasswordspan").hide();
		}
	});
	
	//判断联系电话
	$("#phone").blur(function() {
		if($("#phone").val().trim().length == 0) {
			$("#phonespan").show();
		} else {
			$("#phonespan").hide();
		}
	});
	
	//判断电子邮件
	$("#email").blur(function() {
		if($("#email").val().trim().length == 0) {
			$("#emailspan").show();
		} else {
			$("#emailspan").hide();
		}
	});
	
	//提交判断
	$("#register").click(function() {
		if($("#username").val().trim().length != 0
		&& $("#employeename").val().trim().length != 0 && $("#password").val().trim().length != 0
		&& $("#password").val().trim() ==  $("#repassword").val().trim() && $("#phone").val().trim().length != 0
		&& $("#repassword").val().trim().length != 0){
			$("#registerform").submit();
		}else{
			alert("请填完数据！")
		}
	});
	
	
});
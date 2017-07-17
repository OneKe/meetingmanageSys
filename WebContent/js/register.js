$("document").ready(function() {
	
	var isUsed = true;
	// 针对于username文本 做一个 blur事件
	$("#username").blur(function() {
		if($("#username").val().trim().length == 0) {
			$("#usernamespan").html("<font color = red >账户名为空！</font>");
			$("#usernamespan").show();
		} else {
			$("#usernamespan").hide();
			// 调用jquery下的ajax函数
			$.ajax({
				// 发送请求的方式 get post
				type: "get",
				// 目标资源位置
				url: "testusernameaction",
				// 默认值: true。默认设置下，所有请求均为异步请求。如果需要发送同步请求，请将此选项设置为 false。
				async: true,
				// 需要发送到服务器的数据
				data: {
					"username": $("#username").val()

				},
				// 请求成功后的回调函数。 data 为服务器返回的数据
				success: function(data) {
					var json = $.parseJSON(data);
					isUsed = Boolean(json[0].isUsed);
					var message = json[0].message;
					var fontcolor = 'green';
					if(isUsed) {
						fontcolor = 'red';
					}
					$("#usernamespan").html("<font color = " + fontcolor + " > " + message + "</font>");
					$("#usernamespan").show();
				},
				error: function(data) {
					alert("出错了！");
				}

			});
		}

	});
	
	//判断姓名
	$("#employeename").blur(function() {
		if($("#employeename").val().trim().length == 0) {
			$("#empnamespan").show();
		} else {
			$("#empnamespan").hide();
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
		if(isUsed == false && $("#username").val().trim().length != 0
		&& $("#employeename").val().trim().length != 0 && $("#password").val().trim().length != 0
		&& $("#password").val().trim() ==  $("#repassword").val().trim() && $("#phone").val().trim().length != 0
		&& $("#repassword").val().trim().length != 0){
			$("#registerform").submit();
		}
	});
	
	
});
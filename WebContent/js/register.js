$("document").ready(function() {
	var isUserN=false;
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
			$("#usernamemessage").css('display','none')
		}else{
			$("#usernamespan").hide();
			$.ajax({
				type:"post",
				url:"testusername.action?username="+$("#username").val().trim(),
				async:true,
				success:function(data){
					var json=jQuery.parseJSON(data);
					var list=json[0].i;
					console.log(list);
					var str="";
					if(list==0){
						str="<lable style='color:green;width:200px'>该账户名可以注册</lable>";
							isUserN=true
					}else{
						str="<lable style='color:red;width:200px'>数据库已存在该账户，不能重复注册</lable>";
							isUserN=false
					}
					$("#usernamemessage").show();
					$("#usernamemessage").html(str);
				},
			error:function(data){
				alert("错了");
			}
			});
		}
	});
	
	//判断密码
	$("#userpwd").blur(function() {
		if($("#userpwd").val().trim().length == 0) {
			$("#passwordspan").show();
		} else {
			$("#passwordspan").hide();
		}
		if($("#repassword").val().trim() != $("#userpwd").val().trim()) {
			$("#repasswordspan").show();
		} else {
			$("#repasswordspan").hide();
		}
	});
	
	
	//判断重复密码
	$("#repassword").blur(function() {
		if($("#repassword").val().trim() != $("#userpwd").val().trim()) {
			$("#repasswordspan").show();
		} else {
			$("#repasswordspan").hide();
		}
	});
	
	//获取部门
	$("#departmentid").click(function(){
		
	});
	
	
	//判断部门
	$("#departmentid").blur(function(){
		if($("#departmentid").val()==null){
			$.ajax({
				type:"post",
				url:"selectdpm.action",
				async:true,
				success:function(data){
					var json=jQuery.parseJSON(data);
					var list=json[0].list;
					console.log(list);
					var str="";
					for(var i in list){
						str+="<option id="+'optionid'+" value="+list[i].departmentid+">"+list[i].departmentname+"</option>";
						console.log(list[i].departmentname);
					}
					$("#departmentid").html(str)
				},
				error:function(data){
					alert("出错了");
				}
			});
		}else{
			$("#departmentidspan").hide();
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
		if(isUserN==true&&$("#username").val().trim().length != 0
		&& $("#employeename").val().trim().length != 0 && $("#userpwd").val().trim().length != 0
		&& $("#userpwd").val().trim() ==  $("#repassword").val().trim() && $("#phone").val().trim().length != 0
		&& $("#repassword").val().trim().length != 0
		&& $("#departmentid").val()!=null){
			$("#registerform").submit();
		}else{
			alert("请填完数据！")
		}
	});
	
	
});
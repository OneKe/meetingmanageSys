$("document").ready(function() {
	var isUserN=false;
	var empnamereg=/[\u4e00-\u9fa5]/;
	var isReg=false;
	//判断姓名
	$("#employeename").blur(function() {
		if($("#employeename").val().trim().length == 0) {
			$("#empnamespan").show();
			$("#empnamereg").hide();
		} else {
			$("#empnamespan").hide();
			if(!empnamereg.test($("#employeename").val())){
				$("#empnamereg").show();
				isReg=false;
			}else{
				$("#empnamereg").hide();
				isReg=true;
			}
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
	
	var pwdReg=/^[0-9a-zA-Z_#]{6,16}$/
	//判断密码
	$("#userpwd").blur(function() {
		if($("#userpwd").val().trim().length == 0) {
			$("#passwordspan").show();
			$("#pwdreg").hide();
		} else {
			$("#passwordspan").hide();
			if(!pwdReg.test($("#userpwd").val())){
				$("#pwdreg").show();
			}else{
				$("#pwdreg").hide();
			}
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
	
	
	//判断部门
	window.onload=function(){
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
					str+="<option id="+'optionid'+" value="+list[i].departmentId+">"+list[i].departmentName+"</option>";
					console.log(list[i].departmentName);
				}
				$("#departmentid").html(str)
			},
			error:function(data){
				alert("出错了");
			}
		});
	}
	
	var phoneReg=/0?(13|14|15|18)[0-9]{9}/;
	//判断联系电话
	$("#phone").blur(function() {
		if($("#phone").val().trim().length == 0) {
			$("#phonespan").show();
			$("#phonereg").hide();
		} else {
			$("#phonespan").hide();
			if(!phoneReg.test($("#phone").val())){
				$("#phonereg").show();
				isReg=false;
			}else{
				$("#phonereg").hide();
				isReg=true;
			}
		}
	});
	
	var emailReg=/\w[-\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\.)+[A-Za-z]{2,14}/;
	//判断电子邮件
	$("#email").blur(function() {
		if($("#email").val().trim().length == 0) {
			$("#emailspan").show();
			$("#emailreg").hide();
		} else {
			$("#emailspan").hide();
			if(!emailReg.test($("#email").val())){
				$("#emailreg").show();
				isReg=false;
			}else{
				$("#emailreg").hide();
				isReg=true;
			}
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
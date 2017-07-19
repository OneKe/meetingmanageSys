$("document").ready(function(){
	//验证门牌号
	$("#roomcode").blur(function(){
		if($(this).val().trim().length==0){
			$("#roomcodespan").show()
		}else{
			$("#roomcodespan").hide()
		}
	});
	
	//验证会议室名称
	$("#roomname").blur(function(){
		if($(this).val().trim().length==0){
			$("#roomnamespan").show()
		}else{
			$("#roomnamespan").hide()
		}
	});
	
	//验证最多容纳人数
	$("#roomcapacity").blur(function(){
		if($(this).val()<=0){
			$("#roomcapacityspan").show()
		}else{
			$("#roomcapacityspan").hide()
		}
	});
	
	//表单提交
	$("#addsubmit").click(function(){
		if($("#roomcode").val().trim().length!=0&&$("#roomname").val().trim().length!=0&&$("#roomcapacity").val()>0){
			$("#addmeetingroomform").submit()
		}else{
			alert("请填全数据！")
		}
	})
})
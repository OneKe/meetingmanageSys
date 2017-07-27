$("document").ready(function() {
	$("#reservefromdate").blur(function(){
		if($("#reservetodate").val()==0||($("#reservefromdate").val()>$("#reservetodate").val())){
			$("#reservetodate").val($("#reservefromdate").val());
		}
	})
	
	$("#reservetodate").blur(function(){
		if($("#reservefromdate").val()==0||($("#reservetodate").val()<$("#reservefromdate").val())){
			$("#reservefromdate").val($("#reservetodate").val());
		}
	})
	
	$("#meetingfromdate").blur(function(){
		if($("#meetingtodate").val()==0||($("#meetingfromdate").val()>$("#meetingtodate").val())){
			$("#meetingtodate").val($("#meetingfromdate").val());
		}
	})
	
	$("#meetingtodate").blur(function(){
		if($("#meetingfromdate").val()==0||($("#meetingtodate").val()<$("#meetingfromdate").val())){
			$("#meetingfromdate").val($("#meetingtodate").val());
		}
	})
	
	var pagesize=5;
	var begin=0;
	var count=0;
	var page=parseInt($("#page").text());
	//搜索会议信息
	$("#querymeet").click(function() {
		$.ajax({
			type: "post",
			url: "searchmeeting.action",
			async: true,
			data: {
				meetingname: $("#meetingname").val(),
				roomname: $("#roomname").val(),
				reservername: $("#reservername").val(),
				reservefromdate: $("#reservefromdate").val(),
				reservetodate: $("#reservetodate").val(),
				meetingfromdate: $("#meetingfromdate").val(),
				meetingtodate: $("#meetingtodate").val(),
				pagesize:pagesize,
				begin:begin
			},
			success: function(data) {
				var json = jQuery.parseJSON(data);
				var list = json[0].list;
				count=json[0].count;
				var str = "";
				for(var i in list) {
					str += "<tr><td>" + list[i].MeetingName + "</td><td>" + list[i].RoomName + "</td><td>" + stringTodate(list[i].BeginTime)+ "</td><td>" + stringTodate(list[i].EndTime) + "</td><td>" + stringTodate(list[i].ReservationTime) + "</td><td>" + list[i].EmployeeName + "</td><td><a class='clickbutton' href='querymeetingdetails.action?meetingid="+list[i].meetingid+"'>查看详情</a></td></tr>";
				}
				$("#count").html(count);
				if(count%5==0){
					$("#disnum").html(parseInt(count/pagesize));
				}else{
					$("#disnum").html(parseInt(count/pagesize+1));
				}
				$("#qmt").html(str);
			},
			error: function(data) {
				alert("错了")
			}
		});
	});
	
	//下一页
	$("#nextpage").click(function(){
		if(begin<count&&(begin+pagesize)<count){
		begin+=pagesize;
			page+=1;
		$.ajax({
			type: "post",
			url: "searchmeeting.action",
			async: true,
			data: {
				meetingname: $("#meetingname").val(),
				roomname: $("#roomname").val(),
				reservername: $("#reservername").val(),
				reservefromdate: $("#reservefromdate").val(),
				reservetodate: $("#reservetodate").val(),
				meetingfromdate: $("#meetingfromdate").val(),
				meetingtodate: $("#meetingtodate").val(),
				pagesize:pagesize,
				begin:begin
			},
			success: function(data) {
				var json = jQuery.parseJSON(data);
				var list = json[0].list;
				var count=json[0].count;
				var str = "";
				for(var i in list) {
					str += "<tr><td>" + list[i].MeetingName + "</td><td>" + list[i].RoomName + "</td><td>" + stringTodate(list[i].BeginTime)+ "</td><td>" + stringTodate(list[i].EndTime) + "</td><td>" + stringTodate(list[i].ReservationTime) + "</td><td>" + list[i].EmployeeName + "</td><td><a class='clickbutton' href='querymeetingdetails.action?meetingid="+list[i].meetingid+"'>查看详情</a></td></tr>";
				}
				$("#qmt").html(str);
				$("#page").html(page);
			},
			error: function(data) {
				alert("错了")
			}
		});
		}
	});
	
	//上一页
	$("#lastpage").click(function(){
		if(begin>0){
		begin-=pagesize;
		page-=1;
		$.ajax({
			type: "post",
			url: "searchmeeting.action",
			async: true,
			data: {
				meetingname: $("#meetingname").val(),
				roomname: $("#roomname").val(),
				reservername: $("#reservername").val(),
				reservefromdate: $("#reservefromdate").val(),
				reservetodate: $("#reservetodate").val(),
				meetingfromdate: $("#meetingfromdate").val(),
				meetingtodate: $("#meetingtodate").val(),
				pagesize:pagesize,
				begin:begin
			},
			success: function(data) {
				var json = jQuery.parseJSON(data);
				var list = json[0].list;
				var count=json[0].count;
				var str = "";
				for(var i in list) {
					str += "<tr><td>" + list[i].MeetingName + "</td><td>" + list[i].RoomName + "</td><td>" + stringTodate(list[i].BeginTime)+ "</td><td>" + stringTodate(list[i].EndTime) + "</td><td>" + stringTodate(list[i].ReservationTime) + "</td><td>" + list[i].EmployeeName + "</td><td><a class='clickbutton' href='querymeetingdetails.action?meetingid="+list[i].meetingid+"'>查看详情</a></td></tr>";
				}
				$("#qmt").html(str);
				$("#page").html(page);
			},
			error: function(data) {
				alert("错了")
			}
		});
		}
	});
	
	//首页
	$("#homepage").click(function(){
		begin=0;
		page=1;
		$.ajax({
			type: "post",
			url: "searchmeeting.action",
			async: true,
			data: {
				meetingname: $("#meetingname").val(),
				roomname: $("#roomname").val(),
				reservername: $("#reservername").val(),
				reservefromdate: $("#reservefromdate").val(),
				reservetodate: $("#reservetodate").val(),
				meetingfromdate: $("#meetingfromdate").val(),
				meetingtodate: $("#meetingtodate").val(),
				pagesize:pagesize,
				begin:begin
			},
			success: function(data) {
				var json = jQuery.parseJSON(data);
				var list = json[0].list;
				var count=json[0].count;
				var str = "";
				for(var i in list) {
					str += "<tr><td>" + list[i].MeetingName + "</td><td>" + list[i].RoomName + "</td><td>" + stringTodate(list[i].BeginTime)+ "</td><td>" + stringTodate(list[i].EndTime) + "</td><td>" + stringTodate(list[i].ReservationTime) + "</td><td>" + list[i].EmployeeName + "</td><td><a class='clickbutton' href='querymeetingdetails.action?meetingid="+list[i].meetingid+"'>查看详情</a></td></tr>";
				}
				$("#qmt").html(str);
				$("#page").html(page);
			},
			error: function(data) {
				alert("错了")
			}
		});
	});
	
	//末页
	$("#endpage").click(function(){
		if(count%pagesize==0){
			begin=pagesize*(parseInt(count/pagesize)-1);
		}else{
			begin=pagesize*(parseInt(count/pagesize));
		}
		page=parseInt($("#disnum").text());
		$.ajax({
			type: "post",
			url: "searchmeeting.action",
			async: true,
			data: {
				meetingname: $("#meetingname").val(),
				roomname: $("#roomname").val(),
				reservername: $("#reservername").val(),
				reservefromdate: $("#reservefromdate").val(),
				reservetodate: $("#reservetodate").val(),
				meetingfromdate: $("#meetingfromdate").val(),
				meetingtodate: $("#meetingtodate").val(),
				pagesize:pagesize,
				begin:begin
			},
			success: function(data) {
				var json = jQuery.parseJSON(data);
				var list = json[0].list;
				var count=json[0].count;
				var str = "";
				for(var i in list) {
					str += "<tr><td>" + list[i].MeetingName + "</td><td>" + list[i].RoomName + "</td><td>" + stringTodate(list[i].BeginTime)+ "</td><td>" + stringTodate(list[i].EndTime) + "</td><td>" + stringTodate(list[i].ReservationTime) + "</td><td>" + list[i].EmployeeName + "</td><td><a class='clickbutton' href='querymeetingdetails.action?meetingid="+list[i].meetingid+"'>查看详情</a></td></tr>";
				}
				$("#qmt").html(str);
				$("#page").html(page);
			},
			error: function(data) {
				alert("错了")
			}
		});
	})
	
	//跳转
	$("#skip").click(function(){
		if($("#pagenum").val()>0&&$("#pagenum").val()<=$("#disnum").text()){
			begin=($("#pagenum").val()-1)*pagesize;
			page=$("#pagenum").val();
			$.ajax({
				type: "post",
				url: "searchmeeting.action",
				async: true,
				data: {
					meetingname: $("#meetingname").val(),
					roomname: $("#roomname").val(),
					reservername: $("#reservername").val(),
					reservefromdate: $("#reservefromdate").val(),
					reservetodate: $("#reservetodate").val(),
					meetingfromdate: $("#meetingfromdate").val(),
					meetingtodate: $("#meetingtodate").val(),
					pagesize:pagesize,
					begin:begin
				},
				success: function(data) {
					var json = jQuery.parseJSON(data);
					var list = json[0].list;
					var count=json[0].count;
					var str = "";
					for(var i in list) {
						str += "<tr><td>" + list[i].MeetingName + "</td><td>" + list[i].RoomName + "</td><td>" + stringTodate(list[i].BeginTime)+ "</td><td>" + stringTodate(list[i].EndTime) + "</td><td>" + stringTodate(list[i].ReservationTime) + "</td><td>" + list[i].EmployeeName + "</td><td><a class='clickbutton' href='querymeetingdetails.action?meetingid="+list[i].meetingid+"'>查看详情</a></td></tr>";
					}
					$("#qmt").html(str);
					$("#page").html(page);
				},
				error: function(data) {
					alert("错了")
				}
			});
		}
	})
	
	 function stringTodate(fdate){
		 var format=new Date(fdate);
		 var year=format.getFullYear();//当前年份
		 var month=format.getMonth() +1;//当前月份
		 if(month>=10){
			 month=month;
		 }else{
			 month='0'+month;
		 }
		 var day = format.getDate();//当前日
		 if(day>=10){
			 day=day;
		 }else{
			 day='0'+day;
		 }
		 var hours=format.getHours(); //获取当前小时数(0-23)
		 if(hours>=10){
			 hours=hours;
		 }else{
			 hours='0'+hours;
		 }
		 var minutes=format.getMinutes();     //获取当前分钟数(0-59)
		 if(minutes>=10){
			 minutes=minutes;
		 }else{
			 minutes='0'+minutes;
		 }
		 var seconds=format.getSeconds();     //获取当前秒数(0-59)
		 if(seconds>=10){
			 seconds=seconds;
		 }else{
			 seconds='0'+seconds;
		 }
		 return year+'-'+month+'-'+day+' '+hours+':'+minutes+':'+seconds;
	 }
})



$("document").ready(function() {
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
				meetingtodate: $("#meetingtodate").val()
			},
			success: function(data) {
				var json = jQuery.parseJSON(data);
				var list = json[0].list;
				var str = "";
				for(var i in list) {
					str += "<tr><td>" + list[i].MeetingName + "</td><td>" + list[i].RoomName + "</td><td>" + formatdate(list[i].BeginTime)+ "</td><td>" + list[i].EndTime + "</td><td>" + list[i].ReservationTime + "</td><td>" + list[i].EmployeeName + "</td><td><a class='clickbutton' href='meetingdetails.action'>查看详情</a></td></tr>";
					console.log(list[i].MeetingName);
				}
				$("#qmt").html(str);
			},
			error: function(data) {
				alert("错了")
			}
		});
	});
	
	 function formatdate(format) {
		 var fmt=new Date(format);
	    var date = {
	        "M+": fmt.getMonth() + 1,
	        "d+": fmt.getDate(),
	        "h+": fmt.getHours(),
	        "m+": fmt.getMinutes(),
	        "s+": fmt.getSeconds(),
	        "q+": Math.floor((fmt.getMonth() + 3) / 3),
	        "S+": fmt.getMilliseconds()
	    };
	     
	    if (/(y+)/i.test(format)) {
	        format = format.replace(RegExp.$1, (fmt.getFullYear() + '').substr(4 - RegExp.$1.length));
	    }
	 
	    for (var k in date) {
	        if (new RegExp("(" + k + ")").test(format)) {
	          format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? date[k] : ("00" + date[k]).substr(("" + date[k]).length));
	        }
	    }
	     
	    return format;
	}
})



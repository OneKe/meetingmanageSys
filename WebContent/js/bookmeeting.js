$("document").ready(function() {
	$("#selDepartments").change(function(){
		$.ajax({
			type: "post",
			url: "queryemplbydpid.action",
			data: {
				departmentid: $("#selDepartments").val()
			},
			async: true,
			success:function(data){
				var json=jQuery.parseJSON(data);
				var list=json[0].elist;
				var str="";
				for(var i in list){
					str+="<option value="+list[i].employeeid+">"+list[i].employeename+"</option>"
				}
				$("#selemployees").html(str);
			},
			error:function(data){
				alert("出错了");
			}
		});
	});
	
	window.onload=function(){
		$.ajax({
			type:"post",
			url:"queryemplbydpid.action",
			data: {
				departmentid: 1
			},
			async:true,
			success:function(data){
				var json=jQuery.parseJSON(data);
				var list=json[0].elist;
				var str="";
				for(var i in list){
					str+="<option value="+list[i].employeeid+">"+list[i].employeename+"</option>"
				}
				$("#selemployees").html(str);
			},
			error:function(data){
				alert("出错了");
			}
		});
	};
	
	//select 添加单个
	$('.btn-add').on('click', function() {
		var leftOption = $("#selemployees option:selected");
		addOptionList(leftOption);
	});
	// select 添加所有
	$('.btn-add-all').on('click', function() {
		removeall();
		var leftOption = $("#selemployees option");
		addOptionList(leftOption);
	});
	// select 移除单个
	$('.btn-remove').on('click', function() {
		$('#selSelectedEmployees').find('option:selected').remove();

	});
	// select 移除所有
	$('.btn-remove-all').on('click', function() {
		removeall();
	});
	function removeall() {
		$('#selSelectedEmployees').find('option').remove();
	};
	function addOptionList(leftOption) {
		var rightOption = $("#selSelectedEmployees option");
		for (var i = 0; i < leftOption.length; i++) {
			var leftText = leftOption.eq(i).text();
			var leftValue = leftOption.eq(i).val();
			for (var h = 0; h < rightOption.length; h++) {
				if (rightOption.eq(h).val() == leftValue) {
					return;
				}
			}
			var option = $('<option value="'+leftValue+'">' + leftText + '</option>');
			$('#selSelectedEmployees').append(option);
		}
	};
	
	//会议提交
	$("#bookingbtn").click(function(){
		var rightOption = $("#selSelectedEmployees option");
		var arr=[];
		for(var h = 0; h < rightOption.length; h++){
			arr.push({employeeid:rightOption.eq(h).val()});
		};
		alert(arr);
		$.ajax({
			type: "post",
			url: "bookingmeeting.action",
			data: {
				"employeeids":arr
			},
			async: true,
			
		});
		
	});
	
})

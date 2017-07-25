var isexist = false;

$("document")
		.ready(
				function() {
					window.onload = function() {
						$
								.ajax({
									type : "post",
									url : "queryAllDepartment.action",
									async : true,
									success : function(data) {
										var json = jQuery.parseJSON(data);
										var list = json[0].list;
										var str = "";
										for ( var i in list) {
											str += "<tr><td><span>"
													+ list[i].departmentId
													+ "</span></td><td><span id='"
													+ list[i].departmentId
													+ "namespan'>"
													+ list[i].departmentName
													+ "</span><input type='text' style='display:none' id='"
													+ list[i].departmentId
													+ "nametext' value='"
													+ list[i].departmentName
													+ "'/></td><td><label id='"
													+ list[i].departmentId
													+ "remarkspan'>"
													+ list[i].remark
													+ "</label><input type='text' style='display:none' id='"
													+ list[i].departmentId
													+ "remarktext' value='"
													+ list[i].remark
													+ "'/></td>"
													+ "<td style='width:150px'><input type='button' class='clickbutton' onclick='editclick("
													+ list[i].departmentId
													+ ")' id = '"
													+ list[i].departmentId
													+ "editbtn' value='编辑'/> <input type='button'  class='clickbutton' onclick='editconfirmclick("
													+ list[i].departmentId
													+ ")' id = '"
													+ list[i].departmentId
													+ "editconfirmbtn' style='display:none' value='确认'>"
													+ "<input type='button'  class='clickbutton' onclick='editcancelclick("
													+ list[i].departmentId
													+ ")' id = '"
													+ list[i].departmentId
													+ "editcancelbtn' style='display:none' value='取消'><input type='button'  class='clickbutton' onclick='deleteclick("
													+ list[i].departmentId
													+ ")' id = '"
													+ list[i].departmentId
													+ "deletebtn' value='删除'></td></tr>"
										}
										$("#listtable").html(str);
									}
								})
					}

					// 根据部门名查询部门
					$("#departmentname")
							.blur(
									function() {
										if ($(this).val().trim().length > 0) {
											$
													.ajax({
														type : "post",
														url : "querydepartbyname.action",
														data : {
															departmentname : $(
																	this).val()
														},
														async : true,
														success : function(data) {
															if (data == 0) {
																isexist = true;
																$("#testnamespan").hide();
																$("#departmentnamespan").hide();
															} else {
																isexist = false;
																$("#testnamespan").html("该部门名称已存在，不能重复添加！");
																$("#testnamespan").show();
																$("#departmentnamespan").hide();
															}
														}
													});
										} else {
											$("#departmentnamespan").show();
											$("#testnamespan").hide();
										}
									})
						// 添加部门
					$("#adddepartmentformbutton").click(function() {
						if($("#departmentname").val().trim().length = 0){
							$("#departmentnamespan").show();
						}else if(isexist == false){
							$("#departmentnamespan").hide();
							$("#testnamespan").show();
						}else{
							$("#departmentnamespan").hide();
							$("#testnamespan").hide();
							if (confirm("确定要添加该部门名？")) {
								$("#adddepartmentform").submit();
							}
						}
					})

				})

// 编辑按钮操作
function editclick(id) {
	$("#" + id + "namespan").hide();
	$("#" + id + "nametext").show();
	$("#" + id + "remarkspan").hide();
	$("#" + id + "remarktext").show();
	$("#" + id + "editbtn").hide();
	$("#" + id + "editconfirmbtn").show();
	$("#" + id + "editcancelbtn").show();
	$("#" + id + "deletebtn").hide();
}

// 取消按钮操作
function editcancelclick(id) {
	$("#" + id + "namespan").show();
	$("#" + id + "nametext").hide();
	$("#" + id + "remarkspan").show();
	$("#" + id + "remarktext").hide();
	$("#" + id + "editbtn").show();
	$("#" + id + "editconfirmbtn").hide();
	$("#" + id + "editcancelbtn").hide();
	$("#" + id + "deletebtn").show();
}

// 确认按钮操作
function editconfirmclick(id) {
	if (confirm("确定要修改该数据吗？")) {
		$.ajax({
			type : "post",
			url : "editdepartment.action",
			data : {
				departmentid : id,
				departmentname : $("#" + id + "nametext").val(),
				remark : $("#" + id + "remarktext").val()
			},
			async : true,
			success : function(data) {
				if (data > 0) {
					$("#" + id + "namespan").html(
							$("#" + id + "nametext").val());
					$("#" + id + "remarkspan").html(
							$("#" + id + "remarktext").val());
					alert("修改成功！");
				} else {
					alert("修改失败！");
				}
			}
		});
	}
	$("#" + id + "namespan").show();
	$("#" + id + "nametext").hide();
	$("#" + id + "remarkspan").show();
	$("#" + id + "remarktext").hide();
	$("#" + id + "editbtn").show();
	$("#" + id + "editconfirmbtn").hide();
	$("#" + id + "editcancelbtn").hide();
	$("#" + id + "deletebtn").show();
}

// 删除按钮操作
function deleteclick(id) {
	if (confirm("确定要删除该数据吗？")) {
		$.ajax({
			type : "post",
			url : "deletedepartment.action",
			data : {
				departmentid : id
			},
			async : true,
			success : function(data) {
				if (data > 0) {
					$("#" + id + "deletebtn").parent().parent().remove();
					alert("删除成功！")
				}
			}
		});
	}
}

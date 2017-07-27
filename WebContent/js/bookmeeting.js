$("document")
		.ready(
				function() {
					// 预计会议时间
					$("#startdatetime")
							.blur(
									function() {
										if ($("#startdatetime").val() < stringTodate()) {
											alert("预计开始时间不能小于当前时间！");
											$("#startdatetime").val(
													stringTodate());
										}
										if ($("#enddatetime").val() == 0
												|| ($("#enddatetime").val() < $(
														"#startdatetime").val())) {
											$("#enddatetime").val(
													$("#startdatetime").val())
										}
									});

					$("#enddatetime").blur(
							function() {
								if ($("#enddatetime").val() < stringTodate()) {
									alert("预计结束时间不能小于当前时间！");
									$("#enddatetime").val(stringTodate());
								}
								if ($("#startdatetime").val() == 0
										|| ($("#startdatetime").val() > $(
												"#enddatetime").val())) {
									$("#startdatetime").val(
											$("#enddatetime").val())
								}

							});

					// 获取当前时间
					function stringTodate() {
						var format = new Date();
						var year = format.getFullYear();// 当前年份
						var month = format.getMonth() + 1;// 当前月份
						if (month >= 10) {
							month = month;
						} else {
							month = '0' + month;
						}
						var day = format.getDate();// 当前日
						if (day >= 10) {
							day = day;
						} else {
							day = '0' + day;
						}
						var hours = format.getHours(); // 获取当前小时数(0-23)
						if (hours >= 10) {
							hours = hours;
						} else {
							hours = '0' + hours;
						}
						var minutes = format.getMinutes(); // 获取当前分钟数(0-59)
						if (minutes >= 10) {
							minutes = minutes;
						} else {
							minutes = '0' + minutes;
						}
						var seconds = format.getSeconds(); // 获取当前秒数(0-59)
						if (seconds >= 10) {
							seconds = seconds;
						} else {
							seconds = '0' + seconds;
						}
						return year + '-' + month + '-' + day + 'T' + hours
								+ ':' + minutes;
					}

					var isnum = false;
					// 测试参加人数
					$("#numofparticipants").blur(
							function() {
								var num = parseInt($("#roomid option:selected")
										.text().replace(/[^0-9]/ig, ""))
								if ($(this).val() > num) {
									$("#numtest").show();
									isnum = false;
								} else {
									$("#numtest").hide();
									isnum = true;
								}
							})

					$("#selDepartments").change(
							function() {
								$.ajax({
									type : "post",
									url : "queryemplbydpid.action",
									data : {
										departmentid : $("#selDepartments")
												.val()
									},
									async : true,
									success : function(data) {
										var json = jQuery.parseJSON(data);
										var list = json[0].elist;
										var str = "";
										for ( var i in list) {
											str += "<option value="
													+ list[i].employeeid + ">"
													+ list[i].employeename
													+ "</option>"
										}
										$("#selemployees").html(str);
									},
									error : function(data) {
										alert("出错了");
									}
								});
							});

					window.onload = function() {
						$.ajax({
							type : "post",
							url : "queryemplbydpid.action",
							data : {
								departmentid : 1
							},
							async : true,
							success : function(data) {
								var json = jQuery.parseJSON(data);
								var list = json[0].elist;
								var rlist = json[1].rlist;
								var dlist = json[2].dlist;
								var str = "";
								var rstr = "";
								var dstr = "";
								for ( var i in list) {
									str += "<option value="
											+ list[i].employeeid + ">"
											+ list[i].employeename
											+ "</option>"
								}
								for ( var i in rlist) {
									rstr += "<option value=" + rlist[i].roomid
											+ ">" + rlist[i].roomname + '容量：'
											+ rlist[i].roomcapacity + '人'
											+ "</option>"
								}
								for ( var i in dlist) {
									dstr += "<option value="
											+ dlist[i].departmentId + ">"
											+ dlist[i].departmentName
											+ "</option>"
								}
								$("#selemployees").html(str);
								$("#roomid").html(rstr);
								$("#selDepartments").html(dstr);
							},
							error : function(data) {
								alert("出错了");
							}
						});
					};

					// select 添加单个
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
					$('.btn-remove').on(
							'click',
							function() {
								$('#selSelectedEmployees').find(
										'option:selected').remove();

							});
					// select 移除所有
					$('.btn-remove-all').on('click', function() {
						removeall();
					});
					function removeall() {
						$('#selSelectedEmployees').find('option').remove();
					}
					;
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
							var option = $('<option value="' + leftValue + '">'
									+ leftText + '</option>');
							$('#selSelectedEmployees').append(option);
						}
					}
					;

					// 会议提交
					$("#bookingbtn")
							.click(
									function() {
										if ($("#meetingname").trim().val().length > 0
												&& $("#numofparticipants")
														.val() > 0
												&& $("#startdatetime").val() > 0
												&& $("#enddatetime").val() > 0) {
											var rightOption = $("#selSelectedEmployees option");
											var roomoption = $("#roomid option:selected");
											var arr = [];
											for (var h = 0; h < rightOption.length; h++) {
												arr.push({
													employeeid : rightOption
															.eq(h).val()
												});
											}
											;
											$
													.ajax({
														type : "post",
														url : "bookingmeeting.action",
														dataType : "json",
														data : {
															meetingname : $(
																	"#meetingname")
																	.val(),
															numofparticipants : $(
																	"#numofparticipants")
																	.val(),
															roomid : roomoption
																	.val(),
															startdatetime : $(
																	"#startdatetime")
																	.val(),
															enddatetime : $(
																	"#enddatetime")
																	.val(),
															description : $(
																	"#description")
																	.val(),
															employeeids : JSON
																	.stringify(arr)
														},
														async : true,
														success : function(
																result) {
															if (result == true) {
																location.href = "searchmeetings.jsp"
															}
														},
														error : function(result) {
															alert("错了！");
														}

													});
										} else {
											alert("请填完数据")
										}
									});

				})
				
function operate() {
	return stringTodate2();
}

//获取当前时间
function stringTodate2() {
	var format = new Date();
	var year = format.getFullYear();// 当前年份
	var month = format.getMonth() + 1;// 当前月份
	if (month >= 10) {
		month = month;
	} else {
		month = '0' + month;
	}
	var day = format.getDate();// 当前日
	if (day >= 10) {
		day = day;
	} else {
		day = '0' + day;
	}
	var hours = format.getHours(); // 获取当前小时数(0-23)
	if (hours >= 10) {
		hours = hours;
	} else {
		hours = '0' + hours;
	}
	var minutes = format.getMinutes(); // 获取当前分钟数(0-59)
	if (minutes >= 10) {
		minutes = minutes;
	} else {
		minutes = '0' + minutes;
	}
	var seconds = format.getSeconds(); // 获取当前秒数(0-59)
	if (seconds >= 10) {
		seconds = seconds;
	} else {
		seconds = '0' + seconds;
	}
	return year + '-' + month + '-' + day + 'T' + hours
			+ ':' + minutes;
}

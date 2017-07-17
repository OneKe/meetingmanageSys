$("document").ready(function(){
	$("#adddepartmentformbutton").click(function(){
		if($("#departmentname").val().trim().length != 0){
			$("#departmentnamespan").hide();
			$("#adddepartmentform").submit();
		}else{
			$("#departmentnamespan").show();
		}
	});
});

//编辑按钮
function editclick(id){
	//显示编辑确认、取消按钮
	$( "#"+ id + "editconfirmbtn").show();
	$("#"+ id + "editcancelbtn" ).show();
	//隐藏删除确认、取消按钮
	$("#"+ id + "deleteconfirmbtn" ).hide();
	$("#"+ id + "deletecancelbtn" ).hide();
	//隐藏文字
	$("#" + id + "namespan").hide();
	$("#" + id + "remarkspan").hide();
	//显示编辑框
	$("#" + id + "nametext").show();
	$("#" + id + "remarktext").show();
}

//编辑确认按钮
function editconfirmclick(id){
	$("#" + id + "form").submit();
}

function editcancelclick(id){
	//隐藏编辑确认、取消按钮
	$( "#"+ id + "editconfirmbtn").hide();
	$("#"+ id + "editcancelbtn" ).hide();
	
	//显示文字
	$("#" + id + "namespan").show();
	$("#" + id + "remarkspan").show();
	//显示编辑框
	$("#" + id + "nametext").hide();
	$("#" + id + "remarktext").hide();
}

//删除按钮
function deleteclick(id){
	//显示删除确认、取消按钮
	$("#"+ id + "deleteconfirmbtn" ).show();
	$("#"+ id + "deletecancelbtn" ).show();
	//隐藏编辑确认、取消按钮
	$( "#"+ id + "editconfirmbtn").hide();
	$("#"+ id + "editcancelbtn" ).hide();
}

//删除确认按钮
//function deleteconfirmclick(id){
//	//隐藏删除确认、取消按钮
//	$("#"+ id + "deleteconfirmbtn" ).hide();
//	$("#"+ id + "deletecancelbtn" ).hide();
//	$.ajax({
//		type:"get",
//		url:"/mms/removedepartmentaction?departmentid=" + id,
//		async:false
//	});
////	window.location("/mms/removedepartmentaction?departmentid=" + id);
//	
//}


//删除取消按钮
function deletecancelclick(id){
	//隐藏删除确认、取消按钮
	$("#"+ id + "deleteconfirmbtn" ).hide();
	$("#"+ id + "deletecancelbtn" ).hide();
}





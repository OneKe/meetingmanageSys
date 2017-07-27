$("document").ready(function(){
	checkroleid();
})

function checkroleid() {
	if($("#labelusername").text()==""){
		window.location.href="beforelogin.jsp";
	}
	if($("#roleid").text()==2){
		$(".checkroleid").attr("href","javascript:return false;");
	}
}
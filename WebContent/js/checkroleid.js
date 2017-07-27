$("document").ready(function(){
	checkroleid();
})

function checkroleid() {
	if($("#roleid").text()==2){
		$(".checkroleid").attr("href","javascript:return false;");
	}
}
$(window).ready(function(){
	$("#bookingbtn").click(function(){
		var  selectemployee = document.getElementById("selSelectedEmployees");
		for(var  i  =0 ; i< selectemployee.options.length; i++){
			selectemployee.options[i].selected = true;
		}
		$("#bookingmeetingform").submit();
	});
});

var selDepartments ;
var Departmentsindex;
var Departmentsvalue;

var selEmployees ;
var Employeesindex;
var Employeesvalue;
var Employeestext;

function changeemployees(){
	selDepartments = document.getElementById("selDepartments");
	Departmentsindex  = selDepartments.selectedIndex;
	Departmentsvalue = selDepartments.options[Departmentsindex].value; 
	$(".selEmployees").hide();
	$("#sel" + Departmentsvalue + "Employees").show();
}

function selectEmployees(){
	selEmployees = document.getElementById("sel"+ Departmentsvalue + "Employees");
	Employeesindex = selEmployees.selectedIndex;
	Employeesvalue = selEmployees.options[Employeesindex].value; 
	Employeestext = selEmployees.options[Employeesindex].text;
	
	var selSelectedEmployees = document.getElementById("selSelectedEmployees");
	var opt = document.createElement("option");
	opt.value = Employeesvalue;
	opt.text = Employeestext;
	selSelectedEmployees.appendChild(opt);
	
}

function deSelectEmployees(){
	var selSelectedEmployees = document.getElementById("selSelectedEmployees");
}


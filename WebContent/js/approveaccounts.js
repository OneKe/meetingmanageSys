function check(id) {
	if (confirm("确定审核通过该员工？") == true) {
		 window.location.href = "approveaccounts.action?employeeid=" + id;
	}
}

function remove(id) {
	if (confirm("确定要删除这条信息？") == true) {
		 window.location.href = "removeaccounts.action?employeeid=" + id;
	}
}

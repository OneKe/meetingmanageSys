package com.chinasofti.mms.pojo;

public class Employee {
	private Integer employeeid;

	private String employeename;

	private String username;

	private String userpwd;

	private String phone;

	private String email;

	private Integer departmentid;

	private Integer roleid;

	private Integer employeestatus;

	private String remark;

	public Integer getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename == null ? null : employeename.trim();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd == null ? null : userpwd.trim();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public Integer getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(Integer departmentid) {
		this.departmentid = departmentid;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public Integer getEmployeestatus() {
		return employeestatus;
	}

	public void setEmployeestatus(Integer employeestatus) {
		this.employeestatus = employeestatus;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	@Override
	public String toString() {
		return "Employee [employeeid=" + employeeid + ", employeename=" + employeename + ", username=" + username
				+ ", userpwd=" + userpwd + ", phone=" + phone + ", email=" + email + ", departmentid=" + departmentid
				+ ", roleid=" + roleid + ", employeestatus=" + employeestatus + ", remark=" + remark + "]";
	}

}
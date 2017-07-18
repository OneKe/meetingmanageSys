package com.chinasofti.mms.pojo;

public class Employee {
	private String employeeid;//员工ID

	private String employeename;//员工姓名

	private String username;//账号名

	private String userpwd;//密码

	private String phone;//联系电话

	private String email;//电子邮箱

	private String departmentid;//部门ID

	private String roleid;//员工角色，1表示管理员，2表示普通用户

	private Integer employeestatus;//员工状态，0表示待审核，1表示已审核，2表示审核未通过，3表示被关闭，默认为待审核

	private String remark;//备注
	
	public String getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(String employeeid) {
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

	public String getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(String departmentid) {
		this.departmentid = departmentid;
	}

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
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
	
	//无参构造方法
	public Employee() {
		
	}
	
	public Employee(String username, String userpwd) {
		this.username = username;
		this.userpwd = userpwd;
	}
	
	public Employee(String employeeid, String employeename, String username, String userpwd, String phone,
			String email, String departmentid, String roleid, Integer employeestatus) {
		this.employeeid = employeeid;
		this.employeename = employeename;
		this.username = username;
		this.userpwd = userpwd;
		this.phone = phone;
		this.email = email;
		this.departmentid = departmentid;
		this.roleid = roleid;
		this.employeestatus = employeestatus;
	}
	
	public Employee(String employeeid, String employeename, String username, String userpwd, String phone,
			String email, String departmentid, String roleid, Integer employeestatus, String remark) {
		this.employeeid = employeeid;
		this.employeename = employeename;
		this.username = username;
		this.userpwd = userpwd;
		this.phone = phone;
		this.email = email;
		this.departmentid = departmentid;
		this.roleid = roleid;
		this.employeestatus = employeestatus;
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Employee [employeeid=" + employeeid + ", employeename=" + employeename + ", username=" + username
				+ ", userpwd=" + userpwd + ", phone=" + phone + ", email=" + email + ", departmentid=" + departmentid
				+ ", roleid=" + roleid + ", employeestatus=" + employeestatus + ", remark=" + remark + "]";
	}

}
package com.chinasofti.mms.pojo;

public class Employee {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.EmployeeId
     *
     * @mbg.generated Mon Jul 17 14:31:42 CST 2017
     */
    private Integer employeeid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.EmployeeName
     *
     * @mbg.generated Mon Jul 17 14:31:42 CST 2017
     */
    private String employeename;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.UserName
     *
     * @mbg.generated Mon Jul 17 14:31:42 CST 2017
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.UserPwd
     *
     * @mbg.generated Mon Jul 17 14:31:42 CST 2017
     */
    private String userpwd;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.Phone
     *
     * @mbg.generated Mon Jul 17 14:31:42 CST 2017
     */
    private String phone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.Email
     *
     * @mbg.generated Mon Jul 17 14:31:42 CST 2017
     */
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.DepartmentId
     *
     * @mbg.generated Mon Jul 17 14:31:42 CST 2017
     */
    private Integer departmentid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.Roleid
     *
     * @mbg.generated Mon Jul 17 14:31:42 CST 2017
     */
    private Integer roleid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.EmployeeStatus
     *
     * @mbg.generated Mon Jul 17 14:31:42 CST 2017
     */
    private Integer employeestatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.Remark
     *
     * @mbg.generated Mon Jul 17 14:31:42 CST 2017
     */
    private String remark;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.EmployeeId
     *
     * @return the value of employee.EmployeeId
     *
     * @mbg.generated Mon Jul 17 14:31:42 CST 2017
     */
    public Integer getEmployeeid() {
        return employeeid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.EmployeeId
     *
     * @param employeeid the value for employee.EmployeeId
     *
     * @mbg.generated Mon Jul 17 14:31:42 CST 2017
     */
    public void setEmployeeid(Integer employeeid) {
        this.employeeid = employeeid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.EmployeeName
     *
     * @return the value of employee.EmployeeName
     *
     * @mbg.generated Mon Jul 17 14:31:42 CST 2017
     */
    public String getEmployeename() {
        return employeename;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.EmployeeName
     *
     * @param employeename the value for employee.EmployeeName
     *
     * @mbg.generated Mon Jul 17 14:31:42 CST 2017
     */
    public void setEmployeename(String employeename) {
        this.employeename = employeename == null ? null : employeename.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.UserName
     *
     * @return the value of employee.UserName
     *
     * @mbg.generated Mon Jul 17 14:31:42 CST 2017
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.UserName
     *
     * @param username the value for employee.UserName
     *
     * @mbg.generated Mon Jul 17 14:31:42 CST 2017
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.UserPwd
     *
     * @return the value of employee.UserPwd
     *
     * @mbg.generated Mon Jul 17 14:31:42 CST 2017
     */
    public String getUserpwd() {
        return userpwd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.UserPwd
     *
     * @param userpwd the value for employee.UserPwd
     *
     * @mbg.generated Mon Jul 17 14:31:42 CST 2017
     */
    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd == null ? null : userpwd.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.Phone
     *
     * @return the value of employee.Phone
     *
     * @mbg.generated Mon Jul 17 14:31:42 CST 2017
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.Phone
     *
     * @param phone the value for employee.Phone
     *
     * @mbg.generated Mon Jul 17 14:31:42 CST 2017
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.Email
     *
     * @return the value of employee.Email
     *
     * @mbg.generated Mon Jul 17 14:31:42 CST 2017
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.Email
     *
     * @param email the value for employee.Email
     *
     * @mbg.generated Mon Jul 17 14:31:42 CST 2017
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.DepartmentId
     *
     * @return the value of employee.DepartmentId
     *
     * @mbg.generated Mon Jul 17 14:31:42 CST 2017
     */
    public Integer getDepartmentid() {
        return departmentid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.DepartmentId
     *
     * @param departmentid the value for employee.DepartmentId
     *
     * @mbg.generated Mon Jul 17 14:31:42 CST 2017
     */
    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.Roleid
     *
     * @return the value of employee.Roleid
     *
     * @mbg.generated Mon Jul 17 14:31:42 CST 2017
     */
    public Integer getRoleid() {
        return roleid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.Roleid
     *
     * @param roleid the value for employee.Roleid
     *
     * @mbg.generated Mon Jul 17 14:31:42 CST 2017
     */
    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.EmployeeStatus
     *
     * @return the value of employee.EmployeeStatus
     *
     * @mbg.generated Mon Jul 17 14:31:42 CST 2017
     */
    public Integer getEmployeestatus() {
        return employeestatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.EmployeeStatus
     *
     * @param employeestatus the value for employee.EmployeeStatus
     *
     * @mbg.generated Mon Jul 17 14:31:42 CST 2017
     */
    public void setEmployeestatus(Integer employeestatus) {
        this.employeestatus = employeestatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.Remark
     *
     * @return the value of employee.Remark
     *
     * @mbg.generated Mon Jul 17 14:31:42 CST 2017
     */
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
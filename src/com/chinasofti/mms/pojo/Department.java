package com.chinasofti.mms.pojo;

public class Department {
    
    private Integer departmentId;//部门ID

    private String departmentName;//部门名称

    private String remark;//备注

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}


	public String getDepartmentName() {
		return departmentName;
	}


	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}

    public Department() {
	}
	
    public Department(String departmentname) {
		this.departmentName = departmentname;
	}
    
    public Department(Integer departmentid, String departmentname) {
		this.departmentId = departmentid;
		this.departmentName = departmentname;
	}
    
    public Department(String departmentname, String remark) {
		this.departmentName = departmentname;
		this.remark = remark;
	}
    
	public Department(Integer departmentid, String departmentname, String remark) {
		this.departmentId = departmentid;
		this.departmentName = departmentname;
		this.remark = remark;
	}


	@Override
	public String toString() {
		return "Department [departmentid=" + departmentId + ", departmentname=" + departmentName + ", remark=" + remark
				+ "]";
	}

   
}
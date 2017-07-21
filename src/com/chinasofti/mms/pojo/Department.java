package com.chinasofti.mms.pojo;

public class Department {
    
    private String departmentId;

    private String departmentName;

    private String remark;


	public String getDepartmentId() {
		return departmentId;
	}


	public void setDepartmentId(String departmentId) {
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((departmentId == null) ? 0 : departmentId.hashCode());
		result = prime * result + ((departmentName == null) ? 0 : departmentName.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		if (departmentId == null) {
			if (other.departmentId != null)
				return false;
		} else if (!departmentId.equals(other.departmentId))
			return false;
		if (departmentName == null) {
			if (other.departmentName != null)
				return false;
		} else if (!departmentName.equals(other.departmentName))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		return true;
	}

    public Department() {
	}
	
    public Department(String departmentid, String departmentname) {
		this.departmentId = departmentid;
		this.departmentName = departmentname;
	}
    
	public Department(String depid, String departmentname, String remark) {
		this.departmentId = depid;
		this.departmentName = departmentname;
		this.remark = remark;
	}


	@Override
	public String toString() {
		return "Department [departmentid=" + departmentId + ", departmentname=" + departmentName + ", remark=" + remark
				+ "]";
	}

   
}
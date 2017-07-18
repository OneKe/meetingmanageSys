package com.chinasofti.mms.pojo;

public class Department {
    
    private String departmentid;

    private String departmentname;

    private String remark;

	public String getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(String departmentid) {
		this.departmentid = departmentid;
	}

	public String getDepartmentname() {
		return departmentname;
	}


	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
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
		result = prime * result + ((departmentid == null) ? 0 : departmentid.hashCode());
		result = prime * result + ((departmentname == null) ? 0 : departmentname.hashCode());
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
		if (departmentid == null) {
			if (other.departmentid != null)
				return false;
		} else if (!departmentid.equals(other.departmentid))
			return false;
		if (departmentname == null) {
			if (other.departmentname != null)
				return false;
		} else if (!departmentname.equals(other.departmentname))
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
		this.departmentid = departmentid;
		this.departmentname = departmentname;
	}
    
	public Department(String departmentid, String departmentname, String remark) {
		this.departmentid = departmentid;
		this.departmentname = departmentname;
		this.remark = remark;
	}


	@Override
	public String toString() {
		return "Department [departmentid=" + departmentid + ", departmentname=" + departmentname + ", remark=" + remark
				+ "]";
	}

   
}
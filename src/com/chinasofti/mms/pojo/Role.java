package com.chinasofti.mms.pojo;

public class Role {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.RoleId
     *
     * @mbggenerated Mon Jul 17 15:08:13 CST 2017
     */
    private Integer roleid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.RoleName
     *
     * @mbggenerated Mon Jul 17 15:08:13 CST 2017
     */
    private String rolename;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.Remark
     *
     * @mbggenerated Mon Jul 17 15:08:13 CST 2017
     */
    private String remark;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.RoleId
     *
     * @return the value of role.RoleId
     *
     * @mbggenerated Mon Jul 17 15:08:13 CST 2017
     */
    public Integer getRoleid() {
        return roleid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.RoleId
     *
     * @param roleid the value for role.RoleId
     *
     * @mbggenerated Mon Jul 17 15:08:13 CST 2017
     */
    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.RoleName
     *
     * @return the value of role.RoleName
     *
     * @mbggenerated Mon Jul 17 15:08:13 CST 2017
     */
    public String getRolename() {
        return rolename;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.RoleName
     *
     * @param rolename the value for role.RoleName
     *
     * @mbggenerated Mon Jul 17 15:08:13 CST 2017
     */
    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.Remark
     *
     * @return the value of role.Remark
     *
     * @mbggenerated Mon Jul 17 15:08:13 CST 2017
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.Remark
     *
     * @param remark the value for role.Remark
     *
     * @mbggenerated Mon Jul 17 15:08:13 CST 2017
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}
package com.decryto.bean;

import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.sql.Date;
import java.util.List;

public class Role {
    private Integer id;
    private String roleName;
    private String type;
    private String roleDesc;
    private Integer roleStatus;
    private Date createTime;
    private Date updateTime;
    //一个角色对应多个权限
    List<Permit> permitList;
    //多对多
    List<User> userList;
    //对应权限节点集和
    List<RolePermit> rolePermitList;

//layui返回必须, 四个接口
    private int code;
    private String message;
    private Integer count;
    private List<Role> roleList;

    public List<RolePermit> getRolePermitList() {
        return rolePermitList;
    }

    public void setRolePermitList(List<RolePermit> rolePermitList) {
        this.rolePermitList = rolePermitList;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Permit> getPermitList() {
        return permitList;
    }

    public void setPermitList(List<Permit> permitList) {
        this.permitList = permitList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public Integer getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(Integer roleStatus) {
        this.roleStatus = roleStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}

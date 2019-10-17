package com.decryto.bean;


import java.sql.Date;
import java.util.List;

public class RolePermit {
    private Integer id;
    private Integer RoleId;
    private Integer PermitId;
    private Date createTime;
    private Date updateTime;

    private Permit permit;
    //获取角色权限id
    private List<RolePermit> listId;

    public List<RolePermit> getListId() {
        return listId;
    }

    public void setListId(List<RolePermit> listId) {
        this.listId = listId;
    }

    public Permit getPermit() {
        return permit;
    }

    public void setPermit(Permit permit) {
        this.permit = permit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return RoleId;
    }

    public void setRoleId(Integer roleId) {
        RoleId = roleId;
    }

    public Integer getPermitId() {
        return PermitId;
    }

    public void setPermitId(Integer permitId) {
        PermitId = permitId;
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

package com.decryto.bean;

import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.sql.Date;
import java.util.List;

public class Permit {
    private Integer id;
    private String permitName;
    private String permitType;
    private String permitUrl;
    private String permitCode;
    private String permitleft;
    private String permitParentId;
    private String permitparamentIds;
    private String subEnable;
    private Date createTime;
    private String title;
    private Date updateTime;

    public String getPermitParentId() {
        return permitParentId;
    }

    public void setPermitParentId(String permitParentId) {
        this.permitParentId = permitParentId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    //layui数据接口
    private String message;
    private int code ;
    private Integer count;
    private List<Permit> permitList;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Permit> getPermitList() {
        return permitList;
    }

    public void setPermitList(List<Permit> permitList) {
        this.permitList = permitList;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermitName() {
        return permitName;
    }

    public void setPermitName(String permitName) {
        this.permitName = permitName;
    }

    public String getPermitType() {
        return permitType;
    }

    public void setPermitType(String permitType) {
        this.permitType = permitType;
    }

    public String getPermitUrl() {
        return permitUrl;
    }

    public void setPermitUrl(String permitUrl) {
        this.permitUrl = permitUrl;
    }

    public String getPermitCode() {
        return permitCode;
    }

    public void setPermitCode(String permitCode) {
        this.permitCode = permitCode;
    }

    public String getPermitleft() {
        return permitleft;
    }

    public void setPermitleft(String permitleft) {
        this.permitleft = permitleft;
    }


    public String getPermitparamentIds() {
        return permitparamentIds;
    }

    public void setPermitparamentIds(String permitparamentIds) {
        this.permitparamentIds = permitparamentIds;
    }

    public String getSubEnable() {
        return subEnable;
    }

    public void setSubEnable(String subEnable) {
        this.subEnable = subEnable;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}

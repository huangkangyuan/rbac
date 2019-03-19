package com.hl.pojo;

import java.util.Date;

public class SysLogWithBLOBs extends SysLog {
    private String oldValue;

    private String newValue;

    public SysLogWithBLOBs(Integer id, Integer type, Integer targetId, String operator, Date operateTime, String operateIp, Integer status, String oldValue, String newValue) {
        super(id, type, targetId, operator, operateTime, operateIp, status);
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    public SysLogWithBLOBs() {
        super();
    }

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue == null ? null : oldValue.trim();
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue == null ? null : newValue.trim();
    }
}
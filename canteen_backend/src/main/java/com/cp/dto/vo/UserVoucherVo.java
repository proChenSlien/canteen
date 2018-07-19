package com.cp.dto.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: Slien
 * @Date: 2018-06-15 16:09
 */
public class UserVoucherVo implements Serializable {
    private String id;
    private String userName;
    private String vvName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date validTime;
    private Integer validDays;
    private Integer valid;

    public UserVoucherVo(String id, String userName, String vvName, Date validTime, Integer validDays,
                   Integer valid){
        this.id = id;
        this.userName = userName;
        this.vvName = vvName;
        this.validTime = validTime;
        this.validDays = validDays;
        this.valid = valid;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getVvName() {
        return vvName;
    }

    public void setVvName(String vvName) {
        this.vvName = vvName;
    }

    public Date getValidTime() {
        return validTime;
    }

    public void setValidTime(Date validTime) {
        this.validTime = validTime;
    }

    public Integer getValidDays() {
        return validDays;
    }

    public void setValidDays(Integer validDays) {
        this.validDays = validDays;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }
}

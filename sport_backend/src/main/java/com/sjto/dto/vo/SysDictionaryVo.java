package com.sjto.dto.vo;

import java.io.Serializable;

public class SysDictionaryVo implements Serializable {
    private Long sd_id;
    private String sd_val;
    private String sd_remark;
    private Integer sd_orderNum;
    private String sdg_groupName;
    private String sdg_groupRemark;
    private Integer sdg_orderNum;

    public SysDictionaryVo(Long sd_id, String sd_val, String sd_remark, Integer sd_orderNum, String sdg_groupName, String sdg_groupRemark, Integer sdg_orderNum) {
        this.sd_id = sd_id;
        this.sd_val = sd_val;
        this.sd_remark = sd_remark;
        this.sd_orderNum = sd_orderNum;
        this.sdg_groupName = sdg_groupName;
        this.sdg_groupRemark = sdg_groupRemark;
        this.sdg_orderNum = sdg_orderNum;

    }

    public Long getSd_id() {
        return sd_id;
    }

    public void setSd_id(Long sd_id) {
        this.sd_id = sd_id;
    }

    public String getSd_val() {
        return sd_val;
    }

    public void setSd_val(String sd_val) {
        this.sd_val = sd_val;
    }

    public String getSd_remark() {
        return sd_remark;
    }

    public void setSd_remark(String sd_remark) {
        this.sd_remark = sd_remark;
    }

    public Integer getSd_orderNum() {
        return sd_orderNum;
    }

    public void setSd_orderNum(Integer sd_orderNum) {
        this.sd_orderNum = sd_orderNum;
    }

    public String getSdg_groupName() {
        return sdg_groupName;
    }

    public void setSdg_groupName(String sdg_groupName) {
        this.sdg_groupName = sdg_groupName;
    }

    public String getSdg_groupRemark() {
        return sdg_groupRemark;
    }

    public void setSdg_groupRemark(String sdg_groupRemark) {
        this.sdg_groupRemark = sdg_groupRemark;
    }

    public Integer getSdg_orderNum() {
        return sdg_orderNum;
    }

    public void setSdg_orderNum(Integer sdg_orderNum) {
        this.sdg_orderNum = sdg_orderNum;
    }
}

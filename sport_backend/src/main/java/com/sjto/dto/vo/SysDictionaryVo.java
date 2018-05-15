package com.sjto.dto.vo;

import java.io.Serializable;

public class SysDictionaryVo implements Serializable {
    private Long sd_id;
    private Integer value;
    private String label;
    private Integer sd_orderNum;
    private String sdg_groupName;
    private String sdg_groupRemark;
    private Integer sdg_orderNum;

    public SysDictionaryVo(Long sd_id, Integer sd_val, String sd_remark, Integer sd_orderNum) {
        this.sd_id = sd_id;
        this.value = sd_val;
        this.label = sd_remark;
        this.sd_orderNum = sd_orderNum;
    }

    public Long getSd_id() {
        return sd_id;
    }

    public void setSd_id(Long sd_id) {
        this.sd_id = sd_id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
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

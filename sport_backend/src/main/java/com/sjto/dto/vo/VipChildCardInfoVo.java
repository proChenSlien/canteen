package com.sjto.dto.vo;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @ClassName VipChildCardInfoVo
 * @Description
 * @Author wangsai
 * @Date 2018/5/12 20:59
 **/
public class VipChildCardInfoVo {

    private String babyName;
    private Integer babySex;
    private String authImgUrl;

    public String getBabyName() {
        return babyName;
    }

    public void setBabyName(String babyName) {
        this.babyName = babyName;
    }

    public Integer getBabySex() {
        return babySex;
    }

    public void setBabySex(Integer babySex) {
        this.babySex = babySex;
    }

    public String getAuthImgUrl() {
        return authImgUrl;
    }

    public void setAuthImgUrl(String authImgUrl) {
        this.authImgUrl = authImgUrl;
    }
}

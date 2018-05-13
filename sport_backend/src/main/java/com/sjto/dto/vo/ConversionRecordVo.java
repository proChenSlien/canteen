package com.sjto.dto.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description:兑换信息vo
 * @Author: fanyongjiu
 * @Date: 18/5/13 11:53
 */
public class ConversionRecordVo implements Serializable {
    private Long id;
    private String giftCardName;
    private String userName;
    private Integer days;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    public ConversionRecordVo(Long id, String giftCardName, String userName, Integer days, Date createTime) {
        this.id = id;
        this.giftCardName = giftCardName;
        this.userName = userName;
        this.days = days;
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGiftCardName() {
        return giftCardName;
    }

    public void setGiftCardName(String giftCardName) {
        this.giftCardName = giftCardName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}

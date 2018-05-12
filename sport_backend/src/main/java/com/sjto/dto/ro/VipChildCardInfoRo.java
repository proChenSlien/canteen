package com.sjto.dto.ro;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.Map;

/**
 * @ClassName VipChildCardInfoRo
 * @Description
 * @Author wangsai
 * @Date 2018/5/12 18:58
 **/
public class VipChildCardInfoRo {

    @ApiModelProperty("亲密卡编号")
    private Long id;
    @ApiModelProperty("主体用户id")
    private Long mainUserId;
    @ApiModelProperty("认证状态【未认证 | 认证中 | 已认证 | 认证失败】")
    private Map authState;
    @ApiModelProperty("第一次开通会员的激活时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date activeTime;
    @ApiModelProperty("认证照片地址")
    private String authImgUrl;
    @ApiModelProperty("使用状态【未开通 | 使用中 | 已过期】")
    private Map useState;
    @ApiModelProperty("到期时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date endDate;
    @ApiModelProperty("卡类名称")
    private String cardName;
    @ApiModelProperty("背景图片地址")
    private String bgImgUrl;
    @ApiModelProperty("宝贝姓名")
    private String babyName;
    @ApiModelProperty("宝贝性别")
    private Integer babySex;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMainUserId() {
        return mainUserId;
    }

    public void setMainUserId(Long mainUserId) {
        this.mainUserId = mainUserId;
    }

    public Map getAuthState() {
        return authState;
    }

    public void setAuthState(Map authState) {
        this.authState = authState;
    }

    public Date getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(Date activeTime) {
        this.activeTime = activeTime;
    }

    public String getAuthImgUrl() {
        return authImgUrl;
    }

    public void setAuthImgUrl(String authImgUrl) {
        this.authImgUrl = authImgUrl;
    }

    public Map getUseState() {
        return useState;
    }

    public void setUseState(Map useState) {
        this.useState = useState;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getBgImgUrl() {
        return bgImgUrl;
    }

    public void setBgImgUrl(String bgImgUrl) {
        this.bgImgUrl = bgImgUrl;
    }

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
}

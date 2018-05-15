package com.sjto.dto.ro;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.Map;

@ApiModel("单人健身实体卡信息")
public class VipSingleGymcardInfoRo {
    @ApiModelProperty("实体卡编号")
    private Long id;
    @ApiModelProperty("用户id")
    private Long userId;
    @ApiModelProperty("用户名")
    private String loginName;
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
    @ApiModelProperty("手机号码")
    private Long phone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Map getAuthState() {
        return authState;
    }

    public void setAuthState(Map authState) {
        this.authState = authState;
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

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }
}

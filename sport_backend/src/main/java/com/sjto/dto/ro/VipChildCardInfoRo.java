package com.sjto.dto.ro;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sjto.domain.VipChildCardInfo;
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
}

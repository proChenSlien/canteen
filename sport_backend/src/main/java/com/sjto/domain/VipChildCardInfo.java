package com.sjto.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

/**
 * @ClassName VipChildCardInfo
 * @Description
 * @Author wangsai
 * @Date 2018/5/12 9:48
 **/
@Entity
@Table(name = "vip_child_card_info")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class VipChildCardInfo {
    private Long id;
    private Long cid;
    private String babyName;
    private Integer babySex;
    private String authImgUrl;
    private Integer authState;
    private Date endDate;
    private Long mainUserId;
    private Integer status;
    private Date activeTime;
    private Date createTime;
    private Date updateTime;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true, nullable = false, length = 20)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "cid", nullable = false, columnDefinition = "bigint(20) COMMENT '会员卡唯一编号'")
    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    @Column(name = "baby_name", nullable = false, columnDefinition = "varchar(64) COMMENT '宝贝姓名'")
    public String getBabyName() {
        return babyName;
    }

    public void setBabyName(String babyName) {
        this.babyName = babyName;
    }

    @Column(name = "baby_sex", nullable = false, columnDefinition = "bigint(20) COMMENT '宝贝性别【1-女 | 2-男】'")
    public Integer getBabySex() {
        return babySex;
    }

    public void setBabySex(Integer babySex) {
        this.babySex = babySex;
    }

    @Column(name = "auth_img_url", columnDefinition = "varchar(512) COMMENT '上传的认证图片地址'")
    public String getAuthImgUrl() {
        return authImgUrl;
    }

    public void setAuthImgUrl(String authImgUrl) {
        this.authImgUrl = authImgUrl;
    }

    @Column(name = "auth_state", nullable = false, columnDefinition = "bigint(20) COMMENT '认证状态【0-未认证 | 1-认证中 | 2-已认证 | 3-认证失败】'")
    public Integer getAuthState() {
        return authState;
    }

    public void setAuthState(Integer authState) {
        this.authState = authState;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Column(name = "end_date", columnDefinition = "datetime COMMENT '结束使用时间'")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Column(name = "main_user_id", nullable = false, columnDefinition = "bigint(20) COMMENT '用户唯一编号'")
    public Long getMainUserId() {
        return mainUserId;
    }

    public void setMainUserId(Long mainUserId) {
        this.mainUserId = mainUserId;
    }

    @Column(name = "status", nullable = false, columnDefinition = "bigint(20) default 1 COMMENT '状态【0-无效 | 1-有效】'")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "active_time", nullable = false, columnDefinition = "datetime COMMENT '第一次激活使用时间'")
    public Date getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(Date activeTime) {
        this.activeTime = activeTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "create_time", nullable = false, columnDefinition = "datetime COMMENT '创建时间'")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "update_time", nullable = false, columnDefinition = "datetime COMMENT '最后更新时间'")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}

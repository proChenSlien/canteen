package com.sjto.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.Date;

/***
 * 运动会员单人健身卡实体
 */
@Entity
@Table(name = "vip_single_gymcard_info")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class VipSingleGymcardInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true, nullable = false, length = 20)
    private Long id;

    @Column(name = "cid", nullable = false, columnDefinition = "bigint(20) COMMENT '会员卡唯一编号'")
    private Long cid;

    @Column(name = "user_id", nullable = false, columnDefinition = "bigint(20) COMMENT '用户唯一编号'")
    private Long userId;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Column(name = "end_date", columnDefinition = "datetime COMMENT '结束使用时间'")
    private Date endDate;

    @Column(name = "auth_state", nullable = false, columnDefinition = "tinyint default 1 COMMENT '认证状态【0-未认证 | 1-认证中 | 2-已认证 | 3-认证失败】'")
    private Integer authState;

    @Column(name = "auth_img_url", columnDefinition = "varchar(512) COMMENT '上传的认证图片地址'")
    private String authImgUrl;

    @Column(name = "status", columnDefinition = "bigint(20) default 1 COMMENT '状态【0-无效 | 1-有效】'")
    private Integer status;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "active_time", columnDefinition = "datetime COMMENT '第一次激活使用时间'")
    private Date activeTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "create_time", nullable = false, columnDefinition = "datetime COMMENT '创建时间'")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "update_time", nullable = false, columnDefinition = "datetime COMMENT '最后更新时间'")
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getAuthState() {
        return authState;
    }

    public void setAuthState(Integer authState) {
        this.authState = authState;
    }

    public String getAuthImgUrl() {
        return authImgUrl;
    }

    public void setAuthImgUrl(String authImgUrl) {
        this.authImgUrl = authImgUrl;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(Date activeTime) {
        this.activeTime = activeTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}

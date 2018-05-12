package com.sjto.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

/**
 * @Description: 兑换信息
 * @Author:
 * @Date: 18/5/10 15:26
 */
@Entity
@Table(name = "conversion_record")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class ConversionRecord {
    private Long id;
    private Long sid;
    private Long userId;
    private Long pid;
    private Integer days;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, length = 20)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "sid", nullable = false, columnDefinition = "bigint(20) COMMENT '兑换的礼品卡编号'")
    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    @Column(name = "user_id", nullable = false, columnDefinition = "bigint(20) COMMENT '用户唯一编号【关联用户信息】'")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Column(name = "pid", nullable = false, columnDefinition = "bigint(20) COMMENT '使用的健身卡实体编号【关联运动会员单人健身卡信息】'")
    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    @Column(name = "days", nullable = false, columnDefinition = "int(10) COMMENT '兑换天数'")
    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    @Column(name = "create_time", nullable = false, columnDefinition = "datetime COMMENT '创建时间'")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}

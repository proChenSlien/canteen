package com.sjto.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "member_packages")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class MemberPackages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String remark;
    private Integer days;
    private Double money;
    private Integer award;
    private Integer status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    @Column(name = "id",unique = true, nullable = false, length = 20)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "title", nullable = false, columnDefinition = "varchar(64) COMMENT '套餐标题'")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "remark", nullable = false, columnDefinition = "text COMMENT '购卡说明'")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Column(name = "days", nullable = false, columnDefinition = "int(10) COMMENT '充值天数'")
    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    @Column(name = "money", nullable = false, columnDefinition = "double COMMENT '充值金额'")
    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Column(name = "award", nullable = false, columnDefinition = "int COMMENT '奖励银两或其他币种数量'")
    public Integer getAward() {
        return award;
    }

    public void setAward(Integer award) {
        this.award = award;
    }

    @Column(name = "status", nullable = false, columnDefinition = "int COMMENT '状态【0-无效 | 1-有效】'")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Column(name = "create_time", nullable = false, columnDefinition = "datetime COMMENT '创建时间'")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Column(name = "update_time", nullable = false, columnDefinition = "datetime COMMENT '最后更新时间'")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}

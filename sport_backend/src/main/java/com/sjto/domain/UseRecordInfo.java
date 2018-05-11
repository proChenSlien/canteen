package com.sjto.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

/**
 * 使用记录
 */
@Entity
@Table(name = "use_record_info")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UseRecordInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, length = 20)
    private Long id;

    @Column(name = "user_id", nullable = false, columnDefinition = "bigint(20) COMMENT '用户唯一编号'")
    private Long userId;

    @Column(name = "pid", nullable = false, columnDefinition = "bigint(20) COMMENT '使用的健身卡实体编号'")
    private Long pid;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "begin_time", nullable = false, columnDefinition = "datetime COMMENT '开始使用时间'")
    private Date beginTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "end_time", columnDefinition = "datetime COMMENT '结束使用时间'")
    private Date endTime;

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

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}

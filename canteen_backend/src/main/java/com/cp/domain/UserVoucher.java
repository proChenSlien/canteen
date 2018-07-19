package com.cp.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: Slien
 * @Date: 2018-06-14 16:48
 */
@Entity
@Table(name = "user_voucher")
public class UserVoucher {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;
    @Column(name = "user_id", nullable = false, columnDefinition = "varchar(64) COMMENT '用户id'")
    private String userId;
    @Column(name = "voucher_id", nullable = false, columnDefinition = "varchar(64) COMMENT '优惠券id'")
    private String voucherId;
    @Column(name = "create_time", columnDefinition = "datetime COMMENT '创建时间'")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @Column(name = "valid_time", columnDefinition = "datetime COMMENT '有效时间'")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date validTime;
    @Column(name = "valid_days", columnDefinition = "int COMMENT '有效天数'")
    private Integer validDays;
    @Column(name = "valid", columnDefinition = "int COMMENT '有效标志'")
    private Integer valid = 1;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(String voucherId) {
        this.voucherId = voucherId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getValidTime() {
        return validTime;
    }

    public void setValidTime(Date validTime) {
        this.validTime = validTime;
    }

    public Integer getValidDays() {
        return validDays;
    }

    public void setValidDays(Integer validDays) {
        this.validDays = validDays;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }
}

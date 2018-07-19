package com.cp.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: Slien
 * @Date: 2018-06-13 16:31
 */
@Entity
@Table(name = "value_voucher")
public class ValueVoucher {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;
    @Column(name = "vv_name", nullable = false, columnDefinition = "varchar(64) COMMENT '优惠券名'")
    private String vvName;
    @Column(name = "vv_remark", nullable = false, columnDefinition = "varchar(64) COMMENT '说明'")
    private String vvRemark;
    @Column(name = "discount", nullable = false, columnDefinition = "double COMMENT '折扣'")
    private Double discount;
    @Column(name = "create_time", columnDefinition = "datetime COMMENT '创建时间'")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @Column(name = "valid_time", columnDefinition = "datetime COMMENT '有效时间'")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date validTime;
    @Column(name = "valid_days", columnDefinition = "int COMMENT '有效天数'")
    private Integer validDays;
    @Column(name = "img_url", columnDefinition = "varchar(255) COMMENT '图片地址'")
    private String imgUrl;
    @Column(name = "valid", columnDefinition = "int COMMENT '有效标志'")
    private Integer valid = 1;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVvName() {
        return vvName;
    }

    public void setVvName(String vvName) {
        this.vvName = vvName;
    }

    public String getVvRemark() {
        return vvRemark;
    }

    public void setVvRemark(String vvRemark) {
        this.vvRemark = vvRemark;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}

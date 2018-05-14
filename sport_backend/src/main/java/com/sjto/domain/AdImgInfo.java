package com.sjto.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

/**
 * @Description: 广告位图片信息
 * @Author: fanyongjiu
 * @Date: 18/5/10 15:37
 */
@Entity
@Table(name = "ad_img_info")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AdImgInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, length = 20)
    private Long id;

    @Column(name = "type", nullable = false, columnDefinition = "varchar(64) COMMENT '广告类型，格式如1|3，以“|”分割，前部分是分组编号后部分是对应字典值。'")
    private String type;

    @Column(name = "bg_img_url", columnDefinition = "varchar(512) COMMENT '背景图片地址'")
    private String bgImgUrl;

    @Column(name = "title", nullable = false, columnDefinition = "varchar(64) COMMENT '广告标题'")
    private String title;

    @Column(name = "status", nullable = false, columnDefinition = "bigint(20) COMMENT '状态【0-无效 | 1-有效】'")
    private Integer status;

    @Column(name = "url_xcx", columnDefinition = "varchar(512) COMMENT '跳转小程序链接'")
    private String urlXCX;

    @Column(name = "url_h5", columnDefinition = "varchar(512) COMMENT '跳转H5链接'")
    private String urlH5;

    @Column(name = "images", columnDefinition = "varchar(512) COMMENT '副背景图地址，以“|”分割'")
    private String images;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBgImgUrl() {
        return bgImgUrl;
    }

    public void setBgImgUrl(String bgImgUrl) {
        this.bgImgUrl = bgImgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUrlXCX() {
        return urlXCX;
    }

    public void setUrlXCX(String urlXCX) {
        this.urlXCX = urlXCX;
    }

    public String getUrlH5() {
        return urlH5;
    }

    public void setUrlH5(String urlH5) {
        this.urlH5 = urlH5;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
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

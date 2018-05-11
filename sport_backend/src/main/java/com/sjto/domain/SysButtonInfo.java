package com.sjto.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * @Description: 按钮信息
 * @Author: fanyongjiu
 * @Date: 18/5/10 15:37
 */
@Entity
@Table(name = "sys_button_info")
public class SysButtonInfo {
    private Long id;
    private String image;
    private String title;
    private String remark;
    private Long typeId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true, nullable = false, length = 20)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "image", nullable = false, columnDefinition = "varchar(512) COMMENT '图片'")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Column(name = "title", nullable = false, columnDefinition = "varchar(64) COMMENT '标题'")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "remark", nullable = false, columnDefinition = "varchar(128) COMMENT '副标题'")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Column(name = "type_id", nullable = false, columnDefinition = "bigint(20) COMMENT '字典编号'")
    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }
}

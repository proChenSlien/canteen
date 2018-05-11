package com.sjto.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

/**
 * 监护人与亲子卡关系
 */
@Entity
@Table(name = "family_ties_info")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class FamilyTiesInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false, columnDefinition = "bigint(20) COMMENT '用户唯一编号'")
    private Long userId;

    @Column(name = "sid", nullable = false, columnDefinition = "bigint(20) COMMENT 亲密卡实体编号'")
    private Integer sid;

    @Column(name = "ship_name", nullable = false, columnDefinition = "varchar(64) COMMENT '关系称谓'")
    private String shipName;

    @Column
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }
}

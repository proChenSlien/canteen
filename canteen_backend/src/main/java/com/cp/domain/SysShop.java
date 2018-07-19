package com.cp.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author: Slien
 * @Date: 2018-06-13 16:30
 */
@Entity
@Table(name = "sys_shop")
public class SysShop {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;
    @Column(name = "shop_name", nullable = false, columnDefinition = "varchar(64) COMMENT '店名'")
    private String shopName;
    @Column(name = "shop_phone", columnDefinition = "varchar(64) COMMENT '联系电话'")
    private String shopPhone;
    @Column(name = "shop_address", columnDefinition = "varchar(255) COMMENT '店家地址'")
    private String shopAddress;
    @Column(name = "status", columnDefinition = "varchar(64) COMMENT '状态'")
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopPhone() {
        return shopPhone;
    }

    public void setShopPhone(String shopPhone) {
        this.shopPhone = shopPhone;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

package com.sjto.dto.vo;

public class FamilyTiesVo {
    private Long id;
    private Long userId;
    private String shipName;
    private Long phone;
    private String authImgUrl;

    public FamilyTiesVo(Long id, Long userId, String shipName, Long phone, String authImgUrl) {
        this.id = id;
        this.userId = userId;
        this.shipName = shipName;
        this.phone = phone;
        this.authImgUrl = authImgUrl;

    }
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

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getAuthImgUrl() {
        return authImgUrl;
    }

    public void setAuthImgUrl(String authImgUrl) {
        this.authImgUrl = authImgUrl;
    }
}

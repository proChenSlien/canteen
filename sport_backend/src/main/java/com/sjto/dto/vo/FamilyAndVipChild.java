package com.sjto.dto.vo;

public class FamilyAndVipChild {
    private Long mainUserId;

    public FamilyAndVipChild(Long mainUserId) {
        this.mainUserId = mainUserId;

    }


    public Long getMainUserId() {
        return mainUserId;
    }

    public void setMainUserId(Long mainUserId) {
        this.mainUserId = mainUserId;
    }
}

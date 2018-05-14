package com.sjto.dto.vo;

public class VenueConfigVo {
    private Long id;
    private Double money;
    private String title;
    private String venueName;
    private Long venueId;

    public VenueConfigVo(Long id, Double money, String title, String venueName, Long venueId) {
        this.id = id;
        this.money = money;
        this.title = title;
        this.venueName = venueName;
        this.venueId = venueId;
    }


    public Long getVenueId() {
        return venueId;
    }

    public void setVenueId(Long venueId) {
        this.venueId = venueId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }
}

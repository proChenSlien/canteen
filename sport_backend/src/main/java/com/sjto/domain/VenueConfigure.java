package com.sjto.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "venue_configure")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class VenueConfigure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long kid;
    private Long oid;

    @Column(name = "id",unique = true, nullable = false, length = 20)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "kid", nullable = false, columnDefinition = "bigint(20) COMMENT '单次票套餐id'")
    public Long getKid() {
        return kid;
    }

    public void setKid(Long kid) {
        this.kid = kid;
    }

    @Column(name = "oid", nullable = false, columnDefinition = "bigint(20) COMMENT '场馆编号【关联场馆信息】'")
    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }
}

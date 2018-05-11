package com.sjto.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

/**
 * 内容说明信息
 */
@Entity
@Table(name = "content_info")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class ContentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true, nullable = false, length = 20)
    private Long id;

    @Column(name = "name", nullable = false, columnDefinition = "varchar(64) COMMENT '内容名称'")
    private String name;

    @Column(name = "type", nullable = false, columnDefinition = "bigint(20) COMMENT '内容类型'")
    private Integer type;

    @Column(name = "content", columnDefinition = "text COMMENT '内容说明'")
    private String content;

    @Column(name = "status", nullable = false, columnDefinition = "bigint(20) COMMENT '状态【0-无效 | 1-有效】'")
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}

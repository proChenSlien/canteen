package com.sjto.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * @Description: 操作留痕记录
 * @Author: fanyongjiu
 * @Date: 18/5/10 15:37
 */
@Entity
@Table(name = "opera_log")
public class OperationLog {
    private Long id;
    private Long operaId;
    private Long operaType;
    private Date createTime;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true, nullable = false, length = 20)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "opera_id", nullable = false, columnDefinition = "bigint(20) COMMENT '操作人id'")
    public Long getOperaId() {
        return operaId;
    }

    public void setOperaId(Long operaId) {
        this.operaId = operaId;
    }

    @Column(name = "opera_type", nullable = false, columnDefinition = "bigint(20) COMMENT '操作方式【关联字典表信息】'")
    public Long getOperaType() {
        return operaType;
    }

    public void setOperaType(Long operaType) {
        this.operaType = operaType;
    }

    @Column(name = "create_time", nullable = false, columnDefinition = "datetime COMMENT '创建时间'")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}

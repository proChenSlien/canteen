package com.sjto.domain;

import javax.persistence.*;

/**
 * @Description: 字典
 * @Author: fanyongjiu
 * @Date: 18/5/10 15:26
 */
@Entity
@Table(name = "sys_dictionary")
public class SysDictionary {
    private Long id;
    private Long groupId;
    private Integer val;
    private String remark;
    private Integer orderNum;
    private Integer status;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true, nullable = false, length = 20)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "group_id", nullable = false, columnDefinition = "bigint(20) COMMENT '字典组id'")
    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    @Column(name = "val", nullable = false, columnDefinition = "int(11) COMMENT '字典值'")
    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }

    @Column(name = "remark", nullable = false, columnDefinition = "varchar(128) COMMENT '描述'")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Column(name = "order_num", nullable = false, columnDefinition = "int(11) COMMENT '排序'")
    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    @Column(name = "status", nullable = false, columnDefinition = "int(11) COMMENT '状态【0-无效 | 1-有效】'")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

package com.sjto.domain;

import javax.persistence.*;

/**
 * @Description: 字典组
 * @Author: fanyongjiu
 * @Date: 18/5/10 15:04
 */
@Entity
@Table(name = "sys_dictionary_group")
public class SysDictionaryGroup {
    private Long groupId;
    private String groupName;
    private String groupRemark;
    private Integer orderNum;
    private Integer status;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id",unique = true, nullable = false, length = 20)
    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    @Basic
    @Column(name = "gtoup_name", nullable = false, columnDefinition = "varchar(64) COMMENT '字典组名称'")
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Column(name = "group_remark", nullable = false, columnDefinition = "text COMMENT '字典组描述'")
    public String getGroupRemark() {
        return groupRemark;
    }

    public void setGroupRemark(String groupRemark) {
        this.groupRemark = groupRemark;
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

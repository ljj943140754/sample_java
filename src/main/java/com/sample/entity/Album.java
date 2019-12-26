package com.sample.entity;

import com.common.bean.pageObject;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 予之文化传媒
 * @since 2019-12-24
 */
public class Album extends pageObject  implements Serializable{

    private static final long serialVersionUID=1L;

    /**
     * 相册主键id
     */
    @TableId(value = "alb_id", type = IdType.AUTO)
    private Integer alb_id;

    /**
     * 用户id(worker表主键id)预留字段
     */
    private Integer alb_wor_id;

    /**
     * 分类id、相册属某个分类(classify主键id)
     */
    private Integer alb_classify_id;

    /**
     * 相册名称
     */
    private String alb_name;

    /**
     * 相册描述
     */
    private String alb_describe;

    /**
     * 是否可见: 0、仅自己可见 1、公开
     */
    private Integer alb_visible;

    /**
     * 创建纪录时间
     */
    private Date alb_creation;

    /**
     * 创建者id
     */
    private Integer alb_createdby;

    /**
     * 最后更新时间
     */
    private Date alb_lastupdated;

    /**
     * 最后更新人
     */
    private Integer alb_lastupdatedby;

    /**
     * 是否启动：1、仅CMS可浏览查看 2、全部可见
     */
    private Integer alb_isdel;


    public Integer getAlb_id() {
        return alb_id;
    }

    public void setAlb_id(Integer alb_id) {
        this.alb_id = alb_id;
    }

    public Integer getAlb_wor_id() {
        return alb_wor_id;
    }

    public void setAlb_wor_id(Integer alb_wor_id) {
        this.alb_wor_id = alb_wor_id;
    }

    public Integer getAlb_classify_id() {
        return alb_classify_id;
    }

    public void setAlb_classify_id(Integer alb_classify_id) {
        this.alb_classify_id = alb_classify_id;
    }

    public String getAlb_name() {
        return alb_name;
    }

    public void setAlb_name(String alb_name) {
        this.alb_name = alb_name;
    }

    public String getAlb_describe() {
        return alb_describe;
    }

    public void setAlb_describe(String alb_describe) {
        this.alb_describe = alb_describe;
    }

    public Integer getAlb_visible() {
        return alb_visible;
    }

    public void setAlb_visible(Integer alb_visible) {
        this.alb_visible = alb_visible;
    }

    public Date getAlb_creation() {
        return alb_creation;
    }

    public void setAlb_creation(Date alb_creation) {
        this.alb_creation = alb_creation;
    }

    public Integer getAlb_createdby() {
        return alb_createdby;
    }

    public void setAlb_createdby(Integer alb_createdby) {
        this.alb_createdby = alb_createdby;
    }

    public Date getAlb_lastupdated() {
        return alb_lastupdated;
    }

    public void setAlb_lastupdated(Date alb_lastupdated) {
        this.alb_lastupdated = alb_lastupdated;
    }

    public Integer getAlb_lastupdatedby() {
        return alb_lastupdatedby;
    }

    public void setAlb_lastupdatedby(Integer alb_lastupdatedby) {
        this.alb_lastupdatedby = alb_lastupdatedby;
    }

    public Integer getAlb_isdel() {
        return alb_isdel;
    }

    public void setAlb_isdel(Integer alb_isdel) {
        this.alb_isdel = alb_isdel;
    }

    @Override
    public String toString() {
        return "Album{" +
        "alb_id=" + alb_id +
        ", alb_wor_id=" + alb_wor_id +
        ", alb_classify_id=" + alb_classify_id +
        ", alb_name=" + alb_name +
        ", alb_describe=" + alb_describe +
        ", alb_visible=" + alb_visible +
        ", alb_creation=" + alb_creation +
        ", alb_createdby=" + alb_createdby +
        ", alb_lastupdated=" + alb_lastupdated +
        ", alb_lastupdatedby=" + alb_lastupdatedby +
        ", alb_isdel=" + alb_isdel +
        "}";
    }
}

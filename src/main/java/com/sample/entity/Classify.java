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
public class Classify extends pageObject  implements Serializable{

    private static final long serialVersionUID=1L;

    /**
     * 分类主键id
     */
    @TableId(value = "cla_id", type = IdType.AUTO)
    private Integer cla_id;

    /**
     * 用户id (worker表主键id)
     */
    private Integer cla_wor_id;

    /**
     * 分类文件名
     */
    private String cla_class_name;

    /**
     * 分类描述
     */
    private String cla_describe;

    /**
     * 记录创建时间
     */
    private Date cla_creation;

    /**
     * 创建者id
     */
    private Integer cla_createdby;

    /**
     * 最后更新时间
     */
    private Date cla_lastupdated;

    /**
     * 最后更新人
     */
    private Integer cla_lastupdatedby;

    /**
     * 是否启动：1、仅CMS可浏览查看 2、全部可见
     */
    private Integer cla_isdel;


    public Integer getCla_id() {
        return cla_id;
    }

    public void setCla_id(Integer cla_id) {
        this.cla_id = cla_id;
    }

    public Integer getCla_wor_id() {
        return cla_wor_id;
    }

    public void setCla_wor_id(Integer cla_wor_id) {
        this.cla_wor_id = cla_wor_id;
    }

    public String getCla_class_name() {
        return cla_class_name;
    }

    public void setCla_class_name(String cla_class_name) {
        this.cla_class_name = cla_class_name;
    }

    public String getCla_describe() {
        return cla_describe;
    }

    public void setCla_describe(String cla_describe) {
        this.cla_describe = cla_describe;
    }

    public Date getCla_creation() {
        return cla_creation;
    }

    public void setCla_creation(Date cla_creation) {
        this.cla_creation = cla_creation;
    }

    public Integer getCla_createdby() {
        return cla_createdby;
    }

    public void setCla_createdby(Integer cla_createdby) {
        this.cla_createdby = cla_createdby;
    }

    public Date getCla_lastupdated() {
        return cla_lastupdated;
    }

    public void setCla_lastupdated(Date cla_lastupdated) {
        this.cla_lastupdated = cla_lastupdated;
    }

    public Integer getCla_lastupdatedby() {
        return cla_lastupdatedby;
    }

    public void setCla_lastupdatedby(Integer cla_lastupdatedby) {
        this.cla_lastupdatedby = cla_lastupdatedby;
    }

    public Integer getCla_isdel() {
        return cla_isdel;
    }

    public void setCla_isdel(Integer cla_isdel) {
        this.cla_isdel = cla_isdel;
    }


    @Override
    public String toString() {
        return "Classify{" +
        "cla_id=" + cla_id +
        ", cla_wor_id=" + cla_wor_id +
        ", cla_class_name=" + cla_class_name +
        ", cla_describe=" + cla_describe +
        ", cla_creation=" + cla_creation +
        ", cla_createdby=" + cla_createdby +
        ", cla_lastupdated=" + cla_lastupdated +
        ", cla_lastupdatedby=" + cla_lastupdatedby +
        ", cla_isdel=" + cla_isdel +
        "}";
    }
}

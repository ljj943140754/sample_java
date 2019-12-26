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
public class Photo extends pageObject  implements Serializable{

    private static final long serialVersionUID=1L;

    /**
     * 图片主键id 
     */
    @TableId(value = "pho_id", type = IdType.AUTO)
    private Integer pho_id;

    /**
     * 所属用户（worker表主键id）
     */
    private Integer pho_wor_id;

    /**
     * 所属分类（classify表主键id）
     */
    private String pho_class_id;

    /**
     * 所属相册（album表主键id）
     */
    private Integer pho_album_id;

    /**
     * 所属类型：1、照片2、视频
     */
    private Integer pho_type;

    /**
     * 图片名字
     */
    private String pho_name;

    /**
     * 图片描述
     */
    private String pho_describe;

    /**
     * 图片地址url
     */
    private String pho_url;

    /**
     * 图片html代码url
     */
    private String pho_html_url;

    /**
     * 图片html代码（有回链）url
     */
    private String pho_chain_url;

    /**
     * 创建纪录时间
     */
    private Date pho_creation;

    /**
     * 最后更新时间
     */
    private Date pho_lastupdated;

    /**
     * 是否启动：1、仅CMS可浏览查看 2、全部可见
     */
    private Integer pho_isdel;


    public Integer getPho_id() {
        return pho_id;
    }

    public void setPho_id(Integer pho_id) {
        this.pho_id = pho_id;
    }

    public Integer getPho_wor_id() {
        return pho_wor_id;
    }

    public void setPho_wor_id(Integer pho_wor_id) {
        this.pho_wor_id = pho_wor_id;
    }

    public String getPho_class_id() {
        return pho_class_id;
    }

    public void setPho_class_id(String pho_class_id) {
        this.pho_class_id = pho_class_id;
    }

    public Integer getPho_album_id() {
        return pho_album_id;
    }

    public void setPho_album_id(Integer pho_album_id) {
        this.pho_album_id = pho_album_id;
    }

    public Integer getPho_type() {
        return pho_type;
    }

    public void setPho_type(Integer pho_type) {
        this.pho_type = pho_type;
    }

    public String getPho_name() {
        return pho_name;
    }

    public void setPho_name(String pho_name) {
        this.pho_name = pho_name;
    }

    public String getPho_describe() {
        return pho_describe;
    }

    public void setPho_describe(String pho_describe) {
        this.pho_describe = pho_describe;
    }

    public String getPho_url() {
        return pho_url;
    }

    public void setPho_url(String pho_url) {
        this.pho_url = pho_url;
    }

    public String getPho_html_url() {
        return pho_html_url;
    }

    public void setPho_html_url(String pho_html_url) {
        this.pho_html_url = pho_html_url;
    }

    public String getPho_chain_url() {
        return pho_chain_url;
    }

    public void setPho_chain_url(String pho_chain_url) {
        this.pho_chain_url = pho_chain_url;
    }

    public Date getPho_creation() {
        return pho_creation;
    }

    public void setPho_creation(Date pho_creation) {
        this.pho_creation = pho_creation;
    }

    public Date getPho_lastupdated() {
        return pho_lastupdated;
    }

    public void setPho_lastupdated(Date pho_lastupdated) {
        this.pho_lastupdated = pho_lastupdated;
    }

    public Integer getAlb_isdel() {
        return pho_isdel;
    }

    public void setAlb_isdel(Integer pho_isdel) {
        this.pho_isdel = pho_isdel;
    }


    @Override
    public String toString() {
        return "Photo{" +
        "pho_id=" + pho_id +
        ", pho_wor_id=" + pho_wor_id +
        ", pho_class_id=" + pho_class_id +
        ", pho_album_id=" + pho_album_id +
        ", pho_type=" + pho_type +
        ", pho_name=" + pho_name +
        ", pho_describe=" + pho_describe +
        ", pho_url=" + pho_url +
        ", pho_html_url=" + pho_html_url +
        ", pho_chain_url=" + pho_chain_url +
        ", pho_creation=" + pho_creation +
        ", pho_lastupdated=" + pho_lastupdated +
        ", pho_isdel=" + pho_isdel +
        "}";
    }
}

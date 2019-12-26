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
public class Qr_code extends pageObject  implements Serializable{

    private static final long serialVersionUID=1L;

    /**
     * 二维码主键id
     */
    @TableId(value = "QR_id", type = IdType.AUTO)
    private Integer QR_id;

    /**
     * 二维码名称
     */
    private String QR_name;

    /**
     * 二维码地址url
     */
    private String QR_url;

    /**
     * 创建纪录时间
     */
    private Date QR_creation;

    /**
     * 最后更新时间
     */
    private Date QR_lastupdated;


    public Integer getQR_id() {
        return QR_id;
    }

    public void setQR_id(Integer QR_id) {
        this.QR_id = QR_id;
    }

    public String getQR_name() {
        return QR_name;
    }

    public void setQR_name(String QR_name) {
        this.QR_name = QR_name;
    }

    public String getQR_url() {
        return QR_url;
    }

    public void setQR_url(String QR_url) {
        this.QR_url = QR_url;
    }

    public Date getQR_creation() {
        return QR_creation;
    }

    public void setQR_creation(Date QR_creation) {
        this.QR_creation = QR_creation;
    }

    public Date getQR_lastupdated() {
        return QR_lastupdated;
    }

    public void setQR_lastupdated(Date QR_lastupdated) {
        this.QR_lastupdated = QR_lastupdated;
    }


    @Override
    public String toString() {
        return "Qr_code{" +
        "QR_id=" + QR_id +
        ", QR_name=" + QR_name +
        ", QR_url=" + QR_url +
        ", QR_creation=" + QR_creation +
        ", QR_lastupdated=" + QR_lastupdated +
        "}";
    }
}

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
public class Worker extends pageObject implements Serializable{

    private static final long serialVersionUID=2L;

    /**
     * 工作表主键id
     */
    @TableId(value = "wk_id", type = IdType.AUTO)
    private Integer wk_id;

    /**
     * 工号唯一，管理员添加。用于登陆
     */
    private String wk_num;

    /**
     * 员工角色。
admin 管理员
worker 员工
     */
    private String wk_type;

    /**
     * 员工手机号码
     */
    private String wk_phone;

    /**
     * md5加密后的密码。不允许为空。
     */
    private String wk_password;

    /**
     * 工作人员名称。
     */
    private String wk_name;

    /**
     * 创建纪录时间
     */
    private Date wk_creation;
    
    /**
     * 最后更新时间
     */
    private Date wk_lastupdated;

    /**
     * 使用状态 1启用 0 禁用
     */
    private Integer wk_isdel;

    
    
    public Date getWk_lastupdated() {
		return wk_lastupdated;
	}

	public void setWk_lastupdated(Date wk_lastupdated) {
		this.wk_lastupdated = wk_lastupdated;
	}

	public Integer getWk_id() {
        return wk_id;
    }

    public void setWk_id(Integer wk_id) {
        this.wk_id = wk_id;
    }

    public String getWk_num() {
        return wk_num;
    }

    public void setWk_num(String wk_num) {
        this.wk_num = wk_num;
    }

    public String getWk_type() {
        return wk_type;
    }

    public void setWk_type(String wk_type) {
        this.wk_type = wk_type;
    }

    public String getWk_phone() {
        return wk_phone;
    }

    public void setWk_phone(String wk_phone) {
        this.wk_phone = wk_phone;
    }

    public String getWk_password() {
        return wk_password;
    }

    public void setWk_password(String wk_password) {
        this.wk_password = wk_password;
    }

    public String getWk_name() {
        return wk_name;
    }

    public void setWk_name(String wk_name) {
        this.wk_name = wk_name;
    }

    public Date getWk_creation() {
        return wk_creation;
    }

    public void setWk_creation(Date wk_creation) {
        this.wk_creation = wk_creation;
    }

    public Integer getWk_isdel() {
        return wk_isdel;
    }

    public void setWk_isdel(Integer wk_isdel) {
        this.wk_isdel = wk_isdel;
    }

    @Override
    public String toString() {
        return "Worker{" +
        "wk_id=" + wk_id +
        ", wk_num=" + wk_num +
        ", wk_type=" + wk_type +
        ", wk_phone=" + wk_phone +
        ", wk_password=" + wk_password +
        ", wk_name=" + wk_name +
        ", wk_creation=" + wk_creation +
        ", wk_isdel=" + wk_isdel +
        "}";
    }
}

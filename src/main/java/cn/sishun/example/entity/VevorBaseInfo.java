package cn.sishun.example.entity;

import java.io.Serializable;
import java.util.Date;

public class VevorBaseInfo implements Serializable {
    private Integer id;

    private String store_account;

    private String plat_form;

    private Integer status;

    private Date create_time;

    private Date update_time;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStore_account() {
        return store_account;
    }

    public void setStore_account(String store_account) {
        this.store_account = store_account == null ? null : store_account.trim();
    }

    public String getPlat_form() {
        return plat_form;
    }

    public void setPlat_form(String plat_form) {
        this.plat_form = plat_form == null ? null : plat_form.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}
package com.lbyx.pojo;

import java.util.Date;

public class Order {
    private Integer orderId;

    private Integer adminId;

    private Integer ownerid;

    private Byte ordertype;

    private Float ordervalue;

    private Float usecoupon;

    private Date creattiem;

    private Date delivertime;

    private Date finishtime;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Integer getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(Integer ownerid) {
        this.ownerid = ownerid;
    }

    public Byte getOrdertype() {
        return ordertype;
    }

    public void setOrdertype(Byte ordertype) {
        this.ordertype = ordertype;
    }

    public Float getOrdervalue() {
        return ordervalue;
    }

    public void setOrdervalue(Float ordervalue) {
        this.ordervalue = ordervalue;
    }

    public Float getUsecoupon() {
        return usecoupon;
    }

    public void setUsecoupon(Float usecoupon) {
        this.usecoupon = usecoupon;
    }

    public Date getCreattiem() {
        return creattiem;
    }

    public void setCreattiem(Date creattiem) {
        this.creattiem = creattiem;
    }

    public Date getDelivertime() {
        return delivertime;
    }

    public void setDelivertime(Date delivertime) {
        this.delivertime = delivertime;
    }

    public Date getFinishtime() {
        return finishtime;
    }

    public void setFinishtime(Date finishtime) {
        this.finishtime = finishtime;
    }
}
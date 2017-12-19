package com.lbyx.pojo;

import java.util.Date;

public class CarItem {
    private Integer carItemId;

    private Integer carId;

    private Integer goodsId;

    private Integer goodsnumber;

    private Date addtime;

    public Integer getCarItemId() {
        return carItemId;
    }

    public void setCarItemId(Integer carItemId) {
        this.carItemId = carItemId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGoodsnumber() {
        return goodsnumber;
    }

    public void setGoodsnumber(Integer goodsnumber) {
        this.goodsnumber = goodsnumber;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }
}
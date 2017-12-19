package com.lbyx.pojo;

import java.util.Date;

public class GoodsDesc {
    private Integer goodsDescId;

    private Integer goodsId;

    private Date uploadtime;

    private String goodsdesc;

    public Integer getGoodsDescId() {
        return goodsDescId;
    }

    public void setGoodsDescId(Integer goodsDescId) {
        this.goodsDescId = goodsDescId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Date getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
    }

    public String getGoodsdesc() {
        return goodsdesc;
    }

    public void setGoodsdesc(String goodsdesc) {
        this.goodsdesc = goodsdesc == null ? null : goodsdesc.trim();
    }
}
package com.lbyx.pojo;

public class GoodsType {
    private Integer goodsTypeId;

    private Integer fatherTypeId;

    private String typename;

    private Integer sortorder;

    public Integer getGoodsTypeId() {
        return goodsTypeId;
    }

    public void setGoodsTypeId(Integer goodsTypeId) {
        this.goodsTypeId = goodsTypeId;
    }

    public Integer getFatherTypeId() {
        return fatherTypeId;
    }

    public void setFatherTypeId(Integer fatherTypeId) {
        this.fatherTypeId = fatherTypeId;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    public Integer getSortorder() {
        return sortorder;
    }

    public void setSortorder(Integer sortorder) {
        this.sortorder = sortorder;
    }
}
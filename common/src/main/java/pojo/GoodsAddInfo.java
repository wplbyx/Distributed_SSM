package pojo;

import java.util.Date;
import java.util.List;

/**
 *  Created by Administrator on 2017/12/24 0024.
 */
public class GoodsAddInfo {
    private Integer goodsId;      // 商品的 id
    private Integer goodsTypeId;  // 商品的 类目id
    private String goodsname;     // 商品的名字
    private String goodsdesc;     // 商品的简单文字描述
    private Float goodsprice;     // 商品的价格
    private Integer goodsnumber;  // 商品的库存
    private String provider;      // 商品的供货商
    private Date ontime;          // 商品上架的时间
    private Date offtime;         // 商品下架的时间
    private Byte status;          // 商品的状态 在售，下架，删除
    private Integer givepoints;   // 商品价值的积分

    private String desc;    // 商品的详细描述
    private List<String> img;     // 商品的图片列表

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGoodsTypeId() {
        return goodsTypeId;
    }

    public void setGoodsTypeId(Integer goodsTypeId) {
        this.goodsTypeId = goodsTypeId;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public String getGoodsdesc() {
        return goodsdesc;
    }

    public void setGoodsdesc(String goodsdesc) {
        this.goodsdesc = goodsdesc;
    }

    public Float getGoodsprice() {
        return goodsprice;
    }

    public void setGoodsprice(Float goodsprice) {
        this.goodsprice = goodsprice;
    }

    public Integer getGoodsnumber() {
        return goodsnumber;
    }

    public void setGoodsnumber(Integer goodsnumber) {
        this.goodsnumber = goodsnumber;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public Date getOntime() {
        return ontime;
    }

    public void setOntime(Date ontime) {
        this.ontime = ontime;
    }

    public Date getOfftime() {
        return offtime;
    }

    public void setOfftime(Date offtime) {
        this.offtime = offtime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getGivepoints() {
        return givepoints;
    }

    public void setGivepoints(Integer givepoints) {
        this.givepoints = givepoints;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<String> getImg() {
        return img;
    }

    public void setImg(List<String> img) {
        this.img = img;
    }
}

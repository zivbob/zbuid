package com.ziv.pay;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

/**
 * 商品信息
 *
 * @author ziv
 * @date 2020-10-14
 */
public class AliPayGoods {

    /**
     * 商品编号
     */
    private String goodsId;

    /**
     * 支付宝定义的统一商品编号
     */
    private String aliPayGoodsId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品数量
     */
    private Integer quantity;

    /**
     * 商品单价/元
     */
    private BigDecimal price;

    /**
     * 商品类目
     */
    private String goodsCategory;

    /**
     * 商品类目树，从商品类目根节点到叶子节点的类目id组成，类目id值使用|分割，ex：124868003|126232002|126252004
     */
    private String categoriesTree;

    /**
     * 商品描述信息
     */
    private String body;

    /**
     * 商品的展示地址
     */
    private String showUrl;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getAliPayGoodsId() {
        return aliPayGoodsId;
    }

    public void setAliPayGoodsId(String aliPayGoodsId) {
        this.aliPayGoodsId = aliPayGoodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCategoriesTree() {
        return categoriesTree;
    }

    public void setCategoriesTree(String categoriesTree) {
        this.categoriesTree = categoriesTree;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getShowUrl() {
        return showUrl;
    }

    public void setShowUrl(String showUrl) {
        this.showUrl = showUrl;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> info = new HashMap<>(32);

        info.put("goods_id", goodsId);
        info.put("alipay_goods_id", aliPayGoodsId);
        info.put("goods_name", goodsName);
        info.put("quantity", quantity);
        info.put("price", price.setScale(2, RoundingMode.HALF_UP).doubleValue());
        info.put("goods_category", goodsCategory);
        info.put("categories_tree", categoriesTree);
        info.put("body", body);
        info.put("show_url", showUrl);

        return info;
    }

}

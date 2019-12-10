package com.jianghua.warehousemanager.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_goods")
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class TGoods {
    @Id
    private Integer id;

    @Column(name = "goods_name")
    private String goodsName;

    private String model;

    private String unit;

    private Integer price;

    private Integer stock;

    @Column(name = "old_price")
    private Integer oldPrice;

    @Column(name = "total_price")
    private Integer totalPrice;

    /**
     * 1:正常 2:删除
     */
    private Integer state;

    @Column(name = "update_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;

    @Column(name = "create_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return goods_name
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * @param goodsName
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    /**
     * @return model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @return unit
     */
    public String getUnit() {
        return unit;
    }

    /**
     * @param unit
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * @return price
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * @return stock
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * @param stock
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * @return old_price
     */
    public Integer getOldPrice() {
        return oldPrice;
    }

    /**
     * @param oldPrice
     */
    public void setOldPrice(Integer oldPrice) {
        this.oldPrice = oldPrice;
    }

    /**
     * @return total_price
     */
    public Integer getTotalPrice() {
        return totalPrice;
    }

    /**
     * @param totalPrice
     */
    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * 获取1:正常 2:删除
     *
     * @return state - 1:正常 2:删除
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置1:正常 2:删除
     *
     * @param state 1:正常 2:删除
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
package com.jianghua.warehousemanager.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_order")
public class TOrder {
    @Id
    private Integer id;

    @Column(name = "goods_id")
    private Integer goodsId;

    /**
     * 1:入库 0:出库
     */
    private String flag;

    private Integer num;

    private Integer price;

    @Column(name = "total_price")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Integer totalPrice;

    @Column(name = "create_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    /**
     * 1:正常 0:删除
     */
    private Integer state;

    @Column(name = "update_time")
    private Date updateTime;

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
     * @return goods_id
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * @param goodsId
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * 获取1:入库 0:出库
     *
     * @return flag - 1:入库 0:出库
     */
    public String getFlag() {
        return flag;
    }

    /**
     * 设置1:入库 0:出库
     *
     * @param flag 1:入库 0:出库
     */
    public void setFlag(String flag) {
        this.flag = flag;
    }

    /**
     * @return num
     */
    public Integer getNum() {
        return num;
    }

    /**
     * @param num
     */
    public void setNum(Integer num) {
        this.num = num;
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

    /**
     * 获取1:正常 0:删除
     *
     * @return state - 1:正常 0:删除
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置1:正常 0:删除
     *
     * @param state 1:正常 0:删除
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
}
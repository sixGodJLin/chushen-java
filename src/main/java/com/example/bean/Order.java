package com.example.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "`order`", schema = "chushen")
public class Order {
    private int id;
    private int addressId;
    private int userId;
    private Timestamp createTime;
    private double totalPrice;
    private byte isFinished;
    private byte isPayed;
    private byte isDeliver;
    private byte isReceive;
    private Collection<OrderItem> orderItems;

    public Order(){

    }

    public Order(int orderId) {
        this.id = orderId;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "create_time")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'.000+0000'")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "total_price")
    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Basic
    @Column(name = "is_finished")
    public byte getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(byte isFinished) {
        this.isFinished = isFinished;
    }

    @Basic
    @Column(name = "is_payed")
    public byte getIsPayed() {
        return isPayed;
    }

    public void setIsPayed(byte isPayed) {
        this.isPayed = isPayed;
    }

    @Basic
    @Column(name = "is_deliver")
    public byte getIsDeliver() {
        return isDeliver;
    }

    public void setIsDeliver(byte isDeliver) {
        this.isDeliver = isDeliver;
    }

    @Basic
    @Column(name = "is_receive")
    public byte getIsReceive() {
        return isReceive;
    }

    public void setIsReceive(byte isReceive) {
        this.isReceive = isReceive;
    }

    @OneToMany(mappedBy = "order")
    public Collection<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Collection<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", addressId=" + addressId +
                ", userId=" + userId +
                ", createTime=" + createTime +
                ", totalPrice=" + totalPrice +
                ", isFinished=" + isFinished +
                ", isPayed=" + isPayed +
                ", isDeliver=" + isDeliver +
                ", isReceive=" + isReceive +
                ", orderItems=" + orderItems +
                '}';
    }
}

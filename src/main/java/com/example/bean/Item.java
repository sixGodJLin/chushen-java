package com.example.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Item {
    private int id;
    private String name;
    private double price;
    private int storeNum;
    private String imgUrlJson;
    private int sellNum;
    private Timestamp time;
    private Type type;
    private Shop shop;
    private int commentNum;

    public Item() {
    }

    public Item(int itemId) {
        this.id = itemId;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "store_num")
    public int getStoreNum() {
        return storeNum;
    }

    public void setStoreNum(int storeNum) {
        this.storeNum = storeNum;
    }

    @Basic
    @Column(name = "img_url_json")
    public String getImgUrlJson() {
        return imgUrlJson;
    }

    public void setImgUrlJson(String imgUrlJson) {
        this.imgUrlJson = imgUrlJson;
    }

    @Basic
    @Column(name = "sell_num")
    public int getSellNum() {
        return sellNum;
    }

    public void setSellNum(int sellNum) {
        this.sellNum = sellNum;
    }

    @Basic
    @Column(name = "time")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'.000+0000'")
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Basic
    @Column(name = "comment_num")
    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id", nullable = false)
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @ManyToOne
    @JoinColumn(name = "by_shopid", referencedColumnName = "id", nullable = false)
    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (id != item.id) return false;
        if (Double.compare(item.price, price) != 0) return false;
        if (storeNum != item.storeNum) return false;
        if (sellNum != item.sellNum) return false;
        if (commentNum != item.commentNum) return false;
        if (name != null ? !name.equals(item.name) : item.name != null) return false;
        if (imgUrlJson != null ? !imgUrlJson.equals(item.imgUrlJson) : item.imgUrlJson != null) return false;
        if (time != null ? !time.equals(item.time) : item.time != null) return false;
        if (type != null ? !type.equals(item.type) : item.type != null) return false;
        return shop != null ? shop.equals(item.shop) : item.shop == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + storeNum;
        result = 31 * result + (imgUrlJson != null ? imgUrlJson.hashCode() : 0);
        result = 31 * result + sellNum;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (shop != null ? shop.hashCode() : 0);
        result = 31 * result + commentNum;
        return result;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", storeNum=" + storeNum +
                ", imgUrlJson='" + imgUrlJson + '\'' +
                ", sellNum=" + sellNum +
                ", time=" + time +
                ", type=" + type +
                ", shop=" + shop +
                ", commentNum=" + commentNum +
                '}';
    }
}

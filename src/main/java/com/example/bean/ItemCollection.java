package com.example.bean;

import javax.persistence.*;

@Entity
@Table(name = "item_collection", schema = "chushen")
public class ItemCollection {
    private int id;
    private int userId;
    private Item item;

    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "id",nullable = false)
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
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
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemCollection that = (ItemCollection) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        return item != null ? item.equals(that.item) : that.item == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userId;
        result = 31 * result + (item != null ? item.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ItemCollection{" +
                "id=" + id +
                ", userId=" + userId +
                ", item=" + item +
                '}';
    }
}

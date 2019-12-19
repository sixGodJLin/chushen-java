package com.example.bean;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "day_recommend", schema = "chushen")
public class DayRecommend {
    private int id;
    private Timestamp dateFrom;
    private Timestamp dateTo;
    private Item item;
    private String account;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "date_from")
    public Timestamp getDateFrom() {
        return dateFrom;
    }
    public void setDateFrom(Timestamp dateFrom) {
        this.dateFrom = dateFrom;
    }

    @Basic
    @Column(name = "date_to")
    public Timestamp getDateTo() {
        return dateTo;
    }
    public void setDateTo(Timestamp dateTo) {
        this.dateTo = dateTo;
    }


    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DayRecommend that = (DayRecommend) o;

        if (id != that.id) return false;
        if (dateFrom != null ? !dateFrom.equals(that.dateFrom) : that.dateFrom != null) return false;
        if (dateTo != null ? !dateTo.equals(that.dateTo) : that.dateTo != null) return false;
        if (item != null ? !item.equals(that.item) : that.item != null) return false;
        return account != null ? account.equals(that.account) : that.account == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (dateFrom != null ? dateFrom.hashCode() : 0);
        result = 31 * result + (dateTo != null ? dateTo.hashCode() : 0);
        result = 31 * result + (item != null ? item.hashCode() : 0);
        result = 31 * result + (account != null ? account.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "by_item", referencedColumnName = "id", nullable = false)
    public Item getItem() {
        return item;
    }
    public void setItem(Item item) {
        this.item = item;
    }
}

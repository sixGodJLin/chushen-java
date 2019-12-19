package com.example.bean;

import javax.persistence.*;

@Entity
@Table(name = "menu_collection", schema = "chushen")
public class MenuCollection {
    private int id;
    private int userId;
    private Menu menu;

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

    @ManyToOne
    @JoinColumn(name = "menu_id", referencedColumnName = "id", nullable = false)
    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MenuCollection that = (MenuCollection) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        return menu != null ? menu.equals(that.menu) : that.menu == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userId;
        result = 31 * result + (menu != null ? menu.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MenuCollection{" +
                "id=" + id +
                ", userId=" + userId +
                ", menu=" + menu +
                '}';
    }
}

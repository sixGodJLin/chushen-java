package com.example.bean;

import javax.persistence.*;

@Entity
@Table(name = "item_comment", schema = "chushen")
public class ItemComment {
    private int id;
    private String content;
    private Integer commentId;
    private User user;
    private int itemId;

    @OneToOne()
    @JoinColumn(name = "user_id" , referencedColumnName = "id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
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
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "comment_id")
    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemComment that = (ItemComment) o;

        if (id != that.id) return false;
        if (commentId != that.commentId) return false;
        if (itemId != that.itemId) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        return user != null ? user.equals(that.user) : that.user == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + commentId;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + itemId;
        return result;
    }
}


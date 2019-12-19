package com.example.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "discover", schema = "chushen")
public class Discover {
    private int id;
    private User user;
    private String content;
    private Timestamp createTime;
    private String imageUrls;
    private String videoUrl;
    private int upvote;
    private int commentNum;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToOne
    @JoinColumn(name = "user_id" , referencedColumnName = "id", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
    @Column(name = "create_time")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'.000+0000'")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "image_urls")
    public String getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(String imageUrls) {
        this.imageUrls = imageUrls;
    }

    @Basic
    @Column(name = "video_url")
    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    @Basic
    @Column(name = "upvote")
    public int getUpvote() {
        return upvote;
    }

    public void setUpvote(int upvote) {
        this.upvote = upvote;
    }

    @Basic
    @Column(name = "comment_num")
    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commnetNum) {
        this.commentNum = commnetNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discover discover = (Discover) o;
        return id == discover.id &&
                upvote == discover.upvote &&
                commentNum == discover.commentNum &&
                Objects.equals(user, discover.user) &&
                Objects.equals(content, discover.content) &&
                Objects.equals(createTime, discover.createTime) &&
                Objects.equals(imageUrls, discover.imageUrls) &&
                Objects.equals(videoUrl, discover.videoUrl);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, user, content, createTime, imageUrls, videoUrl, upvote, commentNum);
    }

    @Override
    public String toString() {
        return "Discover{" +
                "id=" + id +
                ", user=" + user +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", imageUrls='" + imageUrls + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                ", upvote=" + upvote +
                ", commnetNum=" + commentNum +
                '}';
    }
}

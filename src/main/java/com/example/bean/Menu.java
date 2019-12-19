package com.example.bean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Menu {
    private int id;
    private String menuName;
    private String imgUrl;
    private String videoUrl;
    private String mainStuff;
    private String assistStuff;
    private String method;
    private String tips;
    private String score;
    private String type;

    public Menu() {
    }

    public Menu(int menuId) {
        this.id = menuId;
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
    @Column(name = "menu_name")
    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    @Basic
    @Column(name = "img_url")
    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
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
    @Column(name = "main_stuff")
    public String getMainStuff() {
        return mainStuff;
    }

    public void setMainStuff(String mainStuff) {
        this.mainStuff = mainStuff;
    }

    @Basic
    @Column(name = "assist_stuff")
    public String getAssistStuff() {
        return assistStuff;
    }

    public void setAssistStuff(String assistStuff) {
        this.assistStuff = assistStuff;
    }

    @Basic
    @Column(name = "method")
    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Basic
    @Column(name = "tips")
    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    @Basic
    @Column(name = "score")
    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Menu menu = (Menu) o;

        if (id != menu.id) return false;
        if (menuName != null ? !menuName.equals(menu.menuName) : menu.menuName != null) return false;
        if (imgUrl != null ? !imgUrl.equals(menu.imgUrl) : menu.imgUrl != null) return false;
        if (videoUrl != null ? !videoUrl.equals(menu.videoUrl) : menu.videoUrl != null) return false;
        if (mainStuff != null ? !mainStuff.equals(menu.mainStuff) : menu.mainStuff != null) return false;
        if (assistStuff != null ? !assistStuff.equals(menu.assistStuff) : menu.assistStuff != null) return false;
        if (method != null ? !method.equals(menu.method) : menu.method != null) return false;
        if (tips != null ? !tips.equals(menu.tips) : menu.tips != null) return false;
        if (score != null ? !score.equals(menu.score) : menu.score != null) return false;
        return type != null ? type.equals(menu.type) : menu.type == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (menuName != null ? menuName.hashCode() : 0);
        result = 31 * result + (imgUrl != null ? imgUrl.hashCode() : 0);
        result = 31 * result + (videoUrl != null ? videoUrl.hashCode() : 0);
        result = 31 * result + (mainStuff != null ? mainStuff.hashCode() : 0);
        result = 31 * result + (assistStuff != null ? assistStuff.hashCode() : 0);
        result = 31 * result + (method != null ? method.hashCode() : 0);
        result = 31 * result + (tips != null ? tips.hashCode() : 0);
        result = 31 * result + (score != null ? score.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", menuName='" + menuName + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                ", mainStuff='" + mainStuff + '\'' +
                ", assistStuff='" + assistStuff + '\'' +
                ", method='" + method + '\'' +
                ", tips='" + tips + '\'' +
                ", score='" + score + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

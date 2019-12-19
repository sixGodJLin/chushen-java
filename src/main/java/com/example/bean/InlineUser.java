package com.example.bean;

import org.springframework.data.rest.core.config.Projection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.Collection;

@Projection(name = "inlineUser", types = User.class)
public interface InlineUser {
    public int getId();

    public String getUsername();

    public String getPassword();

    public String getNickname();

    public String getHeadImgUrl();

    public String getTel();

    Double getAssets();

    boolean isEnable();
}

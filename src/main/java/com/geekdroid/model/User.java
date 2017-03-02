package com.geekdroid.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

/**
 * Created by james.li on 2017/3/2.
 */
@ApiModel("User(用户模型)")
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    @ApiModelProperty("用户名")
    private String userId;
    @ApiModelProperty("用户昵称")
    private String nickName;
    @ApiModelProperty("用户密码")
    private String password;
    @ApiModelProperty("个性签名")
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

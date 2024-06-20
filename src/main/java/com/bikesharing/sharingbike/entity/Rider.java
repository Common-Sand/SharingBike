package com.bikesharing.sharingbike.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Data
public class Rider {
    @NotNull
    private Long id;
    @NotNull
    private String username;
    @JsonIgnore
    private String password;
    @NotEmpty
    private String phone;
    @NotEmpty
    private String avatar;
    @NotNull
    private Integer age;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}
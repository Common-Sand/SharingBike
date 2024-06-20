package com.bikesharing.sharingbike.entity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Data
public class Bike {
    @NotNull
    private Long id;
    @NotNull
    private double locationX;
    @NotNull
    private double locationY;
    @NotEmpty
    private LocalDateTime deployTime;
    @NotEmpty
    private String status;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    public void setId(Long id) {
        this.id = id;
    }

    public void setDeployTime(LocalDateTime deployTime) {
        this.deployTime = deployTime;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public void setLocationX(@NotNull double locationX) {
        this.locationX = locationX;
    }

    public void setLocationY(@NotNull double locationY) {
        this.locationY = locationY;
    }
}
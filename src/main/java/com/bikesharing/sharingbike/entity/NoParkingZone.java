package com.bikesharing.sharingbike.entity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Data
public class NoParkingZone {
    @NotNull
    private Long id;
    @NotEmpty
    private String location;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    public void setId(Long id) {
        this.id = id;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}
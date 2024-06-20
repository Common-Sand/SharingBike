package com.bikesharing.sharingbike.entity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Data
public class Record {
    @NotNull
    private Long id;
    @NotNull
    private Long rid;
    @NotNull
    private Long bid;
    @NotEmpty
    private String startLocation;

    private String endLocation;
    @NotEmpty
    private String status;
    @NotNull
    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    public void setId(Long id) {
        this.id = id;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public void setBid(Long bid) {
        this.bid = bid;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation == null ? null : startLocation.trim();
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation == null ? null : endLocation.trim();
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public void setStartTime(@NotNull LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}
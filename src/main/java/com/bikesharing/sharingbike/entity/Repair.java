package com.bikesharing.sharingbike.entity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
@Setter
@Getter
@Data
public class Repair {
    @NotNull
    private Long id;
    @NotNull
    private Long bid;
    @NotEmpty
    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
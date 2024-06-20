package com.bikesharing.sharingbike.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    public static <T> Result<T> success(T data) {
        return new Result<T>(200, "操作成功", data);
    }
    public static Result success() {
        return new Result(200,"操作成功",null);
    }

    public static Result error( String message) {
        return new Result(500, message, null);
    }
}

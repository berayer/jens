package com.zbx.jens.core.response;

import lombok.Getter;

/**
 * @author zbx
 * @date 2023/5/22
 * @description
 **/
@Getter
public class Result<T> {

    private final int code;
    private final String msg;
    private final T data;

    private Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> Result<T> success() {
        return ofStatus(ResponseStatus.SUCCESS);
    }

    public static <T> Result<T> success(T data) {
        return ofStatus(ResponseStatus.SUCCESS, data);
    }

    public static <T> Result<T> failed() {
        return ofStatus(ResponseStatus.FAILED);
    }

    public static <T> Result<T> failed(T data) {
        return ofStatus(ResponseStatus.FAILED, data);
    }

    public static <T> Result<T> error() {
        return ofStatus(ResponseStatus.ERROR);
    }

    public static <T> Result<T> error(T data) {
        return ofStatus(ResponseStatus.ERROR, data);
    }

    public static <T> Result<T> ofStatus(ResponseStatus status) {
        return ofStatus(status, null);
    }

    public static <T> Result<T> ofStatus(ResponseStatus status, T data) {
        return new Result<>(status.getCode(), status.getMsg(), data);
    }

}

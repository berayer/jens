package com.zbx.jens.core.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author zbx
 * @date 2023/5/22
 * @description
 **/
@RequiredArgsConstructor
@Getter
public enum ResponseStatus {

    SUCCESS(200, "ok"),
    FAILED(400, "客户端错误"),
    ERROR(500,"服务器错误");

    private final int code;
    private final String msg;

}

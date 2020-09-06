package com.miniweibo.common.dto;

import com.miniweibo.common.constant.MessageCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author nicolas.chan
 * 2020/9/6
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse<T> {

    private T data;
    private int code;
    private String msg;

    public CommonResponse<T> success(T t) {
        this.code = MessageCode.SUCCESS.getVal();
        this.msg = MessageCode.SUCCESS.getDesc();
        this.data = t;
        return this;
    }

    public CommonResponse<T> fail(MessageCode messageCode, T t) {
        this.code = messageCode.getVal();
        this.msg = messageCode.getDesc();
        this.data = t;
        return this;
    }

}

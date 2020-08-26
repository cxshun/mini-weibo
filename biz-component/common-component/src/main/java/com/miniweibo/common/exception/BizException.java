package com.miniweibo.common.exception;

import com.miniweibo.common.constant.MessageCode;

/**
 * @author nicolas.chan
 * 2020/8/26
 */
public class BizException extends Exception{

    private String msg;

    public BizException(MessageCode messageCode, Object... args) {
        this.msg = String.format(messageCode.getDesc(), args);
    }

    @Override
    public String getMessage() {
        return msg;
    }
}

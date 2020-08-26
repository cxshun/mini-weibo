package com.miniweibo.common.constant;

import lombok.Getter;

/**
 * @author nicolas.chan
 * 2020/8/26
 */
@Getter
public enum MessageCode {
    /**
     * message code for represent business process result, only 200 represent success
     */
    SUCCESS(200, "success"),
    BIZ_ERROR(400, "biz error"),
    CUSTOM_ERROR(400, "%s");

    private int val;
    private String desc;

    MessageCode(int val, String desc) {
        this.val = val;
        this.desc = desc;
    }

}

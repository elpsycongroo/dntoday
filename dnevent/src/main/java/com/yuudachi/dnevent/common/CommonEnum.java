package com.yuudachi.dnevent.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Description: TODO
 *
 * @author Yuudachi(Han Zhumeng)
 * @since 2019/12/6
 */
@Getter
@AllArgsConstructor
public enum CommonEnum {

    /**
     * 成功
     */
    SUCCESS(0, "SUCCESS"),
    /**
     * 失败
     */
    ERROR(-1, "ERROR");

    /**
     * 业务码
     */
    private int code;
    /**
     * 提示信息
     */
    private String msg;

}

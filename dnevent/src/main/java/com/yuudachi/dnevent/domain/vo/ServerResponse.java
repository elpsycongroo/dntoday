package com.yuudachi.dnevent.domain.vo;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * Description: 通用返回类
 *
 * @author Yuudachi(Han Zhumeng)
 * @since 2019/12/6
 */
@Data
@Builder
public class ServerResponse<T> implements Serializable {

    private Integer code;

    private String msg;

    private T data;
}

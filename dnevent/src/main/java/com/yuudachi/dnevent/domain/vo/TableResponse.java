package com.yuudachi.dnevent.domain.vo;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Description: TODO
 *
 * @author Yuudachi(Han Zhumeng)
 * @since 2019/12/6
 */
@Data
@Builder
public class TableResponse<T> {

    private Integer total;

    private List<T> rows;

}

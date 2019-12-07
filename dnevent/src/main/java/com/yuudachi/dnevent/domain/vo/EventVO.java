package com.yuudachi.dnevent.domain.vo;

import lombok.Data;

/**
 * Description: EventVO
 *
 * @author Yuudachi(Han Zhumeng)
 * @since 2019/12/6
 */
@Data
public class EventVO {

    private String id;

    private String name;

    private String description;

    private String award;

    private String fluqType;

    private String awardType;

    private String startTime;

    private String endTime;

    private String isWegame;
}

package com.yuudachi.dnevent.domain.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Description: 事件PO
 *
 * @author Yuudachi(Han Zhumeng)
 * @since 2019/12/5
 */
@Entity
@Data
@Table(name = "event")
public class EventPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String award;

    @Column
    private String fluqType;

    @Column
    private String awardType;

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate startTime;

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate endTime;

    @Column
    private String isWegame;

}

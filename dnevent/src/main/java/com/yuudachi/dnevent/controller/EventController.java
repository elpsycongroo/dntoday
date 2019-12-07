package com.yuudachi.dnevent.controller;

import com.yuudachi.dnevent.common.CommonEnum;
import com.yuudachi.dnevent.domain.vo.EventVO;
import com.yuudachi.dnevent.domain.vo.ServerResponse;
import com.yuudachi.dnevent.domain.vo.TableResponse;
import com.yuudachi.dnevent.service.EventService;
import io.lettuce.core.dynamic.annotation.Param;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Description: 事件控制器
 *
 * @author Yuudachi(Han Zhumeng)
 * @since 2019/12/6
 */
@RestController
@Slf4j
@Validated
@AllArgsConstructor
@RequestMapping("/api/event")
public class EventController {

    private EventService eventService;

    @CrossOrigin(origins = "*")
    @GetMapping
    public TableResponse getEventListByDate(@Param("date") String date) {
        List list = eventService.getEventList(date);
        return TableResponse.builder().total(list.size())
                .rows(list).build();
    }

}

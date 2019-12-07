package com.yuudachi.dnevent.service;

import com.yuudachi.dnevent.ConvertUtil;
import com.yuudachi.dnevent.domain.po.EventPO;
import com.yuudachi.dnevent.domain.vo.EventVO;
import com.yuudachi.dnevent.repository.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Description: 事件服务类
 *
 * @author Yuudachi(Han Zhumeng)
 * @since 2019/12/5
 */
@Service
@AllArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    private final RedisTemplate<String, Object> hashRedisTemplate;

    private final DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public List<EventVO> getEventList(String nowTime) {
        if (StringUtils.isEmpty(nowTime)) {
            nowTime = LocalDate.now().format(df);
        }
        List<EventVO> eventList = (List<EventVO>)hashRedisTemplate.opsForValue().get(nowTime);
//        if (null != eventList) {
//            return eventList;
//        }
        eventList = ConvertUtil.eventPoListConvert2VoList(eventRepository.getListByTime(nowTime));
        hashRedisTemplate.opsForValue().set(nowTime, eventList);
        hashRedisTemplate.expire(nowTime, 6*60*60, TimeUnit.SECONDS);
        return eventList;
    }

}

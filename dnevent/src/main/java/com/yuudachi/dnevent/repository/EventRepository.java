package com.yuudachi.dnevent.repository;

import com.yuudachi.dnevent.domain.po.EventPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description: 事件DAO
 *
 * @author Yuudachi(Han Zhumeng)
 * @since 2019/12/5
 */
@Repository
public interface EventRepository extends JpaRepository<EventPO, Long>, JpaSpecificationExecutor<EventPO> {

    /**
     * 根据时间查询该时间前后的事件
     * @param nowTime
     * @return
     */
    @Query(nativeQuery = true, value = "select * from event where start_time <= :#{#nowTime} and end_time >= :#{#nowTime} and is_wegame in (1,2) order by id")
    List<EventPO> getListByTime(String nowTime);

}

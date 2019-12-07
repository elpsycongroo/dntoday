package com.yuudachi.dnevent;

import com.yuudachi.dnevent.domain.po.EventPO;
import com.yuudachi.dnevent.domain.vo.EventVO;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description: ConvertUtil
 *
 * @author Yuudachi(Han Zhumeng)
 * @since 2019/12/6
 */
public class ConvertUtil {

    private static final DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static EventVO eventPoConvert2Vo(EventPO po) {
        EventVO vo = new EventVO();
        vo.setId(String.valueOf(po.getId()));
        vo.setName(po.getName());
        vo.setDescription(po.getDescription());
        vo.setAward(po.getAward());
        vo.setFluqType(po.getFluqType());
        vo.setAwardType(po.getAwardType());
        vo.setStartTime(po.getStartTime().format(df));
        vo.setEndTime(po.getEndTime().format(df));
        vo.setIsWegame(po.getIsWegame());
        return vo;
    }

    public static List<EventVO> eventPoListConvert2VoList(List<EventPO> poList) {
        return poList.stream().map(ConvertUtil::eventPoConvert2Vo).collect(Collectors.toList());
    }

}

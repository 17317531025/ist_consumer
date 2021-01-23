package com.ist.kafka.consumer.dao;

import com.ist.kafka.consumer.domain.Msg;
import com.ist.kafka.consumer.domain.MsgExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface MsgMapper {
    long countByExample(MsgExample example);

    int deleteByExample(MsgExample example);

    int insert(Msg record);

    int insertSelective(Msg record);

    List<Msg> selectByExample(MsgExample example);

    int updateByExampleSelective(@Param("record") Msg record, @Param("example") MsgExample example);

    int updateByExample(@Param("record") Msg record, @Param("example") MsgExample example);

    int updateByParams(Map<String, Object> params);
}
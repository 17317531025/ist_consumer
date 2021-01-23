package com.ist.kafka.consumer.dao;

import com.ist.kafka.consumer.domain.MsgGroup;
import com.ist.kafka.consumer.domain.MsgGroupExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MsgGroupMapper {
    long countByExample(MsgGroupExample example);

    int deleteByExample(MsgGroupExample example);

    int deleteByPrimaryKey(Long groupid);

    int insert(MsgGroup record);

    int insertSelective(MsgGroup record);

    List<MsgGroup> selectByExample(MsgGroupExample example);

    MsgGroup selectByPrimaryKey(Long groupid);

    int updateByExampleSelective(@Param("record") MsgGroup record, @Param("example") MsgGroupExample example);

    int updateByExample(@Param("record") MsgGroup record, @Param("example") MsgGroupExample example);

    int updateByPrimaryKeySelective(MsgGroup record);

    int updateByPrimaryKey(MsgGroup record);
}
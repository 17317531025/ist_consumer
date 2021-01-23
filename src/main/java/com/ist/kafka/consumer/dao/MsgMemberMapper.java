package com.ist.kafka.consumer.dao;

import com.ist.kafka.consumer.domain.MsgMember;
import com.ist.kafka.consumer.domain.MsgMemberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MsgMemberMapper {
    long countByExample(MsgMemberExample example);

    int deleteByExample(MsgMemberExample example);

    int insert(MsgMember record);

    int insertSelective(MsgMember record);

    List<MsgMember> selectByExample(MsgMemberExample example);

    int updateByExampleSelective(@Param("record") MsgMember record, @Param("example") MsgMemberExample example);

    int updateByExample(@Param("record") MsgMember record, @Param("example") MsgMemberExample example);

    Integer selectMaxSeqByGroupId(long parseLong);
}
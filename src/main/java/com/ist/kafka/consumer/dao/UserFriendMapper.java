package com.ist.kafka.consumer.dao;

import com.ist.kafka.consumer.domain.UserFriend;
import com.ist.kafka.consumer.domain.UserFriendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserFriendMapper {
    long countByExample(UserFriendExample example);

    int deleteByExample(UserFriendExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserFriend record);

    int insertSelective(UserFriend record);

    List<UserFriend> selectByExample(UserFriendExample example);

    UserFriend selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserFriend record, @Param("example") UserFriendExample example);

    int updateByExample(@Param("record") UserFriend record, @Param("example") UserFriendExample example);

    int updateByPrimaryKeySelective(UserFriend record);

    int updateByPrimaryKey(UserFriend record);
}
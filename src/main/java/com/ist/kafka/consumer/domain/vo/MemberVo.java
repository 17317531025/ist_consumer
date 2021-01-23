package com.ist.kafka.consumer.domain.vo;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @Author: ligun
 */
@Setter
@Getter
public class MemberVo {
    private String memberId;
    private String seq;
    private String talker;
    private String nickname;
    private String avatarUrl;
    private String createTime;
    private String updateTime;
    private String optUserId;
    private String inviteUserId;
    private Integer role;
    private String lockTime;
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}

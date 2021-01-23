package com.ist.kafka.consumer.domain.vo;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * @Author: ligun
 */
@Setter
@Getter
public class GetGroupMembyIdVo {
    private String groupId;
    private List<String> talkers;
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}

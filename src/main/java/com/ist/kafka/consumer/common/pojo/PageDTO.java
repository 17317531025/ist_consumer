package com.ist.kafka.consumer.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class PageDTO {

    private Integer pageNum;
    private Integer pageSize;
    private String startTime;
    private String endTime;

    public PageDTO(Integer pageNum, Integer pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.startTime = null;
        this.endTime = null;
    }
}

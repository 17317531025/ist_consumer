package com.ist.kafka.consumer.common.pojo;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * <pre>
 *	code SUCCESS = 0
 * <pre>
 */
public class ResultVO {
    private static final String SUCCESS = "0";
	private boolean flag;
    private String code;
    private String msg;
    private Integer count;
    private Object data;

    public ResultVO() {
    	this.flag = true;
        this.code = SUCCESS;
        this.msg = "成功";
    }
    public ResultVO(Integer count, Object data){
        this.count = count;
        this.flag = true;
        this.code = SUCCESS;
        this.msg = "成功";
        this.data = data;
    }
    public ResultVO(Object data){
        this.flag = true;
        this.code = SUCCESS;
        this.msg = "成功";
        this.data = data;
    }

    public ResultVO(String code, String desc) {
        this.code = code;
        this.msg = desc;
        if(code == SUCCESS){
            this.flag = true;
        }else {
            this.flag = false;
        }
    }


    public static String getSUCCESS() {
        return SUCCESS;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}

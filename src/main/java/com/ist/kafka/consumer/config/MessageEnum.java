package com.ist.kafka.consumer.config;

import java.util.ArrayList;
import java.util.List;

/**
 * 枚举都定义于次
 *
 */
public interface MessageEnum {

	enum SeqName implements MessageEnum {
        USER_ID("seq_user_id","UID序列"),
        USER_COUPON_NO("seq_user_coupon_no","用户领取劵生成的劵号"),
        ROAM_ACCOUNT("seq_roam_account","漫游账号序列"),
        WINDOW_ID("seq_window_id","消息窗口序列"),
        ORDER_ID("seq_order_id","订单id序列"),
        TRANS_ID("seq_trans_id_order","支付流水"),
        ORDER_NO("seq_order_no","订单号序列");
    	private String seqValue;
        private String desc;
    	SeqName (String seqValue,String desc){
    		this.seqValue = seqValue;
    		this.desc = desc;
    	}
		public String getSeqValue() {
			return seqValue;
		}
		public String getDesc() {
			return desc;
		}
    }


    /**
     * 用户账号类型
     */
    enum UserType implements MessageEnum {
        TYPE_PHONE(1,"手机号"),
        TYPE_ROMA(2,"漫游"),
        TYPE_EMAIL(3,"邮箱");

        private Integer type;
        private String typeDesc;
        UserType(Integer type,String typeDesc){
            this.type = type;
            this.typeDesc = typeDesc;
        }
        public Integer getType(){return type;}
        public String getTypeDesc(){return typeDesc;}
        public static UserType getUserType(int code) {
            for (UserType type : values()) {
                if (type.getType() == code) {
                    return type;
                }
            }
            return null;
        }
        public static List<Integer> getTypes(){
            List<Integer> types = new ArrayList<>();
            for (UserType type : values()){
                types.add(type.getType());

            }
            return types;
        }
    }

    enum ProductLine implements MessageEnum {
        UNIT_PRODUCT(105, "统一产品线");
        private int code;
        private String desc;

        ProductLine(int code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public int getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }
    }


    /**
     * 用户账号状态
     *      NORMAL      (1, "正常")
     *      LOGOUT      (2, "注销")
     */
    enum UserAccountStatus implements MessageEnum {
        NORMAL(1, "正常"),
        LOGOUT(2, "注销");

        private int status;
        private String desc;

        UserAccountStatus(int status, String desc) {
            this.status = status;
            this.desc = desc;
        }

        public int getStatus() {
            return status;
        }

        public String getDesc() {
            return desc;
        }

    }

    /**
     * 用户劵状态
     *      NOT_USED      (1, "未使用")
     *      USED      (2, "已使用")
     */
    enum UserCouponStatus implements MessageEnum {
        NOT_USED(Short.valueOf("1"), "未使用"),
        USED(Short.valueOf("2"), "已使用");

        private short status;
        private String desc;

        UserCouponStatus(short status, String desc) {
            this.status = status;
            this.desc = desc;
        }

        public short getStatus() {
            return status;
        }

        public String getDesc() {
            return desc;
        }

    }

    /**
     * 用户登陆类型
     */
    enum LoginType implements MessageEnum {
        TYPE_ACCOUNT(1,"账号密码"),
        TYPE_SMS(2,"短信验证码"),
        TYPE_WEIXIN(3,"微信第三方登陆");

        private Integer type;
        private String typeDesc;
        LoginType(Integer type,String typeDesc){
            this.type = type;
            this.typeDesc = typeDesc;
        }
        public Integer getType(){return type;}
        public String getTypeDesc(){return typeDesc;}
        public static LoginType getUserType(int code) {
            for (LoginType type : values()) {
                if (type.getType() == code) {
                    return type;
                }
            }
            return null;
        }
    }

    /**
     * 用户ChangeNum
     */
    enum ChangeNum implements MessageEnum {
        RESET(Short.valueOf("0"),"需要重置");

        private short type;
        private String typeDesc;
        ChangeNum(short type,String typeDesc){
            this.type = type;
            this.typeDesc = typeDesc;
        }
        public short getType(){return type;}
        public String getTypeDesc(){return typeDesc;}
        public static ChangeNum getUserType(short code) {
            for (ChangeNum type : values()) {
                if (type.getType() == code) {
                    return type;
                }
            }
            return null;
        }
    }

    /**
     * 用户状态
     */
    enum UserStatus implements MessageEnum {
        NORMAL(Short.valueOf("1"),"正常"),
        REPORT_LOSS(Short.valueOf("2"),"挂失"),
        TITLE(Short.valueOf("9"),"封号");

        private short status;
        private String statusDesc;
        UserStatus(short status,String statusDesc){
            this.status = status;
            this.statusDesc = statusDesc;
        }
        public short getStatus(){return status;}
        public String getStatusDesc(){return statusDesc;}
        public static UserStatus getStatusType(short status) {
            for (UserStatus userStatus : values()) {
                if (userStatus.getStatus() == status) {
                    return userStatus;
                }
            }
            return null;
        }
    }

    /**
     * 查询用户信息操作类型
     */
    enum QueryUserOperType implements MessageEnum {
        TYPE_ACCOUNT(1,"通过登陆账号查询"),
        TYPE_USERID(2,"通过userId查询");

        private Integer type;
        private String typeDesc;
        QueryUserOperType(Integer type,String typeDesc){
            this.type = type;
            this.typeDesc = typeDesc;
        }
        public Integer getType(){return type;}
        public String getTypeDesc(){return typeDesc;}
        public static QueryUserOperType getOperType(int code) {
            for (QueryUserOperType type : values()) {
                if (type.getType() == code) {
                    return type;
                }
            }
            return null;
        }
    }

    /**
     * 添加用户地址作类型
     */
    enum UserAddressOptType implements MessageEnum {
        TYPE_ADD(1,"添加"),
        TYPE_MODIFY(2,"修改");

        private Integer type;
        private String typeDesc;
        UserAddressOptType(Integer type,String typeDesc){
            this.type = type;
            this.typeDesc = typeDesc;
        }
        public Integer getType(){return type;}
        public String getTypeDesc(){return typeDesc;}
        public static UserAddressOptType getOperType(int code) {
            for (UserAddressOptType type : values()) {
                if (type.getType() == code) {
                    return type;
                }
            }
            return null;
        }
    }

    /**
     * 用户地址状态
     */
    enum UserAddressStatus implements MessageEnum {
        NORMAL(Short.valueOf("1"),"正常"),
        DEL(Short.valueOf("2"),"刪除");

        private short status;
        private String statusDesc;
        UserAddressStatus(short status,String statusDesc){
            this.status = status;
            this.statusDesc = statusDesc;
        }
        public short getStatus(){return status;}
        public String getStatusDesc(){return statusDesc;}
        public static UserAddressStatus getStatusType(short status) {
            for (UserAddressStatus userStatus : values()) {
                if (userStatus.getStatus() == status) {
                    return userStatus;
                }
            }
            return null;
        }
    }

    /**
     * 查询用户地址类型
     */
    enum QueryUserAddressType implements MessageEnum {
        TYPE_USERID(1,"通过USERID查询"),
        TYPE_ADDRESSID(2,"通过ADDRESSID查询");

        private Integer type;
        private String typeDesc;
        QueryUserAddressType(Integer type,String typeDesc){
            this.type = type;
            this.typeDesc = typeDesc;
        }
        public Integer getType(){return type;}
        public String getTypeDesc(){return typeDesc;}
        public static QueryUserAddressType getOperType(int code) {
            for (QueryUserAddressType type : values()) {
                if (type.getType() == code) {
                    return type;
                }
            }
            return null;
        }
    }

    /**
     * 查询用户地址类型
     */
    enum QueryUserAddressIsDefault implements MessageEnum {
        IS_DEFAULT(Short.valueOf("1"),"默认"),
        NOT_DEFAULT(Short.valueOf("0"),"不是默认");

        private Short type;
        private String typeDesc;
        QueryUserAddressIsDefault(Short type,String typeDesc){
            this.type = type;
            this.typeDesc = typeDesc;
        }
        public Short getType(){return type;}
        public String getTypeDesc(){return typeDesc;}
        public static QueryUserAddressIsDefault getOperType(int code) {
            for (QueryUserAddressIsDefault type : values()) {
                if (type.getType() == code) {
                    return type;
                }
            }
            return null;
        }
    }

    /**
     * 产品状态
     */
    enum ProdStatus implements MessageEnum {
        NORMAL(Short.valueOf("1"),"正常"),
        OFFLINE(Short.valueOf("2"),"下线"),
        NOT_ON_LINE((short)0,"未上线");

        private short status;
        private String statusDesc;
        ProdStatus(short status,String statusDesc){
            this.status = status;
            this.statusDesc = statusDesc;
        }
        public short getStatus(){return status;}
        public String getStatusDesc(){return statusDesc;}
        public static ProdStatus getStatusType(short status) {
            for (ProdStatus prodStatus : values()) {
                if (prodStatus.getStatus() == status) {
                    return prodStatus;
                }
            }
            return null;
        }
    }

    enum ResultEnum implements MessageEnum {

        SUCCESS(0, "success"),
        OPERATE_FAIL(1000, "操作失败"),
        ;
        ResultEnum(int code,String msg){
            this.code = code;
            this.msg = msg;
        }
        public int getCode(){
            return code;
        }
        int code;
        String msg;
    }

    /**
     * 订单状态
     */
    enum OrderStatus implements MessageEnum {
        CANCEL(Short.valueOf("0"),"取消"),
        NOT_PAY(Short.valueOf("2"),"未付款"),
        PAY((short)4,"已付款"),
        DELIVERY((short)8,"配送中"),
        COMPLETED((short)10,"已付款");

        private short status;
        private String statusDesc;
        OrderStatus(short status,String statusDesc){
            this.status = status;
            this.statusDesc = statusDesc;
        }
        public short getStatus(){return status;}
        public String getStatusDesc(){return statusDesc;}
        public static OrderStatus getStatusType(short status) {
            for (OrderStatus orderStatus : values()) {
                if (orderStatus.getStatus() == status) {
                    return orderStatus;
                }
            }
            return null;
        }
    }

    /**
     * 聊天消息状态
     */
    enum MsgStatus implements MessageEnum {
        NOT_DELIVERY(Short.valueOf("-1"),"未送达"),
        NOT_READ(Short.valueOf("0"),"未读"),
        READ(Short.valueOf("1"),"已读"),
        UNDO(Short.valueOf("2"),"撤销");

        private short status;
        private String statusDesc;
        MsgStatus(short status,String statusDesc){
            this.status = status;
            this.statusDesc = statusDesc;
        }
        public short getStatus(){return status;}
        public String getStatusDesc(){return statusDesc;}
        public static MsgStatus getStatusType(short status) {
            for (MsgStatus userStatus : values()) {
                if (userStatus.getStatus() == status) {
                    return userStatus;
                }
            }
            return null;
        }
    }

    /**
     * 聊天消息状态
     */
    enum GradeProcStatus implements MessageEnum {
        EFFECT_MOT_DISPLAY(Short.valueOf("0"),"生效但不显示"),
        MODIFY(Short.valueOf("2"),"修改后"),
        NORMAL(Short.valueOf("1"),"正常"),
        DELETE(Short.valueOf("-1"),"删除");

        private short status;
        private String statusDesc;
        GradeProcStatus(short status,String statusDesc){
            this.status = status;
            this.statusDesc = statusDesc;
        }
        public short getStatus(){return status;}
        public String getStatusDesc(){return statusDesc;}
        public static GradeProcStatus getStatusType(short status) {
            for (GradeProcStatus gradeProcStatus : values()) {
                if (gradeProcStatus.getStatus() == status) {
                    return gradeProcStatus;
                }
            }
            return null;
        }
    }

    /**
     * 账户状态
     */
    enum AcctStatus implements MessageEnum {
        NORMAL(Short.valueOf("1"),"正常"),
        LOCK(Short.valueOf("2"),"下线");

        private short status;
        private String statusDesc;
        AcctStatus(short status,String statusDesc){
            this.status = status;
            this.statusDesc = statusDesc;
        }
        public short getStatus(){return status;}
        public String getStatusDesc(){return statusDesc;}
        public static AcctStatus getStatusType(short status) {
            for (AcctStatus acctStatus : values()) {
                if (acctStatus.getStatus() == status) {
                    return acctStatus;
                }
            }
            return null;
        }
    }

    /**
     * 账本状态
     */
    enum AcctBookStatus implements MessageEnum {
        TO_BE_PAY(Short.valueOf("0"),"发起支付"),
        PAY_FINISH(Short.valueOf("1"),"完成支付");

        private short status;
        private String statusDesc;
        AcctBookStatus(short status,String statusDesc){
            this.status = status;
            this.statusDesc = statusDesc;
        }
        public short getStatus(){return status;}
        public String getStatusDesc(){return statusDesc;}
        public static AcctBookStatus getStatusType(short status) {
            for (AcctBookStatus acctStatus : values()) {
                if (acctStatus.getStatus() == status) {
                    return acctStatus;
                }
            }
            return null;
        }
    }

    /**
     * 账户状态
     */
    enum AcctType implements MessageEnum {
        CASH(1,"现金"),
        INTEGRAL(2,"积分"),
        BOND(3,"保证金"),
        BOOK(99,"记账");

        private int type;
        private String typeDesc;
        AcctType(int type,String typeDesc){
            this.type = type;
            this.typeDesc = typeDesc;
        }
        public int getType(){return type;}
        public String getTypeDesc(){return typeDesc;}
        public static AcctType getStatusType(short status) {
            for (AcctType acctType : values()) {
                if (acctType.getType() == status) {
                    return acctType;
                }
            }
            return null;
        }
    }

    /**
     * 消息类型
     */
    enum MsgType implements MessageEnum {
        POINTTOPOINT(1,"点对点"),
        GROUP(2,"群"),
        CUSTOMER(3,"保证金");

        private int type;
        private String typeDesc;
        MsgType(int type,String typeDesc){
            this.type = type;
            this.typeDesc = typeDesc;
        }
        public int getType(){return type;}
        public String getTypeDesc(){return typeDesc;}
        public static MsgType getMsgType(short status) {
            for (MsgType acctType : values()) {
                if (acctType.getType() == status) {
                    return acctType;
                }
            }
            return null;
        }
    }
}

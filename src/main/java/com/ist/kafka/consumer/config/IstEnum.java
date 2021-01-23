package com.ist.kafka.consumer.config;

public interface IstEnum {
    /**
     * 好友分组类型
     */
    enum GroupType implements IstEnum{
        /**
         * -1 黑名单
         * 2 亲友
         * 4 好友
         * 6 同学
         * 8 同事
         * 10 朋友
         * 12 其他
         */
        BLACK((short)-1,"否"),
        FFRIEND((short)2,"亲友"),
        GFRIEND((short)4,"好友"),
        CLASSMATE((short)6,"同学"),
        FRIEND((short)10,"朋友"),
        OTHER((short)12,"其他");

        private short code;
        private String desc;
        GroupType(short code, String desc) {
            this.code = code;
            this.desc = desc;
        }
        public short getCode() {
            return code;
        }
        public String getDesc() {
            return desc;
        }


        public static GroupType getGroupType(short c){
            for (GroupType item : GroupType.values()) {
                if (item.getCode() == c) {
                    return item;
                }
            }
            return null;
        }
    }

    /**
     * 分组状态
     */
    enum GroupStatus implements IstEnum{
        /**
         * 1 正常
         * 2 解散
         * 5 禁言
         */
        NORMAL((short)1,"正常"),
        DISMISS((short)2,"解散"),
        SILENCE((short)5,"禁言");

        private short code;
        private String desc;
        GroupStatus(short code, String desc) {
            this.code = code;
            this.desc = desc;
        }
        public short getCode() {
            return code;
        }
        public String getDesc() {
            return desc;
        }


        public static GroupStatus getGroupStatus(short c){
            for (GroupStatus item : GroupStatus.values()) {
                if (item.getCode() == c) {
                    return item;
                }
            }
            return null;
        }
    }

    /**
     * 成员角色
     */
    enum MemberRole implements IstEnum{
        /**
         * 0 成员
         * 1 创建者
         * 2 管理员
         */
        MEMBER((short)0,"成员"),
        CREATER((short)2,"创建者"),
        ADMINE((short)5,"管理员");

        private short code;
        private String desc;
        MemberRole(short code, String desc) {
            this.code = code;
            this.desc = desc;
        }
        public short getCode() {
            return code;
        }
        public String getDesc() {
            return desc;
        }


        public static MemberRole getMemRole(short c){
            for (MemberRole item : MemberRole.values()) {
                if (item.getCode() == c) {
                    return item;
                }
            }
            return null;
        }
    }
}

package com.ist.kafka.consumer.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MsgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MsgExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andTimeidIsNull() {
            addCriterion("timeid is null");
            return (Criteria) this;
        }

        public Criteria andTimeidIsNotNull() {
            addCriterion("timeid is not null");
            return (Criteria) this;
        }

        public Criteria andTimeidEqualTo(Long value) {
            addCriterion("timeid =", value, "timeid");
            return (Criteria) this;
        }

        public Criteria andTimeidNotEqualTo(Long value) {
            addCriterion("timeid <>", value, "timeid");
            return (Criteria) this;
        }

        public Criteria andTimeidGreaterThan(Long value) {
            addCriterion("timeid >", value, "timeid");
            return (Criteria) this;
        }

        public Criteria andTimeidGreaterThanOrEqualTo(Long value) {
            addCriterion("timeid >=", value, "timeid");
            return (Criteria) this;
        }

        public Criteria andTimeidLessThan(Long value) {
            addCriterion("timeid <", value, "timeid");
            return (Criteria) this;
        }

        public Criteria andTimeidLessThanOrEqualTo(Long value) {
            addCriterion("timeid <=", value, "timeid");
            return (Criteria) this;
        }

        public Criteria andTimeidIn(List<Long> values) {
            addCriterion("timeid in", values, "timeid");
            return (Criteria) this;
        }

        public Criteria andTimeidNotIn(List<Long> values) {
            addCriterion("timeid not in", values, "timeid");
            return (Criteria) this;
        }

        public Criteria andTimeidBetween(Long value1, Long value2) {
            addCriterion("timeid between", value1, value2, "timeid");
            return (Criteria) this;
        }

        public Criteria andTimeidNotBetween(Long value1, Long value2) {
            addCriterion("timeid not between", value1, value2, "timeid");
            return (Criteria) this;
        }

        public Criteria andMsgtypeIsNull() {
            addCriterion("msgtype is null");
            return (Criteria) this;
        }

        public Criteria andMsgtypeIsNotNull() {
            addCriterion("msgtype is not null");
            return (Criteria) this;
        }

        public Criteria andMsgtypeEqualTo(Short value) {
            addCriterion("msgtype =", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeNotEqualTo(Short value) {
            addCriterion("msgtype <>", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeGreaterThan(Short value) {
            addCriterion("msgtype >", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeGreaterThanOrEqualTo(Short value) {
            addCriterion("msgtype >=", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeLessThan(Short value) {
            addCriterion("msgtype <", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeLessThanOrEqualTo(Short value) {
            addCriterion("msgtype <=", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeIn(List<Short> values) {
            addCriterion("msgtype in", values, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeNotIn(List<Short> values) {
            addCriterion("msgtype not in", values, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeBetween(Short value1, Short value2) {
            addCriterion("msgtype between", value1, value2, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeNotBetween(Short value1, Short value2) {
            addCriterion("msgtype not between", value1, value2, "msgtype");
            return (Criteria) this;
        }

        public Criteria andContenttypeIsNull() {
            addCriterion("contenttype is null");
            return (Criteria) this;
        }

        public Criteria andContenttypeIsNotNull() {
            addCriterion("contenttype is not null");
            return (Criteria) this;
        }

        public Criteria andContenttypeEqualTo(Short value) {
            addCriterion("contenttype =", value, "contenttype");
            return (Criteria) this;
        }

        public Criteria andContenttypeNotEqualTo(Short value) {
            addCriterion("contenttype <>", value, "contenttype");
            return (Criteria) this;
        }

        public Criteria andContenttypeGreaterThan(Short value) {
            addCriterion("contenttype >", value, "contenttype");
            return (Criteria) this;
        }

        public Criteria andContenttypeGreaterThanOrEqualTo(Short value) {
            addCriterion("contenttype >=", value, "contenttype");
            return (Criteria) this;
        }

        public Criteria andContenttypeLessThan(Short value) {
            addCriterion("contenttype <", value, "contenttype");
            return (Criteria) this;
        }

        public Criteria andContenttypeLessThanOrEqualTo(Short value) {
            addCriterion("contenttype <=", value, "contenttype");
            return (Criteria) this;
        }

        public Criteria andContenttypeIn(List<Short> values) {
            addCriterion("contenttype in", values, "contenttype");
            return (Criteria) this;
        }

        public Criteria andContenttypeNotIn(List<Short> values) {
            addCriterion("contenttype not in", values, "contenttype");
            return (Criteria) this;
        }

        public Criteria andContenttypeBetween(Short value1, Short value2) {
            addCriterion("contenttype between", value1, value2, "contenttype");
            return (Criteria) this;
        }

        public Criteria andContenttypeNotBetween(Short value1, Short value2) {
            addCriterion("contenttype not between", value1, value2, "contenttype");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andSenderIsNull() {
            addCriterion("sender is null");
            return (Criteria) this;
        }

        public Criteria andSenderIsNotNull() {
            addCriterion("sender is not null");
            return (Criteria) this;
        }

        public Criteria andSenderEqualTo(Long value) {
            addCriterion("sender =", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotEqualTo(Long value) {
            addCriterion("sender <>", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderGreaterThan(Long value) {
            addCriterion("sender >", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderGreaterThanOrEqualTo(Long value) {
            addCriterion("sender >=", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderLessThan(Long value) {
            addCriterion("sender <", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderLessThanOrEqualTo(Long value) {
            addCriterion("sender <=", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderIn(List<Long> values) {
            addCriterion("sender in", values, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotIn(List<Long> values) {
            addCriterion("sender not in", values, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderBetween(Long value1, Long value2) {
            addCriterion("sender between", value1, value2, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotBetween(Long value1, Long value2) {
            addCriterion("sender not between", value1, value2, "sender");
            return (Criteria) this;
        }

        public Criteria andNoIsNull() {
            addCriterion("`no` is null");
            return (Criteria) this;
        }

        public Criteria andNoIsNotNull() {
            addCriterion("`no` is not null");
            return (Criteria) this;
        }

        public Criteria andNoEqualTo(Long value) {
            addCriterion("`no` =", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoNotEqualTo(Long value) {
            addCriterion("`no` <>", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoGreaterThan(Long value) {
            addCriterion("`no` >", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoGreaterThanOrEqualTo(Long value) {
            addCriterion("`no` >=", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoLessThan(Long value) {
            addCriterion("`no` <", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoLessThanOrEqualTo(Long value) {
            addCriterion("`no` <=", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoIn(List<Long> values) {
            addCriterion("`no` in", values, "no");
            return (Criteria) this;
        }

        public Criteria andNoNotIn(List<Long> values) {
            addCriterion("`no` not in", values, "no");
            return (Criteria) this;
        }

        public Criteria andNoBetween(Long value1, Long value2) {
            addCriterion("`no` between", value1, value2, "no");
            return (Criteria) this;
        }

        public Criteria andNoNotBetween(Long value1, Long value2) {
            addCriterion("`no` not between", value1, value2, "no");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("`status` is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("`status` is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Short value) {
            addCriterion("`status` =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Short value) {
            addCriterion("`status` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Short value) {
            addCriterion("`status` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("`status` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Short value) {
            addCriterion("`status` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Short value) {
            addCriterion("`status` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Short> values) {
            addCriterion("`status` in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Short> values) {
            addCriterion("`status` not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Short value1, Short value2) {
            addCriterion("`status` between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Short value1, Short value2) {
            addCriterion("`status` not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updatetime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("updatetime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("updatetime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("updatetime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updatetime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("updatetime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("updatetime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("updatetime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("updatetime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("updatetime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("updatetime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("`type` is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("`type` is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Short value) {
            addCriterion("`type` =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Short value) {
            addCriterion("`type` <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Short value) {
            addCriterion("`type` >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("`type` >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Short value) {
            addCriterion("`type` <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Short value) {
            addCriterion("`type` <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Short> values) {
            addCriterion("`type` in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Short> values) {
            addCriterion("`type` not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Short value1, Short value2) {
            addCriterion("`type` between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Short value1, Short value2) {
            addCriterion("`type` not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTalkerIsNull() {
            addCriterion("talker is null");
            return (Criteria) this;
        }

        public Criteria andTalkerIsNotNull() {
            addCriterion("talker is not null");
            return (Criteria) this;
        }

        public Criteria andTalkerEqualTo(Long value) {
            addCriterion("talker =", value, "talker");
            return (Criteria) this;
        }

        public Criteria andTalkerNotEqualTo(Long value) {
            addCriterion("talker <>", value, "talker");
            return (Criteria) this;
        }

        public Criteria andTalkerGreaterThan(Long value) {
            addCriterion("talker >", value, "talker");
            return (Criteria) this;
        }

        public Criteria andTalkerGreaterThanOrEqualTo(Long value) {
            addCriterion("talker >=", value, "talker");
            return (Criteria) this;
        }

        public Criteria andTalkerLessThan(Long value) {
            addCriterion("talker <", value, "talker");
            return (Criteria) this;
        }

        public Criteria andTalkerLessThanOrEqualTo(Long value) {
            addCriterion("talker <=", value, "talker");
            return (Criteria) this;
        }

        public Criteria andTalkerIn(List<Long> values) {
            addCriterion("talker in", values, "talker");
            return (Criteria) this;
        }

        public Criteria andTalkerNotIn(List<Long> values) {
            addCriterion("talker not in", values, "talker");
            return (Criteria) this;
        }

        public Criteria andTalkerBetween(Long value1, Long value2) {
            addCriterion("talker between", value1, value2, "talker");
            return (Criteria) this;
        }

        public Criteria andTalkerNotBetween(Long value1, Long value2) {
            addCriterion("talker not between", value1, value2, "talker");
            return (Criteria) this;
        }
        public Criteria andReceiverIdIsNull() {
            addCriterion("receiverId is null");
            return (Criteria) this;
        }

        public Criteria andReceiverIdIsNotNull() {
            addCriterion("receiverId is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverIdEqualTo(Long value) {
            addCriterion("receiverId =", value, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdNotEqualTo(Long value) {
            addCriterion("receiverId <>", value, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdGreaterThan(Long value) {
            addCriterion("receiverId >", value, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdGreaterThanOrEqualTo(Long value) {
            addCriterion("receiverId >=", value, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdLessThan(Long value) {
            addCriterion("receiverId <", value, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdLessThanOrEqualTo(Long value) {
            addCriterion("receiverId <=", value, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdIn(List<Long> values) {
            addCriterion("receiverId in", values, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdNotIn(List<Long> values) {
            addCriterion("receiverId not in", values, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdBetween(Long value1, Long value2) {
            addCriterion("receiverId between", value1, value2, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdNotBetween(Long value1, Long value2) {
            addCriterion("receiverId not between", value1, value2, "receiverId");
            return (Criteria) this;
        }

        public Criteria andShopidIsNull() {
            addCriterion("shopid is null");
            return (Criteria) this;
        }

        public Criteria andShopidIsNotNull() {
            addCriterion("shopid is not null");
            return (Criteria) this;
        }

        public Criteria andShopidEqualTo(Integer value) {
            addCriterion("shopid =", value, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidNotEqualTo(Integer value) {
            addCriterion("shopid <>", value, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidGreaterThan(Integer value) {
            addCriterion("shopid >", value, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidGreaterThanOrEqualTo(Integer value) {
            addCriterion("shopid >=", value, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidLessThan(Integer value) {
            addCriterion("shopid <", value, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidLessThanOrEqualTo(Integer value) {
            addCriterion("shopid <=", value, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidIn(List<Integer> values) {
            addCriterion("shopid in", values, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidNotIn(List<Integer> values) {
            addCriterion("shopid not in", values, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidBetween(Integer value1, Integer value2) {
            addCriterion("shopid between", value1, value2, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidNotBetween(Integer value1, Integer value2) {
            addCriterion("shopid not between", value1, value2, "shopid");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
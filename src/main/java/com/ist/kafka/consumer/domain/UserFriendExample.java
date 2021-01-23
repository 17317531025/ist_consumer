package com.ist.kafka.consumer.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserFriendExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserFriendExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Long value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Long value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Long value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Long value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Long value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Long value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Long> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Long> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Long value1, Long value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Long value1, Long value2) {
            addCriterion("userid not between", value1, value2, "userid");
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

        public Criteria andGrouptypeIsNull() {
            addCriterion("grouptype is null");
            return (Criteria) this;
        }

        public Criteria andGrouptypeIsNotNull() {
            addCriterion("grouptype is not null");
            return (Criteria) this;
        }

        public Criteria andGrouptypeEqualTo(Short value) {
            addCriterion("grouptype =", value, "grouptype");
            return (Criteria) this;
        }

        public Criteria andGrouptypeNotEqualTo(Short value) {
            addCriterion("grouptype <>", value, "grouptype");
            return (Criteria) this;
        }

        public Criteria andGrouptypeGreaterThan(Short value) {
            addCriterion("grouptype >", value, "grouptype");
            return (Criteria) this;
        }

        public Criteria andGrouptypeGreaterThanOrEqualTo(Short value) {
            addCriterion("grouptype >=", value, "grouptype");
            return (Criteria) this;
        }

        public Criteria andGrouptypeLessThan(Short value) {
            addCriterion("grouptype <", value, "grouptype");
            return (Criteria) this;
        }

        public Criteria andGrouptypeLessThanOrEqualTo(Short value) {
            addCriterion("grouptype <=", value, "grouptype");
            return (Criteria) this;
        }

        public Criteria andGrouptypeIn(List<Short> values) {
            addCriterion("grouptype in", values, "grouptype");
            return (Criteria) this;
        }

        public Criteria andGrouptypeNotIn(List<Short> values) {
            addCriterion("grouptype not in", values, "grouptype");
            return (Criteria) this;
        }

        public Criteria andGrouptypeBetween(Short value1, Short value2) {
            addCriterion("grouptype between", value1, value2, "grouptype");
            return (Criteria) this;
        }

        public Criteria andGrouptypeNotBetween(Short value1, Short value2) {
            addCriterion("grouptype not between", value1, value2, "grouptype");
            return (Criteria) this;
        }

        public Criteria andFriendgroupidIsNull() {
            addCriterion("friendGroupId is null");
            return (Criteria) this;
        }

        public Criteria andFriendgroupidIsNotNull() {
            addCriterion("friendGroupId is not null");
            return (Criteria) this;
        }

        public Criteria andFriendgroupidEqualTo(Long value) {
            addCriterion("friendGroupId =", value, "friendgroupid");
            return (Criteria) this;
        }

        public Criteria andFriendgroupidNotEqualTo(Long value) {
            addCriterion("friendGroupId <>", value, "friendgroupid");
            return (Criteria) this;
        }

        public Criteria andFriendgroupidGreaterThan(Long value) {
            addCriterion("friendGroupId >", value, "friendgroupid");
            return (Criteria) this;
        }

        public Criteria andFriendgroupidGreaterThanOrEqualTo(Long value) {
            addCriterion("friendGroupId >=", value, "friendgroupid");
            return (Criteria) this;
        }

        public Criteria andFriendgroupidLessThan(Long value) {
            addCriterion("friendGroupId <", value, "friendgroupid");
            return (Criteria) this;
        }

        public Criteria andFriendgroupidLessThanOrEqualTo(Long value) {
            addCriterion("friendGroupId <=", value, "friendgroupid");
            return (Criteria) this;
        }

        public Criteria andFriendgroupidIn(List<Long> values) {
            addCriterion("friendGroupId in", values, "friendgroupid");
            return (Criteria) this;
        }

        public Criteria andFriendgroupidNotIn(List<Long> values) {
            addCriterion("friendGroupId not in", values, "friendgroupid");
            return (Criteria) this;
        }

        public Criteria andFriendgroupidBetween(Long value1, Long value2) {
            addCriterion("friendGroupId between", value1, value2, "friendgroupid");
            return (Criteria) this;
        }

        public Criteria andFriendgroupidNotBetween(Long value1, Long value2) {
            addCriterion("friendGroupId not between", value1, value2, "friendgroupid");
            return (Criteria) this;
        }

        public Criteria andFuseridIsNull() {
            addCriterion("fuserid is null");
            return (Criteria) this;
        }

        public Criteria andFuseridIsNotNull() {
            addCriterion("fuserid is not null");
            return (Criteria) this;
        }

        public Criteria andFuseridEqualTo(Long value) {
            addCriterion("fuserid =", value, "fuserid");
            return (Criteria) this;
        }

        public Criteria andFuseridNotEqualTo(Long value) {
            addCriterion("fuserid <>", value, "fuserid");
            return (Criteria) this;
        }

        public Criteria andFuseridGreaterThan(Long value) {
            addCriterion("fuserid >", value, "fuserid");
            return (Criteria) this;
        }

        public Criteria andFuseridGreaterThanOrEqualTo(Long value) {
            addCriterion("fuserid >=", value, "fuserid");
            return (Criteria) this;
        }

        public Criteria andFuseridLessThan(Long value) {
            addCriterion("fuserid <", value, "fuserid");
            return (Criteria) this;
        }

        public Criteria andFuseridLessThanOrEqualTo(Long value) {
            addCriterion("fuserid <=", value, "fuserid");
            return (Criteria) this;
        }

        public Criteria andFuseridIn(List<Long> values) {
            addCriterion("fuserid in", values, "fuserid");
            return (Criteria) this;
        }

        public Criteria andFuseridNotIn(List<Long> values) {
            addCriterion("fuserid not in", values, "fuserid");
            return (Criteria) this;
        }

        public Criteria andFuseridBetween(Long value1, Long value2) {
            addCriterion("fuserid between", value1, value2, "fuserid");
            return (Criteria) this;
        }

        public Criteria andFuseridNotBetween(Long value1, Long value2) {
            addCriterion("fuserid not between", value1, value2, "fuserid");
            return (Criteria) this;
        }

        public Criteria andMarknameIsNull() {
            addCriterion("markname is null");
            return (Criteria) this;
        }

        public Criteria andMarknameIsNotNull() {
            addCriterion("markname is not null");
            return (Criteria) this;
        }

        public Criteria andMarknameEqualTo(String value) {
            addCriterion("markname =", value, "markname");
            return (Criteria) this;
        }

        public Criteria andMarknameNotEqualTo(String value) {
            addCriterion("markname <>", value, "markname");
            return (Criteria) this;
        }

        public Criteria andMarknameGreaterThan(String value) {
            addCriterion("markname >", value, "markname");
            return (Criteria) this;
        }

        public Criteria andMarknameGreaterThanOrEqualTo(String value) {
            addCriterion("markname >=", value, "markname");
            return (Criteria) this;
        }

        public Criteria andMarknameLessThan(String value) {
            addCriterion("markname <", value, "markname");
            return (Criteria) this;
        }

        public Criteria andMarknameLessThanOrEqualTo(String value) {
            addCriterion("markname <=", value, "markname");
            return (Criteria) this;
        }

        public Criteria andMarknameLike(String value) {
            addCriterion("markname like", value, "markname");
            return (Criteria) this;
        }

        public Criteria andMarknameNotLike(String value) {
            addCriterion("markname not like", value, "markname");
            return (Criteria) this;
        }

        public Criteria andMarknameIn(List<String> values) {
            addCriterion("markname in", values, "markname");
            return (Criteria) this;
        }

        public Criteria andMarknameNotIn(List<String> values) {
            addCriterion("markname not in", values, "markname");
            return (Criteria) this;
        }

        public Criteria andMarknameBetween(String value1, String value2) {
            addCriterion("markname between", value1, value2, "markname");
            return (Criteria) this;
        }

        public Criteria andMarknameNotBetween(String value1, String value2) {
            addCriterion("markname not between", value1, value2, "markname");
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
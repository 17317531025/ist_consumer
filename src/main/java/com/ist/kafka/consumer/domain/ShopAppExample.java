package com.ist.kafka.consumer.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShopAppExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShopAppExample() {
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNull() {
            addCriterion("APP_ID is null");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNotNull() {
            addCriterion("APP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAppIdEqualTo(String value) {
            addCriterion("APP_ID =", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotEqualTo(String value) {
            addCriterion("APP_ID <>", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThan(String value) {
            addCriterion("APP_ID >", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("APP_ID >=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThan(String value) {
            addCriterion("APP_ID <", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThanOrEqualTo(String value) {
            addCriterion("APP_ID <=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLike(String value) {
            addCriterion("APP_ID like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotLike(String value) {
            addCriterion("APP_ID not like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdIn(List<String> values) {
            addCriterion("APP_ID in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotIn(List<String> values) {
            addCriterion("APP_ID not in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdBetween(String value1, String value2) {
            addCriterion("APP_ID between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotBetween(String value1, String value2) {
            addCriterion("APP_ID not between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppNameIsNull() {
            addCriterion("APP_NAME is null");
            return (Criteria) this;
        }

        public Criteria andAppNameIsNotNull() {
            addCriterion("APP_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andAppNameEqualTo(String value) {
            addCriterion("APP_NAME =", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotEqualTo(String value) {
            addCriterion("APP_NAME <>", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameGreaterThan(String value) {
            addCriterion("APP_NAME >", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameGreaterThanOrEqualTo(String value) {
            addCriterion("APP_NAME >=", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLessThan(String value) {
            addCriterion("APP_NAME <", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLessThanOrEqualTo(String value) {
            addCriterion("APP_NAME <=", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLike(String value) {
            addCriterion("APP_NAME like", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotLike(String value) {
            addCriterion("APP_NAME not like", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameIn(List<String> values) {
            addCriterion("APP_NAME in", values, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotIn(List<String> values) {
            addCriterion("APP_NAME not in", values, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameBetween(String value1, String value2) {
            addCriterion("APP_NAME between", value1, value2, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotBetween(String value1, String value2) {
            addCriterion("APP_NAME not between", value1, value2, "appName");
            return (Criteria) this;
        }

        public Criteria andAppSecretIsNull() {
            addCriterion("APP_SECRET is null");
            return (Criteria) this;
        }

        public Criteria andAppSecretIsNotNull() {
            addCriterion("APP_SECRET is not null");
            return (Criteria) this;
        }

        public Criteria andAppSecretEqualTo(String value) {
            addCriterion("APP_SECRET =", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretNotEqualTo(String value) {
            addCriterion("APP_SECRET <>", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretGreaterThan(String value) {
            addCriterion("APP_SECRET >", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretGreaterThanOrEqualTo(String value) {
            addCriterion("APP_SECRET >=", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretLessThan(String value) {
            addCriterion("APP_SECRET <", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretLessThanOrEqualTo(String value) {
            addCriterion("APP_SECRET <=", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretLike(String value) {
            addCriterion("APP_SECRET like", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretNotLike(String value) {
            addCriterion("APP_SECRET not like", value, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretIn(List<String> values) {
            addCriterion("APP_SECRET in", values, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretNotIn(List<String> values) {
            addCriterion("APP_SECRET not in", values, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretBetween(String value1, String value2) {
            addCriterion("APP_SECRET between", value1, value2, "appSecret");
            return (Criteria) this;
        }

        public Criteria andAppSecretNotBetween(String value1, String value2) {
            addCriterion("APP_SECRET not between", value1, value2, "appSecret");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("`STATUS` is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("`STATUS` is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("`STATUS` =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("`STATUS` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("`STATUS` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("`STATUS` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("`STATUS` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("`STATUS` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("`STATUS` in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("`STATUS` not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("`STATUS` between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("`STATUS` not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andDevelopIdIsNull() {
            addCriterion("DEVELOP_ID is null");
            return (Criteria) this;
        }

        public Criteria andDevelopIdIsNotNull() {
            addCriterion("DEVELOP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDevelopIdEqualTo(String value) {
            addCriterion("DEVELOP_ID =", value, "developId");
            return (Criteria) this;
        }

        public Criteria andDevelopIdNotEqualTo(String value) {
            addCriterion("DEVELOP_ID <>", value, "developId");
            return (Criteria) this;
        }

        public Criteria andDevelopIdGreaterThan(String value) {
            addCriterion("DEVELOP_ID >", value, "developId");
            return (Criteria) this;
        }

        public Criteria andDevelopIdGreaterThanOrEqualTo(String value) {
            addCriterion("DEVELOP_ID >=", value, "developId");
            return (Criteria) this;
        }

        public Criteria andDevelopIdLessThan(String value) {
            addCriterion("DEVELOP_ID <", value, "developId");
            return (Criteria) this;
        }

        public Criteria andDevelopIdLessThanOrEqualTo(String value) {
            addCriterion("DEVELOP_ID <=", value, "developId");
            return (Criteria) this;
        }

        public Criteria andDevelopIdLike(String value) {
            addCriterion("DEVELOP_ID like", value, "developId");
            return (Criteria) this;
        }

        public Criteria andDevelopIdNotLike(String value) {
            addCriterion("DEVELOP_ID not like", value, "developId");
            return (Criteria) this;
        }

        public Criteria andDevelopIdIn(List<String> values) {
            addCriterion("DEVELOP_ID in", values, "developId");
            return (Criteria) this;
        }

        public Criteria andDevelopIdNotIn(List<String> values) {
            addCriterion("DEVELOP_ID not in", values, "developId");
            return (Criteria) this;
        }

        public Criteria andDevelopIdBetween(String value1, String value2) {
            addCriterion("DEVELOP_ID between", value1, value2, "developId");
            return (Criteria) this;
        }

        public Criteria andDevelopIdNotBetween(String value1, String value2) {
            addCriterion("DEVELOP_ID not between", value1, value2, "developId");
            return (Criteria) this;
        }

        public Criteria andDevelopNameIsNull() {
            addCriterion("DEVELOP_NAME is null");
            return (Criteria) this;
        }

        public Criteria andDevelopNameIsNotNull() {
            addCriterion("DEVELOP_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andDevelopNameEqualTo(String value) {
            addCriterion("DEVELOP_NAME =", value, "developName");
            return (Criteria) this;
        }

        public Criteria andDevelopNameNotEqualTo(String value) {
            addCriterion("DEVELOP_NAME <>", value, "developName");
            return (Criteria) this;
        }

        public Criteria andDevelopNameGreaterThan(String value) {
            addCriterion("DEVELOP_NAME >", value, "developName");
            return (Criteria) this;
        }

        public Criteria andDevelopNameGreaterThanOrEqualTo(String value) {
            addCriterion("DEVELOP_NAME >=", value, "developName");
            return (Criteria) this;
        }

        public Criteria andDevelopNameLessThan(String value) {
            addCriterion("DEVELOP_NAME <", value, "developName");
            return (Criteria) this;
        }

        public Criteria andDevelopNameLessThanOrEqualTo(String value) {
            addCriterion("DEVELOP_NAME <=", value, "developName");
            return (Criteria) this;
        }

        public Criteria andDevelopNameLike(String value) {
            addCriterion("DEVELOP_NAME like", value, "developName");
            return (Criteria) this;
        }

        public Criteria andDevelopNameNotLike(String value) {
            addCriterion("DEVELOP_NAME not like", value, "developName");
            return (Criteria) this;
        }

        public Criteria andDevelopNameIn(List<String> values) {
            addCriterion("DEVELOP_NAME in", values, "developName");
            return (Criteria) this;
        }

        public Criteria andDevelopNameNotIn(List<String> values) {
            addCriterion("DEVELOP_NAME not in", values, "developName");
            return (Criteria) this;
        }

        public Criteria andDevelopNameBetween(String value1, String value2) {
            addCriterion("DEVELOP_NAME between", value1, value2, "developName");
            return (Criteria) this;
        }

        public Criteria andDevelopNameNotBetween(String value1, String value2) {
            addCriterion("DEVELOP_NAME not between", value1, value2, "developName");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNull() {
            addCriterion("CREATE_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNotNull() {
            addCriterion("CREATE_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdEqualTo(String value) {
            addCriterion("CREATE_USER_ID =", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotEqualTo(String value) {
            addCriterion("CREATE_USER_ID <>", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThan(String value) {
            addCriterion("CREATE_USER_ID >", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_USER_ID >=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThan(String value) {
            addCriterion("CREATE_USER_ID <", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThanOrEqualTo(String value) {
            addCriterion("CREATE_USER_ID <=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLike(String value) {
            addCriterion("CREATE_USER_ID like", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotLike(String value) {
            addCriterion("CREATE_USER_ID not like", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIn(List<String> values) {
            addCriterion("CREATE_USER_ID in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotIn(List<String> values) {
            addCriterion("CREATE_USER_ID not in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdBetween(String value1, String value2) {
            addCriterion("CREATE_USER_ID between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotBetween(String value1, String value2) {
            addCriterion("CREATE_USER_ID not between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("CREATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("CREATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("CREATE_DATE =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("CREATE_DATE <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("CREATE_DATE >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("CREATE_DATE <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("CREATE_DATE in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("CREATE_DATE not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andLastModifiedIdIsNull() {
            addCriterion("LAST_MODIFIED_ID is null");
            return (Criteria) this;
        }

        public Criteria andLastModifiedIdIsNotNull() {
            addCriterion("LAST_MODIFIED_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLastModifiedIdEqualTo(String value) {
            addCriterion("LAST_MODIFIED_ID =", value, "lastModifiedId");
            return (Criteria) this;
        }

        public Criteria andLastModifiedIdNotEqualTo(String value) {
            addCriterion("LAST_MODIFIED_ID <>", value, "lastModifiedId");
            return (Criteria) this;
        }

        public Criteria andLastModifiedIdGreaterThan(String value) {
            addCriterion("LAST_MODIFIED_ID >", value, "lastModifiedId");
            return (Criteria) this;
        }

        public Criteria andLastModifiedIdGreaterThanOrEqualTo(String value) {
            addCriterion("LAST_MODIFIED_ID >=", value, "lastModifiedId");
            return (Criteria) this;
        }

        public Criteria andLastModifiedIdLessThan(String value) {
            addCriterion("LAST_MODIFIED_ID <", value, "lastModifiedId");
            return (Criteria) this;
        }

        public Criteria andLastModifiedIdLessThanOrEqualTo(String value) {
            addCriterion("LAST_MODIFIED_ID <=", value, "lastModifiedId");
            return (Criteria) this;
        }

        public Criteria andLastModifiedIdLike(String value) {
            addCriterion("LAST_MODIFIED_ID like", value, "lastModifiedId");
            return (Criteria) this;
        }

        public Criteria andLastModifiedIdNotLike(String value) {
            addCriterion("LAST_MODIFIED_ID not like", value, "lastModifiedId");
            return (Criteria) this;
        }

        public Criteria andLastModifiedIdIn(List<String> values) {
            addCriterion("LAST_MODIFIED_ID in", values, "lastModifiedId");
            return (Criteria) this;
        }

        public Criteria andLastModifiedIdNotIn(List<String> values) {
            addCriterion("LAST_MODIFIED_ID not in", values, "lastModifiedId");
            return (Criteria) this;
        }

        public Criteria andLastModifiedIdBetween(String value1, String value2) {
            addCriterion("LAST_MODIFIED_ID between", value1, value2, "lastModifiedId");
            return (Criteria) this;
        }

        public Criteria andLastModifiedIdNotBetween(String value1, String value2) {
            addCriterion("LAST_MODIFIED_ID not between", value1, value2, "lastModifiedId");
            return (Criteria) this;
        }

        public Criteria andLastModifiedIsNull() {
            addCriterion("LAST_MODIFIED is null");
            return (Criteria) this;
        }

        public Criteria andLastModifiedIsNotNull() {
            addCriterion("LAST_MODIFIED is not null");
            return (Criteria) this;
        }

        public Criteria andLastModifiedEqualTo(Date value) {
            addCriterion("LAST_MODIFIED =", value, "lastModified");
            return (Criteria) this;
        }

        public Criteria andLastModifiedNotEqualTo(Date value) {
            addCriterion("LAST_MODIFIED <>", value, "lastModified");
            return (Criteria) this;
        }

        public Criteria andLastModifiedGreaterThan(Date value) {
            addCriterion("LAST_MODIFIED >", value, "lastModified");
            return (Criteria) this;
        }

        public Criteria andLastModifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("LAST_MODIFIED >=", value, "lastModified");
            return (Criteria) this;
        }

        public Criteria andLastModifiedLessThan(Date value) {
            addCriterion("LAST_MODIFIED <", value, "lastModified");
            return (Criteria) this;
        }

        public Criteria andLastModifiedLessThanOrEqualTo(Date value) {
            addCriterion("LAST_MODIFIED <=", value, "lastModified");
            return (Criteria) this;
        }

        public Criteria andLastModifiedIn(List<Date> values) {
            addCriterion("LAST_MODIFIED in", values, "lastModified");
            return (Criteria) this;
        }

        public Criteria andLastModifiedNotIn(List<Date> values) {
            addCriterion("LAST_MODIFIED not in", values, "lastModified");
            return (Criteria) this;
        }

        public Criteria andLastModifiedBetween(Date value1, Date value2) {
            addCriterion("LAST_MODIFIED between", value1, value2, "lastModified");
            return (Criteria) this;
        }

        public Criteria andLastModifiedNotBetween(Date value1, Date value2) {
            addCriterion("LAST_MODIFIED not between", value1, value2, "lastModified");
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
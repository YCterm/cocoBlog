package com.yc.blog.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommentExample() {
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

        public Criteria andComidIsNull() {
            addCriterion("comid is null");
            return (Criteria) this;
        }

        public Criteria andComidIsNotNull() {
            addCriterion("comid is not null");
            return (Criteria) this;
        }

        public Criteria andComidEqualTo(Integer value) {
            addCriterion("comid =", value, "comid");
            return (Criteria) this;
        }

        public Criteria andComidNotEqualTo(Integer value) {
            addCriterion("comid <>", value, "comid");
            return (Criteria) this;
        }

        public Criteria andComidGreaterThan(Integer value) {
            addCriterion("comid >", value, "comid");
            return (Criteria) this;
        }

        public Criteria andComidGreaterThanOrEqualTo(Integer value) {
            addCriterion("comid >=", value, "comid");
            return (Criteria) this;
        }

        public Criteria andComidLessThan(Integer value) {
            addCriterion("comid <", value, "comid");
            return (Criteria) this;
        }

        public Criteria andComidLessThanOrEqualTo(Integer value) {
            addCriterion("comid <=", value, "comid");
            return (Criteria) this;
        }

        public Criteria andComidIn(List<Integer> values) {
            addCriterion("comid in", values, "comid");
            return (Criteria) this;
        }

        public Criteria andComidNotIn(List<Integer> values) {
            addCriterion("comid not in", values, "comid");
            return (Criteria) this;
        }

        public Criteria andComidBetween(Integer value1, Integer value2) {
            addCriterion("comid between", value1, value2, "comid");
            return (Criteria) this;
        }

        public Criteria andComidNotBetween(Integer value1, Integer value2) {
            addCriterion("comid not between", value1, value2, "comid");
            return (Criteria) this;
        }

        public Criteria andArtidIsNull() {
            addCriterion("artid is null");
            return (Criteria) this;
        }

        public Criteria andArtidIsNotNull() {
            addCriterion("artid is not null");
            return (Criteria) this;
        }

        public Criteria andArtidEqualTo(Integer value) {
            addCriterion("artid =", value, "artid");
            return (Criteria) this;
        }

        public Criteria andArtidNotEqualTo(Integer value) {
            addCriterion("artid <>", value, "artid");
            return (Criteria) this;
        }

        public Criteria andArtidGreaterThan(Integer value) {
            addCriterion("artid >", value, "artid");
            return (Criteria) this;
        }

        public Criteria andArtidGreaterThanOrEqualTo(Integer value) {
            addCriterion("artid >=", value, "artid");
            return (Criteria) this;
        }

        public Criteria andArtidLessThan(Integer value) {
            addCriterion("artid <", value, "artid");
            return (Criteria) this;
        }

        public Criteria andArtidLessThanOrEqualTo(Integer value) {
            addCriterion("artid <=", value, "artid");
            return (Criteria) this;
        }

        public Criteria andArtidIn(List<Integer> values) {
            addCriterion("artid in", values, "artid");
            return (Criteria) this;
        }

        public Criteria andArtidNotIn(List<Integer> values) {
            addCriterion("artid not in", values, "artid");
            return (Criteria) this;
        }

        public Criteria andArtidBetween(Integer value1, Integer value2) {
            addCriterion("artid between", value1, value2, "artid");
            return (Criteria) this;
        }

        public Criteria andArtidNotBetween(Integer value1, Integer value2) {
            addCriterion("artid not between", value1, value2, "artid");
            return (Criteria) this;
        }

        public Criteria andRecomidIsNull() {
            addCriterion("recomid is null");
            return (Criteria) this;
        }

        public Criteria andRecomidIsNotNull() {
            addCriterion("recomid is not null");
            return (Criteria) this;
        }

        public Criteria andRecomidEqualTo(Integer value) {
            addCriterion("recomid =", value, "recomid");
            return (Criteria) this;
        }

        public Criteria andRecomidNotEqualTo(Integer value) {
            addCriterion("recomid <>", value, "recomid");
            return (Criteria) this;
        }

        public Criteria andRecomidGreaterThan(Integer value) {
            addCriterion("recomid >", value, "recomid");
            return (Criteria) this;
        }

        public Criteria andRecomidGreaterThanOrEqualTo(Integer value) {
            addCriterion("recomid >=", value, "recomid");
            return (Criteria) this;
        }

        public Criteria andRecomidLessThan(Integer value) {
            addCriterion("recomid <", value, "recomid");
            return (Criteria) this;
        }

        public Criteria andRecomidLessThanOrEqualTo(Integer value) {
            addCriterion("recomid <=", value, "recomid");
            return (Criteria) this;
        }

        public Criteria andRecomidIn(List<Integer> values) {
            addCriterion("recomid in", values, "recomid");
            return (Criteria) this;
        }

        public Criteria andRecomidNotIn(List<Integer> values) {
            addCriterion("recomid not in", values, "recomid");
            return (Criteria) this;
        }

        public Criteria andRecomidBetween(Integer value1, Integer value2) {
            addCriterion("recomid between", value1, value2, "recomid");
            return (Criteria) this;
        }

        public Criteria andRecomidNotBetween(Integer value1, Integer value2) {
            addCriterion("recomid not between", value1, value2, "recomid");
            return (Criteria) this;
        }

        public Criteria andComtimeIsNull() {
            addCriterion("comtime is null");
            return (Criteria) this;
        }

        public Criteria andComtimeIsNotNull() {
            addCriterion("comtime is not null");
            return (Criteria) this;
        }

        public Criteria andComtimeEqualTo(Date value) {
            addCriterion("comtime =", value, "comtime");
            return (Criteria) this;
        }

        public Criteria andComtimeNotEqualTo(Date value) {
            addCriterion("comtime <>", value, "comtime");
            return (Criteria) this;
        }

        public Criteria andComtimeGreaterThan(Date value) {
            addCriterion("comtime >", value, "comtime");
            return (Criteria) this;
        }

        public Criteria andComtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("comtime >=", value, "comtime");
            return (Criteria) this;
        }

        public Criteria andComtimeLessThan(Date value) {
            addCriterion("comtime <", value, "comtime");
            return (Criteria) this;
        }

        public Criteria andComtimeLessThanOrEqualTo(Date value) {
            addCriterion("comtime <=", value, "comtime");
            return (Criteria) this;
        }

        public Criteria andComtimeIn(List<Date> values) {
            addCriterion("comtime in", values, "comtime");
            return (Criteria) this;
        }

        public Criteria andComtimeNotIn(List<Date> values) {
            addCriterion("comtime not in", values, "comtime");
            return (Criteria) this;
        }

        public Criteria andComtimeBetween(Date value1, Date value2) {
            addCriterion("comtime between", value1, value2, "comtime");
            return (Criteria) this;
        }

        public Criteria andComtimeNotBetween(Date value1, Date value2) {
            addCriterion("comtime not between", value1, value2, "comtime");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Integer value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Integer value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Integer value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Integer value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Integer value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Integer> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Integer> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Integer value1, Integer value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Integer value1, Integer value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andComcontentIsNull() {
            addCriterion("comcontent is null");
            return (Criteria) this;
        }

        public Criteria andComcontentIsNotNull() {
            addCriterion("comcontent is not null");
            return (Criteria) this;
        }

        public Criteria andComcontentEqualTo(String value) {
            addCriterion("comcontent =", value, "comcontent");
            return (Criteria) this;
        }

        public Criteria andComcontentNotEqualTo(String value) {
            addCriterion("comcontent <>", value, "comcontent");
            return (Criteria) this;
        }

        public Criteria andComcontentGreaterThan(String value) {
            addCriterion("comcontent >", value, "comcontent");
            return (Criteria) this;
        }

        public Criteria andComcontentGreaterThanOrEqualTo(String value) {
            addCriterion("comcontent >=", value, "comcontent");
            return (Criteria) this;
        }

        public Criteria andComcontentLessThan(String value) {
            addCriterion("comcontent <", value, "comcontent");
            return (Criteria) this;
        }

        public Criteria andComcontentLessThanOrEqualTo(String value) {
            addCriterion("comcontent <=", value, "comcontent");
            return (Criteria) this;
        }

        public Criteria andComcontentLike(String value) {
            addCriterion("comcontent like", value, "comcontent");
            return (Criteria) this;
        }

        public Criteria andComcontentNotLike(String value) {
            addCriterion("comcontent not like", value, "comcontent");
            return (Criteria) this;
        }

        public Criteria andComcontentIn(List<String> values) {
            addCriterion("comcontent in", values, "comcontent");
            return (Criteria) this;
        }

        public Criteria andComcontentNotIn(List<String> values) {
            addCriterion("comcontent not in", values, "comcontent");
            return (Criteria) this;
        }

        public Criteria andComcontentBetween(String value1, String value2) {
            addCriterion("comcontent between", value1, value2, "comcontent");
            return (Criteria) this;
        }

        public Criteria andComcontentNotBetween(String value1, String value2) {
            addCriterion("comcontent not between", value1, value2, "comcontent");
            return (Criteria) this;
        }

        public Criteria andComstatusIsNull() {
            addCriterion("comstatus is null");
            return (Criteria) this;
        }

        public Criteria andComstatusIsNotNull() {
            addCriterion("comstatus is not null");
            return (Criteria) this;
        }

        public Criteria andComstatusEqualTo(Integer value) {
            addCriterion("comstatus =", value, "comstatus");
            return (Criteria) this;
        }

        public Criteria andComstatusNotEqualTo(Integer value) {
            addCriterion("comstatus <>", value, "comstatus");
            return (Criteria) this;
        }

        public Criteria andComstatusGreaterThan(Integer value) {
            addCriterion("comstatus >", value, "comstatus");
            return (Criteria) this;
        }

        public Criteria andComstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("comstatus >=", value, "comstatus");
            return (Criteria) this;
        }

        public Criteria andComstatusLessThan(Integer value) {
            addCriterion("comstatus <", value, "comstatus");
            return (Criteria) this;
        }

        public Criteria andComstatusLessThanOrEqualTo(Integer value) {
            addCriterion("comstatus <=", value, "comstatus");
            return (Criteria) this;
        }

        public Criteria andComstatusIn(List<Integer> values) {
            addCriterion("comstatus in", values, "comstatus");
            return (Criteria) this;
        }

        public Criteria andComstatusNotIn(List<Integer> values) {
            addCriterion("comstatus not in", values, "comstatus");
            return (Criteria) this;
        }

        public Criteria andComstatusBetween(Integer value1, Integer value2) {
            addCriterion("comstatus between", value1, value2, "comstatus");
            return (Criteria) this;
        }

        public Criteria andComstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("comstatus not between", value1, value2, "comstatus");
            return (Criteria) this;
        }

        public Criteria andComtempIsNull() {
            addCriterion("comtemp is null");
            return (Criteria) this;
        }

        public Criteria andComtempIsNotNull() {
            addCriterion("comtemp is not null");
            return (Criteria) this;
        }

        public Criteria andComtempEqualTo(String value) {
            addCriterion("comtemp =", value, "comtemp");
            return (Criteria) this;
        }

        public Criteria andComtempNotEqualTo(String value) {
            addCriterion("comtemp <>", value, "comtemp");
            return (Criteria) this;
        }

        public Criteria andComtempGreaterThan(String value) {
            addCriterion("comtemp >", value, "comtemp");
            return (Criteria) this;
        }

        public Criteria andComtempGreaterThanOrEqualTo(String value) {
            addCriterion("comtemp >=", value, "comtemp");
            return (Criteria) this;
        }

        public Criteria andComtempLessThan(String value) {
            addCriterion("comtemp <", value, "comtemp");
            return (Criteria) this;
        }

        public Criteria andComtempLessThanOrEqualTo(String value) {
            addCriterion("comtemp <=", value, "comtemp");
            return (Criteria) this;
        }

        public Criteria andComtempLike(String value) {
            addCriterion("comtemp like", value, "comtemp");
            return (Criteria) this;
        }

        public Criteria andComtempNotLike(String value) {
            addCriterion("comtemp not like", value, "comtemp");
            return (Criteria) this;
        }

        public Criteria andComtempIn(List<String> values) {
            addCriterion("comtemp in", values, "comtemp");
            return (Criteria) this;
        }

        public Criteria andComtempNotIn(List<String> values) {
            addCriterion("comtemp not in", values, "comtemp");
            return (Criteria) this;
        }

        public Criteria andComtempBetween(String value1, String value2) {
            addCriterion("comtemp between", value1, value2, "comtemp");
            return (Criteria) this;
        }

        public Criteria andComtempNotBetween(String value1, String value2) {
            addCriterion("comtemp not between", value1, value2, "comtemp");
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
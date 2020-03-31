package com.yc.blog.bean;

import java.util.ArrayList;
import java.util.List;

public class CategoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CategoryExample() {
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

        public Criteria andCateidIsNull() {
            addCriterion("cateid is null");
            return (Criteria) this;
        }

        public Criteria andCateidIsNotNull() {
            addCriterion("cateid is not null");
            return (Criteria) this;
        }

        public Criteria andCateidEqualTo(Integer value) {
            addCriterion("cateid =", value, "cateid");
            return (Criteria) this;
        }

        public Criteria andCateidNotEqualTo(Integer value) {
            addCriterion("cateid <>", value, "cateid");
            return (Criteria) this;
        }

        public Criteria andCateidGreaterThan(Integer value) {
            addCriterion("cateid >", value, "cateid");
            return (Criteria) this;
        }

        public Criteria andCateidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cateid >=", value, "cateid");
            return (Criteria) this;
        }

        public Criteria andCateidLessThan(Integer value) {
            addCriterion("cateid <", value, "cateid");
            return (Criteria) this;
        }

        public Criteria andCateidLessThanOrEqualTo(Integer value) {
            addCriterion("cateid <=", value, "cateid");
            return (Criteria) this;
        }

        public Criteria andCateidIn(List<Integer> values) {
            addCriterion("cateid in", values, "cateid");
            return (Criteria) this;
        }

        public Criteria andCateidNotIn(List<Integer> values) {
            addCriterion("cateid not in", values, "cateid");
            return (Criteria) this;
        }

        public Criteria andCateidBetween(Integer value1, Integer value2) {
            addCriterion("cateid between", value1, value2, "cateid");
            return (Criteria) this;
        }

        public Criteria andCateidNotBetween(Integer value1, Integer value2) {
            addCriterion("cateid not between", value1, value2, "cateid");
            return (Criteria) this;
        }

        public Criteria andCatenameIsNull() {
            addCriterion("catename is null");
            return (Criteria) this;
        }

        public Criteria andCatenameIsNotNull() {
            addCriterion("catename is not null");
            return (Criteria) this;
        }

        public Criteria andCatenameEqualTo(String value) {
            addCriterion("catename =", value, "catename");
            return (Criteria) this;
        }

        public Criteria andCatenameNotEqualTo(String value) {
            addCriterion("catename <>", value, "catename");
            return (Criteria) this;
        }

        public Criteria andCatenameGreaterThan(String value) {
            addCriterion("catename >", value, "catename");
            return (Criteria) this;
        }

        public Criteria andCatenameGreaterThanOrEqualTo(String value) {
            addCriterion("catename >=", value, "catename");
            return (Criteria) this;
        }

        public Criteria andCatenameLessThan(String value) {
            addCriterion("catename <", value, "catename");
            return (Criteria) this;
        }

        public Criteria andCatenameLessThanOrEqualTo(String value) {
            addCriterion("catename <=", value, "catename");
            return (Criteria) this;
        }

        public Criteria andCatenameLike(String value) {
            addCriterion("catename like", value, "catename");
            return (Criteria) this;
        }

        public Criteria andCatenameNotLike(String value) {
            addCriterion("catename not like", value, "catename");
            return (Criteria) this;
        }

        public Criteria andCatenameIn(List<String> values) {
            addCriterion("catename in", values, "catename");
            return (Criteria) this;
        }

        public Criteria andCatenameNotIn(List<String> values) {
            addCriterion("catename not in", values, "catename");
            return (Criteria) this;
        }

        public Criteria andCatenameBetween(String value1, String value2) {
            addCriterion("catename between", value1, value2, "catename");
            return (Criteria) this;
        }

        public Criteria andCatenameNotBetween(String value1, String value2) {
            addCriterion("catename not between", value1, value2, "catename");
            return (Criteria) this;
        }

        public Criteria andLabelIsNull() {
            addCriterion("label is null");
            return (Criteria) this;
        }

        public Criteria andLabelIsNotNull() {
            addCriterion("label is not null");
            return (Criteria) this;
        }

        public Criteria andLabelEqualTo(String value) {
            addCriterion("label =", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelNotEqualTo(String value) {
            addCriterion("label <>", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelGreaterThan(String value) {
            addCriterion("label >", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelGreaterThanOrEqualTo(String value) {
            addCriterion("label >=", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelLessThan(String value) {
            addCriterion("label <", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelLessThanOrEqualTo(String value) {
            addCriterion("label <=", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelLike(String value) {
            addCriterion("label like", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelNotLike(String value) {
            addCriterion("label not like", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelIn(List<String> values) {
            addCriterion("label in", values, "label");
            return (Criteria) this;
        }

        public Criteria andLabelNotIn(List<String> values) {
            addCriterion("label not in", values, "label");
            return (Criteria) this;
        }

        public Criteria andLabelBetween(String value1, String value2) {
            addCriterion("label between", value1, value2, "label");
            return (Criteria) this;
        }

        public Criteria andLabelNotBetween(String value1, String value2) {
            addCriterion("label not between", value1, value2, "label");
            return (Criteria) this;
        }

        public Criteria andCatestatusIsNull() {
            addCriterion("catestatus is null");
            return (Criteria) this;
        }

        public Criteria andCatestatusIsNotNull() {
            addCriterion("catestatus is not null");
            return (Criteria) this;
        }

        public Criteria andCatestatusEqualTo(Integer value) {
            addCriterion("catestatus =", value, "catestatus");
            return (Criteria) this;
        }

        public Criteria andCatestatusNotEqualTo(Integer value) {
            addCriterion("catestatus <>", value, "catestatus");
            return (Criteria) this;
        }

        public Criteria andCatestatusGreaterThan(Integer value) {
            addCriterion("catestatus >", value, "catestatus");
            return (Criteria) this;
        }

        public Criteria andCatestatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("catestatus >=", value, "catestatus");
            return (Criteria) this;
        }

        public Criteria andCatestatusLessThan(Integer value) {
            addCriterion("catestatus <", value, "catestatus");
            return (Criteria) this;
        }

        public Criteria andCatestatusLessThanOrEqualTo(Integer value) {
            addCriterion("catestatus <=", value, "catestatus");
            return (Criteria) this;
        }

        public Criteria andCatestatusIn(List<Integer> values) {
            addCriterion("catestatus in", values, "catestatus");
            return (Criteria) this;
        }

        public Criteria andCatestatusNotIn(List<Integer> values) {
            addCriterion("catestatus not in", values, "catestatus");
            return (Criteria) this;
        }

        public Criteria andCatestatusBetween(Integer value1, Integer value2) {
            addCriterion("catestatus between", value1, value2, "catestatus");
            return (Criteria) this;
        }

        public Criteria andCatestatusNotBetween(Integer value1, Integer value2) {
            addCriterion("catestatus not between", value1, value2, "catestatus");
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
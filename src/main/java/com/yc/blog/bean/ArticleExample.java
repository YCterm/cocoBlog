package com.yc.blog.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ArticleExample() {
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

        public Criteria andAuthorIsNull() {
            addCriterion("author is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNotNull() {
            addCriterion("author is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorEqualTo(String value) {
            addCriterion("author =", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotEqualTo(String value) {
            addCriterion("author <>", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThan(String value) {
            addCriterion("author >", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("author >=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThan(String value) {
            addCriterion("author <", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThanOrEqualTo(String value) {
            addCriterion("author <=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLike(String value) {
            addCriterion("author like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotLike(String value) {
            addCriterion("author not like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorIn(List<String> values) {
            addCriterion("author in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotIn(List<String> values) {
            addCriterion("author not in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorBetween(String value1, String value2) {
            addCriterion("author between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotBetween(String value1, String value2) {
            addCriterion("author not between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
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

        public Criteria andImgsIsNull() {
            addCriterion("imgs is null");
            return (Criteria) this;
        }

        public Criteria andImgsIsNotNull() {
            addCriterion("imgs is not null");
            return (Criteria) this;
        }

        public Criteria andImgsEqualTo(String value) {
            addCriterion("imgs =", value, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsNotEqualTo(String value) {
            addCriterion("imgs <>", value, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsGreaterThan(String value) {
            addCriterion("imgs >", value, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsGreaterThanOrEqualTo(String value) {
            addCriterion("imgs >=", value, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsLessThan(String value) {
            addCriterion("imgs <", value, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsLessThanOrEqualTo(String value) {
            addCriterion("imgs <=", value, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsLike(String value) {
            addCriterion("imgs like", value, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsNotLike(String value) {
            addCriterion("imgs not like", value, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsIn(List<String> values) {
            addCriterion("imgs in", values, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsNotIn(List<String> values) {
            addCriterion("imgs not in", values, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsBetween(String value1, String value2) {
            addCriterion("imgs between", value1, value2, "imgs");
            return (Criteria) this;
        }

        public Criteria andImgsNotBetween(String value1, String value2) {
            addCriterion("imgs not between", value1, value2, "imgs");
            return (Criteria) this;
        }

        public Criteria andArttimeIsNull() {
            addCriterion("arttime is null");
            return (Criteria) this;
        }

        public Criteria andArttimeIsNotNull() {
            addCriterion("arttime is not null");
            return (Criteria) this;
        }

        public Criteria andArttimeEqualTo(Date value) {
            addCriterion("arttime =", value, "arttime");
            return (Criteria) this;
        }

        public Criteria andArttimeNotEqualTo(Date value) {
            addCriterion("arttime <>", value, "arttime");
            return (Criteria) this;
        }

        public Criteria andArttimeGreaterThan(Date value) {
            addCriterion("arttime >", value, "arttime");
            return (Criteria) this;
        }

        public Criteria andArttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("arttime >=", value, "arttime");
            return (Criteria) this;
        }

        public Criteria andArttimeLessThan(Date value) {
            addCriterion("arttime <", value, "arttime");
            return (Criteria) this;
        }

        public Criteria andArttimeLessThanOrEqualTo(Date value) {
            addCriterion("arttime <=", value, "arttime");
            return (Criteria) this;
        }

        public Criteria andArttimeIn(List<Date> values) {
            addCriterion("arttime in", values, "arttime");
            return (Criteria) this;
        }

        public Criteria andArttimeNotIn(List<Date> values) {
            addCriterion("arttime not in", values, "arttime");
            return (Criteria) this;
        }

        public Criteria andArttimeBetween(Date value1, Date value2) {
            addCriterion("arttime between", value1, value2, "arttime");
            return (Criteria) this;
        }

        public Criteria andArttimeNotBetween(Date value1, Date value2) {
            addCriterion("arttime not between", value1, value2, "arttime");
            return (Criteria) this;
        }

        public Criteria andReadcntIsNull() {
            addCriterion("readcnt is null");
            return (Criteria) this;
        }

        public Criteria andReadcntIsNotNull() {
            addCriterion("readcnt is not null");
            return (Criteria) this;
        }

        public Criteria andReadcntEqualTo(Integer value) {
            addCriterion("readcnt =", value, "readcnt");
            return (Criteria) this;
        }

        public Criteria andReadcntNotEqualTo(Integer value) {
            addCriterion("readcnt <>", value, "readcnt");
            return (Criteria) this;
        }

        public Criteria andReadcntGreaterThan(Integer value) {
            addCriterion("readcnt >", value, "readcnt");
            return (Criteria) this;
        }

        public Criteria andReadcntGreaterThanOrEqualTo(Integer value) {
            addCriterion("readcnt >=", value, "readcnt");
            return (Criteria) this;
        }

        public Criteria andReadcntLessThan(Integer value) {
            addCriterion("readcnt <", value, "readcnt");
            return (Criteria) this;
        }

        public Criteria andReadcntLessThanOrEqualTo(Integer value) {
            addCriterion("readcnt <=", value, "readcnt");
            return (Criteria) this;
        }

        public Criteria andReadcntIn(List<Integer> values) {
            addCriterion("readcnt in", values, "readcnt");
            return (Criteria) this;
        }

        public Criteria andReadcntNotIn(List<Integer> values) {
            addCriterion("readcnt not in", values, "readcnt");
            return (Criteria) this;
        }

        public Criteria andReadcntBetween(Integer value1, Integer value2) {
            addCriterion("readcnt between", value1, value2, "readcnt");
            return (Criteria) this;
        }

        public Criteria andReadcntNotBetween(Integer value1, Integer value2) {
            addCriterion("readcnt not between", value1, value2, "readcnt");
            return (Criteria) this;
        }

        public Criteria andArtstatusIsNull() {
            addCriterion("artstatus is null");
            return (Criteria) this;
        }

        public Criteria andArtstatusIsNotNull() {
            addCriterion("artstatus is not null");
            return (Criteria) this;
        }

        public Criteria andArtstatusEqualTo(Integer value) {
            addCriterion("artstatus =", value, "artstatus");
            return (Criteria) this;
        }

        public Criteria andArtstatusNotEqualTo(Integer value) {
            addCriterion("artstatus <>", value, "artstatus");
            return (Criteria) this;
        }

        public Criteria andArtstatusGreaterThan(Integer value) {
            addCriterion("artstatus >", value, "artstatus");
            return (Criteria) this;
        }

        public Criteria andArtstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("artstatus >=", value, "artstatus");
            return (Criteria) this;
        }

        public Criteria andArtstatusLessThan(Integer value) {
            addCriterion("artstatus <", value, "artstatus");
            return (Criteria) this;
        }

        public Criteria andArtstatusLessThanOrEqualTo(Integer value) {
            addCriterion("artstatus <=", value, "artstatus");
            return (Criteria) this;
        }

        public Criteria andArtstatusIn(List<Integer> values) {
            addCriterion("artstatus in", values, "artstatus");
            return (Criteria) this;
        }

        public Criteria andArtstatusNotIn(List<Integer> values) {
            addCriterion("artstatus not in", values, "artstatus");
            return (Criteria) this;
        }

        public Criteria andArtstatusBetween(Integer value1, Integer value2) {
            addCriterion("artstatus between", value1, value2, "artstatus");
            return (Criteria) this;
        }

        public Criteria andArtstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("artstatus not between", value1, value2, "artstatus");
            return (Criteria) this;
        }

        public Criteria andArttempIsNull() {
            addCriterion("arttemp is null");
            return (Criteria) this;
        }

        public Criteria andArttempIsNotNull() {
            addCriterion("arttemp is not null");
            return (Criteria) this;
        }

        public Criteria andArttempEqualTo(String value) {
            addCriterion("arttemp =", value, "arttemp");
            return (Criteria) this;
        }

        public Criteria andArttempNotEqualTo(String value) {
            addCriterion("arttemp <>", value, "arttemp");
            return (Criteria) this;
        }

        public Criteria andArttempGreaterThan(String value) {
            addCriterion("arttemp >", value, "arttemp");
            return (Criteria) this;
        }

        public Criteria andArttempGreaterThanOrEqualTo(String value) {
            addCriterion("arttemp >=", value, "arttemp");
            return (Criteria) this;
        }

        public Criteria andArttempLessThan(String value) {
            addCriterion("arttemp <", value, "arttemp");
            return (Criteria) this;
        }

        public Criteria andArttempLessThanOrEqualTo(String value) {
            addCriterion("arttemp <=", value, "arttemp");
            return (Criteria) this;
        }

        public Criteria andArttempLike(String value) {
            addCriterion("arttemp like", value, "arttemp");
            return (Criteria) this;
        }

        public Criteria andArttempNotLike(String value) {
            addCriterion("arttemp not like", value, "arttemp");
            return (Criteria) this;
        }

        public Criteria andArttempIn(List<String> values) {
            addCriterion("arttemp in", values, "arttemp");
            return (Criteria) this;
        }

        public Criteria andArttempNotIn(List<String> values) {
            addCriterion("arttemp not in", values, "arttemp");
            return (Criteria) this;
        }

        public Criteria andArttempBetween(String value1, String value2) {
            addCriterion("arttemp between", value1, value2, "arttemp");
            return (Criteria) this;
        }

        public Criteria andArttempNotBetween(String value1, String value2) {
            addCriterion("arttemp not between", value1, value2, "arttemp");
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
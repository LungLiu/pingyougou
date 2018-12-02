package com.pinyougou.pojo;

import java.util.ArrayList;
import java.util.List;

public class BrefProExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BrefProExample() {
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

        public Criteria andBpIdIsNull() {
            addCriterion("bp_id is null");
            return (Criteria) this;
        }

        public Criteria andBpIdIsNotNull() {
            addCriterion("bp_id is not null");
            return (Criteria) this;
        }

        public Criteria andBpIdEqualTo(Integer value) {
            addCriterion("bp_id =", value, "bpId");
            return (Criteria) this;
        }

        public Criteria andBpIdNotEqualTo(Integer value) {
            addCriterion("bp_id <>", value, "bpId");
            return (Criteria) this;
        }

        public Criteria andBpIdGreaterThan(Integer value) {
            addCriterion("bp_id >", value, "bpId");
            return (Criteria) this;
        }

        public Criteria andBpIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("bp_id >=", value, "bpId");
            return (Criteria) this;
        }

        public Criteria andBpIdLessThan(Integer value) {
            addCriterion("bp_id <", value, "bpId");
            return (Criteria) this;
        }

        public Criteria andBpIdLessThanOrEqualTo(Integer value) {
            addCriterion("bp_id <=", value, "bpId");
            return (Criteria) this;
        }

        public Criteria andBpIdIn(List<Integer> values) {
            addCriterion("bp_id in", values, "bpId");
            return (Criteria) this;
        }

        public Criteria andBpIdNotIn(List<Integer> values) {
            addCriterion("bp_id not in", values, "bpId");
            return (Criteria) this;
        }

        public Criteria andBpIdBetween(Integer value1, Integer value2) {
            addCriterion("bp_id between", value1, value2, "bpId");
            return (Criteria) this;
        }

        public Criteria andBpIdNotBetween(Integer value1, Integer value2) {
            addCriterion("bp_id not between", value1, value2, "bpId");
            return (Criteria) this;
        }

        public Criteria andBpTypeIsNull() {
            addCriterion("bp_type is null");
            return (Criteria) this;
        }

        public Criteria andBpTypeIsNotNull() {
            addCriterion("bp_type is not null");
            return (Criteria) this;
        }

        public Criteria andBpTypeEqualTo(String value) {
            addCriterion("bp_type =", value, "bpType");
            return (Criteria) this;
        }

        public Criteria andBpTypeNotEqualTo(String value) {
            addCriterion("bp_type <>", value, "bpType");
            return (Criteria) this;
        }

        public Criteria andBpTypeGreaterThan(String value) {
            addCriterion("bp_type >", value, "bpType");
            return (Criteria) this;
        }

        public Criteria andBpTypeGreaterThanOrEqualTo(String value) {
            addCriterion("bp_type >=", value, "bpType");
            return (Criteria) this;
        }

        public Criteria andBpTypeLessThan(String value) {
            addCriterion("bp_type <", value, "bpType");
            return (Criteria) this;
        }

        public Criteria andBpTypeLessThanOrEqualTo(String value) {
            addCriterion("bp_type <=", value, "bpType");
            return (Criteria) this;
        }

        public Criteria andBpTypeLike(String value) {
            addCriterion("bp_type like", value, "bpType");
            return (Criteria) this;
        }

        public Criteria andBpTypeNotLike(String value) {
            addCriterion("bp_type not like", value, "bpType");
            return (Criteria) this;
        }

        public Criteria andBpTypeIn(List<String> values) {
            addCriterion("bp_type in", values, "bpType");
            return (Criteria) this;
        }

        public Criteria andBpTypeNotIn(List<String> values) {
            addCriterion("bp_type not in", values, "bpType");
            return (Criteria) this;
        }

        public Criteria andBpTypeBetween(String value1, String value2) {
            addCriterion("bp_type between", value1, value2, "bpType");
            return (Criteria) this;
        }

        public Criteria andBpTypeNotBetween(String value1, String value2) {
            addCriterion("bp_type not between", value1, value2, "bpType");
            return (Criteria) this;
        }

        public Criteria andBpUrlIsNull() {
            addCriterion("bp_url is null");
            return (Criteria) this;
        }

        public Criteria andBpUrlIsNotNull() {
            addCriterion("bp_url is not null");
            return (Criteria) this;
        }

        public Criteria andBpUrlEqualTo(String value) {
            addCriterion("bp_url =", value, "bpUrl");
            return (Criteria) this;
        }

        public Criteria andBpUrlNotEqualTo(String value) {
            addCriterion("bp_url <>", value, "bpUrl");
            return (Criteria) this;
        }

        public Criteria andBpUrlGreaterThan(String value) {
            addCriterion("bp_url >", value, "bpUrl");
            return (Criteria) this;
        }

        public Criteria andBpUrlGreaterThanOrEqualTo(String value) {
            addCriterion("bp_url >=", value, "bpUrl");
            return (Criteria) this;
        }

        public Criteria andBpUrlLessThan(String value) {
            addCriterion("bp_url <", value, "bpUrl");
            return (Criteria) this;
        }

        public Criteria andBpUrlLessThanOrEqualTo(String value) {
            addCriterion("bp_url <=", value, "bpUrl");
            return (Criteria) this;
        }

        public Criteria andBpUrlLike(String value) {
            addCriterion("bp_url like", value, "bpUrl");
            return (Criteria) this;
        }

        public Criteria andBpUrlNotLike(String value) {
            addCriterion("bp_url not like", value, "bpUrl");
            return (Criteria) this;
        }

        public Criteria andBpUrlIn(List<String> values) {
            addCriterion("bp_url in", values, "bpUrl");
            return (Criteria) this;
        }

        public Criteria andBpUrlNotIn(List<String> values) {
            addCriterion("bp_url not in", values, "bpUrl");
            return (Criteria) this;
        }

        public Criteria andBpUrlBetween(String value1, String value2) {
            addCriterion("bp_url between", value1, value2, "bpUrl");
            return (Criteria) this;
        }

        public Criteria andBpUrlNotBetween(String value1, String value2) {
            addCriterion("bp_url not between", value1, value2, "bpUrl");
            return (Criteria) this;
        }

        public Criteria andBpHuohaoIsNull() {
            addCriterion("bp_huohao is null");
            return (Criteria) this;
        }

        public Criteria andBpHuohaoIsNotNull() {
            addCriterion("bp_huohao is not null");
            return (Criteria) this;
        }

        public Criteria andBpHuohaoEqualTo(String value) {
            addCriterion("bp_huohao =", value, "bpHuohao");
            return (Criteria) this;
        }

        public Criteria andBpHuohaoNotEqualTo(String value) {
            addCriterion("bp_huohao <>", value, "bpHuohao");
            return (Criteria) this;
        }

        public Criteria andBpHuohaoGreaterThan(String value) {
            addCriterion("bp_huohao >", value, "bpHuohao");
            return (Criteria) this;
        }

        public Criteria andBpHuohaoGreaterThanOrEqualTo(String value) {
            addCriterion("bp_huohao >=", value, "bpHuohao");
            return (Criteria) this;
        }

        public Criteria andBpHuohaoLessThan(String value) {
            addCriterion("bp_huohao <", value, "bpHuohao");
            return (Criteria) this;
        }

        public Criteria andBpHuohaoLessThanOrEqualTo(String value) {
            addCriterion("bp_huohao <=", value, "bpHuohao");
            return (Criteria) this;
        }

        public Criteria andBpHuohaoLike(String value) {
            addCriterion("bp_huohao like", value, "bpHuohao");
            return (Criteria) this;
        }

        public Criteria andBpHuohaoNotLike(String value) {
            addCriterion("bp_huohao not like", value, "bpHuohao");
            return (Criteria) this;
        }

        public Criteria andBpHuohaoIn(List<String> values) {
            addCriterion("bp_huohao in", values, "bpHuohao");
            return (Criteria) this;
        }

        public Criteria andBpHuohaoNotIn(List<String> values) {
            addCriterion("bp_huohao not in", values, "bpHuohao");
            return (Criteria) this;
        }

        public Criteria andBpHuohaoBetween(String value1, String value2) {
            addCriterion("bp_huohao between", value1, value2, "bpHuohao");
            return (Criteria) this;
        }

        public Criteria andBpHuohaoNotBetween(String value1, String value2) {
            addCriterion("bp_huohao not between", value1, value2, "bpHuohao");
            return (Criteria) this;
        }

        public Criteria andBpPriceIsNull() {
            addCriterion("bp_price is null");
            return (Criteria) this;
        }

        public Criteria andBpPriceIsNotNull() {
            addCriterion("bp_price is not null");
            return (Criteria) this;
        }

        public Criteria andBpPriceEqualTo(String value) {
            addCriterion("bp_price =", value, "bpPrice");
            return (Criteria) this;
        }

        public Criteria andBpPriceNotEqualTo(String value) {
            addCriterion("bp_price <>", value, "bpPrice");
            return (Criteria) this;
        }

        public Criteria andBpPriceGreaterThan(String value) {
            addCriterion("bp_price >", value, "bpPrice");
            return (Criteria) this;
        }

        public Criteria andBpPriceGreaterThanOrEqualTo(String value) {
            addCriterion("bp_price >=", value, "bpPrice");
            return (Criteria) this;
        }

        public Criteria andBpPriceLessThan(String value) {
            addCriterion("bp_price <", value, "bpPrice");
            return (Criteria) this;
        }

        public Criteria andBpPriceLessThanOrEqualTo(String value) {
            addCriterion("bp_price <=", value, "bpPrice");
            return (Criteria) this;
        }

        public Criteria andBpPriceLike(String value) {
            addCriterion("bp_price like", value, "bpPrice");
            return (Criteria) this;
        }

        public Criteria andBpPriceNotLike(String value) {
            addCriterion("bp_price not like", value, "bpPrice");
            return (Criteria) this;
        }

        public Criteria andBpPriceIn(List<String> values) {
            addCriterion("bp_price in", values, "bpPrice");
            return (Criteria) this;
        }

        public Criteria andBpPriceNotIn(List<String> values) {
            addCriterion("bp_price not in", values, "bpPrice");
            return (Criteria) this;
        }

        public Criteria andBpPriceBetween(String value1, String value2) {
            addCriterion("bp_price between", value1, value2, "bpPrice");
            return (Criteria) this;
        }

        public Criteria andBpPriceNotBetween(String value1, String value2) {
            addCriterion("bp_price not between", value1, value2, "bpPrice");
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
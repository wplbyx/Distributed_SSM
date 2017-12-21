package com.lbyx.pojo;

import java.util.ArrayList;
import java.util.List;

public class GoodsTypeQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsTypeQuery() {
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

        public Criteria andGoodsTypeIdIsNull() {
            addCriterion("goods_type_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIdIsNotNull() {
            addCriterion("goods_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIdEqualTo(Integer value) {
            addCriterion("goods_type_id =", value, "goodsTypeId");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIdNotEqualTo(Integer value) {
            addCriterion("goods_type_id <>", value, "goodsTypeId");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIdGreaterThan(Integer value) {
            addCriterion("goods_type_id >", value, "goodsTypeId");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_type_id >=", value, "goodsTypeId");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIdLessThan(Integer value) {
            addCriterion("goods_type_id <", value, "goodsTypeId");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("goods_type_id <=", value, "goodsTypeId");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIdIn(List<Integer> values) {
            addCriterion("goods_type_id in", values, "goodsTypeId");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIdNotIn(List<Integer> values) {
            addCriterion("goods_type_id not in", values, "goodsTypeId");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("goods_type_id between", value1, value2, "goodsTypeId");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_type_id not between", value1, value2, "goodsTypeId");
            return (Criteria) this;
        }

        public Criteria andFatherTypeIdIsNull() {
            addCriterion("father_type_id is null");
            return (Criteria) this;
        }

        public Criteria andFatherTypeIdIsNotNull() {
            addCriterion("father_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andFatherTypeIdEqualTo(Integer value) {
            addCriterion("father_type_id =", value, "fatherTypeId");
            return (Criteria) this;
        }

        public Criteria andFatherTypeIdNotEqualTo(Integer value) {
            addCriterion("father_type_id <>", value, "fatherTypeId");
            return (Criteria) this;
        }

        public Criteria andFatherTypeIdGreaterThan(Integer value) {
            addCriterion("father_type_id >", value, "fatherTypeId");
            return (Criteria) this;
        }

        public Criteria andFatherTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("father_type_id >=", value, "fatherTypeId");
            return (Criteria) this;
        }

        public Criteria andFatherTypeIdLessThan(Integer value) {
            addCriterion("father_type_id <", value, "fatherTypeId");
            return (Criteria) this;
        }

        public Criteria andFatherTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("father_type_id <=", value, "fatherTypeId");
            return (Criteria) this;
        }

        public Criteria andFatherTypeIdIn(List<Integer> values) {
            addCriterion("father_type_id in", values, "fatherTypeId");
            return (Criteria) this;
        }

        public Criteria andFatherTypeIdNotIn(List<Integer> values) {
            addCriterion("father_type_id not in", values, "fatherTypeId");
            return (Criteria) this;
        }

        public Criteria andFatherTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("father_type_id between", value1, value2, "fatherTypeId");
            return (Criteria) this;
        }

        public Criteria andFatherTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("father_type_id not between", value1, value2, "fatherTypeId");
            return (Criteria) this;
        }

        public Criteria andIsleafIsNull() {
            addCriterion("isLeaf is null");
            return (Criteria) this;
        }

        public Criteria andIsleafIsNotNull() {
            addCriterion("isLeaf is not null");
            return (Criteria) this;
        }

        public Criteria andIsleafEqualTo(Boolean value) {
            addCriterion("isLeaf =", value, "isleaf");
            return (Criteria) this;
        }

        public Criteria andIsleafNotEqualTo(Boolean value) {
            addCriterion("isLeaf <>", value, "isleaf");
            return (Criteria) this;
        }

        public Criteria andIsleafGreaterThan(Boolean value) {
            addCriterion("isLeaf >", value, "isleaf");
            return (Criteria) this;
        }

        public Criteria andIsleafGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isLeaf >=", value, "isleaf");
            return (Criteria) this;
        }

        public Criteria andIsleafLessThan(Boolean value) {
            addCriterion("isLeaf <", value, "isleaf");
            return (Criteria) this;
        }

        public Criteria andIsleafLessThanOrEqualTo(Boolean value) {
            addCriterion("isLeaf <=", value, "isleaf");
            return (Criteria) this;
        }

        public Criteria andIsleafIn(List<Boolean> values) {
            addCriterion("isLeaf in", values, "isleaf");
            return (Criteria) this;
        }

        public Criteria andIsleafNotIn(List<Boolean> values) {
            addCriterion("isLeaf not in", values, "isleaf");
            return (Criteria) this;
        }

        public Criteria andIsleafBetween(Boolean value1, Boolean value2) {
            addCriterion("isLeaf between", value1, value2, "isleaf");
            return (Criteria) this;
        }

        public Criteria andIsleafNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isLeaf not between", value1, value2, "isleaf");
            return (Criteria) this;
        }

        public Criteria andTypenameIsNull() {
            addCriterion("typeName is null");
            return (Criteria) this;
        }

        public Criteria andTypenameIsNotNull() {
            addCriterion("typeName is not null");
            return (Criteria) this;
        }

        public Criteria andTypenameEqualTo(String value) {
            addCriterion("typeName =", value, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameNotEqualTo(String value) {
            addCriterion("typeName <>", value, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameGreaterThan(String value) {
            addCriterion("typeName >", value, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameGreaterThanOrEqualTo(String value) {
            addCriterion("typeName >=", value, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameLessThan(String value) {
            addCriterion("typeName <", value, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameLessThanOrEqualTo(String value) {
            addCriterion("typeName <=", value, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameLike(String value) {
            addCriterion("typeName like", value, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameNotLike(String value) {
            addCriterion("typeName not like", value, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameIn(List<String> values) {
            addCriterion("typeName in", values, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameNotIn(List<String> values) {
            addCriterion("typeName not in", values, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameBetween(String value1, String value2) {
            addCriterion("typeName between", value1, value2, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameNotBetween(String value1, String value2) {
            addCriterion("typeName not between", value1, value2, "typename");
            return (Criteria) this;
        }

        public Criteria andSortorderIsNull() {
            addCriterion("sortOrder is null");
            return (Criteria) this;
        }

        public Criteria andSortorderIsNotNull() {
            addCriterion("sortOrder is not null");
            return (Criteria) this;
        }

        public Criteria andSortorderEqualTo(Integer value) {
            addCriterion("sortOrder =", value, "sortorder");
            return (Criteria) this;
        }

        public Criteria andSortorderNotEqualTo(Integer value) {
            addCriterion("sortOrder <>", value, "sortorder");
            return (Criteria) this;
        }

        public Criteria andSortorderGreaterThan(Integer value) {
            addCriterion("sortOrder >", value, "sortorder");
            return (Criteria) this;
        }

        public Criteria andSortorderGreaterThanOrEqualTo(Integer value) {
            addCriterion("sortOrder >=", value, "sortorder");
            return (Criteria) this;
        }

        public Criteria andSortorderLessThan(Integer value) {
            addCriterion("sortOrder <", value, "sortorder");
            return (Criteria) this;
        }

        public Criteria andSortorderLessThanOrEqualTo(Integer value) {
            addCriterion("sortOrder <=", value, "sortorder");
            return (Criteria) this;
        }

        public Criteria andSortorderIn(List<Integer> values) {
            addCriterion("sortOrder in", values, "sortorder");
            return (Criteria) this;
        }

        public Criteria andSortorderNotIn(List<Integer> values) {
            addCriterion("sortOrder not in", values, "sortorder");
            return (Criteria) this;
        }

        public Criteria andSortorderBetween(Integer value1, Integer value2) {
            addCriterion("sortOrder between", value1, value2, "sortorder");
            return (Criteria) this;
        }

        public Criteria andSortorderNotBetween(Integer value1, Integer value2) {
            addCriterion("sortOrder not between", value1, value2, "sortorder");
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
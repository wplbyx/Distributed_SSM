package com.lbyx.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderQuery() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Integer value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Integer value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Integer value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Integer> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Integer> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andAdminIdIsNull() {
            addCriterion("admin_id is null");
            return (Criteria) this;
        }

        public Criteria andAdminIdIsNotNull() {
            addCriterion("admin_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdminIdEqualTo(Integer value) {
            addCriterion("admin_id =", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotEqualTo(Integer value) {
            addCriterion("admin_id <>", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdGreaterThan(Integer value) {
            addCriterion("admin_id >", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("admin_id >=", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLessThan(Integer value) {
            addCriterion("admin_id <", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLessThanOrEqualTo(Integer value) {
            addCriterion("admin_id <=", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdIn(List<Integer> values) {
            addCriterion("admin_id in", values, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotIn(List<Integer> values) {
            addCriterion("admin_id not in", values, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdBetween(Integer value1, Integer value2) {
            addCriterion("admin_id between", value1, value2, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotBetween(Integer value1, Integer value2) {
            addCriterion("admin_id not between", value1, value2, "adminId");
            return (Criteria) this;
        }

        public Criteria andOwneridIsNull() {
            addCriterion("ownerId is null");
            return (Criteria) this;
        }

        public Criteria andOwneridIsNotNull() {
            addCriterion("ownerId is not null");
            return (Criteria) this;
        }

        public Criteria andOwneridEqualTo(Integer value) {
            addCriterion("ownerId =", value, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridNotEqualTo(Integer value) {
            addCriterion("ownerId <>", value, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridGreaterThan(Integer value) {
            addCriterion("ownerId >", value, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridGreaterThanOrEqualTo(Integer value) {
            addCriterion("ownerId >=", value, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridLessThan(Integer value) {
            addCriterion("ownerId <", value, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridLessThanOrEqualTo(Integer value) {
            addCriterion("ownerId <=", value, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridIn(List<Integer> values) {
            addCriterion("ownerId in", values, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridNotIn(List<Integer> values) {
            addCriterion("ownerId not in", values, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridBetween(Integer value1, Integer value2) {
            addCriterion("ownerId between", value1, value2, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridNotBetween(Integer value1, Integer value2) {
            addCriterion("ownerId not between", value1, value2, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOrdertypeIsNull() {
            addCriterion("orderType is null");
            return (Criteria) this;
        }

        public Criteria andOrdertypeIsNotNull() {
            addCriterion("orderType is not null");
            return (Criteria) this;
        }

        public Criteria andOrdertypeEqualTo(Byte value) {
            addCriterion("orderType =", value, "ordertype");
            return (Criteria) this;
        }

        public Criteria andOrdertypeNotEqualTo(Byte value) {
            addCriterion("orderType <>", value, "ordertype");
            return (Criteria) this;
        }

        public Criteria andOrdertypeGreaterThan(Byte value) {
            addCriterion("orderType >", value, "ordertype");
            return (Criteria) this;
        }

        public Criteria andOrdertypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("orderType >=", value, "ordertype");
            return (Criteria) this;
        }

        public Criteria andOrdertypeLessThan(Byte value) {
            addCriterion("orderType <", value, "ordertype");
            return (Criteria) this;
        }

        public Criteria andOrdertypeLessThanOrEqualTo(Byte value) {
            addCriterion("orderType <=", value, "ordertype");
            return (Criteria) this;
        }

        public Criteria andOrdertypeIn(List<Byte> values) {
            addCriterion("orderType in", values, "ordertype");
            return (Criteria) this;
        }

        public Criteria andOrdertypeNotIn(List<Byte> values) {
            addCriterion("orderType not in", values, "ordertype");
            return (Criteria) this;
        }

        public Criteria andOrdertypeBetween(Byte value1, Byte value2) {
            addCriterion("orderType between", value1, value2, "ordertype");
            return (Criteria) this;
        }

        public Criteria andOrdertypeNotBetween(Byte value1, Byte value2) {
            addCriterion("orderType not between", value1, value2, "ordertype");
            return (Criteria) this;
        }

        public Criteria andOrdervalueIsNull() {
            addCriterion("orderValue is null");
            return (Criteria) this;
        }

        public Criteria andOrdervalueIsNotNull() {
            addCriterion("orderValue is not null");
            return (Criteria) this;
        }

        public Criteria andOrdervalueEqualTo(Float value) {
            addCriterion("orderValue =", value, "ordervalue");
            return (Criteria) this;
        }

        public Criteria andOrdervalueNotEqualTo(Float value) {
            addCriterion("orderValue <>", value, "ordervalue");
            return (Criteria) this;
        }

        public Criteria andOrdervalueGreaterThan(Float value) {
            addCriterion("orderValue >", value, "ordervalue");
            return (Criteria) this;
        }

        public Criteria andOrdervalueGreaterThanOrEqualTo(Float value) {
            addCriterion("orderValue >=", value, "ordervalue");
            return (Criteria) this;
        }

        public Criteria andOrdervalueLessThan(Float value) {
            addCriterion("orderValue <", value, "ordervalue");
            return (Criteria) this;
        }

        public Criteria andOrdervalueLessThanOrEqualTo(Float value) {
            addCriterion("orderValue <=", value, "ordervalue");
            return (Criteria) this;
        }

        public Criteria andOrdervalueIn(List<Float> values) {
            addCriterion("orderValue in", values, "ordervalue");
            return (Criteria) this;
        }

        public Criteria andOrdervalueNotIn(List<Float> values) {
            addCriterion("orderValue not in", values, "ordervalue");
            return (Criteria) this;
        }

        public Criteria andOrdervalueBetween(Float value1, Float value2) {
            addCriterion("orderValue between", value1, value2, "ordervalue");
            return (Criteria) this;
        }

        public Criteria andOrdervalueNotBetween(Float value1, Float value2) {
            addCriterion("orderValue not between", value1, value2, "ordervalue");
            return (Criteria) this;
        }

        public Criteria andUsecouponIsNull() {
            addCriterion("useCoupon is null");
            return (Criteria) this;
        }

        public Criteria andUsecouponIsNotNull() {
            addCriterion("useCoupon is not null");
            return (Criteria) this;
        }

        public Criteria andUsecouponEqualTo(Float value) {
            addCriterion("useCoupon =", value, "usecoupon");
            return (Criteria) this;
        }

        public Criteria andUsecouponNotEqualTo(Float value) {
            addCriterion("useCoupon <>", value, "usecoupon");
            return (Criteria) this;
        }

        public Criteria andUsecouponGreaterThan(Float value) {
            addCriterion("useCoupon >", value, "usecoupon");
            return (Criteria) this;
        }

        public Criteria andUsecouponGreaterThanOrEqualTo(Float value) {
            addCriterion("useCoupon >=", value, "usecoupon");
            return (Criteria) this;
        }

        public Criteria andUsecouponLessThan(Float value) {
            addCriterion("useCoupon <", value, "usecoupon");
            return (Criteria) this;
        }

        public Criteria andUsecouponLessThanOrEqualTo(Float value) {
            addCriterion("useCoupon <=", value, "usecoupon");
            return (Criteria) this;
        }

        public Criteria andUsecouponIn(List<Float> values) {
            addCriterion("useCoupon in", values, "usecoupon");
            return (Criteria) this;
        }

        public Criteria andUsecouponNotIn(List<Float> values) {
            addCriterion("useCoupon not in", values, "usecoupon");
            return (Criteria) this;
        }

        public Criteria andUsecouponBetween(Float value1, Float value2) {
            addCriterion("useCoupon between", value1, value2, "usecoupon");
            return (Criteria) this;
        }

        public Criteria andUsecouponNotBetween(Float value1, Float value2) {
            addCriterion("useCoupon not between", value1, value2, "usecoupon");
            return (Criteria) this;
        }

        public Criteria andCreattiemIsNull() {
            addCriterion("creatTiem is null");
            return (Criteria) this;
        }

        public Criteria andCreattiemIsNotNull() {
            addCriterion("creatTiem is not null");
            return (Criteria) this;
        }

        public Criteria andCreattiemEqualTo(Date value) {
            addCriterion("creatTiem =", value, "creattiem");
            return (Criteria) this;
        }

        public Criteria andCreattiemNotEqualTo(Date value) {
            addCriterion("creatTiem <>", value, "creattiem");
            return (Criteria) this;
        }

        public Criteria andCreattiemGreaterThan(Date value) {
            addCriterion("creatTiem >", value, "creattiem");
            return (Criteria) this;
        }

        public Criteria andCreattiemGreaterThanOrEqualTo(Date value) {
            addCriterion("creatTiem >=", value, "creattiem");
            return (Criteria) this;
        }

        public Criteria andCreattiemLessThan(Date value) {
            addCriterion("creatTiem <", value, "creattiem");
            return (Criteria) this;
        }

        public Criteria andCreattiemLessThanOrEqualTo(Date value) {
            addCriterion("creatTiem <=", value, "creattiem");
            return (Criteria) this;
        }

        public Criteria andCreattiemIn(List<Date> values) {
            addCriterion("creatTiem in", values, "creattiem");
            return (Criteria) this;
        }

        public Criteria andCreattiemNotIn(List<Date> values) {
            addCriterion("creatTiem not in", values, "creattiem");
            return (Criteria) this;
        }

        public Criteria andCreattiemBetween(Date value1, Date value2) {
            addCriterion("creatTiem between", value1, value2, "creattiem");
            return (Criteria) this;
        }

        public Criteria andCreattiemNotBetween(Date value1, Date value2) {
            addCriterion("creatTiem not between", value1, value2, "creattiem");
            return (Criteria) this;
        }

        public Criteria andDelivertimeIsNull() {
            addCriterion("deliverTime is null");
            return (Criteria) this;
        }

        public Criteria andDelivertimeIsNotNull() {
            addCriterion("deliverTime is not null");
            return (Criteria) this;
        }

        public Criteria andDelivertimeEqualTo(Date value) {
            addCriterion("deliverTime =", value, "delivertime");
            return (Criteria) this;
        }

        public Criteria andDelivertimeNotEqualTo(Date value) {
            addCriterion("deliverTime <>", value, "delivertime");
            return (Criteria) this;
        }

        public Criteria andDelivertimeGreaterThan(Date value) {
            addCriterion("deliverTime >", value, "delivertime");
            return (Criteria) this;
        }

        public Criteria andDelivertimeGreaterThanOrEqualTo(Date value) {
            addCriterion("deliverTime >=", value, "delivertime");
            return (Criteria) this;
        }

        public Criteria andDelivertimeLessThan(Date value) {
            addCriterion("deliverTime <", value, "delivertime");
            return (Criteria) this;
        }

        public Criteria andDelivertimeLessThanOrEqualTo(Date value) {
            addCriterion("deliverTime <=", value, "delivertime");
            return (Criteria) this;
        }

        public Criteria andDelivertimeIn(List<Date> values) {
            addCriterion("deliverTime in", values, "delivertime");
            return (Criteria) this;
        }

        public Criteria andDelivertimeNotIn(List<Date> values) {
            addCriterion("deliverTime not in", values, "delivertime");
            return (Criteria) this;
        }

        public Criteria andDelivertimeBetween(Date value1, Date value2) {
            addCriterion("deliverTime between", value1, value2, "delivertime");
            return (Criteria) this;
        }

        public Criteria andDelivertimeNotBetween(Date value1, Date value2) {
            addCriterion("deliverTime not between", value1, value2, "delivertime");
            return (Criteria) this;
        }

        public Criteria andFinishtimeIsNull() {
            addCriterion("finishTime is null");
            return (Criteria) this;
        }

        public Criteria andFinishtimeIsNotNull() {
            addCriterion("finishTime is not null");
            return (Criteria) this;
        }

        public Criteria andFinishtimeEqualTo(Date value) {
            addCriterion("finishTime =", value, "finishtime");
            return (Criteria) this;
        }

        public Criteria andFinishtimeNotEqualTo(Date value) {
            addCriterion("finishTime <>", value, "finishtime");
            return (Criteria) this;
        }

        public Criteria andFinishtimeGreaterThan(Date value) {
            addCriterion("finishTime >", value, "finishtime");
            return (Criteria) this;
        }

        public Criteria andFinishtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("finishTime >=", value, "finishtime");
            return (Criteria) this;
        }

        public Criteria andFinishtimeLessThan(Date value) {
            addCriterion("finishTime <", value, "finishtime");
            return (Criteria) this;
        }

        public Criteria andFinishtimeLessThanOrEqualTo(Date value) {
            addCriterion("finishTime <=", value, "finishtime");
            return (Criteria) this;
        }

        public Criteria andFinishtimeIn(List<Date> values) {
            addCriterion("finishTime in", values, "finishtime");
            return (Criteria) this;
        }

        public Criteria andFinishtimeNotIn(List<Date> values) {
            addCriterion("finishTime not in", values, "finishtime");
            return (Criteria) this;
        }

        public Criteria andFinishtimeBetween(Date value1, Date value2) {
            addCriterion("finishTime between", value1, value2, "finishtime");
            return (Criteria) this;
        }

        public Criteria andFinishtimeNotBetween(Date value1, Date value2) {
            addCriterion("finishTime not between", value1, value2, "finishtime");
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
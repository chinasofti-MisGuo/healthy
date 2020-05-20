package com.mongolia.model.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AudioExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AudioExample() {
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

        public Criteria andDirIdIsNull() {
            addCriterion("dir_id is null");
            return (Criteria) this;
        }

        public Criteria andDirIdIsNotNull() {
            addCriterion("dir_id is not null");
            return (Criteria) this;
        }

        public Criteria andDirIdEqualTo(Long value) {
            addCriterion("dir_id =", value, "dirId");
            return (Criteria) this;
        }

        public Criteria andDirIdNotEqualTo(Long value) {
            addCriterion("dir_id <>", value, "dirId");
            return (Criteria) this;
        }

        public Criteria andDirIdGreaterThan(Long value) {
            addCriterion("dir_id >", value, "dirId");
            return (Criteria) this;
        }

        public Criteria andDirIdGreaterThanOrEqualTo(Long value) {
            addCriterion("dir_id >=", value, "dirId");
            return (Criteria) this;
        }

        public Criteria andDirIdLessThan(Long value) {
            addCriterion("dir_id <", value, "dirId");
            return (Criteria) this;
        }

        public Criteria andDirIdLessThanOrEqualTo(Long value) {
            addCriterion("dir_id <=", value, "dirId");
            return (Criteria) this;
        }

        public Criteria andDirIdIn(List<Long> values) {
            addCriterion("dir_id in", values, "dirId");
            return (Criteria) this;
        }

        public Criteria andDirIdNotIn(List<Long> values) {
            addCriterion("dir_id not in", values, "dirId");
            return (Criteria) this;
        }

        public Criteria andDirIdBetween(Long value1, Long value2) {
            addCriterion("dir_id between", value1, value2, "dirId");
            return (Criteria) this;
        }

        public Criteria andDirIdNotBetween(Long value1, Long value2) {
            addCriterion("dir_id not between", value1, value2, "dirId");
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

        public Criteria andIntroduceIsNull() {
            addCriterion("introduce is null");
            return (Criteria) this;
        }

        public Criteria andIntroduceIsNotNull() {
            addCriterion("introduce is not null");
            return (Criteria) this;
        }

        public Criteria andIntroduceEqualTo(String value) {
            addCriterion("introduce =", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotEqualTo(String value) {
            addCriterion("introduce <>", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceGreaterThan(String value) {
            addCriterion("introduce >", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceGreaterThanOrEqualTo(String value) {
            addCriterion("introduce >=", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceLessThan(String value) {
            addCriterion("introduce <", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceLessThanOrEqualTo(String value) {
            addCriterion("introduce <=", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceLike(String value) {
            addCriterion("introduce like", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotLike(String value) {
            addCriterion("introduce not like", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceIn(List<String> values) {
            addCriterion("introduce in", values, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotIn(List<String> values) {
            addCriterion("introduce not in", values, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceBetween(String value1, String value2) {
            addCriterion("introduce between", value1, value2, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotBetween(String value1, String value2) {
            addCriterion("introduce not between", value1, value2, "introduce");
            return (Criteria) this;
        }

        public Criteria andImageIsNull() {
            addCriterion("image is null");
            return (Criteria) this;
        }

        public Criteria andImageIsNotNull() {
            addCriterion("image is not null");
            return (Criteria) this;
        }

        public Criteria andImageEqualTo(String value) {
            addCriterion("image =", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotEqualTo(String value) {
            addCriterion("image <>", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThan(String value) {
            addCriterion("image >", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThanOrEqualTo(String value) {
            addCriterion("image >=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThan(String value) {
            addCriterion("image <", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThanOrEqualTo(String value) {
            addCriterion("image <=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLike(String value) {
            addCriterion("image like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotLike(String value) {
            addCriterion("image not like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageIn(List<String> values) {
            addCriterion("image in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotIn(List<String> values) {
            addCriterion("image not in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageBetween(String value1, String value2) {
            addCriterion("image between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotBetween(String value1, String value2) {
            addCriterion("image not between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andAudioPathIsNull() {
            addCriterion("audio_path is null");
            return (Criteria) this;
        }

        public Criteria andAudioPathIsNotNull() {
            addCriterion("audio_path is not null");
            return (Criteria) this;
        }

        public Criteria andAudioPathEqualTo(String value) {
            addCriterion("audio_path =", value, "audioPath");
            return (Criteria) this;
        }

        public Criteria andAudioPathNotEqualTo(String value) {
            addCriterion("audio_path <>", value, "audioPath");
            return (Criteria) this;
        }

        public Criteria andAudioPathGreaterThan(String value) {
            addCriterion("audio_path >", value, "audioPath");
            return (Criteria) this;
        }

        public Criteria andAudioPathGreaterThanOrEqualTo(String value) {
            addCriterion("audio_path >=", value, "audioPath");
            return (Criteria) this;
        }

        public Criteria andAudioPathLessThan(String value) {
            addCriterion("audio_path <", value, "audioPath");
            return (Criteria) this;
        }

        public Criteria andAudioPathLessThanOrEqualTo(String value) {
            addCriterion("audio_path <=", value, "audioPath");
            return (Criteria) this;
        }

        public Criteria andAudioPathLike(String value) {
            addCriterion("audio_path like", value, "audioPath");
            return (Criteria) this;
        }

        public Criteria andAudioPathNotLike(String value) {
            addCriterion("audio_path not like", value, "audioPath");
            return (Criteria) this;
        }

        public Criteria andAudioPathIn(List<String> values) {
            addCriterion("audio_path in", values, "audioPath");
            return (Criteria) this;
        }

        public Criteria andAudioPathNotIn(List<String> values) {
            addCriterion("audio_path not in", values, "audioPath");
            return (Criteria) this;
        }

        public Criteria andAudioPathBetween(String value1, String value2) {
            addCriterion("audio_path between", value1, value2, "audioPath");
            return (Criteria) this;
        }

        public Criteria andAudioPathNotBetween(String value1, String value2) {
            addCriterion("audio_path not between", value1, value2, "audioPath");
            return (Criteria) this;
        }

        public Criteria andAudioTimeIsNull() {
            addCriterion("audio_time is null");
            return (Criteria) this;
        }

        public Criteria andAudioTimeIsNotNull() {
            addCriterion("audio_time is not null");
            return (Criteria) this;
        }

        public Criteria andAudioTimeEqualTo(String value) {
            addCriterion("audio_time =", value, "audioTime");
            return (Criteria) this;
        }

        public Criteria andAudioTimeNotEqualTo(String value) {
            addCriterion("audio_time <>", value, "audioTime");
            return (Criteria) this;
        }

        public Criteria andAudioTimeGreaterThan(String value) {
            addCriterion("audio_time >", value, "audioTime");
            return (Criteria) this;
        }

        public Criteria andAudioTimeGreaterThanOrEqualTo(String value) {
            addCriterion("audio_time >=", value, "audioTime");
            return (Criteria) this;
        }

        public Criteria andAudioTimeLessThan(String value) {
            addCriterion("audio_time <", value, "audioTime");
            return (Criteria) this;
        }

        public Criteria andAudioTimeLessThanOrEqualTo(String value) {
            addCriterion("audio_time <=", value, "audioTime");
            return (Criteria) this;
        }

        public Criteria andAudioTimeLike(String value) {
            addCriterion("audio_time like", value, "audioTime");
            return (Criteria) this;
        }

        public Criteria andAudioTimeNotLike(String value) {
            addCriterion("audio_time not like", value, "audioTime");
            return (Criteria) this;
        }

        public Criteria andAudioTimeIn(List<String> values) {
            addCriterion("audio_time in", values, "audioTime");
            return (Criteria) this;
        }

        public Criteria andAudioTimeNotIn(List<String> values) {
            addCriterion("audio_time not in", values, "audioTime");
            return (Criteria) this;
        }

        public Criteria andAudioTimeBetween(String value1, String value2) {
            addCriterion("audio_time between", value1, value2, "audioTime");
            return (Criteria) this;
        }

        public Criteria andAudioTimeNotBetween(String value1, String value2) {
            addCriterion("audio_time not between", value1, value2, "audioTime");
            return (Criteria) this;
        }

        public Criteria andLrcPathIsNull() {
            addCriterion("lrc_path is null");
            return (Criteria) this;
        }

        public Criteria andLrcPathIsNotNull() {
            addCriterion("lrc_path is not null");
            return (Criteria) this;
        }

        public Criteria andLrcPathEqualTo(String value) {
            addCriterion("lrc_path =", value, "lrcPath");
            return (Criteria) this;
        }

        public Criteria andLrcPathNotEqualTo(String value) {
            addCriterion("lrc_path <>", value, "lrcPath");
            return (Criteria) this;
        }

        public Criteria andLrcPathGreaterThan(String value) {
            addCriterion("lrc_path >", value, "lrcPath");
            return (Criteria) this;
        }

        public Criteria andLrcPathGreaterThanOrEqualTo(String value) {
            addCriterion("lrc_path >=", value, "lrcPath");
            return (Criteria) this;
        }

        public Criteria andLrcPathLessThan(String value) {
            addCriterion("lrc_path <", value, "lrcPath");
            return (Criteria) this;
        }

        public Criteria andLrcPathLessThanOrEqualTo(String value) {
            addCriterion("lrc_path <=", value, "lrcPath");
            return (Criteria) this;
        }

        public Criteria andLrcPathLike(String value) {
            addCriterion("lrc_path like", value, "lrcPath");
            return (Criteria) this;
        }

        public Criteria andLrcPathNotLike(String value) {
            addCriterion("lrc_path not like", value, "lrcPath");
            return (Criteria) this;
        }

        public Criteria andLrcPathIn(List<String> values) {
            addCriterion("lrc_path in", values, "lrcPath");
            return (Criteria) this;
        }

        public Criteria andLrcPathNotIn(List<String> values) {
            addCriterion("lrc_path not in", values, "lrcPath");
            return (Criteria) this;
        }

        public Criteria andLrcPathBetween(String value1, String value2) {
            addCriterion("lrc_path between", value1, value2, "lrcPath");
            return (Criteria) this;
        }

        public Criteria andLrcPathNotBetween(String value1, String value2) {
            addCriterion("lrc_path not between", value1, value2, "lrcPath");
            return (Criteria) this;
        }

        public Criteria andIfPayIsNull() {
            addCriterion("if_pay is null");
            return (Criteria) this;
        }

        public Criteria andIfPayIsNotNull() {
            addCriterion("if_pay is not null");
            return (Criteria) this;
        }

        public Criteria andIfPayEqualTo(Short value) {
            addCriterion("if_pay =", value, "ifPay");
            return (Criteria) this;
        }

        public Criteria andIfPayNotEqualTo(Short value) {
            addCriterion("if_pay <>", value, "ifPay");
            return (Criteria) this;
        }

        public Criteria andIfPayGreaterThan(Short value) {
            addCriterion("if_pay >", value, "ifPay");
            return (Criteria) this;
        }

        public Criteria andIfPayGreaterThanOrEqualTo(Short value) {
            addCriterion("if_pay >=", value, "ifPay");
            return (Criteria) this;
        }

        public Criteria andIfPayLessThan(Short value) {
            addCriterion("if_pay <", value, "ifPay");
            return (Criteria) this;
        }

        public Criteria andIfPayLessThanOrEqualTo(Short value) {
            addCriterion("if_pay <=", value, "ifPay");
            return (Criteria) this;
        }

        public Criteria andIfPayIn(List<Short> values) {
            addCriterion("if_pay in", values, "ifPay");
            return (Criteria) this;
        }

        public Criteria andIfPayNotIn(List<Short> values) {
            addCriterion("if_pay not in", values, "ifPay");
            return (Criteria) this;
        }

        public Criteria andIfPayBetween(Short value1, Short value2) {
            addCriterion("if_pay between", value1, value2, "ifPay");
            return (Criteria) this;
        }

        public Criteria andIfPayNotBetween(Short value1, Short value2) {
            addCriterion("if_pay not between", value1, value2, "ifPay");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNull() {
            addCriterion("is_del is null");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNotNull() {
            addCriterion("is_del is not null");
            return (Criteria) this;
        }

        public Criteria andIsDelEqualTo(Short value) {
            addCriterion("is_del =", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotEqualTo(Short value) {
            addCriterion("is_del <>", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThan(Short value) {
            addCriterion("is_del >", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThanOrEqualTo(Short value) {
            addCriterion("is_del >=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThan(Short value) {
            addCriterion("is_del <", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThanOrEqualTo(Short value) {
            addCriterion("is_del <=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelIn(List<Short> values) {
            addCriterion("is_del in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotIn(List<Short> values) {
            addCriterion("is_del not in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelBetween(Short value1, Short value2) {
            addCriterion("is_del between", value1, value2, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotBetween(Short value1, Short value2) {
            addCriterion("is_del not between", value1, value2, "isDel");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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
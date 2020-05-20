package com.mongolia.model.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DynamicExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DynamicExample() {
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

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Long value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Long value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Long value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Long value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Long value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Long value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Long> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Long> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Long value1, Long value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Long value1, Long value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andTagIdIsNull() {
            addCriterion("tag_id is null");
            return (Criteria) this;
        }

        public Criteria andTagIdIsNotNull() {
            addCriterion("tag_id is not null");
            return (Criteria) this;
        }

        public Criteria andTagIdEqualTo(Long value) {
            addCriterion("tag_id =", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdNotEqualTo(Long value) {
            addCriterion("tag_id <>", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdGreaterThan(Long value) {
            addCriterion("tag_id >", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdGreaterThanOrEqualTo(Long value) {
            addCriterion("tag_id >=", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdLessThan(Long value) {
            addCriterion("tag_id <", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdLessThanOrEqualTo(Long value) {
            addCriterion("tag_id <=", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdIn(List<Long> values) {
            addCriterion("tag_id in", values, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdNotIn(List<Long> values) {
            addCriterion("tag_id not in", values, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdBetween(Long value1, Long value2) {
            addCriterion("tag_id between", value1, value2, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdNotBetween(Long value1, Long value2) {
            addCriterion("tag_id not between", value1, value2, "tagId");
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

        public Criteria andArtistIsNull() {
            addCriterion("artist is null");
            return (Criteria) this;
        }

        public Criteria andArtistIsNotNull() {
            addCriterion("artist is not null");
            return (Criteria) this;
        }

        public Criteria andArtistEqualTo(String value) {
            addCriterion("artist =", value, "artist");
            return (Criteria) this;
        }

        public Criteria andArtistNotEqualTo(String value) {
            addCriterion("artist <>", value, "artist");
            return (Criteria) this;
        }

        public Criteria andArtistGreaterThan(String value) {
            addCriterion("artist >", value, "artist");
            return (Criteria) this;
        }

        public Criteria andArtistGreaterThanOrEqualTo(String value) {
            addCriterion("artist >=", value, "artist");
            return (Criteria) this;
        }

        public Criteria andArtistLessThan(String value) {
            addCriterion("artist <", value, "artist");
            return (Criteria) this;
        }

        public Criteria andArtistLessThanOrEqualTo(String value) {
            addCriterion("artist <=", value, "artist");
            return (Criteria) this;
        }

        public Criteria andArtistLike(String value) {
            addCriterion("artist like", value, "artist");
            return (Criteria) this;
        }

        public Criteria andArtistNotLike(String value) {
            addCriterion("artist not like", value, "artist");
            return (Criteria) this;
        }

        public Criteria andArtistIn(List<String> values) {
            addCriterion("artist in", values, "artist");
            return (Criteria) this;
        }

        public Criteria andArtistNotIn(List<String> values) {
            addCriterion("artist not in", values, "artist");
            return (Criteria) this;
        }

        public Criteria andArtistBetween(String value1, String value2) {
            addCriterion("artist between", value1, value2, "artist");
            return (Criteria) this;
        }

        public Criteria andArtistNotBetween(String value1, String value2) {
            addCriterion("artist not between", value1, value2, "artist");
            return (Criteria) this;
        }

        public Criteria andIsHeatIsNull() {
            addCriterion("is_heat is null");
            return (Criteria) this;
        }

        public Criteria andIsHeatIsNotNull() {
            addCriterion("is_heat is not null");
            return (Criteria) this;
        }

        public Criteria andIsHeatEqualTo(Short value) {
            addCriterion("is_heat =", value, "isHeat");
            return (Criteria) this;
        }

        public Criteria andIsHeatNotEqualTo(Short value) {
            addCriterion("is_heat <>", value, "isHeat");
            return (Criteria) this;
        }

        public Criteria andIsHeatGreaterThan(Short value) {
            addCriterion("is_heat >", value, "isHeat");
            return (Criteria) this;
        }

        public Criteria andIsHeatGreaterThanOrEqualTo(Short value) {
            addCriterion("is_heat >=", value, "isHeat");
            return (Criteria) this;
        }

        public Criteria andIsHeatLessThan(Short value) {
            addCriterion("is_heat <", value, "isHeat");
            return (Criteria) this;
        }

        public Criteria andIsHeatLessThanOrEqualTo(Short value) {
            addCriterion("is_heat <=", value, "isHeat");
            return (Criteria) this;
        }

        public Criteria andIsHeatIn(List<Short> values) {
            addCriterion("is_heat in", values, "isHeat");
            return (Criteria) this;
        }

        public Criteria andIsHeatNotIn(List<Short> values) {
            addCriterion("is_heat not in", values, "isHeat");
            return (Criteria) this;
        }

        public Criteria andIsHeatBetween(Short value1, Short value2) {
            addCriterion("is_heat between", value1, value2, "isHeat");
            return (Criteria) this;
        }

        public Criteria andIsHeatNotBetween(Short value1, Short value2) {
            addCriterion("is_heat not between", value1, value2, "isHeat");
            return (Criteria) this;
        }

        public Criteria andIsRecIsNull() {
            addCriterion("is_rec is null");
            return (Criteria) this;
        }

        public Criteria andIsRecIsNotNull() {
            addCriterion("is_rec is not null");
            return (Criteria) this;
        }

        public Criteria andIsRecEqualTo(Short value) {
            addCriterion("is_rec =", value, "isRec");
            return (Criteria) this;
        }

        public Criteria andIsRecNotEqualTo(Short value) {
            addCriterion("is_rec <>", value, "isRec");
            return (Criteria) this;
        }

        public Criteria andIsRecGreaterThan(Short value) {
            addCriterion("is_rec >", value, "isRec");
            return (Criteria) this;
        }

        public Criteria andIsRecGreaterThanOrEqualTo(Short value) {
            addCriterion("is_rec >=", value, "isRec");
            return (Criteria) this;
        }

        public Criteria andIsRecLessThan(Short value) {
            addCriterion("is_rec <", value, "isRec");
            return (Criteria) this;
        }

        public Criteria andIsRecLessThanOrEqualTo(Short value) {
            addCriterion("is_rec <=", value, "isRec");
            return (Criteria) this;
        }

        public Criteria andIsRecIn(List<Short> values) {
            addCriterion("is_rec in", values, "isRec");
            return (Criteria) this;
        }

        public Criteria andIsRecNotIn(List<Short> values) {
            addCriterion("is_rec not in", values, "isRec");
            return (Criteria) this;
        }

        public Criteria andIsRecBetween(Short value1, Short value2) {
            addCriterion("is_rec between", value1, value2, "isRec");
            return (Criteria) this;
        }

        public Criteria andIsRecNotBetween(Short value1, Short value2) {
            addCriterion("is_rec not between", value1, value2, "isRec");
            return (Criteria) this;
        }

        public Criteria andPlayNumIsNull() {
            addCriterion("play_num is null");
            return (Criteria) this;
        }

        public Criteria andPlayNumIsNotNull() {
            addCriterion("play_num is not null");
            return (Criteria) this;
        }

        public Criteria andPlayNumEqualTo(Integer value) {
            addCriterion("play_num =", value, "playNum");
            return (Criteria) this;
        }

        public Criteria andPlayNumNotEqualTo(Integer value) {
            addCriterion("play_num <>", value, "playNum");
            return (Criteria) this;
        }

        public Criteria andPlayNumGreaterThan(Integer value) {
            addCriterion("play_num >", value, "playNum");
            return (Criteria) this;
        }

        public Criteria andPlayNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("play_num >=", value, "playNum");
            return (Criteria) this;
        }

        public Criteria andPlayNumLessThan(Integer value) {
            addCriterion("play_num <", value, "playNum");
            return (Criteria) this;
        }

        public Criteria andPlayNumLessThanOrEqualTo(Integer value) {
            addCriterion("play_num <=", value, "playNum");
            return (Criteria) this;
        }

        public Criteria andPlayNumIn(List<Integer> values) {
            addCriterion("play_num in", values, "playNum");
            return (Criteria) this;
        }

        public Criteria andPlayNumNotIn(List<Integer> values) {
            addCriterion("play_num not in", values, "playNum");
            return (Criteria) this;
        }

        public Criteria andPlayNumBetween(Integer value1, Integer value2) {
            addCriterion("play_num between", value1, value2, "playNum");
            return (Criteria) this;
        }

        public Criteria andPlayNumNotBetween(Integer value1, Integer value2) {
            addCriterion("play_num not between", value1, value2, "playNum");
            return (Criteria) this;
        }

        public Criteria andIsPassIsNull() {
            addCriterion("is_pass is null");
            return (Criteria) this;
        }

        public Criteria andIsPassIsNotNull() {
            addCriterion("is_pass is not null");
            return (Criteria) this;
        }

        public Criteria andIsPassEqualTo(Short value) {
            addCriterion("is_pass =", value, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassNotEqualTo(Short value) {
            addCriterion("is_pass <>", value, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassGreaterThan(Short value) {
            addCriterion("is_pass >", value, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassGreaterThanOrEqualTo(Short value) {
            addCriterion("is_pass >=", value, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassLessThan(Short value) {
            addCriterion("is_pass <", value, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassLessThanOrEqualTo(Short value) {
            addCriterion("is_pass <=", value, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassIn(List<Short> values) {
            addCriterion("is_pass in", values, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassNotIn(List<Short> values) {
            addCriterion("is_pass not in", values, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassBetween(Short value1, Short value2) {
            addCriterion("is_pass between", value1, value2, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassNotBetween(Short value1, Short value2) {
            addCriterion("is_pass not between", value1, value2, "isPass");
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

        public Criteria andIsRelIsNull() {
            addCriterion("is_rel is null");
            return (Criteria) this;
        }

        public Criteria andIsRelIsNotNull() {
            addCriterion("is_rel is not null");
            return (Criteria) this;
        }

        public Criteria andIsRelEqualTo(Short value) {
            addCriterion("is_rel =", value, "isRel");
            return (Criteria) this;
        }

        public Criteria andIsRelNotEqualTo(Short value) {
            addCriterion("is_rel <>", value, "isRel");
            return (Criteria) this;
        }

        public Criteria andIsRelGreaterThan(Short value) {
            addCriterion("is_rel >", value, "isRel");
            return (Criteria) this;
        }

        public Criteria andIsRelGreaterThanOrEqualTo(Short value) {
            addCriterion("is_rel >=", value, "isRel");
            return (Criteria) this;
        }

        public Criteria andIsRelLessThan(Short value) {
            addCriterion("is_rel <", value, "isRel");
            return (Criteria) this;
        }

        public Criteria andIsRelLessThanOrEqualTo(Short value) {
            addCriterion("is_rel <=", value, "isRel");
            return (Criteria) this;
        }

        public Criteria andIsRelIn(List<Short> values) {
            addCriterion("is_rel in", values, "isRel");
            return (Criteria) this;
        }

        public Criteria andIsRelNotIn(List<Short> values) {
            addCriterion("is_rel not in", values, "isRel");
            return (Criteria) this;
        }

        public Criteria andIsRelBetween(Short value1, Short value2) {
            addCriterion("is_rel between", value1, value2, "isRel");
            return (Criteria) this;
        }

        public Criteria andIsRelNotBetween(Short value1, Short value2) {
            addCriterion("is_rel not between", value1, value2, "isRel");
            return (Criteria) this;
        }

        public Criteria andExContentIsNull() {
            addCriterion("ex_content is null");
            return (Criteria) this;
        }

        public Criteria andExContentIsNotNull() {
            addCriterion("ex_content is not null");
            return (Criteria) this;
        }

        public Criteria andExContentEqualTo(String value) {
            addCriterion("ex_content =", value, "exContent");
            return (Criteria) this;
        }

        public Criteria andExContentNotEqualTo(String value) {
            addCriterion("ex_content <>", value, "exContent");
            return (Criteria) this;
        }

        public Criteria andExContentGreaterThan(String value) {
            addCriterion("ex_content >", value, "exContent");
            return (Criteria) this;
        }

        public Criteria andExContentGreaterThanOrEqualTo(String value) {
            addCriterion("ex_content >=", value, "exContent");
            return (Criteria) this;
        }

        public Criteria andExContentLessThan(String value) {
            addCriterion("ex_content <", value, "exContent");
            return (Criteria) this;
        }

        public Criteria andExContentLessThanOrEqualTo(String value) {
            addCriterion("ex_content <=", value, "exContent");
            return (Criteria) this;
        }

        public Criteria andExContentLike(String value) {
            addCriterion("ex_content like", value, "exContent");
            return (Criteria) this;
        }

        public Criteria andExContentNotLike(String value) {
            addCriterion("ex_content not like", value, "exContent");
            return (Criteria) this;
        }

        public Criteria andExContentIn(List<String> values) {
            addCriterion("ex_content in", values, "exContent");
            return (Criteria) this;
        }

        public Criteria andExContentNotIn(List<String> values) {
            addCriterion("ex_content not in", values, "exContent");
            return (Criteria) this;
        }

        public Criteria andExContentBetween(String value1, String value2) {
            addCriterion("ex_content between", value1, value2, "exContent");
            return (Criteria) this;
        }

        public Criteria andExContentNotBetween(String value1, String value2) {
            addCriterion("ex_content not between", value1, value2, "exContent");
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
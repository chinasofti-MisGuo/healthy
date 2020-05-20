package com.mongolia.service.impl;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.mongolia.dao.AudioClassMapper;
import com.mongolia.dao.AudioDirMapper;
import com.mongolia.dao.RadioClassMapper;
import com.mongolia.exception.InformationErrorException;
import com.mongolia.model.dto.BaseDataDTO;
import com.mongolia.model.dto.PageDTO;
import com.mongolia.model.entity.AudioClass;
import com.mongolia.model.entity.RadioClass;
import com.mongolia.model.enums.FlagType;
import com.mongolia.model.enums.StateType;
import com.mongolia.model.example.AudioClassExample;
import com.mongolia.model.example.AudioDirExample;
import com.mongolia.model.example.RadioClassExample;
import com.mongolia.service.ClassService;
import org.apache.commons.lang.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 分类相关Service实现
 *
 * @author Dong.w
 */
@Service
public class ClassServiceImpl implements ClassService {

    private final Logger logger = LoggerFactory.getLogger(ClassServiceImpl.class);

    @Autowired
    private AudioClassMapper audioClassMapper;

    @Autowired
    private RadioClassMapper radioClassMapper;

    @Autowired
    private AudioDirMapper audioDirMapper;

    @Override
    public List<AudioClass> getIndexClass() {
        AudioClassExample audioClassExample = new AudioClassExample();
        audioClassExample.setOrderByClause("create_time");
        AudioClassExample.Criteria criteria = audioClassExample.createCriteria();
        criteria.andIsDelEqualTo(Short.valueOf("0"));
        return audioClassMapper.selectByExample(audioClassExample);
    }

    @Override
    public PageInfo<AudioClass> audioClassList(PageDTO pageDTO) {
        AudioClassExample audioClassExample = new AudioClassExample();
        audioClassExample.setOrderByClause("id DESC");
        AudioClassExample.Criteria criteria = audioClassExample.createCriteria();
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        List<AudioClass> audioClassList = audioClassMapper.selectByExample(audioClassExample);
        if (Objects.isNull(audioClassList)) {
            audioClassList = Lists.newArrayList();
        }
        return new PageInfo<>(audioClassList);
    }

    @Override
    public PageInfo<RadioClass> radioClassList(PageDTO pageDTO) {
        RadioClassExample radioClassExample = new RadioClassExample();
        radioClassExample.setOrderByClause("id DESC");
        RadioClassExample.Criteria criteria = radioClassExample.createCriteria();
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        List<RadioClass> radioClasses = radioClassMapper.selectByExample(radioClassExample);
        if (Objects.isNull(radioClasses)) {
            radioClasses = Lists.newArrayList();
        }
        return new PageInfo<>(radioClasses);
    }

    @Override
    public boolean addAudioClass(AudioClass audioClass) {
        audioClass.setCreateTime(new Date());
        logger.debug(audioClass.toString());
        int result = audioClassMapper.insertSelective(audioClass);
        return (result == 1);
    }

    @Override
    public boolean editAudioClass(AudioClass audioClass) {
        audioClass.setUpdateTime(new Date());
        int result = audioClassMapper.updateByPrimaryKeySelective(audioClass);
        return (result == 1);
    }

    @Override
    public boolean deleteAudioClass(BaseDataDTO dataDTO) {
        AudioDirExample audioDirExample = new AudioDirExample();
        AudioDirExample.Criteria criteria = audioDirExample.createCriteria();
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        criteria.andFlagEqualTo(FlagType.AUDIO.getValue());
        criteria.andClassIdEqualTo(dataDTO.getId());
        int num = audioDirMapper.countByExample(audioDirExample);
        if (num > 0) {
            throw new InformationErrorException("此分类下包含音频,不可删除");
        }
        AudioClass audioClass = new AudioClass();
        audioClass.setId(dataDTO.getId());
        audioClass.setIsDel(StateType.YES.getValue());
        audioClass.setUpdateTime(new Date());
        int result = audioClassMapper.updateByPrimaryKeySelective(audioClass);
        return (result == 1);
    }

    @Override
    public boolean addRadioClass(RadioClass radioClass) {
        radioClass.setCreateTime(new Date());
        int result = radioClassMapper.insertSelective(radioClass);
        return (result == 1);
    }

    @Override
    public boolean editRadioClass(RadioClass radioClass) {
        radioClass.setUpdateTime(new Date());
        int result = radioClassMapper.updateByPrimaryKeySelective(radioClass);
        return (result == 1);
    }

    @Override
    public boolean deleteRadioClass(BaseDataDTO dataDTO) {
        RadioClassExample radioClassExample = new RadioClassExample();
        RadioClassExample.Criteria radioCriteria = radioClassExample.createCriteria();
        radioCriteria.andIsDelEqualTo(StateType.NO.getValue());
        radioCriteria.andBaseIdEqualTo(dataDTO.getId());
        int num = radioClassMapper.countByExample(radioClassExample);
        if (num > 0) {
            throw new InformationErrorException("此分类下包含子分类,不可删除");
        }
        AudioDirExample audioDirExample = new AudioDirExample();
        AudioDirExample.Criteria criteria = audioDirExample.createCriteria();
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        criteria.andFlagEqualTo(FlagType.RADIO.getValue());
        criteria.andClassIdEqualTo(dataDTO.getId());
        num = audioDirMapper.countByExample(audioDirExample);
        if (num > 0) {
            throw new InformationErrorException("此分类下包含音频,不可删除");
        }
        RadioClass radioClass = new RadioClass();
        radioClass.setId(dataDTO.getId());
        radioClass.setIsDel(StateType.YES.getValue());
        radioClass.setUpdateTime(new Date());
        int result = radioClassMapper.updateByPrimaryKeySelective(radioClass);
        return (result == 1);
    }

    @Override
    public List<Integer> audioClassSort(Integer id) {
        AudioClassExample audioClassExample = new AudioClassExample();
        AudioClassExample.Criteria criteria = audioClassExample.createCriteria();
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        List<AudioClass> audioClassList = audioClassMapper.selectByExample(audioClassExample);
        List<Integer> list = Lists.newArrayList();
        for (AudioClass audioClass : audioClassList) {
            if (NumberUtils.compare(id, audioClass.getId()) != 0) {
                list.add(audioClass.getSort());
            }
        }
        return list;
    }

    @Override
    public List<Integer> radioClassSort(BaseDataDTO dataDTO, Integer id) {
        RadioClassExample radioClassExample = new RadioClassExample();
        RadioClassExample.Criteria criteria = radioClassExample.createCriteria();
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        criteria.andLevelEqualTo(id.shortValue());
        List<RadioClass> radioClasses = radioClassMapper.selectByExample(radioClassExample);
        List<Integer> list = Lists.newArrayList();
        for (RadioClass radioClass : radioClasses) {
            if (NumberUtils.compare(dataDTO.getId(), radioClass.getId()) != 0) {
                list.add(radioClass.getSort());
            }
        }
        return list;
    }

    @Override
    public List<AudioClass> audioClass() {
        AudioClassExample audioClassExample = new AudioClassExample();
        audioClassExample.setOrderByClause("id DESC");
        audioClassExample.createCriteria().andIsDelEqualTo(StateType.NO.getValue());
        List<AudioClass> audioClassList = audioClassMapper.selectByExample(audioClassExample);
        if (Objects.isNull(audioClassList)) {
            audioClassList = Lists.newArrayList();
        }
        return audioClassList;
    }

    @Override
    public List<RadioClass> radioClass(Integer id) {
        RadioClassExample radioClassExample = new RadioClassExample();
        radioClassExample.setOrderByClause("id DESC");
        RadioClassExample.Criteria criteria = radioClassExample.createCriteria();
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        criteria.andBaseIdEqualTo(id);
        List<RadioClass> radioClasses = radioClassMapper.selectByExample(radioClassExample);
        if(Objects.isNull(radioClasses)){
            radioClasses = Lists.newArrayList();
        }
        return radioClasses;
    }
}

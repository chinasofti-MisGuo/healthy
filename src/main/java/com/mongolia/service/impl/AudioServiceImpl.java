package com.mongolia.service.impl;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.mongolia.dao.AudioDirMapper;
import com.mongolia.dao.AudioDirTagMapper;
import com.mongolia.dao.AudioMapper;
import com.mongolia.exception.InformationErrorException;
import com.mongolia.model.dto.BaseDataDTO;
import com.mongolia.model.dto.PageDTO;
import com.mongolia.model.dto.SearchDTO;
import com.mongolia.model.entity.*;
import com.mongolia.model.enums.FlagType;
import com.mongolia.model.enums.StateType;
import com.mongolia.model.example.AudioDirExample;
import com.mongolia.model.example.AudioExample;
import com.mongolia.service.AudioService;
import com.mongolia.service.CollectionService;
import com.mongolia.service.CommentService;
import com.mongolia.service.FavoriteService;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

/**
 * 音频相关Service实现
 *
 * @author Dong.w
 */
@Service
public class AudioServiceImpl implements AudioService {

    @Autowired
    private AudioMapper audioMapper;

    @Autowired
    private AudioDirTagMapper audioDirTagMapper;

    @Autowired
    private AudioDirMapper audioDirMapper;

    @Autowired
    private FavoriteService favoriteService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private CollectionService collectionService;

    @Override
    public PageInfo<AudioDir> getRecommendList(PageDTO pageDTO) {
        AudioDirExample audioDirExample = new AudioDirExample();
        audioDirExample.setOrderByClause("id DESC");
        AudioDirExample.Criteria criteria = audioDirExample.createCriteria();
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        criteria.andIfRecEqualTo(StateType.YES.getValue());
        criteria.andIfRelEqualTo(StateType.YES.getValue());
        List<AudioDir> audioDirs = audioDirMapper.selectByExample(audioDirExample);
        for (AudioDir audioDir : audioDirs) {
            int num = favoriteService.audioDirLikeNum(audioDir.getId());
            audioDir.setLikeNum(num);
            Comment comment = new Comment();
            comment.setComId(audioDir.getId());
            comment.setFlag(FlagType.AUDIO.getValue());
            num = commentService.getCommentNum(comment);
            audioDir.setCommentNum(num);
        }
        return new PageInfo<>(audioDirs);
    }

    @Override
    public PageInfo<AudioDir> getClassList(PageDTO pageDTO, Integer id) {
        AudioDirExample audioDirExample = new AudioDirExample();
        audioDirExample.setOrderByClause("id DESC");
        AudioDirExample.Criteria criteria = audioDirExample.createCriteria();
        criteria.andClassIdEqualTo(id);
        criteria.andIfRelEqualTo(StateType.YES.getValue());
        List<AudioDir> audioDirs = audioDirMapper.selectByExample(audioDirExample);
        for (AudioDir audioDir : audioDirs) {
            int num = favoriteService.audioDirLikeNum(audioDir.getId());
            audioDir.setLikeNum(num);
            Comment comment = new Comment();
            comment.setComId(audioDir.getId());
            comment.setFlag(FlagType.AUDIO.getValue());
            num = commentService.getCommentNum(comment);
            audioDir.setCommentNum(num);
        }
        return new PageInfo<>(audioDirs);
    }

    @Override
    public PageInfo<Audio> getAudioList(PageDTO pageDTO) {
        AudioExample audioExample = new AudioExample();
        audioExample.setOrderByClause("id DESC");
        AudioExample.Criteria criteria = audioExample.createCriteria();
        criteria.andDirIdEqualTo(pageDTO.getId());
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        List<Audio> audio = audioMapper.selectByExample(audioExample);
        return new PageInfo<>(audio);
    }

    @Override
    public Map<String, Object> getAudioDetail(BaseDataDTO dataDTO) {
        int likeNum = favoriteService.audioLikeNum((long)dataDTO.getId());
        Comment comment = new Comment();
        comment.setFlag(FlagType.AUDIO.getValue());
        comment.setComId((long)dataDTO.getId());
        int commentNum = commentService.getCommentNum(comment);
        Favorite favorite = new Favorite();
        favorite.setFlag(FlagType.AUDIO.getValue());
        favorite.setLikeId((long) dataDTO.getId());
        boolean isLike = favoriteService.isLike(favorite);
        Collect collect = new Collect();
        collect.setUid(dataDTO.getUid());
        collect.setCollId((long)dataDTO.getId());
        collect.setFlag(FlagType.AUDIO.getValue());
        collect.setIsDel(StateType.NO.getValue());
        boolean isCollection = collectionService.isCollection(collect);
        Map<String, Object> result = new HashMap<>(4);
        result.put("likeNum", likeNum);
        result.put("commentNum", commentNum);
        result.put("isLike", isLike? 1 : 0);
        result.put("isCollection", isCollection ? 1 : 0);
        return result;
    }

    @Override
    public PageInfo<Comment> getCommentList(PageDTO pageDTO, Long id) {
        Comment comment = new Comment();
        comment.setComId(id);
        comment.setFlag(FlagType.AUDIO_LIKE.getValue());
        comment.setIsDel(StateType.NO.getValue());
        comment.setBaseId(0L);
        return commentService.getCommentList(pageDTO, comment);
    }

    @Override
    public PageInfo<AudioDir> getSearchList(SearchDTO searchDTO) {
        AudioDirExample audioDirExample = new AudioDirExample();
        audioDirExample.setOrderByClause("id DESC");
        AudioDirExample.Criteria criteria = audioDirExample.createCriteria();
        criteria.andTitleLike("%" + searchDTO.getTitle() + "%");
        criteria.andIfRelEqualTo(StateType.YES.getValue());
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        List<AudioDir> audioDirs = audioDirMapper.selectByExample(audioDirExample);
        for (AudioDir audioDir : audioDirs) {
            int num = favoriteService.audioDirLikeNum(audioDir.getId());
            audioDir.setLikeNum(num);
            Comment comment = new Comment();
            comment.setComId(audioDir.getId());
            comment.setFlag(FlagType.AUDIO.getValue());
            num = commentService.getCommentNum(comment);
            audioDir.setCommentNum(num);
        }
        return new PageInfo<>(audioDirs);
    }

    @Override
    public PageInfo<AudioDir> userCollectList(PageDTO pageDTO, Long uid) {
        List<AudioDir> audioDirs = audioDirMapper.selectJoinCollect(uid);
        if(Objects.isNull(audioDirs)){
            audioDirs = Lists.newArrayList();
        }
        for (AudioDir audioDir : audioDirs) {
            int num = favoriteService.audioDirLikeNum(audioDir.getId());
            audioDir.setLikeNum(num);
            Comment comment = new Comment();
            comment.setComId(audioDir.getId());
            comment.setFlag(FlagType.AUDIO.getValue());
            num = commentService.getCommentNum(comment);
            audioDir.setCommentNum(num);
        }
        return new PageInfo<>(audioDirs);
    }

    @Override
    public PageInfo<AudioDir> audioDirList(PageDTO pageDTO) {
        AudioDirExample audioDirExample = new AudioDirExample();
        audioDirExample.setOrderByClause("id DESC");
        AudioDirExample.Criteria criteria = audioDirExample.createCriteria();
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        criteria.andFlagEqualTo(FlagType.AUDIO.getValue());
        List<AudioDir> audioDirs = audioDirMapper.selectByExample(audioDirExample);
        if (Objects.isNull(audioDirs)) {
            audioDirs = Lists.newArrayList();
        }
        return new PageInfo<>(audioDirs);
    }

    @Override
    public PageInfo<AudioDir> audioDirListBySearch(SearchDTO searchDTO) {
        AudioDirExample audioDirExample = new AudioDirExample();
        audioDirExample.setOrderByClause("id DESC");
        AudioDirExample.Criteria criteria = audioDirExample.createCriteria();
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        criteria.andFlagEqualTo(searchDTO.getAge());
        if (StringUtils.isNotEmpty(searchDTO.getTitle())) {
            criteria.andTitleLike("%" + searchDTO.getTitle() + "%");
        }
        if(Objects.nonNull(searchDTO.getRec())){
            criteria.andClassIdEqualTo(searchDTO.getRec().intValue());
        }
        if(Objects.nonNull(searchDTO.getState())){
            criteria.andIfRelEqualTo(searchDTO.getState());
        }
        if (Objects.nonNull(searchDTO.getFlag())) {
            if(searchDTO.getFlag() == StateType.NO.getValue()) {
                criteria.andPriceEqualTo(new BigDecimal("0.0"));
            }else{
                criteria.andPriceGreaterThan(new BigDecimal("0.0"));
            }
        }
        if(Objects.nonNull(searchDTO.getRec())){
            criteria.andClassIdEqualTo(searchDTO.getRec().intValue());
        }
        List<AudioDir> list = audioDirMapper.selectByExample(audioDirExample);
        if(Objects.isNull(list)){
            list = Lists.newArrayList();
        }
        return new PageInfo<>(list);
    }

    @Override
    public boolean likeAudioDir(BaseDataDTO dataDTO) {
        Favorite favorite = new Favorite();
        favorite.setUid(dataDTO.getUid());
        favorite.setLikeId(dataDTO.getId().longValue());
        favorite.setFlag(FlagType.AUDIO.getValue());
        favorite.setCreateTime(new Date());
        return favoriteService.setLike(favorite);
    }

    @Override
    public boolean likeAudio(BaseDataDTO dataDTO) {
        Favorite favorite = new Favorite();
        favorite.setUid(dataDTO.getUid());
        favorite.setLikeId(dataDTO.getId().longValue());
        favorite.setFlag(FlagType.AUDIO_LIKE.getValue());
        favorite.setCreateTime(new Date());
        return favoriteService.setLike(favorite);
    }

    @Override
    public boolean commentAudioDir(Comment comment) {
        comment.setFlag(FlagType.AUDIO.getValue());
        comment.setCreateTime(new Date());
        return commentService.addComment(comment);
    }

    @Override
    public boolean commentAudio(Comment comment) {
        comment.setFlag(FlagType.AUDIO_LIKE.getValue());
        comment.setCreateTime(new Date());
        return commentService.addComment(comment);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean publishAudioDir(AudioDir audioDir) {
        audioDir.setCreateTime(new Date());
        int result = audioDirMapper.insertSelective(audioDir);
        String[] split = null;
        if (Objects.nonNull(audioDir.getTag())) {
            split = audioDir.getTag().split(",");
        }
        for(String str : split){
            AudioDirTag audioDirTag = new AudioDirTag();
            audioDirTag.setCreateTime(new Date());
            audioDirTag.setDirId(audioDir.getId());
            audioDirTag.setTagId(Integer.parseInt(str));
            int i = audioDirTagMapper.insertSelective(audioDirTag);
            if(i == 0){
                return false;
            }
        }
        return (result == 1);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean editAudioDir(AudioDir audioDir) {
        audioDir.setUpdateTime(new Date());
        audioDirTagMapper.deleteByDirId(audioDir.getId());
        String[] split = null;
        if (Objects.nonNull(audioDir.getTag())) {
            split = audioDir.getTag().split(",");
        }
        for(String str : split){
            AudioDirTag audioDirTag = new AudioDirTag();
            audioDirTag.setCreateTime(new Date());
            audioDirTag.setDirId(audioDir.getId());
            audioDirTag.setTagId(Integer.parseInt(str));
            int i = audioDirTagMapper.insertSelective(audioDirTag);
            if(i == 0){
                return false;
            }
        }
        int result = audioDirMapper.updateByPrimaryKeySelective(audioDir);
        return (result == 1);
    }

    @Override
    public boolean deleteAudioDir(BaseDataDTO dataDTO) {
        AudioDir audioDir = new AudioDir();
        audioDir.setIsDel(StateType.YES.getValue());
        AudioDirExample audioDirExample = new AudioDirExample();
        AudioDirExample.Criteria criteria = audioDirExample.createCriteria();
        criteria.andIdEqualTo(dataDTO.getId().longValue());
        int result = audioDirMapper.updateByExampleSelective(audioDir, audioDirExample);
        Comment comment = new Comment();
        comment.setFlag(FlagType.AUDIO.getValue());
        comment.setComId(dataDTO.getId().longValue());
        boolean a = deleteAudioDir(dataDTO.getId().longValue());
        boolean b = commentService.deleteComment(comment);
        return (result == 1) && b && a;
    }

    @Override
    public boolean publishAudio(Audio audio) {
        audio.setCreateTime(new Date());
        int result = audioMapper.insertSelective(audio);
        return (result == 1);
    }

    @Override
    public boolean editAudio(Audio audio) {
        audio.setUpdateTime(new Date());
        int result = audioMapper.updateByPrimaryKeySelective(audio);
        return (result == 1);
    }

    @Override
    public boolean deleteAudio(BaseDataDTO dataDTO) {
        Audio audio = new Audio();
        audio.setIsDel(StateType.YES.getValue());
        AudioExample audioExample = new AudioExample();
        AudioExample.Criteria criteria = audioExample.createCriteria();
        criteria.andIdEqualTo(dataDTO.getId().longValue());
        int result = audioMapper.updateByExampleSelective(audio, audioExample);
        Comment comment = new Comment();
        comment.setFlag(FlagType.AUDIO_LIKE.getValue());
        comment.setComId(dataDTO.getId().longValue());
        boolean b = commentService.deleteComment(comment);
        return (result == 1) && b;
    }

    @Override
    public boolean likeDirComment(BaseDataDTO dataDTO) {
        Favorite favorite = new Favorite();
        favorite.setLikeId(dataDTO.getId().longValue());
        favorite.setUid(dataDTO.getUid());
        favorite.setFlag(FlagType.AUDIO.getValue());
        favorite.setCreateTime(new Date());
        return favoriteService.setLike(favorite);
    }

    @Override
    public boolean likeComment(BaseDataDTO dataDTO) {
        Favorite favorite = new Favorite();
        favorite.setLikeId(dataDTO.getId().longValue());
        favorite.setUid(dataDTO.getUid());
        favorite.setFlag(FlagType.AUDIO_LIKE.getValue());
        favorite.setCreateTime(new Date());
        return favoriteService.setLike(favorite);
    }

    @Override
    public boolean shelvesAudioDir(BaseDataDTO dataDTO) {
        AudioDir audioDir = audioDirMapper.selectByPrimaryKey(dataDTO.getId().longValue());
        if(Objects.isNull(audioDir)){
            throw new InformationErrorException("数据不存在");
        }
        if(NumberUtils.compare(audioDir.getIfRel(), StateType.NO.getValue()) == 0){
            audioDir.setIfRel(StateType.YES.getValue());
        }
        if(NumberUtils.compare(audioDir.getIfRel(), StateType.YES.getValue()) == 0){
            audioDir.setIfRel(StateType.NO.getValue());
        }
        int result = audioDirMapper.updateByPrimaryKeySelective(audioDir);
        return (result == 1);
    }

    @Override
    public boolean payAudio(BaseDataDTO dataDTO) {
        Audio audio = audioMapper.selectByPrimaryKey(dataDTO.getId().longValue());
        if(Objects.isNull(audio)){
            throw new InformationErrorException("请求资源不存在");
        }

        if(NumberUtils.compare(audio.getIfPay(), StateType.YES.getValue()) == 0){
            audio.setIfPay(StateType.NO.getValue());
        }else if (NumberUtils.compare(audio.getIfPay(), StateType.NO.getValue()) == 0){
            audio.setIfPay(StateType.YES.getValue());
        }
        int result = audioMapper.updateByPrimaryKeySelective(audio);
        return (result == 1);
    }

    @Override
    public PageInfo<AudioDir> radioDirList(PageDTO pageDTO) {
        AudioDirExample audioDirExample = new AudioDirExample();
        audioDirExample.setOrderByClause("id DESC");
        AudioDirExample.Criteria criteria = audioDirExample.createCriteria();
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        criteria.andFlagEqualTo(FlagType.RADIO.getValue());
        List<AudioDir> audioDirs = audioDirMapper.selectByExample(audioDirExample);
        if (Objects.isNull(audioDirs)) {
            audioDirs = Lists.newArrayList();
        }
        return new PageInfo<>(audioDirs);
    }

    @Override
    public boolean collectAudioDir(BaseDataDTO dataDTO) {
        Collect collect = new Collect();
        collect.setUid(dataDTO.getUid());
        collect.setCollId(dataDTO.getId().longValue());
        collect.setFlag(FlagType.AUDIO.getValue());
        collect.setCreateTime(new Date());
        collect.setIsDel(StateType.NO.getValue());
        return collectionService.collect(collect);
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean deleteAudioDir(Long id){
        AudioExample audioExample = new AudioExample();
        AudioExample.Criteria criteria = audioExample.createCriteria();
        criteria.andDirIdEqualTo(id);
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        List<Audio> audios = audioMapper.selectByExample(audioExample);
        for(Audio audio : audios){
            Comment comment = new Comment();
            comment.setFlag(FlagType.AUDIO_LIKE.getValue());
            comment.setComId(audio.getId());
            commentService.deleteComment(comment);
        }
        return true;
    }
}

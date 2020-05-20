package com.mongolia.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.mongolia.dao.IntegralMapper;
import com.mongolia.dao.UserMapper;
import com.mongolia.exception.ExistedException;
import com.mongolia.exception.InformationErrorException;
import com.mongolia.exception.UserNotFoundException;
import com.mongolia.model.dto.BaseDataDTO;
import com.mongolia.model.dto.PageDTO;
import com.mongolia.model.dto.SearchDTO;
import com.mongolia.model.entity.*;
import com.mongolia.model.enums.StateType;
import com.mongolia.model.example.UserExample;
import com.mongolia.service.*;
import com.mongolia.util.EncryptionUtils;
import com.mongolia.util.JWTUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

/**
 * 用户相关Service实现
 *
 * @author Dong.w
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IntegralMapper integralMapper;

    @Autowired
    private DynamicService dynamicService;

    @Autowired
    private FollowService followService;

    @Autowired
    private UserTagService userTagService;

    @Autowired
    private CollectionService collectionService;

    @Autowired
    private CommentService commentService;

    @Override
    public Map<String, Object> personHomePageDetail(BaseDataDTO dataDTO) {
        Map<String, Object> result = new HashMap<>(3);
        Integer fansNumber = followService.fansNumber(dataDTO.getUid());
        Integer attentionNumber = followService.attentionNumber(dataDTO.getUid());
        result.put("fansNum", fansNumber);
        result.put("attNum", attentionNumber);
        return result;
    }

    @Override
    public Map<String, Object> othersHomePageDetail(BaseDataDTO dataDTO) {
        User user = userMapper.selectByUid(dataDTO.getOUid());
        Map<String, Object> result = new HashMap<>(7);
        Integer fansNumber = followService.fansNumber(dataDTO.getUid());
        Integer attentionNumber = followService.attentionNumber(dataDTO.getUid());
        boolean isCollect = followService.isFollow(dataDTO.getUid(), dataDTO.getOUid());
        result.put("fansNum", fansNumber);
        result.put("attNum", attentionNumber);
        result.put("isCollect", isCollect ? 1 : 0);
        result.put("headPortrait", user.getHeadPortrait());
        result.put("nickName", user.getNickname());
        result.put("profile", user.getProfile());
        return result;
    }

    @Override
    public List<Follow> getFans(BaseDataDTO dataDTO) {
        List<Follow> fans = followService.getUserFans(dataDTO.getOUid());
        setState(fans, dataDTO.getUid());
        return fans;
    }

    @Override
    public List<Follow> getCollect(BaseDataDTO dataDTO) {
        List<Follow> collect = followService.getCollect(dataDTO.getOUid());
        setState(collect, dataDTO.getUid());
        return collect;
    }

    @Override
    public Map<String, Object> getCertification(Long uid) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUidEqualTo(uid);
        criteria.andStateEqualTo(StateType.NO.getValue());
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        List<User> users = userMapper.selectByExample(userExample);
        if (Objects.isNull(users) || users.isEmpty()) {
            throw new UserNotFoundException();
        }
        User user = users.get(0);
        Map<String, Object> result = new HashMap<>(6);
        result.put("state", user.getAuditState());
        result.put("name", user.getFullname());
        result.put("cardId", user.getIdNumber());
        String[] img = user.getIdCardImg().split(",");
        result.put("img", img);
        return result;
    }

    @Override
    public List<Integral> getUserIntegral(BaseDataDTO dataDTO) {
        List<Integral> integral = integralMapper.selectByUid(dataDTO.getUid());
        if (Objects.isNull(integral)) {
            integral = Lists.newArrayList();
        }
        return integral;
    }

    @Override
    public PageInfo<User> userList(PageDTO pageDTO) {
        UserExample userExample = new UserExample();
        userExample.setOrderByClause("id DESC");
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        List<User> users = userMapper.selectByExample(userExample);
        return new PageInfo<>(users);
    }

    @Override
    public PageInfo<User> notAuditUserList(PageDTO pageDTO) {
        UserExample userExample = new UserExample();
        userExample.setOrderByClause("id DESC");
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        criteria.andAuditStateEqualTo(StateType.NO.getValue());
        List<User> users = userMapper.selectByExample(userExample);
        if (Objects.isNull(users)) {
            users = Lists.newArrayList();
        }
        return new PageInfo<>(users);
    }

    @Override
    public PageInfo<User> userListBySearch(SearchDTO searchDTO) {
        UserExample userExample = new UserExample();
        userExample.setOrderByClause("id DESC");
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        if(Objects.nonNull(searchDTO.getUid())){
            criteria.andUidEqualTo(searchDTO.getUid());
        }
        if (StringUtils.isNotEmpty(searchDTO.getPhone())) {
            criteria.andPhoneLike("%" + searchDTO.getPhone() + "%");
        }
        if (Objects.nonNull(searchDTO.getSex())) {
            criteria.andSexEqualTo(searchDTO.getSex());
        }
        if (StringUtils.isNotEmpty(searchDTO.getCity())) {
            criteria.andCityLike("%" + searchDTO.getCity() + "%");
        }
        if(Objects.nonNull(searchDTO.getFlag())){
            criteria.andIsVipEqualTo(searchDTO.getFlag());
        }
        if (Objects.nonNull(searchDTO.getAge())) {
            criteria.andAgeEqualTo(searchDTO.getAge());
        }
        if (Objects.nonNull(searchDTO.getState())) {
            criteria.andIsVipEqualTo(searchDTO.getState());
        }
        if (Objects.nonNull(searchDTO.getStart()) && Objects.nonNull(searchDTO.getEnd())) {
            criteria.andLoginTimeBetween(searchDTO.getStart(), searchDTO.getEnd());
        }
        if (Objects.nonNull(searchDTO.getSignStart()) && Objects.nonNull(searchDTO.getSignEnd())) {
            criteria.andCreateTimeBetween(searchDTO.getSignStart(), searchDTO.getSignEnd());
        }
        List<User> users = userMapper.selectByExample(userExample);
        if (Objects.isNull(users)) {
            users = Lists.newArrayList();
        }
        return new PageInfo<>(users);
    }

    @Override
    public PageInfo<User> auditUserListBySearch(SearchDTO searchDTO) {
        UserExample userExample = new UserExample();
        userExample.setOrderByClause("id DESC");
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        criteria.andAuditStateEqualTo(StateType.NO.getValue());
        if(Objects.nonNull(searchDTO.getUid())){
            criteria.andUidEqualTo(searchDTO.getUid());
        }
        if (Objects.nonNull(searchDTO.getPhone())) {
            criteria.andPhoneLike("%" + searchDTO.getPhone() + "%");
        }
        if (Objects.nonNull(searchDTO.getState())) {
            criteria.andAuditStateEqualTo(searchDTO.getState());
        }
        List<User> users = userMapper.selectByExample(userExample);
        if (Objects.isNull(users)) {
            users = Lists.newArrayList();
        }
        return new PageInfo<>(users);
    }

    @Override
    public boolean registered(User user) {
        user.setCreateTime(new Date());
        user.setNickname(user.getPhone().substring(0,3) + user.getPhone().substring(6));
        user.setPassword(EncryptionUtils.md5AndSalt(user.getPassword()));
        user.setToken(null);

        synchronized (UserServiceImpl.class) {
            while (true) {
                long uid = RandomUtil.randomLong(100000, 10000000);
                User userTmp = userMapper.selectByUid(uid);
                if (Objects.isNull(userTmp)) {
                    user.setUid(uid);
                    break;
                }
            }
        }

        int result = 0;
        try {
            result = userMapper.insertSelective(user);
        }catch (Exception e){
            throw new ExistedException("用户此存在");
        }
        return (result == 1);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public User userLogin(User user) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andPhoneEqualTo(user.getPhone());
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        List<User> users = userMapper.selectByExample(userExample);
        if (Objects.isNull(users) || users.isEmpty()) {
            throw new UserNotFoundException("此用户不存在");
        }
        User userByLogin = users.get(0);
        if (!StringUtils.equals(EncryptionUtils.md5AndSalt(user.getPassword())
                , userByLogin.getPassword())) {
            throw new InformationErrorException("密码错误");
        }
        String token = JWTUtils.sign(userByLogin.getPhone(), userByLogin.getUid().toString(), userByLogin.getPassword());
        userByLogin.setToken(token);
        userByLogin.setLoginTime(new Date());
        int result = userMapper.updateByPrimaryKeySelective(userByLogin);
        if (result == 0) {
            throw new RuntimeException("服务器处理有误");
        }
        return userByLogin;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean changePwd(User user) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        criteria.andPhoneEqualTo(user.getPhone());
        List<User> users = userMapper.selectByExample(userExample);
        if (Objects.isNull(users) || users.isEmpty()) {
            throw new UserNotFoundException("此用户不存在");
        }
        User userByCh = users.get(0);
        userByCh.setPassword(EncryptionUtils.md5AndSalt(user.getPassword()));
        userByCh.setUpdateTime(new Date());
        int result = userMapper.updateByPrimaryKeySelective(userByCh);
        return (result == 1);
    }

    @Override
    public User quickLogin(User user) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andPhoneEqualTo(user.getPhone());
        criteria.andStateEqualTo(StateType.NO.getValue());
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        List<User> users = userMapper.selectByExample(userExample);
        if (Objects.isNull(users) || users.isEmpty()) {
            throw new UserNotFoundException("用户不存在");
        }
        User userByLogin = users.get(0);
        userByLogin.setLoginTime(new Date());
        String token = JWTUtils.sign(userByLogin.getPhone(), userByLogin.getUid().toString(), userByLogin.getLoginTime().toString());
        userByLogin.setToken(token);
        int result = userMapper.updateByPrimaryKeySelective(userByLogin);
        if (result == 0) {
            throw new RuntimeException("服务器处理有误");
        }
        return userByLogin;
    }

    @Override
    public boolean certification(User user) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        criteria.andUidEqualTo(user.getUid());
        user.setAuditState(StateType.NO.getValue());
        int result = userMapper.updateByExampleSelective(user, userExample);
        return (result == 1);
    }

    @Override
    public User editDatum(User user) throws Exception {
        user.setUpdateTime(new Date());
        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(user.getBirthday());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        LocalDate birthday = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(calendar.get(Calendar.DAY_OF_MONTH)));
        LocalDate now = LocalDate.now();
        user.setAge((short)((now.toEpochDay() - birthday.toEpochDay()) / 365));
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUidEqualTo(user.getUid());
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        criteria.andStateEqualTo(StateType.NO.getValue());
        int result = userMapper.updateByExampleSelective(user, userExample);
        if(result != 1){
            throw new RuntimeException("error");
        }
        return user;
    }


    @Override
    public boolean selectTag(BaseDataDTO dataDTO) {
        String[] split = dataDTO.getTmp().split(",");
        for (String s : split){
            UserTag userTag = new UserTag();
            userTag.setUid(dataDTO.getUid());
            userTag.setTagId(Integer.parseInt(s));
            boolean result = userTagService.addHobbyTag(userTag);
            if(!result){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean freezeUser(BaseDataDTO dataDTO) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        criteria.andIdEqualTo(dataDTO.getId().longValue());
        List<User> users = userMapper.selectByExample(userExample);
        if (Objects.isNull(users) || users.isEmpty()) {
            throw new UserNotFoundException("用户不存在");
        }
        User user = users.get(0);
        if (NumberUtils.compare(user.getState(),StateType.NO.getValue()) == 0) {
            user.setState(StateType.YES.getValue());
        }
        else if(NumberUtils.compare(user.getState(),StateType.YES.getValue()) == 0){
            user.setState(StateType.NO.getValue());
        }
        int result = userMapper.updateByExampleSelective(user, userExample);
        return (result == 1);
    }

    @Override
    public boolean freezeComment(BaseDataDTO dataDTO) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        criteria.andIdEqualTo(dataDTO.getId().longValue());
        List<User> users = userMapper.selectByExample(userExample);
        if (Objects.isNull(users) || users.isEmpty()) {
            throw new UserNotFoundException("用户不存在");
        }
        User user = users.get(0);
        if (NumberUtils.compare(user.getComState(), StateType.NO.getValue()) == 0) {
            user.setComState(StateType.YES.getValue());
        }
        else if (NumberUtils.compare(user.getComState(), StateType.YES.getValue()) == 0) {
            user.setComState(StateType.NO.getValue());
        }
        int result = userMapper.updateByExampleSelective(user, userExample);
        return (result == 1);
    }

    @Override
    public boolean reviewUser(BaseDataDTO dataDTO) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        criteria.andIdEqualTo(dataDTO.getId().longValue());
        List<User> users = userMapper.selectByExample(userExample);
        if(Objects.isNull(users) || users.isEmpty()){
            throw new UserNotFoundException("用户不存在");
        }
        User user = users.get(0);
        user.setAuditState(dataDTO.getFlag());
        user.setExContent(dataDTO.getTmp());
        int result = userMapper.updateByPrimaryKeySelective(user);
        return (result == 1);
    }

    @Override
    public boolean collectUser(BaseDataDTO dataDTO) {
        Follow follow = new Follow();
        follow.setFolUid(dataDTO.getUid());
        follow.setBeUid(dataDTO.getOUid());
        return followService.andFollow(follow);
    }

    @Override
    public boolean deleteUser(BaseDataDTO dataDTO) {
        boolean dynamicResult = dynamicService.deleteDynamicByUid(dataDTO.getUid());
        boolean commentResult = commentService.deleteCommentByUid(dataDTO.getUid());
        boolean collectResult = collectionService.deleteCollect(dataDTO.getUid());
        boolean integralResult = integralMapper.deleteByUid(dataDTO.getUid());
        return dynamicResult && commentResult && collectResult && integralResult;
    }

    private void setState(List<Follow> list, Long uid) {
        for (Follow follow : list) {
            boolean isF = followService.isFollow(follow.getFolUid(), uid);
            boolean isC = followService.isFollow(uid, follow.getFolUid());
            if (isC && isF) {
                follow.setState(Short.parseShort("2"));
            } else if (isC) {
                follow.setState(Short.parseShort("1"));
            }
        }
    }
}

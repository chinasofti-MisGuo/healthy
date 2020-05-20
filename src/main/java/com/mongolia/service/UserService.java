package com.mongolia.service;

import com.github.pagehelper.PageInfo;
import com.mongolia.model.dto.BaseDataDTO;
import com.mongolia.model.dto.PageDTO;
import com.mongolia.model.dto.SearchDTO;
import com.mongolia.model.entity.Follow;
import com.mongolia.model.entity.Integral;
import com.mongolia.model.entity.User;

import java.util.List;
import java.util.Map;

/**
 * 用户相关Service接口
 * @author Dong.w
 */
public interface UserService {

    /**
     * 个人主页数据
     * @param dataDTO   请求数据
     * @return  result
     */
    Map<String, Object> personHomePageDetail(BaseDataDTO dataDTO);

    /**
     * 他人主页数据
     * @param dataDTO   请求数据
     * @return  result
     */
    Map<String, Object> othersHomePageDetail(BaseDataDTO dataDTO);

    /**
     * 粉丝列表
     * @param dataDTO   请求数据
     * @return  result
     */
    List<Follow> getFans(BaseDataDTO dataDTO);

    /**
     * 关注列表
     * @param dataDTO   请求数据
     * @return  result
     */
    List<Follow> getCollect(BaseDataDTO dataDTO);

    /**
     * 认证信息
     * @param uid   用户uid
     * @return  result
     */
    Map<String, Object> getCertification(Long uid);

    /**
     * 用户积分
     * @param dataDTO   请求数据
     * @return  result list
     */
    List<Integral> getUserIntegral(BaseDataDTO dataDTO);

    /**
     * 用户列表
     * @param pageDTO   分页数据
     * @return  result page
     */
    PageInfo<User> userList(PageDTO pageDTO);

    /**
     * 未审核用户
     * @param pageDTO   分页数据
     * @return  result page
     */
    PageInfo<User> notAuditUserList(PageDTO pageDTO);

    /**
     * 搜索用户
     * @param searchDTO 搜索条件
     * @return  result page
     */
    PageInfo<User> userListBySearch(SearchDTO searchDTO);

    /**
     * 搜索审核用户
     * @param searchDTO 搜索条件
     * @return  result page
     */
    PageInfo<User> auditUserListBySearch(SearchDTO searchDTO);

    /**
     * 用户注册
     * @param user  数据实体
     * @return  result
     */
    boolean registered(User user);

    /**
     * 用户登录
     * @param user  用户实体
     * @return  result
     */
    User userLogin(User user);

    /**
     * 忘记密码
     * @param user  用户实体
     * @return  result
     */
    boolean changePwd(User user);

    /**
     * 快捷登录
     * @param user  用户数据实体
     * @return  result
     */
    User quickLogin(User user);

    /**
     * 用户信息认证
     * @param user  用户数据
     * @return  result
     */
    boolean certification(User user);

    /**
     * 编辑个人资料
     * @param user  数据实体
     * @return  result
     */
    User editDatum(User user) throws Exception;

    /**
     * 选择兴趣标签
     * @param dataDTO   请求数据
     * @return  result
     */
    boolean selectTag(BaseDataDTO dataDTO);

    /**
     * 冻结用户
     * @param dataDTO   请求参数
     * @return  result
     */
    boolean freezeUser(BaseDataDTO dataDTO);

    /**
     * 冻结用户评论
     * @param dataDTO   请求参数
     * @return  result
     */
    boolean freezeComment(BaseDataDTO dataDTO);

    /**
     * 审核用户
     * @param dataDTO   请求参数
     * @return  result
     */
    boolean reviewUser(BaseDataDTO dataDTO);

    /**
     * 关注用户
     * @param dataDTO   关注用户
     * @return  result
     */
    boolean collectUser(BaseDataDTO dataDTO);

    /**
     * 删除用户
     * @param dataDTO   删除用户
     * @return  result
     */
    boolean deleteUser(BaseDataDTO dataDTO);
}

package com.mongolia.service;

import com.mongolia.model.entity.About;

import java.util.Optional;

/**
 * 关于我们相关Service
 *
 * @author Dong.w
 */
public interface AboutService {

    /**
     * 获取关于我们
     * @return  about实体
     */
    Optional<About> getAboutUs();

    /**
     * 获取联系我们
     * @return about实体
     */
    Optional<About> getContactUs();

    /**
     * 编辑/添加关于我们信息
     * @param about 信息实体
     * @return  result
     */
    int editAboutUs(About about);

    /**
     * 平台使用协议
     * @return  result
     */
    String getUseAgreement();
}

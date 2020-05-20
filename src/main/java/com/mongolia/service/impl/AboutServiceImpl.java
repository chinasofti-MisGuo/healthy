package com.mongolia.service.impl;

import com.mongolia.dao.AboutMapper;
import com.mongolia.model.entity.About;
import com.mongolia.service.AboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

/**
 * 关于我们Service
 *
 * @author Dong.w
 */
@Service
public class AboutServiceImpl implements AboutService {

    @Autowired
    private AboutMapper aboutMapper;

    @Override
    public Optional<About> getAboutUs() {
        About about = aboutMapper.selectByPrimaryKey();
        return Optional.ofNullable(about);
    }

    @Override
    public Optional<About> getContactUs() {
        About about = aboutMapper.selectByPrimaryKey();
        return Optional.ofNullable(about);
    }

    @Override
    public int editAboutUs(About about) {
        About selectResult = aboutMapper.selectByPrimaryKey();
        int result = 0;
        if(Objects.isNull(selectResult)){
            result = aboutMapper.insertSelective(about);
        }else {
            about.setId(selectResult.getId());
            result = aboutMapper.updateByPrimaryKeySelective(about);
        }
        return result;
    }

    @Override
    public String getUseAgreement() {
        return aboutMapper.selectUseAreement();
    }
}

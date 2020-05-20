package com.mongolia.test.dao;

import com.mongolia.dao.CommentMapper;
import com.mongolia.dao.UserMapper;
import com.mongolia.model.entity.Comment;
import com.mongolia.model.enums.StateType;
import com.mongolia.model.example.CommentExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author Dong.w
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application.xml")
public class UserDaoTest {

    @Autowired
    UserMapper userMapper;

    @Autowired
    CommentMapper commentMapper;

    @Test
    public void nickNameTest() throws Exception {
        String s = userMapper.selectNikeNameByUid(1405891L);
        System.out.println(s);
    }

    @Test
    public void commentTest() throws Exception{
        CommentExample commentExample = new CommentExample();
        commentExample.setOrderByClause("id DESC");
        CommentExample.Criteria criteria = commentExample.createCriteria();
        criteria.andBaseIdEqualTo(1L);
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        List<Comment> comments = commentMapper.selectByExample(commentExample);
        System.out.println(comments);
    }

}

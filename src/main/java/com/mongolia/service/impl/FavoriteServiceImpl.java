package com.mongolia.service.impl;

import com.mongolia.dao.FavoriteMapper;
import com.mongolia.model.entity.Favorite;
import com.mongolia.model.enums.FlagType;
import com.mongolia.model.enums.StateType;
import com.mongolia.model.example.FavoriteExample;
import com.mongolia.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 点赞相关实现
 *
 * @author Dong.w
 */
@Service
public class FavoriteServiceImpl implements FavoriteService {

    @Autowired
    private FavoriteMapper favoriteMapper;

    @Override
    public Integer audioDirLikeNum(@NotNull Long audioDirId) {
        return getLikeNum(audioDirId, FlagType.AUDIO);
    }

    @Override
    public Integer audioLikeNum(@NotNull Long audioId) {
        return getLikeNum(audioId, FlagType.AUDIO);
    }

    @Override
    public Integer dynamicLikeNum(@NotNull Long dynamicId) {
        return getLikeNum(dynamicId, FlagType.DYNAMIC);
    }

    @Override
    public Integer commentLikeNum(@NotNull Long commentId) {
        return getLikeNum(commentId, FlagType.COMMENT);
    }

    @Override
    public Boolean isLike(@Valid Favorite favorite) {
        FavoriteExample favoriteExample = new FavoriteExample();
        FavoriteExample.Criteria criteria = favoriteExample.createCriteria();
        criteria.andLikeIdEqualTo(favorite.getLikeId());
        criteria.andFlagEqualTo(favorite.getFlag());
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        int num = favoriteMapper.countByExample(favoriteExample);
        return num != 0;
    }

    @Override
    public Boolean setLike(@Valid Favorite favorite) {
        FavoriteExample favoriteExample = new FavoriteExample();
        FavoriteExample.Criteria criteria = favoriteExample.createCriteria();
        criteria.andFlagEqualTo(favorite.getFlag());
        criteria.andUidEqualTo(favorite.getUid());
        criteria.andLikeIdEqualTo(favorite.getLikeId());
        List<Favorite> favorites = favoriteMapper.selectByExample(favoriteExample);
        int result = 0;
        if (Objects.isNull(favorite) || favorites.isEmpty()) {
            favorite.setCreateTime(new Date());
            result = favoriteMapper.insertSelective(favorite);
        }else {
            Favorite favoriteExist = favorites.get(0);
            if (favoriteExist.getIsDel().equals(StateType.NO.getValue())) {
                favoriteExist.setIsDel(StateType.YES.getValue());
            } else if(favoriteExist.getIsDel().equals(StateType.YES.getValue())){
                favoriteExist.setIsDel(StateType.NO.getValue());
            }
            result = favoriteMapper.updateByPrimaryKeySelective(favoriteExist);
        }
        return (result != 0);
    }

    private Integer getLikeNum(Long likeId, FlagType flag) {
        FavoriteExample favoriteExample = new FavoriteExample();
        FavoriteExample.Criteria criteria = favoriteExample.createCriteria();
        criteria.andLikeIdEqualTo(likeId);
        criteria.andFlagEqualTo((short) flag.getValue());
        criteria.andIsDelEqualTo(Short.valueOf("0"));
        return favoriteMapper.countByExample(favoriteExample);
    }
}

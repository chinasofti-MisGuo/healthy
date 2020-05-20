package com.mongolia.service.impl;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.mongolia.dao.BannerMapper;
import com.mongolia.model.dto.BaseDataDTO;
import com.mongolia.model.dto.PageDTO;
import com.mongolia.model.dto.SearchDTO;
import com.mongolia.model.entity.Banner;
import com.mongolia.model.enums.StateType;
import com.mongolia.model.example.BannerExample;
import com.mongolia.service.BannerService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 广告管理相关Service实现
 *
 * @author Dong.w
 */
@Service
public class BannerServiceImpl implements BannerService {

    @Resource
    private BannerMapper bannerMapper;

    @Override
    public PageInfo<Banner> indexGetList() {
        BannerExample example = new BannerExample();
        example.setOrderByClause("img_sort DESC");
        example.createCriteria().andImgStateEqualTo(Short.valueOf("1")).andIsDelEqualTo(Short.valueOf("0"));
        List<Banner> banners = bannerMapper.selectByExample(example);
        return new PageInfo<>(banners);
    }

    @Override
    public PageInfo<Banner> getList(PageDTO pageDTO) {
        BannerExample example = new BannerExample();
        example.setOrderByClause("create_time DESC");
        example.createCriteria().andIsDelEqualTo(Short.valueOf("0"));
        List<Banner> banners = bannerMapper.selectByExample(example);
        return new PageInfo<>(banners);
    }

    @Override
    public int saveBanner(Banner banner) {
        banner.setCreateTime(new Date());
        return bannerMapper.insertSelective(banner);
    }

    @Override
    public int editBanner(Banner banner) {
        banner.setUpdateTime(new Date());
        return bannerMapper.updateByPrimaryKeySelective(banner);
    }

    @Override
    public int deleteBanner(BaseDataDTO baseDataDTO) {
        Banner banner = bannerMapper.selectByPrimaryKey(baseDataDTO.getId());
        banner.setIsDel(Short.valueOf("1"));
        banner.setUpdateTime(new Date());
        return bannerMapper.updateByPrimaryKey(banner);
    }

    @Override
    public PageInfo<Banner> getSearchList(SearchDTO searchDTO) {
        BannerExample example = new BannerExample();
        BannerExample.Criteria criteria = example.createCriteria();
        example.setOrderByClause("create_time DESC");
        criteria.andIsDelEqualTo(Short.valueOf("0"));
        if(!StringUtils.isEmpty(searchDTO.getName())){
            criteria.andImgNameLike(String.format("%%%s%%", searchDTO.getName()));
        }
        if(Objects.nonNull(searchDTO.getState())){
            criteria.andImgStateEqualTo(searchDTO.getState());
        }
        if(Objects.nonNull(searchDTO.getStart()) && Objects.nonNull(searchDTO.getEnd())){
            criteria.andCreateTimeBetween(searchDTO.getStart(), searchDTO.getEnd());
        }
        List<Banner> banners = bannerMapper.selectByExample(example);
        return new PageInfo<>(banners);
    }

    @Override
    public int upperShelf(BaseDataDTO baseDataDTO) {
        Banner banner = bannerMapper.selectByPrimaryKey(baseDataDTO.getId());
        if(banner.getImgState() == 0){
            banner.setImgState(StateType.YES.getValue());
        }else{
            banner.setImgState(StateType.NO.getValue());
        }
        return bannerMapper.updateByPrimaryKeySelective(banner);
    }

    @Override
    public List allSort(Integer id) {
        BannerExample bannerExample = new BannerExample();
        BannerExample.Criteria criteria = bannerExample.createCriteria();
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        if(id.intValue() != 0) {
            criteria.andIdGreaterThan(id);
            BannerExample.Criteria or = bannerExample.or();
            or.andIdLessThan(id);
            or.andIsDelEqualTo(StateType.NO.getValue());
        }
        List<Banner> banners = bannerMapper.selectByExample(bannerExample);
        List<Integer> list = Lists.newArrayList();
        if (Objects.isNull(banners) || banners.isEmpty()) {
            return list;
        }
        for(Banner b : banners){
            list.add(b.getImgSort());
        }
        return list;
    }
}

package com.mongolia.service;

import com.github.pagehelper.PageInfo;
import com.mongolia.model.dto.BaseDataDTO;
import com.mongolia.model.dto.PageDTO;
import com.mongolia.model.dto.SearchDTO;
import com.mongolia.model.entity.Banner;

import java.util.List;

/**
 * 广告管理相关
 *
 * @author Dong.w
 */
public interface BannerService {

    /**
     * app端首页轮播图列表
     * @return  result
     */
    PageInfo<Banner> indexGetList();

    /**
     * 后台获取轮播图列表
     * @param pageDTO   分页数据
     * @return  result
     */
    PageInfo<Banner> getList(PageDTO pageDTO);

    /**
     * 保存轮播图
     * @param banner    轮播图实体
     * @return  result
     */
    int saveBanner(Banner banner);

    /**
     * 编辑轮播图
     * @param banner    轮播图实体
     * @return  result
     */
    int editBanner(Banner banner);

    /**
     * 删除轮播图
     * @param baseDataDTO 删除条件
     * @return  result
     */
    int deleteBanner(BaseDataDTO baseDataDTO);

    /**
     * 搜索轮播图
     * @param searchDTO 搜索条件
     * @return  result
     */
    PageInfo<Banner> getSearchList(SearchDTO searchDTO);

    /**
     * 上架/下架
     * @param baseDataDTO   数据
     * @return  result
     */
    int upperShelf(BaseDataDTO baseDataDTO);

    /**
     * 已存在排序
     * @param id 需要过滤的id
     * @return  result
     */
    List allSort(Integer id);
}

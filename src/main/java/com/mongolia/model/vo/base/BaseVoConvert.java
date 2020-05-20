package com.mongolia.model.vo.base;

/**
 * VO基类
 *
 * @author Dong.w
 */
public abstract class BaseVoConvert<T, V> {

    /**
     * 将VO转化未实体
     *
     * @param v VO
     * @return 实体
     */
    protected abstract T doForward(V v);

    /**
     * 将实体转化未VO
     *
     * @param t 实体
     * @return VO
     */
    protected abstract V doBackward(T t);

}

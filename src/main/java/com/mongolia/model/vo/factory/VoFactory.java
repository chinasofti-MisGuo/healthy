package com.mongolia.model.vo.factory;

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;

import javax.xml.transform.sax.SAXTransformerFactory;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author Dong.w
 */
public class VoFactory {

    private static final Logger logger = LoggerFactory.getLogger(VoFactory.class);

    private VoFactory() {
    }

    /**
     * 将实体列表转化VO
     *
     * @param t 实体
     * @return VO列表
     */
    public static <T, V> List<V> doBackwardList(List<T> t, Class<?> clazz) {

        if (Objects.isNull(t)) {
            return Lists.newArrayList();
        }
        List<V> voList = Lists.newArrayList();
        try {
            for (T arg : t) {
                V vo = (V) clazz.newInstance();
                BeanUtils.copyProperties(arg, vo);
                voList.add(vo);
            }
            return voList;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("voFactory exception error [{%s}]", e);
            return Lists.newArrayList();
        }
    }

}

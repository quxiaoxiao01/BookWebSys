package com.qiuwuyu.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author paralog
 * @date 2021/6/2 14:53
 */
public class WebUtils {

    public static <T> T copyParamToBean(Map value, T bean) {
        try {
            BeanUtils.populate(bean, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static int parseInter(String id, int defaultVal) {
        try {
            return Integer.parseInt(id);
        } catch (NumberFormatException e) {
        }
        return defaultVal;
    }
}
package com.dongyinuo.mybatis.generator.utils;

import java.util.List;

/**
 * @author dongyinuo
 */
public class BaseGenerator {

    static String AUTHOR;

    public static void setAUTHOR(String author) {
        AUTHOR = author;
    }
    /**
     * 添加引包语句
     *
     * @param packageName 包名
     * @param content     output
     */
    static void addPackage(String packageName, List<String> content) {
        content.add(CommonUtil.PACKAGE.replace("$modulePackagePath", packageName));
    }
}

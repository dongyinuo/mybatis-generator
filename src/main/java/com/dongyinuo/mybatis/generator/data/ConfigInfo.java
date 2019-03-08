package com.dongyinuo.mybatis.generator.data;

import lombok.Data;

/**
 * 生成文件配置类
 * @author dongyinuo
 */
@Data
public class ConfigInfo {

    /**
     * 包路径
     */
    private String modulePackagePath;

    /**
     * domain包名
     */
    private String domainPackageName;

    /**
     * mapper文件夹名
     */
    private String mapperDir;

    /**
     * domain文件名后缀(不包括文件类型)
     * eg: Po
     */
    private String domainPostfix = "";

    /**
     * dao文件名后缀(不包括文件类型)
     * eg: Dao
     */
    private String daoPostfix = "Mapper";

    /**
     * dao文件名后缀(不包括文件类型)
     * eg: Mapper
     */
    private String mapperPostfix = "Mapper";

    /**
     * domain文件后缀
     */
    public String getDomainFilePostfix() {
        return this.domainPostfix + ".java";
    }

    /**
     * dao文件后缀
     */
    public String getDaoFilePostfix() {
        return this.daoPostfix + ".java";
    }

    /**
     * mapper文件后缀
     */
    public String getMapperFilePostfix() {
        return this.mapperPostfix + ".xml";
    }

    /**
     * domain包路径
     */
    public String getDomainPackagePath() {
        return this.modulePackagePath + "." + this.domainPackageName;
    }
}

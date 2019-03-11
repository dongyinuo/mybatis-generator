package com.dongyinuo.mybatis.generator;


import com.dongyinuo.mybatis.generator.data.ConfigInfo;
import com.dongyinuo.mybatis.generator.data.TableInfo;
import com.dongyinuo.mybatis.generator.jdbc.DbUtil;
import com.dongyinuo.mybatis.generator.jdbc.SchemaUtil;
import com.dongyinuo.mybatis.generator.utils.BaseGenerator;
import com.dongyinuo.mybatis.generator.utils.FileGenerator;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * mybatis generator
 * @author dongyinuo
 */
public class MybatisGenerator {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {

        // 设置作者名
        BaseGenerator.setAUTHOR("dongyinuo");
        DbUtil.initConnection("jdbc:mysql://10.44.63.143/db_auction", "auction", "cm1ZwY0MrMZSoUvcowr5");

        // 生成逆向生成表信息
        String tableSchema = "db_auction";
        List<String> tables = Arrays.asList("t_brand", "t_prod_category");
        List<TableInfo> tableInfos = SchemaUtil.getTableInfos(tableSchema, tables);

        // dao、model、mapper 生成路径配置
        ConfigInfo configInfo = new ConfigInfo();
        configInfo.setModulePackagePath("com.output");
        configInfo.setDomainPackageName("model");
        configInfo.setMapperDir("resources/mapper");

        // 生成
        FileGenerator.generate(configInfo, tableInfos);
        System.out.println("全部完成");
    }
}

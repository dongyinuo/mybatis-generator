package com.dongyinuo.mybatis.generator.utils;

import com.dongyinuo.mybatis.generator.data.ColumnInfo;
import com.dongyinuo.mybatis.generator.data.ConfigInfo;
import com.dongyinuo.mybatis.generator.data.DataTypeTranslator;
import com.dongyinuo.mybatis.generator.data.TableInfo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 生成Domain的内容
 * @author dongyinuo
 */
public class DomainGenerator extends BaseGenerator {

    /**
     * 入口
     * @param configInfo 文件配置
     * @param tableInfo
     */
    public static List<String> generate(ConfigInfo configInfo, TableInfo tableInfo) {
        List<String> content = new ArrayList<>();
        addPackage(configInfo.getDomainPackagePath(), content);
        addImport(tableInfo, content);
        addClassComment(tableInfo, content);
        addAnnotation(content);
        addClass(configInfo.getDomainPostfix(), tableInfo, content);
        return content;
    }

    /**
     * 入口
     * @param configInfo 文件配置
     * @param tableInfo
     */
    public static List<String> generateExt(ConfigInfo configInfo, TableInfo tableInfo) {
        List<String> content = new ArrayList<>();
        addPackage(configInfo.getDomainPackagePath(), content);
        addImportExt(tableInfo, content);
        addClassComment(tableInfo, content);
        addAnnotationExt(content);
        addClassExt(configInfo.getDomainPostfix(), tableInfo, content);
        return content;
    }

    /**
     * 添加类内容
     * @param tableInfo
     * @param content
     */
    private static void addClass(String postfix, TableInfo tableInfo, List<String> content) {
        content.add("public class " + tableInfo.getClassName() + postfix + " {");
        for (ColumnInfo columnInfo : tableInfo.getColumnInfos()) {
            content.add("");
            content.add(CommonUtil.SPACE4 + "/**");
            content.add(CommonUtil.SPACE4 + " * " + columnInfo.getComment());
            content.add(CommonUtil.SPACE4 + " */");
            content.add(CommonUtil.SPACE4 + "private " + columnInfo.getType().java + " " + columnInfo.getProperty() + ";");
        }
        content.add("}");
    }

    /**
     * 添加扩展类内容
     * @param tableInfo
     * @param content
     */
    private static void addClassExt(String postfix, TableInfo tableInfo, List<String> content) {
        String className = tableInfo.getClassName();
        content.add("public class " + className + "Ext" + postfix + " extends " + className + "{");
        content.add("}");
    }

    /**
     * 添加类注解
     * @param content
     */
    private static void addAnnotation(List<String> content) {
        content.add("@Data");
    }

    /**
     * 添加类注解
     * @param content
     */
    private static void addAnnotationExt(List<String> content) {
        content.add("@Data");
        content.add("@Builder");
        content.add("@NoArgsConstructor");
        content.add("@AllArgsConstructor");
    }

    /**
     * 添加类注释
     * @param tableInfo raw materials
     * @param content   output
     */
    private static void addClassComment(TableInfo tableInfo, List<String> content) {
        content.add("");
        content.add("/**");
        content.add(" * " + tableInfo.getComment());
        content.add(" * ");
        content.add(" * @author " + AUTHOR);
        content.add(" * @date " + new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        content.add(" */");
    }

    /**
     * 添加import语句
     *
     * @param tableInfo raw materials
     * @param content   output
     */
    private static void addImport(TableInfo tableInfo, List<String> content) {
        content.add("");
        content.add("import lombok.Data;");

        boolean importBlob = false;
        boolean importClob = false;
        boolean importDate = false;
        boolean importLocalDate = false;
        boolean importLocalDateTime = false;
        boolean importBigDecimal = false;

        for (ColumnInfo columnInfo : tableInfo.getColumnInfos()) {
            DataTypeTranslator.Java2Mysql java2Mysql = DataTypeTranslator.Java2Mysql.instanceOf(columnInfo.getType());
            if (java2Mysql != null) {
                switch (java2Mysql) {
                    case BLOB:
                        importBlob = importPackage(content, importBlob, java2Mysql);
                        break;
                    case CLOB:
                        importClob = importPackage(content, importClob, java2Mysql);
                        break;
                    case DATE:
                        importDate = importPackage(content, importDate, java2Mysql);
                        break;
                    case LOCAL_DATE:
                        importLocalDate = importPackage(content, importLocalDate, java2Mysql);
                        break;
                    case LOCAL_DATE_TIME:
                        importLocalDateTime = importPackage(content, importLocalDateTime, java2Mysql);
                        break;
                    case BIG_DECIMAL:
                        importBigDecimal = importPackage(content, importBigDecimal, java2Mysql);
                        break;
                    default:
                        System.err.println("未识别的数据类型: " + java2Mysql);
                }
            }
        }
    }

    /**
     * 添加import语句
     *
     * @param tableInfo raw materials
     * @param content   output
     */
    private static void addImportExt(TableInfo tableInfo, List<String> content) {
        content.add("");
        content.add("import lombok.AllArgsConstructor;");
        content.add("import lombok.Builder;");
        content.add("import lombok.Data;");
        content.add("import lombok.NoArgsConstructor;");
    }

    private static boolean importPackage(List<String> content, boolean imported, DataTypeTranslator.Java2Mysql typeEnum) {
        if (!imported) {
            content.add(CommonUtil.IMPORT.replace("$modulePackagePath", typeEnum.packageName));
        }
        return true;
    }
}

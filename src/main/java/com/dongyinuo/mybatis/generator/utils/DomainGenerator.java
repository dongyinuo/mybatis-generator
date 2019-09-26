package com.dongyinuo.mybatis.generator.utils;

import com.dongyinuo.mybatis.generator.data.ColumnInfo;
import com.dongyinuo.mybatis.generator.data.ConfigInfo;
import com.dongyinuo.mybatis.generator.data.DataTypeTranslator;
import com.dongyinuo.mybatis.generator.data.TableInfo;
import org.springframework.util.StringUtils;

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
        addClassComment(tableInfo, content, 0);
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
        addClassComment(tableInfo, content, 1);
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
        String extClassName = className + "Ext";
        content.add("public class " + extClassName + postfix + " extends " + className + "{");

        // 拼装构造函数
        StringBuilder superProperty = new StringBuilder();
        for (ColumnInfo columnInfo : tableInfo.getColumnInfos()) {
            superProperty.append(columnInfo.getType().java + " " + columnInfo.getProperty() + ", ");
        }

        if (superProperty.length() > 0){
            content.add("");
            content.add(CommonUtil.SPACE4 + "@Builder");
            content.add(CommonUtil.SPACE4 + "public " + extClassName + "(" + superProperty.substring(0, superProperty.length() - 2) + ") {");

            superProperty = new StringBuilder();
            for (ColumnInfo columnInfo : tableInfo.getColumnInfos()) {
                superProperty.append(columnInfo.getProperty() + ", ");
            }

            content.add(CommonUtil.SPACE4 + CommonUtil.SPACE4 + "super(" + superProperty.substring(0, superProperty.length() - 2) + ");");
            content.add(CommonUtil.SPACE4 + "}");
        }

        content.add("}");
    }

    /**
     * 添加类注解
     * @param content
     */
    private static void addAnnotation(List<String> content) {
        content.add("@Getter");
        content.add("@Setter");
        content.add("@ToString");
        content.add("@NoArgsConstructor");
        content.add("@AllArgsConstructor");
    }

    /**
     * 添加类注解
     * @param content
     */
    private static void addAnnotationExt(List<String> content) {
        content.add("@Getter");
        content.add("@Setter");
        content.add("@ToString");
        content.add("@NoArgsConstructor");
    }

    /**
     * 添加类注释
     * @param tableInfo raw materials
     * @param content   output
     */
    private static void addClassComment(TableInfo tableInfo, List<String> content, int flag) {
        content.add("");
        content.add("/**");
        String tableComment = tableInfo.getComment();
        if (!StringUtils.isEmpty(tableComment)){
            content.add(" * " + tableComment + (flag == 1 ? "扩展" : ""));
        }
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
        content.add("import lombok.*;");

        importTableFieldType(tableInfo, content);
    }

    /**
     * 添加import语句
     *
     * @param tableInfo raw materials
     * @param content   output
     */
    private static void addImportExt(TableInfo tableInfo, List<String> content) {
        content.add("");
        content.add("import lombok.*;");

        importTableFieldType(tableInfo, content);
    }

    /**
     * 导入数据库字段依赖
     * @param tableInfo
     * @param content
     */
    private static void importTableFieldType(TableInfo tableInfo, List<String> content) {
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

    private static boolean importPackage(List<String> content, boolean imported, DataTypeTranslator.Java2Mysql typeEnum) {
        if (!imported) {
            content.add(CommonUtil.IMPORT.replace("$modulePackagePath", typeEnum.packageName));
        }
        return true;
    }
}

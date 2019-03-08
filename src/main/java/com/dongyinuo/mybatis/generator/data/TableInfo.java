package com.dongyinuo.mybatis.generator.data;

import com.dongyinuo.mybatis.generator.utils.CommonUtil;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 表信息
 * @author dongyinuo
 */
@Data
public class TableInfo {

    private final static String table_prefix = "T_";

    /**
     * 表名
     */
    private String tableName;

    /**
     * 表注释
     */
    private String comment;

    /**
     * 类名(首字母大写)
     */
    private String className;

    /**
     * 对象名(首字母小写)
     */
    private String objectName;

    /**
     * 列属性
     */
    private List<ColumnInfo> columnInfos;

    public void setClassName() {
        if (this.tableName.startsWith(table_prefix)){
            this.className = CommonUtil.toHump(this.tableName.substring(2));
        }else {
            this.className = CommonUtil.toHump(this.tableName);
        }
    }

    public void setObjectName() {
        if (StringUtils.isEmpty(this.className)) {
            this.setClassName();
        }
        this.objectName = CommonUtil.toLowerHead(this.className);
    }
}

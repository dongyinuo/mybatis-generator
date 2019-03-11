package com.output.model;

import lombok.Data;
import java.util.Date;

/**
 * 品牌信息
 * 
 * @author dongyinuo
 * @date 2019-03-11
 */
@Data
public class Brand {

    /**
     * 主键id
     */
    private Long id;

    /**
     * 品牌名称
     */
    private String brandName;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 状态:0禁用，1启用
     */
    private Byte status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}

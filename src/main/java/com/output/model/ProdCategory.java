package com.output.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.Date;

/**
 * 
 * @author dongyinuo
 * @date 2019-03-11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdCategory {

    /**
     * 分类id
     */
    private Long id;

    /**
     * 商品分类
     */
    private String categoryName;

    /**
     * 状态
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

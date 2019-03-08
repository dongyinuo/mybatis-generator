package com.output.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

/**
 * 
 * 
 * @author dongyinuo
 * @date 2019-03-08
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdCategory {

    /**
     * 主键
     */
    private Long id;

    /**
     * 商品id
     */
    private Long prodId;

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

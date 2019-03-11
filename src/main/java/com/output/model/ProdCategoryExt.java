package com.output.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
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
public class ProdCategoryExt extends ProdCategory{

    @Builder
    public ProdCategoryExt(Long id, String categoryName, Byte status, Date createTime, Date updateTime) {
        super(id, categoryName, status, createTime, updateTime);
    }
}

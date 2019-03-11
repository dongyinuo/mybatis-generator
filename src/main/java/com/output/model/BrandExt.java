package com.output.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

/**
 * 品牌信息扩展
 * 
 * @author dongyinuo
 * @date 2019-03-11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BrandExt extends Brand{

    @Builder
    public BrandExt(Long id, String brandName, Integer sort, Byte status, Date createTime, Date updateTime) {
        super(id, brandName, sort, status, createTime, updateTime);
    }
}

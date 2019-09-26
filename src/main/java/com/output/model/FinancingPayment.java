package com.output.model;

import lombok.*;
import java.util.Date;

/**
 * 支持融资趸付
 * 
 * @author dongyinuo
 * @date 2019-09-17
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FinancingPayment {

    /**
     * 主键
     */
    private Long id;

    /**
     * 易拍机订单号
     */
    private String orderNo;

    /**
     * 商城商品id
     */
    private Long mallProductId;

    /**
     * 商品sku id
     */
    private Long skuId;

    /**
     * 分段租金id
     */
    private Long rentTypeId;

    /**
     * 0 无效、1 有效
     */
    private Byte status;

    /**
     * 订单完成时间
     */
    private Date orderFinished;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}

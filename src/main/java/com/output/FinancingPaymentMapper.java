package com.output;

import org.springframework.stereotype.Repository;
import com.output.model.FinancingPayment;
import java.util.List;

/**
 * 支持融资趸付数据访问
 * 
 * @author dongyinuo
 * @date 2019-09-17
 */ 
@Repository("financingPaymentMapper")
public interface FinancingPaymentMapper {

    /**
     * 插入一条数据
     * 
     * @param financingPayment 待插入对象
     */
    void insert(FinancingPayment financingPayment);

    /**
     * 插入一条数据
     * 
     * @param financingPayment 待插入对象
     */
    void insertSelective(FinancingPayment financingPayment);

    /**
     * 批量插入多条数据
     * 
     * @param list 待插入对象列表
     */
    void batchInsert(List<FinancingPayment> list);

    /**
     * 根据主键删除
     * 
     * @param id 主键值
     * @return 影响条数
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 根据主键更新
     * 
     * @param condition 要更新的对象
     * @return 影响条数
     */
    int updateByPrimaryKey(FinancingPayment condition);

    /**
     * 根据主键查询
     * 
     * @param id 主键值
     * @return 根据主键查询到的对象
     */
    FinancingPayment queryByPrimaryKey(Long id);

    /**
     * 根据条件查询一条记录
     * 
     * @param condition 查询条件
     * @return 查询出来的对象
     */
    FinancingPayment queryOne(FinancingPayment condition);

    /**
     * 根据条件查询列表
     * 
     * @param condition 查询条件
     * @return 查询出来的对象列表
     */
    List<FinancingPayment> queryList(FinancingPayment condition);

    /**
     * 根据条件统计数量
     * 
     * @param condition 统计条件
     * @return 记录总数
     */
    int count(FinancingPayment condition);
}

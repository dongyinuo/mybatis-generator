package com.output;

import com.output.model.ProdCategory;
import java.util.List;

/**
 * 数据访问
 * 
 * @author dongyinuo
 * @date 2019-03-08
 */ 
public interface ProdCategoryMapper {

    /**
     * 插入一条数据
     * 
     * @param prodCategory 待插入对象
     */
    void insert(ProdCategory prodCategory);

    /**
     * 批量插入多条数据
     * 
     * @param list 待插入对象列表
     */
    void batchInsert(List<ProdCategory> list);

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
    int updateByPrimaryKey(ProdCategory condition);

    /**
     * 根据主键查询
     * 
     * @param id 主键值
     * @return 根据主键查询到的对象
     */
    ProdCategory queryByPrimaryKey(Long id);

    /**
     * 根据条件查询一条记录
     * 
     * @param condition 查询条件
     * @return 查询出来的对象
     */
    ProdCategory queryOne(ProdCategory condition);

    /**
     * 根据条件查询列表
     * 
     * @param condition 查询条件
     * @return 查询出来的对象列表
     */
    List<ProdCategory> queryList(ProdCategory condition);

    /**
     * 根据条件统计数量
     * 
     * @param condition 统计条件
     * @return 记录总数
     */
    int count(ProdCategory condition);
}

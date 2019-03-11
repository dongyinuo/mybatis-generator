package com.output;

import org.springframework.stereotype.Repository;
import com.output.model.BrandExt;
import java.util.List;

/**
 * 品牌信息数据访问
 * 
 * @author dongyinuo
 * @date 2019-03-11
 */ 
@Repository("BrandMapperMapper")
public interface BrandMapper {

    /**
     * 插入一条数据
     * 
     * @param brandExt 待插入对象
     */
    void insert(BrandExt brandExt);

    /**
     * 插入一条数据
     * 
     * @param brandExt 待插入对象
     */
    void insertSelective(BrandExt brandExt);

    /**
     * 批量插入多条数据
     * 
     * @param list 待插入对象列表
     */
    void batchInsert(List<BrandExt> list);

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
    int updateByPrimaryKey(BrandExt condition);

    /**
     * 根据主键查询
     * 
     * @param id 主键值
     * @return 根据主键查询到的对象
     */
    BrandExt queryByPrimaryKey(Long id);

    /**
     * 根据条件查询一条记录
     * 
     * @param condition 查询条件
     * @return 查询出来的对象
     */
    BrandExt queryOne(BrandExt condition);

    /**
     * 根据条件查询列表
     * 
     * @param condition 查询条件
     * @return 查询出来的对象列表
     */
    List<BrandExt> queryList(BrandExt condition);

    /**
     * 根据条件统计数量
     * 
     * @param condition 统计条件
     * @return 记录总数
     */
    int count(BrandExt condition);
}

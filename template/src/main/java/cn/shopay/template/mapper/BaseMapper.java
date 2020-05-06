package cn.shopay.template.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.shopay.template.entity.BaseEntity;

/**
 * @description 所有mapper接口的父接口，定义了公用的方法
 * @author Yuanzhi.Xu
 *
 * @param <K> 主键
 * @param <T> 实体类
 */
public interface BaseMapper<K, T extends BaseEntity> {

    /**
     * @description 添加数据
     * @param 要添加的对象
     * @return 影响的行数
     */
    public int save(T obj);

    /**
     * @description 修改数据
     * @param 要修改的对象
     * @return 影响的行数
     */
    public int update(T obj);

    /**
     * @description 根据ID删除数据，逻辑删除，实际执行的是更新操作
     * @param id 主键
     * @param deleteBy 删除人，记录到更新人字段上
     * @return 影响的行数
     */
    public int deleteById(@Param("id") K id, @Param("deleteBy") String deleteBy);

    /**
     * @description 根据ID获取数据
     * @param id 主键
     * @return 查询到的对象
     */
    public T findById(@Param("id") K id);

    /**
     * @description 获取所有数据
     * @return 此类型的所有数据
     */
    public List<T> findAll();
}

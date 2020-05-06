package cn.shopay.template.service;

import java.util.List;

import cn.shopay.template.entity.BaseEntity;

/**
 * @description 所有service接口的父接口，定义了公用的方法
 * @author Yuanzhi.Xu
 * @version 1.0
 * @date 2020-05-06
 * 
 * @param <K> 主键
 * @param <T> 实体类
 */
public interface BaseService<K, T extends BaseEntity> {

    /**
     * @description 添加数据
     * @param 要添加的对象
     * @return 是否成功
     */
    public boolean save(T obj);

    /**
     * @description 修改数据
     * @param 要修改的对象
     * @return 是否成功
     */
    public boolean update(T obj);

    /**
     * @description 根据ID删除数据，逻辑删除，实际执行的是更新操作
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteById(K id);

    /**
     * @description 根据ID获取数据
     * @param id 主键
     * @return 查询到的对象
     */
    public T findById(K id);

    /**
     * @description 获取所有数据
     * @return 此类型的所有数据
     */
    public List<T> findAll();

}

package cn.shopay.template.service.impl;

import java.util.List;
import java.util.UUID;

import cn.shopay.template.config.UserHolder;
import cn.shopay.template.entity.BaseEntity;
import cn.shopay.template.mapper.BaseMapper;

/**
 * @description 所有service实现类的父类，实现了BaseService中定义的公用方法
 * @author Yuanzhi.Xu
 *
 * @param <K> 主键
 * @param <T> 实体类
 */
public abstract class BaseServiceImpl<K, T extends BaseEntity> {

    /**
     * @description 添加数据
     * @param 要添加的对象
     * @return 是否成功
     */
    public boolean save(T obj) {
        obj.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        obj.setCreateBy(UserHolder.getName());
        if (obj.getStatus() == null) {
            obj.setStatus(BaseEntity.STATUS_ACTIVE);
        }
        return getMapper().save(obj) > 0;
    }
    
    /**
     * @description 修改数据
     * @param 要修改的对象
     * @return 是否成功
     */
    public boolean update(T obj) {
        obj.setUpdateBy(UserHolder.getName());
        return getMapper().update(obj) > 0;
    }

    /**
     * @description 根据ID删除数据，逻辑删除，实际执行的是更新操作
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteById(K id) {
        return getMapper().deleteById(id, UserHolder.getName()) > 0;
    }

    /**
     * @description 根据ID获取数据
     * @param id 主键
     * @return 查询到的对象
     */
    public T findById(K id) {
        return getMapper().findById(id);
    }

    /**
     * @description 获取所有数据
     * @return 此类型的所有数据
     */
    public List<T> findAll() {
        return getMapper().findAll();
    }

    /**
     * @description 抽象方法，用于获取实际的mapper对象
     * @return mapper对象
     */
    public abstract BaseMapper<K, T> getMapper();
}

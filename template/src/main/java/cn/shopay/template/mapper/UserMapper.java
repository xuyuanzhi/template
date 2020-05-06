package cn.shopay.template.mapper;

import org.apache.ibatis.annotations.Param;

import cn.shopay.template.entity.User;

/**
 * @description 用户mapper
 * @author Yuanzhi.Xu
 *
 */
public interface UserMapper extends BaseMapper<String, User> {

    /**
     * @description 根据名称获取用户数据
     * @param name 用户名称
     * @return 用户数据
     */
    public User findByName(@Param("name") String name);
}

package cn.shopay.template.service;

import cn.shopay.template.entity.User;

/**
 * @description 用户service接口，定义了父接口中没有定义的方法
 * @author Yuanzhi.Xu
 * @version 1.0
 * @date 2020-05-06
 */
public interface UserService extends BaseService<String, User> {

    /**
     * @description 根据名称获取用户数据
     * @param name 用户名称
     * @return 用户数据
     */
	public User findByName(String name);
}

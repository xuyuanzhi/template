package cn.shopay.template.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.shopay.template.entity.User;
import cn.shopay.template.mapper.BaseMapper;
import cn.shopay.template.mapper.UserMapper;
import cn.shopay.template.service.UserService;

/**
 * @description 用户service的实现类
 * @author Yuanzhi.Xu
 *
 * @param <K> 主键
 * @param <T> 公司实体类
 */
@Service
public class UserServiceImpl<K, T> extends BaseServiceImpl<String, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * @description 根据名称获取用户数据
     * @param name 用户名称
     * @return 用户数据
     */
    public User findByName(String name) {
        return userMapper.findByName(name);
    }

    /**
     * @description 实现父类中的抽象方法，返回用户mapper对象
     */
    @Override
    public BaseMapper<String, User> getMapper() {
        return userMapper;
    }

}

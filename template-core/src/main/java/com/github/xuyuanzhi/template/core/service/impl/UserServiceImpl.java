package com.github.xuyuanzhi.template.core.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.xuyuanzhi.template.core.entity.User;
import com.github.xuyuanzhi.template.core.mapper.UserMapper;
import com.github.xuyuanzhi.template.core.service.UserService;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


}

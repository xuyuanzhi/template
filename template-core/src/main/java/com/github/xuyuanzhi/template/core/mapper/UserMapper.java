package com.github.xuyuanzhi.template.core.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.xuyuanzhi.template.core.entity.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}

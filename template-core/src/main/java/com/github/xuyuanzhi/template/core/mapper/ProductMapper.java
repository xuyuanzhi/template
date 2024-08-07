package com.github.xuyuanzhi.template.core.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.xuyuanzhi.template.core.entity.Product;

@Mapper
public interface ProductMapper extends BaseMapper<Product> {

}

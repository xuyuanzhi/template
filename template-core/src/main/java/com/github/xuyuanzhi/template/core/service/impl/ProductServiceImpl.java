package com.github.xuyuanzhi.template.core.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.xuyuanzhi.template.core.entity.Product;
import com.github.xuyuanzhi.template.core.mapper.ProductMapper;
import com.github.xuyuanzhi.template.core.service.ProductService;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

}

package cn.shopay.template.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.shopay.template.entity.Company;
import cn.shopay.template.mapper.BaseMapper;
import cn.shopay.template.mapper.CompanyMapper;
import cn.shopay.template.service.CompanyService;

/**
 * @description 公司service的实现类
 * @author Yuanzhi.Xu
 *
 * @param <K> 主键
 * @param <T> 公司实体类
 */
@Service
public class CompanyServiceImpl<K, T> extends BaseServiceImpl<String, Company> implements CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    /**
     * @description 根据地址模糊查询公司数据
     * @param addr 地址模糊查询条件
     * @return 公司列表
     */
    public List<Company> findLikeAddr(String addr) {
        return companyMapper.findLikeAddr("%" + addr + "%");
    }

    /**
     * @description 实现父类中的抽象方法，返回公司mapper对象
     */
    @Override
    public BaseMapper<String, Company> getMapper() {
        return companyMapper;
    }

}

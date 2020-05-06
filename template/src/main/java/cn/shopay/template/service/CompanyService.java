package cn.shopay.template.service;

import java.util.List;

import cn.shopay.template.entity.Company;

/**
 * @description 公司service接口，定义了父接口中没有定义的方法
 * @author Yuanzhi.Xu
 * @version 1.0
 * @date 2020-05-06
 */
public interface CompanyService extends BaseService<String, Company> {

    /**
     * @description 根据地址模糊查询公司数据
     * @param addr 地址模糊查询条件
     * @return 公司列表
     */
    public List<Company> findLikeAddr(String addr);
}

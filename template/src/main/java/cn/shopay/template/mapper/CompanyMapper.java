package cn.shopay.template.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.shopay.template.entity.Company;

/**
 * @description 公司mapper
 * @author Yuanzhi.Xu
 *
 */
public interface CompanyMapper extends BaseMapper<String, Company> {

    /**
     * @description 根据地址模糊查询公司数据
     * @param addr 地址模糊查询条件
     * @return 公司列表
     */
    public List<Company> findLikeAddr(@Param("addr") String addr);
}

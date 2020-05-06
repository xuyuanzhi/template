package cn.shopay.template.entity;

/**
 * @description 公司类
 * @author Yuanzhi.Xu
 * @version 1.0
 * @date 2020-05-06
 */
public class Company extends BaseEntity {

    /** 公司名称 **/
    private String name;
    /** 公司地址 **/
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}

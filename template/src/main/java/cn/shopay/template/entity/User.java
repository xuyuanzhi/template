package cn.shopay.template.entity;

/**
 * @description 用户类
 * @author Yuanzhi.Xu
 * @version 1.0
 * @date 2020-05-06
 */
public class User extends BaseEntity {

    /** 用户名称 **/
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

package cn.shopay.template.entity;

import java.sql.Timestamp;

import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * @description 所有实体类的父类，包含公用的几个属性
 * @author Yuanzhi.Xu
 * @version 1.0
 * @date 2020-05-06
 */
public class BaseEntity {

    /** 状态的3个静态常量 **/
    public final static int STATUS_ACTIVE = 1;
    public final static int STATUS_INACTIVE = 2;
    public final static int STATUS_DELETE = 3;

    /** 主键 **/
    private String id;
    /** 创建时间 **/
    private Timestamp createTime;
    /** 创建人 **/
    private String createBy;
    /** 最后更新时间 **/
    private Timestamp updateTime;
    /** 最后更新人 **/
    private String updateBy;
    /** 状态，1：启用，2：禁用，3：删除 **/
    private Integer status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    /**
     * @description 创建时间的字符输出，精确到秒
     * @return 创建时间的字符输出
     */
    public String getCreateTimeText() {
        if (createTime != null) {
            return DateFormatUtils.format(createTime, "yyyy-MM-dd HH:mm:ss");
        }
        return "";
    }

    /**
     * @description 创建时间的字符输出，精确到天
     * @return 创建时间的字符输出
     */
    public String getCreateDateText() {
        if (createTime != null) {
            return DateFormatUtils.format(createTime, "yyyy-MM-dd");
        }
        return "";
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @description 更新时间的字符输出，精确到秒
     * @return 更新时间的字符输出
     */
    public String getUpdateTimeText() {
        if (updateTime != null) {
            return DateFormatUtils.format(updateTime, "yyyy-MM-dd HH:mm:ss");
        }
        return "";
    }

    /**
     * @description 更新时间的字符输出，精确到天
     * @return 更新时间的字符输出
     */
    public String getUpdateDateText() {
        if (updateTime != null) {
            return DateFormatUtils.format(updateTime, "yyyy-MM-dd");
        }
        return "";
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @description 状态的字符输出
     * @return 状态的字符输出
     */
    public String getStatusText() {
        if (STATUS_ACTIVE == status) {
            return "启用";
        } else if (STATUS_INACTIVE == status) {
            return "禁用";
        } else if (STATUS_DELETE == status) {
            return "删除";
        } else {
            return "";
        }
    }

    /**
     * @description 状态的字符输出，包含了修饰的html，用于页面显示的效果
     * @return 状态的字符输出
     */
    public String getStatusHtml() {
        if (STATUS_ACTIVE == status) {
            return "<span style='color:green;'>启用</span>";
        } else if (STATUS_INACTIVE == status) {
            return "<span style='color:red;'>禁用</span>";
        } else if (STATUS_DELETE == status) {
            return "删除";
        } else {
            return "";
        }
    }
}

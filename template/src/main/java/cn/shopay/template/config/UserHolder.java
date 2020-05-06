package cn.shopay.template.config;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;

import cn.shopay.template.entity.User;

/**
 * @description 用户线程类，用于请求执行时获取当前用户对象
 * @author Yuanzhi.Xu
 * @version 1.0
 * @date 2020-05-06
 */
@Configuration
public class UserHolder {

    /** 存储用户的ThreadLocal **/
	private ThreadLocal<User> userLocal = new ThreadLocal<User>();
	/** UserHolder单例对象 **/
	private static UserHolder holder;
	
	/**
	 * @description 初始化方法
	 */
	@PostConstruct
	public void init() {
		holder = this;
	}
	
	public static User get() {
		return holder.userLocal.get();
	}
	
	/**
	 * @description 获取当前用户的名称
	 * @return 用户名称
	 */
	public static String getName() {
		if (holder.userLocal.get() != null) {
			return holder.userLocal.get().getName();
		} else {
			return "default";
		}
	}
	
	public static void set(User user) {
		holder.userLocal.set(user);
	}
	
	public static void remove() {
		holder.userLocal.remove();
	}
}

package com.github.xuyuanzhi.template.core.config;

import com.github.xuyuanzhi.template.core.view.UserView;

public class UserHolder {

	private static final ThreadLocal<UserView> userLocal = new ThreadLocal<>();
	
	public static UserView get() {
        return userLocal.get();
    }

    public static void set(UserView user) {
    	userLocal.set(user);
    }

    public static void remove() {
    	userLocal.remove();
    }
}

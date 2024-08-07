package com.github.xuyuanzhi.template.core.intergration.i18n;

import java.util.Locale;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class MessageSourceHolder {
	
	private static MessageSourceHolder holder;

	@Autowired
	private MessageSource messageSource;
	
	@PostConstruct
	public void init() {
		holder = this;
	}
	
	private String getMessage0(String key) {
		Locale locale = LocaleContextHolder.getLocale();
		String message = messageSource.getMessage(key, null, locale);
		return message;
	}
	
	private String getMessage0(String key, Object[] args) {
		Locale locale = LocaleContextHolder.getLocale();
		String message = messageSource.getMessage(key, args, locale);
		return message;
	}
	
	public static String getMessage(String key) {
		return holder.getMessage0(key);
	}
	
	public static String getMessage(String key, Object[] args) {
		return holder.getMessage0(key, args);
	}
}

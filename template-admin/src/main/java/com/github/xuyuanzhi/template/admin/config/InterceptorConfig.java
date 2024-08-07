package com.github.xuyuanzhi.template.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.github.xuyuanzhi.template.admin.interceptor.AdminInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AdminInterceptor()).addPathPatterns("/**").excludePathPatterns("/static/**",
				"/error", "/swagger-ui.html", "/swagger-ui/**", "/v3/**", "/doc.html");
	}

}
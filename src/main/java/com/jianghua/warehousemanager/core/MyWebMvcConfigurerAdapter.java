package com.jianghua.warehousemanager.core;

import com.jianghua.warehousemanager.interceptor.AccountInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("deprecation")
@Configuration
public class MyWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {
	/**
	 * 配置静态访问资源
	 * 
	 * @param registry
	 */
/*	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/templet/**").addResourceLocations("classpath:/templet/");
		super.addResourceHandlers(registry);
	}*/

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		List<String> excludePath = new ArrayList<>();
		excludePath.add("/toLogin");
		excludePath.add("/login");
		excludePath.add("/loginOut");
		excludePath.add("/test");
		excludePath.add("/error");
		excludePath.add("/css/*");
		excludePath.add("/img/*");
		excludePath.add("/fonts/*");
		excludePath.add("/js/*");
		excludePath.add("/plugins/*");
		excludePath.add("/**/*.css");
		excludePath.add("/**/*.png");
		excludePath.add("/**/*.js");
		excludePath.add("/**/*.gif");
		excludePath.add("/**/*.jpg");
		excludePath.add("/**/*.jpeg");
//		excludePath.add("/**/*.htm");
//		excludePath.add("/**/*.html");
		registry.addInterceptor(new AccountInterceptor()).addPathPatterns("/**").excludePathPatterns(excludePath);
		super.addInterceptors(registry);
	}

/*	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
	*//*	registry.addViewController("/main").setViewName("login");
		registry.addViewController("/index").setViewName("index");
		registry.addViewController("/update").setViewName("systemUser/passwordMdy");
		registry.addViewController("/error").setViewName("error");*//*
		super.addViewControllers(registry);
	}*/
@Bean
public FilterRegistrationBean corsFilter() {
	UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	CorsConfiguration config = new CorsConfiguration();
	config.setAllowCredentials(true);
	config.addAllowedOrigin(CorsConfiguration.ALL);
	config.addAllowedHeader(CorsConfiguration.ALL);
	config.addAllowedMethod(CorsConfiguration.ALL);
	source.registerCorsConfiguration("/**", config);
	FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
	bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
	return bean;

}
}
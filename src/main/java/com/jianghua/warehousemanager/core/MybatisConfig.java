package com.jianghua.warehousemanager.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import java.util.Properties;

@Configuration
public class MybatisConfig {
	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer(){
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
//		mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
		mapperScannerConfigurer.setBasePackage("com.jianghua.warehousemanager.mapper");
		Properties properties = new Properties();

		properties.setProperty("mappers", Mapper.class.getName());
		properties.setProperty("notEmpty", "false");
//		properties.setProperty("IDENTITY","MYSQL");
		properties.setProperty("ORDER","BEFORE");
		mapperScannerConfigurer.setProperties(properties);
		return mapperScannerConfigurer;
	}

}

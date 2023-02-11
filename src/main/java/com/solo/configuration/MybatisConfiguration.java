package com.solo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ibatis.Mybatis;
import com.ibatis.MybatisSMC;

@Configuration
public class MybatisConfiguration {
	
	@Bean
	public MybatisSMC mybatisSMC() {
		MybatisSMC mybatisSMC = new MybatisSMC();
		return mybatisSMC;
	}
	
	@Bean
	public Mybatis mybatis() {
		Mybatis mybatis = new Mybatis();
		return mybatis;
	}

}

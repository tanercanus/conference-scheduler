package com.conference.init;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
// @EnableTransactionManagement
@ComponentScan({ "com.conference.controller", "com.conference.exception" })
// @EntityScan("...")
@PropertySource("classpath:application.properties")
// @EnableJpaRepositories("...")
// @EnableMongoRepositories("...")
@EnableAutoConfiguration(exclude = { ErrorMvcAutoConfiguration.class })
public class WebAppConfig extends WebMvcConfigurerAdapter {

	/*
	 * @Override public void addResourceHandlers(final ResourceHandlerRegistry
	 * registry) {
	 * registry.addResourceHandler("/assets/**").addResourceLocations("/assets/"
	 * ); }
	 */

}

package com.rbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.rbc"})
public class WebMVCConfig extends WebMvcConfigurerAdapter{
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/*.js/**").addResourceLocations("/resources/");
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
	
	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
        registry.addViewController("/").setViewName("login");
        /*registry.addViewController("/home").setViewName("Home");*/
    }
	
	@Bean
	public RestTemplate restTemplate() throws SecurityException{
		RestTemplate restTemplate = new RestTemplate(/*clientHttpRequestFactory()*/);
		return restTemplate;
	}
	
	/*private ClientHttpRequestFactory clientHttpRequestFactory() {
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		factory.setReadTimeout(240000);
		factory.setConnectionRequestTimeout(240000);
		return factory;
	}*/
}

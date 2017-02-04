package com.br.sicc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.br.sicc.business.ProdutoBO;
import com.br.sicc.business.ProdutoBOImpl;
import com.br.sicc.facade.GenericFacade;
import com.br.sicc.facade.GenericFacadeImpl;


/*
 * Classe de configuração do Spring MVC, que substitui 95% dos xml de configurações
 * Classe responsável pela configuração do Spring MVC
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.br.sicc")
public class AppConfig {
	
	@Autowired
	private ApplicationContext context;
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Bean
	public MessageSource messageSource() {
	    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	    messageSource.setBasename("messages");
	    return messageSource;
	}
	
	@Bean
	public ApplicationContextProvider applicationContextProvider(){
		ApplicationContextProvider provider = new ApplicationContextProvider();
		provider.setApplicationContext(context);
		return provider;
	}
}


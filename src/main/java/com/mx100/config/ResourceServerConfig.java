package com.mx100.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	
	@Override
	public void configure(HttpSecurity http) throws Exception {		
    	http.csrf().disable()
    			.anonymous().and()
				.authorizeRequests()
				.antMatchers(HttpMethod.POST, "/oauth/token").permitAll()
				.antMatchers(HttpMethod.POST, "/api/user").permitAll()
				.antMatchers("/api/**").authenticated()
    			.antMatchers("/auth").authenticated();
    }
	
	@Bean
    public MessageSource messageSource() {
        Locale.setDefault(Locale.ENGLISH);
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.addBasenames("classpath:messages_en");
        return messageSource;
    }
	
}

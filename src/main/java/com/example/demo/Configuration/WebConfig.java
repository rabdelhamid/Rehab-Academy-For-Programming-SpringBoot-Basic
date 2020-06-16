/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//https://programmer.group/how-do-spring-boot-2.x-add-interceptors.html
package com.example.demo.Configuration;

import com.example.demo.Interceptors.DemoInterceptor;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;



/**
 *
 * @author user
 */
@Configuration
public class WebConfig implements WebMvcConfigurer{
    
    @Autowired
    private DemoInterceptor demoInterceptor;
    //https://developer.okta.com/blog/2019/02/25/java-i18n-internationalization-localization
    /**LocaleResolver
        We need to determine default Locale of your application.
    **/
    @Bean
    public LocaleResolver localeResolver() {
//       SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
//       sessionLocaleResolver.setDefaultLocale(Locale.US);
//       return sessionLocaleResolver;
         return new CookieLocaleResolver();
    }
    /**
     * LocaleChangeInterceptor
        * LocaleChangeInterceptor is a used to change the new Locale 
        * based on the value of the language parameter added to a request.
     **/
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
       LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
       localeChangeInterceptor.setParamName("language");
       return localeChangeInterceptor;
    }
  
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        
        registry.addInterceptor(demoInterceptor);
        registry.addInterceptor(localeChangeInterceptor());
    }
}

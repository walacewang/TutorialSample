package com.zac.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.zac.config.handle.MyInterceptorHandler;
import com.zac.config.message.BundleMessageSource;
 
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.zac")
public class MyWebMvcConfigurer extends WebMvcConfigurerAdapter {
    @Bean /* (NOW NOT USED) */
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}
    
	@Bean(name = "messageSource")
	public BundleMessageSource getBundleMessageSource() {
		BundleMessageSource messageSource = new BundleMessageSource();
		messageSource.setBasenames("classpath:/i18n/messages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

    @Bean
    MyInterceptorHandler myInterceptor() {
         return new MyInterceptorHandler();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor());
    }
    
    
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        // Static ressources from both WEB-INF and webjars
//        registry
//            .addResourceHandler("/resources/**")
//                .addResourceLocations("/resources/")
//                .setCachePeriod(CACHE_PERIOD);
//        registry
//            .addResourceHandler("/webjars/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/")
//                .setCachePeriod(CACHE_PERIOD);
//    }

//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/about"); // the about page did not required any controller
//    }
//
//    @Override
//    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//        // Serving static files using the Servlet container's default Servlet.
//        configurer.enable();
//    }
//
//    @Override
//    public void addFormatters(FormatterRegistry formatterRegistry) {
//        // add your custom formatters
//    }
 
}
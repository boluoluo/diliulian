package com.diliulian.framework.springfox;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableWebMvc
@EnableSwagger2
@ComponentScan("com.diliulian.platform.controller")
public class SwaggerConfig extends WebMvcConfigurerAdapter
{
	
	
	/*public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
		super.addResourceHandlers(registry);
	}*/
	
	
	@Bean
	public Docket customDocket()
	{
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());/*.select()
				.apis(RequestHandlerSelectors.basePackage("com.diliulian.platform.controller")).paths(PathSelectors.any())
				.build();*/
	}

	private ApiInfo apiInfo()
	{
		ApiInfo apiInfo = new ApiInfo("Battcn接口文档", "Battcn是鏖战八方的一个开源项目,里面的内容包含框架,工具,适合新手以及刚工作不久的人,希望能帮助到大家",
				"battcn2.0", "My Apps API terms of service",
				new Contact("鏖战八方", "http://www.diliulian.com", "1837307557@qq.com"), "加入我们", "http://www.diliulian.com");
		return apiInfo;
	}
}
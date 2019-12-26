package com.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*swagger 配置注入
 * 并初始化信息*/
@Configuration
@EnableSwagger2
public class swaggerConfig {
	@Bean
	 public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sample.controller"))
                .paths(PathSelectors.any())
                .build();
    }

	//初始化参数数据
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("样品模板项目接口测试")
                .description("予之文化传媒")
                .termsOfServiceUrl("http://cengjide.top")
                .contact("开发部")
                .version("1.0")
                .build();
    }

}

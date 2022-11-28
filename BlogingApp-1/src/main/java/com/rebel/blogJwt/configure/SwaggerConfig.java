package com.rebel.blogJwt.configure;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig 
{
	private final static String  Authorization_Header = "Authorization";
	
	private ApiKey apiAccess()
	{
		return new ApiKey("JWT", Authorization_Header, "header");
	}
	
	//Security context
	private List<SecurityContext> getCon()
	{
		return Arrays.asList(SecurityContext.builder().securityReferences(sf()).build());
	}
	
	//Security References
	private List<SecurityReference> sf()
	{
		AuthorizationScope scope = new AuthorizationScope("global", "accessEverything");
		
		return Arrays.asList(new SecurityReference("JWT", new AuthorizationScope[] {scope} ));
	}
	
	
	//Docket
	@Bean
   public Docket api()
   {
	   return new Docket(DocumentationType.SWAGGER_2)
			   .apiInfo(getInfo())
			   .securitySchemes(Arrays.asList(apiAccess()))
			   .securityContexts(getCon())
			   .select()
			   .apis(RequestHandlerSelectors.any())
			   .paths(PathSelectors.any()).build();
   }
	
	
	private ApiInfo getInfo()
	{
		return new ApiInfo("Bloggin Application", "Developed By Hiren Devmurari", "1.0", "Licence Service", new Contact("Hiren Devmurari", "Github/hiren0000", "Hiru.devmurari@gmail.com"), "Licence", "Licence URL", Collections.emptyList());
	}
	
}

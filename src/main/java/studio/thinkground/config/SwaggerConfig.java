package studio.thinkground.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
/*@EnableWebMvc*/
public class SwaggerConfig implements WebMvcConfigurer {
  /*@Bean
  public Docket api(){
      return new Docket(DocumentationType.SWAGGER_2)
              .apiInfo(apiInfo())
              .select()
              .apis(RequestHandlerSelectors.basePackage("studio.thinkground"))
              .paths(PathSelectors.any())
              .build();
  }

  private ApiInfo apiInfo()
  {
      return new ApiInfoBuilder()
              .title("my test swagger page")
              .description("descrtiption")
              .version("1.0")
              .build();
  }*/

  @Bean
  public OpenAPI openAPI() {
    return new OpenAPI().components(new Components()).info(apiInfo());
  }

  private Info apiInfo() {
    return new Info()
        .title("Springdoc Test")
        .description("Springdoc Swagger UI Test")
        .version("1.0.0");
  }

  /*@Override
  public void addResourceHandlers(ResourceHandlerRegistry registry)
  {
      registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
      registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
      registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
  }*/

}

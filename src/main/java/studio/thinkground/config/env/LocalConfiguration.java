package studio.thinkground.config.env;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("local")
@Configuration
public class LocalConfiguration {
  @Value("${studio.thinkground.loading.message}")
  private String message;

  @Bean
  public String getMessage() {
    return "local profile : " + message;
  }
}

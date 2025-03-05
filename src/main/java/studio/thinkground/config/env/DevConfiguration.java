package studio.thinkground.config.env;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("dev")
@Configuration
public class DevConfiguration {
  @Value("${studio.thinkground.loading.message}")
  private String message;

  @Bean
  public String getMessage() {
    return "dev profile : " + message;
  }
}

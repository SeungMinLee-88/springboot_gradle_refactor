package studio.thinkground.client.kakao;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
@ConfigurationProperties(prefix = "aroundhub.client.kakao")
public class KakaoClientProperties {
  private String baseUrl;
  private String apiKey;
  private String apiSecret;
  private Integer connectionTimeout;
  private Integer responseTimeout;
  private Integer readTimeout;
  private Integer writeTimeout;
  private Integer idleTimeoutSeconds;
}

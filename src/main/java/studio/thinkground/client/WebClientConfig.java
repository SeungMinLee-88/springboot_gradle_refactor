package studio.thinkground.client;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;
import studio.thinkground.client.kakao.KakaoClientProperties;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Configuration
public class WebClientConfig {
  @Bean
  @Qualifier("WebclientForKakao")
  public WebClient WebclientForKakao(KakaoClientProperties kakaoClientProperties){
    return null;
  }

  private HttpClient buildHttpClient(
          int connectionTimeout,
          int responseTimeout,
          int readTimeout,
          int writeTimeout,
          int idleTimeoutSeconds,
          String msName
  ){
    ConnectionProvider connectionProvider =
            ConnectionProvider.builder("aroundhub-client")
                    .maxIdleTime(Duration.ofSeconds(idleTimeoutSeconds))
                    .build();
    return HttpClient.create(connectionProvider)
            .followRedirect(true)
            .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, connectionTimeout)
            .responseTimeout(Duration.ofMillis(readTimeout))
            .doOnConnected(connection -> connection.addHandlerLast(new ReadTimeoutHandler(
                    readTimeout, TimeUnit.MILLISECONDS
            )).addHandlerLast(new WriteTimeoutHandler(writeTimeout, TimeUnit.MILLISECONDS)));

  }
}

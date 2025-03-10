package studio.thinkground.client;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.hibernate.dialect.unique.DefaultUniqueDelegate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
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
    HttpClient httpClient = buildHttpClient(kakaoClientProperties.getConnectionTimeout(), kakaoClientProperties.getResponseTimeout(), kakaoClientProperties.getReadTimeout()
            , kakaoClientProperties.getWriteTimeout(), kakaoClientProperties.getIdleTimeoutSeconds()
    , ExternalService.KAKAO.getServiceName());
    DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(kakaoClientProperties.getBaseUrl());


    return WebClient.builder()
            .uriBuilderFactory(factory)
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .defaultHeader(kakaoClientProperties.getApiKey(), kakaoClientProperties.getApiSecret())
            .clientConnector(new ReactorClientHttpConnector(httpClient))
            .build();
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
            .doOnRequest((request, conn) -> conn.addHandlerFirst(new LoggingHandler(msName)))
            .doOnConnected(connection -> connection.addHandlerLast(new ReadTimeoutHandler(
                    readTimeout, TimeUnit.MILLISECONDS
            )).addHandlerLast(new WriteTimeoutHandler(writeTimeout, TimeUnit.MILLISECONDS)));

  }
}

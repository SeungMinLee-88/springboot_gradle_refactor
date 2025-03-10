package studio.thinkground.client.kakao;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class KakaoClient {

  private final WebClient webClient;

  public KakaoClient(@Qualifier("WebclientForKakao") WebClient webClient){
    this.webClient = webClient;
  }

  public Mono<String> checkApi(Long id){
    String uri = String.format("/api/v1/check/%d");

    return webClient.get().uri(uri)
            .exchangeToMono(
                    response -> {
                      if(response.statusCode().is2xxSuccessful())
                      {
                        return response.bodyToMono(String.class);
                      }
                      if(response.statusCode().is4xxClientError())
                      {
                        return Mono.error(
                                new RuntimeException("Unexpected response code : " + response.statusCode())
                        );
                      }
                      if(response.statusCode().is5xxServerError())
                      {
                        return Mono.error(
                                new RuntimeException("Unexpected response code : " + response.statusCode())
                        );
                      }
                      return Mono.error(
                              new RuntimeException("Unexpected response code : " + response.statusCode())
                      );
                    }
            );
  }
}

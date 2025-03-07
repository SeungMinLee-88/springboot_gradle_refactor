package studio.thinkground.client;

import lombok.Getter;

@Getter
public enum ExternalService {
  KAKAO("kakao");
  NAVER("naver");

  private final String serviceName;

  ExternalService(String serviceName){
    this.serviceName = serviceName;
  }
}

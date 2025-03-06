package studio.thinkground.service.impl;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import studio.thinkground.data.dto.MemberDTO;
import studio.thinkground.service.RestTemplateService;

@Service
public class RestTemplateServiceImpl implements RestTemplateService {

  private final Logger LOGGER = LoggerFactory.getLogger(RestTemplateServiceImpl.class);

  @Override
  public String getAroundHub() {
    LOGGER.info("chk 1111111111111111111111111");
    URI uri =
        UriComponentsBuilder.fromUriString("http://localhost:8090")
            .path("/resttemplate/aroundhub")
            .encode()
            .build()
            .toUri();
    LOGGER.info("chk 222222222222222222");
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);
    LOGGER.info("chk 333333333333");
    LOGGER.info("status code : {}", responseEntity.getStatusCode());
    LOGGER.info("body : {}", responseEntity.getBody());

    return "getAroundHub";
  }

  @Override
  public String getName() {

    URI uri =
        UriComponentsBuilder.fromUriString("http://localhost:8090")
            .path("/resttemplate/name")
            .queryParam("name", "Flature")
            .encode()
            .build()
            .toUri();

    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);

    LOGGER.info("status code : {}", responseEntity.getStatusCode());
    LOGGER.info("body : {}", responseEntity.getBody());

    return responseEntity.getBody();
  }

  @Override
  public String getName2() {
    URI uri =
        UriComponentsBuilder.fromUriString("http://localhost:8090")
            .path("/resttemplate/{name}")
            .encode()
            .build()
            .expand("Flature21321") // 복수의 값을 넣어야할 경우 , 를 추가하여 구분
            .toUri();

    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);

    LOGGER.info("status code : {}", responseEntity.getStatusCode());
    LOGGER.info("body : {}", responseEntity.getBody());

    return responseEntity.getBody();
  }

  @Override
  public ResponseEntity<MemberDTO> postDto() {
    URI uri =
        UriComponentsBuilder.fromUriString("http://localhost:8090")
            .path("/resttemplate/member")
            .queryParam("name", "lsmslm")
            .queryParam("email", "aaaa@jjj.com")
            .queryParam("organization", "myhome")
            .encode()
            .build()
            .toUri();

    MemberDTO memberDTO = new MemberDTO();
    memberDTO.setName("aaa!!");
    memberDTO.setEmail("ccc@aaa.com");
    memberDTO.setOrganization("asdasd!");

    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<MemberDTO> responseEntity =
        restTemplate.postForEntity(uri, memberDTO, MemberDTO.class);

    LOGGER.info("status code : {}", responseEntity.getStatusCode());
    LOGGER.info("body : {}", responseEntity.getBody());

    return responseEntity;
  }

  @Override
  public ResponseEntity<MemberDTO> addHeader() {
    URI uri =
        UriComponentsBuilder.fromUriString("http://localhost:8090")
            .path("/resttemplate/add-header")
            .encode()
            .build()
            .toUri();

    MemberDTO memberDTO = new MemberDTO();
    memberDTO.setName("flature");
    memberDTO.setEmail("jjj@jjj.com");
    memberDTO.setOrganization("Around Hub Studio");

    RequestEntity<MemberDTO> requestEntity =
        RequestEntity.post(uri).header("ardheader", "headervaluuu").body(memberDTO);

    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<MemberDTO> responseEntity =
        restTemplate.exchange(requestEntity, MemberDTO.class);

    LOGGER.info("status code : {}", responseEntity.getStatusCode());
    LOGGER.info("body : {}", responseEntity.getBody());

    return responseEntity;
  }
}

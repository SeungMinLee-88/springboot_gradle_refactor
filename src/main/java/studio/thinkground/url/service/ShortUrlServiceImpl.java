package studio.thinkground.url.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studio.thinkground.url.entity.ShortUrlEntity;
import studio.thinkground.url.repository.ShortUrlDAO;
import studio.thinkground.url.dto.ShortUrlResponse;
import studio.thinkground.url.repository.ShortUrlRedisRepository;

@Service
public class ShortUrlServiceImpl implements ShortUrlService {
  private final Logger LOGGER = LoggerFactory.getLogger(ShortUrlServiceImpl.class);

  private final ShortUrlDAO shortUrlDAO;
  private final ShortUrlRedisRepository shortUrlRedisRepository;

  @Autowired
  public ShortUrlServiceImpl(
      ShortUrlDAO shortUrlDAO, ShortUrlRedisRepository shortUrlRedisRepository) {
    this.shortUrlDAO = shortUrlDAO;
    this.shortUrlRedisRepository = shortUrlRedisRepository;
  }

  @Override
  public ShortUrlResponse getShortUrl(String clientId, String clientSecret, String originalUrl) {
    LOGGER.info("getShortUrl originalUrl : " + originalUrl);
    Optional<ShortUrlResponse> foundResponseDto = shortUrlRedisRepository.findById(originalUrl);
    if (foundResponseDto.isPresent()) {
      LOGGER.info("getShortUrl Cache Exists");
      return foundResponseDto.get();
    } else {
      LOGGER.info("getShortUrl Cache NotNotNotNot Exists");
      ;
    }

    ShortUrlEntity getShortUrlEntity = shortUrlDAO.getShortUrl(originalUrl);

    String orgUrl;
    String shortUrl;
    if (getShortUrlEntity == null) {
      LOGGER.info("getShortUrl no entity database");
      /*ResponseEntity<NaverUrlDto> responseEntity = requestShortUrl(clientId, clientSecret, originalUrl);*/
      ShortUrlResponse responseEntity = generateShortUrl(clientId, clientSecret, originalUrl);
      orgUrl = responseEntity.getOriginalUrl();
      shortUrl = responseEntity.getShortUrl();
      /*            orgUrl = "test.com";
      shortUrl = "d2.test.com/helloworld/23123";*/

      // ResponseEntity<NaverUrlDto> responseEntity = requestShortUrl();
    } else {
      orgUrl = getShortUrlEntity.getOrgUrl();
      shortUrl = getShortUrlEntity.getUrl();
    }

    /*ShortUrlResponseDto shortUrlResponseDto = new ShortUrlResponseDto(orgUrl, shortUrl);*/
    ShortUrlResponse shortUrlResponse = new ShortUrlResponse();
    shortUrlResponse.setOriginalUrl(originalUrl);
    shortUrlResponse.setShortUrl("http://d2.naver.com/helloworld/4874130");
    LOGGER.info("getShortUrl shortUrlResponseDto : " + shortUrlResponse.toString());

    return foundResponseDto.get();
  }

  @Override
  // 09:59
  public ShortUrlResponse generateShortUrl(
      String clientId, String clientSecret, String originalUrl) {
    LOGGER.info("generateShortUrl originalUrl : " + originalUrl);
    /*ResponseEntity<NaverUrlDto> responseEntity = requestShortUrl(clientId, clientSecret, originalUrl);*/

    /*String orgUrl = responseEntity.getBody().getResult().getOrgUrl();
    String shortUrl = responseEntity.getBody().getResult().getUrl();
    String hash = responseEntity.getBody().getResult().getHash();*/
    String orgUrl = originalUrl;
    String shortUrl = "d2.test.com/helloworld/23123";
    /*String orgUrl = "d2.test.com/helloworld/23123";
    String shortUrl = "111.com";*/
    String hash = "124124asfwqet2";

    ShortUrlEntity shortUrlEntity = new ShortUrlEntity();
    shortUrlEntity.setOrgUrl(orgUrl);
    shortUrlEntity.setUrl(shortUrl);
    shortUrlEntity.setHash(hash);

    shortUrlDAO.saveShortUrl(shortUrlEntity);

    ShortUrlResponse shortUrlResponse = new ShortUrlResponse();
    shortUrlResponse.setOriginalUrl(originalUrl);
    shortUrlResponse.setShortUrl("http://d2.naver.com/helloworld/4874130");
    // 0656

    shortUrlRedisRepository.save(shortUrlResponse);

    LOGGER.info("generate short urlshortUrlResponseDto : " + shortUrlResponse.toString());

    return shortUrlResponse;
  }

  @Override
  public ShortUrlResponse updateShortUrl(
      String clientId, String clientSecret, String originalUrl) {
    return null;
  }

  @Override
  public void deleteShortUrl(String url) {
    LOGGER.info("call deleteShortUrl url : " + url);
    if (url.contains("d2.do")) {
      LOGGER.info("delete ShortUrl");
      deleteByShortUrl(url);
    } else {
      LOGGER.info("delete Origina Url");
      deleteByOriginalShortUrl(url);
    }
  }

  @Override
  public ShortUrlResponse deleteByShortUrl(String shortUrl) {
    LOGGER.info("deleteByShortUrl called");
    shortUrlDAO.deleteByShortUrl(shortUrl);
    return null;
  }

  @Override
  public ShortUrlResponse deleteByOriginalShortUrl(String originalUrl) {
    LOGGER.info("deleteByOriginalShortUrl called");
    shortUrlDAO.deleteByOriginalUrl(originalUrl);
    return null;
  }

  // 11:45
  // http://127.0.0.1:8090/shorturl?originalUrl=naver.com
  /*private ResponseEntity<NaverUrlDto> requestShortUrl(String clientId, String clientSecret, String originalUrl)*/
  private ShortUrlResponse requestShortUrl(
      String clientId, String clientSecret, String originalUrl) {
    LOGGER.info("resust short clientId : " + clientId);
    LOGGER.info("resust short clientSecret : " + clientSecret);
    LOGGER.info("resust short url : " + originalUrl);

    /*URI uri = UriComponentsBuilder
            .fromUriString("https://openapi.naver.com/v1/util/shorturl")
            .path("/shorturl")
            .queryParam("url", originalUrl)
            .build()
            .toUri();

    LOGGER.info("resust short url Header");

    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Arrays.asList(new MediaType[]{MediaType.APPLICATION_JSON}));
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.set("X-Naver-Client-Id", clientId);
    headers.set("X-Naver-Client-Secret", clientSecret);

    HttpEntity<String> entity = new HttpEntity<>("", headers);

    RestTemplate restTemplate = new RestTemplate();

    LOGGER.info("resust short restTemplate : " + originalUrl);

    ResponseEntity<NaverUrlDto> responseEntity = restTemplate.exchange(uri, HttpMethod.GET
    , entity, NaverUrlDto.class);
    LOGGER.info("resust short success : " + originalUrl);*/
    String orgUrl = "aaa.com";
    String shortUrl = "d2.test.com/helloworld/aaaa";
    String hash = "aaaaa";

    ShortUrlEntity shortUrlEntity = new ShortUrlEntity();
    shortUrlEntity.setOrgUrl(orgUrl);
    shortUrlEntity.setUrl(shortUrl);
    shortUrlEntity.setHash(hash);

    shortUrlDAO.saveShortUrl(shortUrlEntity);

    ShortUrlResponse shortUrlResponse = new ShortUrlResponse();
    shortUrlResponse.setOriginalUrl(originalUrl);
    shortUrlResponse.setShortUrl("http://d2.naver.com/helloworld/4874130");

    LOGGER.info("generate short urlshortUrlResponseDto : " + shortUrlResponse.toString());

    return shortUrlResponse;
  }
}

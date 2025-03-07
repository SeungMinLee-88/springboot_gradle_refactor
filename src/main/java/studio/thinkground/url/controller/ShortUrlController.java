package studio.thinkground.url.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import studio.thinkground.url.dto.ShortUrlResponse;
import studio.thinkground.url.service.ShortUrlService;

// 05:28
@RestController
@RequestMapping("/shorturl")
public class ShortUrlController {

  private final Logger LOGGER = LoggerFactory.getLogger(ShortUrlController.class);

  @Value("${around.hub.short.url.id}")
  private String CLIENT_ID;

  @Value("${around.hub.short.url.secret}")
  private String CLIENT_SECRET;

  ShortUrlService shortUrlService;

  @Autowired
  public ShortUrlController(ShortUrlService shortUrlService) {
    this.shortUrlService = shortUrlService;
  }

  // 17:43 test
  // http://127.0.0.1:8090/shorturl
  @PostMapping()
  private ShortUrlResponse generateShortUrl(@RequestBody String originalUrl) {
    LOGGER.info("PostMapping generateShourUrl");
    LOGGER.info("PostMapping generateShourUrl originalUrl : " + originalUrl);
    return shortUrlService.generateShortUrl(CLIENT_ID, CLIENT_SECRET, originalUrl);
  }

  // http://127.0.0.1:8090/shorturl?originalUrl=https://www.naver.com
  @GetMapping
  public ShortUrlResponse getShortUrl(String originalUrl) {
    LOGGER.info("GetMapping getShortUrl");
    LOGGER.info("GetMapping getShortUrl originalUrl : " + originalUrl);

    /*ShortUrlResponseDto shortUrlResponseDto = new ShortUrlResponseDto("ss", "ss");*/
    return shortUrlService.getShortUrl(CLIENT_ID, CLIENT_SECRET, originalUrl);
  }

  @PutMapping("/")
  public ShortUrlResponse updateShortUrl(
      String clientId, String clientSecret, String originalUrl) {
    shortUrlService.updateShortUrl(clientId, clientSecret, originalUrl);
    return null;
  }

  /*
  http://127.0.0.1:8090/shorturl/delete/naver.com
  난 왜 이거 있어야 되는거야? /delete
  */
  @DeleteMapping("/delete")
  public ResponseEntity<String> deleteShortUrl(String url) {
    try {
      shortUrlService.deleteShortUrl(url);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return ResponseEntity.status(HttpStatus.OK).body("comlete delete");
  }
}

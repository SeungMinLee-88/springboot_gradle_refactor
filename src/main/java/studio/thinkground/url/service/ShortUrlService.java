package studio.thinkground.url.service;

import studio.thinkground.url.dto.ShortUrlResponse;

public interface ShortUrlService {

  ShortUrlResponse getShortUrl(String clientId, String clientSecret, String originalUrl);

  ShortUrlResponse generateShortUrl(String clientId, String clientSecret, String originalUrl);

  ShortUrlResponse updateShortUrl(String clientId, String clientSecret, String originalUrl);

  void deleteShortUrl(String url);

  ShortUrlResponse deleteByShortUrl(String shortUrl);

  ShortUrlResponse deleteByOriginalShortUrl(String originalUrl);
}

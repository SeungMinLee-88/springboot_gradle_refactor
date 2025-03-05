package studio.thinkground.service;

import studio.thinkground.data.dto.ShortUrlResponseDto;

public interface ShortUrlService {

  ShortUrlResponseDto getShortUrl(String clientId, String clientSecret, String originalUrl);

  ShortUrlResponseDto generateShortUrl(String clientId, String clientSecret, String originalUrl);

  ShortUrlResponseDto updateShortUrl(String clientId, String clientSecret, String originalUrl);

  void deleteShortUrl(String url);

  ShortUrlResponseDto deleteByShortUrl(String shortUrl);

  ShortUrlResponseDto deleteByOriginalShortUrl(String originalUrl);
}

package studio.thinkground.url.repository;

import studio.thinkground.url.entity.ShortUrlEntity;

public interface ShortUrlDAO {

  ShortUrlEntity saveShortUrl(ShortUrlEntity shortUrl);

  ShortUrlEntity getShortUrl(String originalUrl);

  ShortUrlEntity getOriginalUrl(String shortUrl);

  ShortUrlEntity updateShortUrl(ShortUrlEntity newShortUrlEntity);

  void deleteByShortUrl(String shortUrl);

  void deleteByOriginalUrl(String originalUrl);
}

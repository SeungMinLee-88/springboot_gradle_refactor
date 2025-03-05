package studio.thinkground.data.dao;

import studio.thinkground.data.Entity.ShortUrlEntity;

public interface ShortUrlDAO {

  ShortUrlEntity saveShortUrl(ShortUrlEntity shortUrl);

  ShortUrlEntity getShortUrl(String originalUrl);

  ShortUrlEntity getOriginalUrl(String shortUrl);

  ShortUrlEntity updateShortUrl(ShortUrlEntity newShortUrlEntity);

  void deleteByShortUrl(String shortUrl);

  void deleteByOriginalUrl(String originalUrl);
}

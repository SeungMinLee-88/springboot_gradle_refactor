package studio.thinkground.url.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import studio.thinkground.url.entity.ShortUrlEntity;

// 06:30
public interface ShortUrlRepository extends JpaRepository<ShortUrlEntity, Long> {

  ShortUrlEntity findByUrl(String url);

  ShortUrlEntity findByOrgUrl(String originalurl);
}

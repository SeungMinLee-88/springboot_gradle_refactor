package studio.thinkground.data.reposittory;

import org.springframework.data.jpa.repository.JpaRepository;
import studio.thinkground.data.Entity.ShortUrlEntity;
//06:30
public interface ShortUrlRepository extends JpaRepository<ShortUrlEntity, Long> {

    ShortUrlEntity findByUrl(String url);

    ShortUrlEntity findByOrgUrl(String originalurl);
}

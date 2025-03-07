package studio.thinkground.url.repository;

import org.springframework.data.repository.CrudRepository;

import studio.thinkground.url.dto.ShortUrlResponse;

public interface ShortUrlRedisRepository extends CrudRepository<ShortUrlResponse, String> {}

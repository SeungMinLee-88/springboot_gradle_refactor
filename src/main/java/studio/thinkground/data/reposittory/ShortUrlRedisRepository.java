package studio.thinkground.data.reposittory;

import org.springframework.data.repository.CrudRepository;

import studio.thinkground.data.dto.ShortUrlResponseDto;

public interface ShortUrlRedisRepository extends CrudRepository<ShortUrlResponseDto, String> {}

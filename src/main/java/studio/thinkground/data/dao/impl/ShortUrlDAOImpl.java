package studio.thinkground.data.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import studio.thinkground.data.Entity.ShortUrlEntity;
import studio.thinkground.data.dao.ShortUrlDAO;
import studio.thinkground.data.reposittory.ShortUrlRepository;

@Component
public class ShortUrlDAOImpl implements ShortUrlDAO {
    /*@Autowired
    public ShortUrlDAOImpl(S)*/
    private final ShortUrlRepository shortUrlRepository;

    @Autowired
    public ShortUrlDAOImpl(ShortUrlRepository shortUrlRepository){
        this.shortUrlRepository = shortUrlRepository;
    }

    @Override
    public ShortUrlEntity saveShortUrl(ShortUrlEntity shortUrlEntity)
    {
        ShortUrlEntity foundShortUrlEntity = shortUrlRepository.save(shortUrlEntity);
        return foundShortUrlEntity;
    }
    @Override
    public ShortUrlEntity getShortUrl(String originalUrl)
    {
        ShortUrlEntity foundShortUrlEntity = shortUrlRepository.findByOrgUrl(originalUrl);
        return foundShortUrlEntity;
    }

    @Override
    public ShortUrlEntity getOriginalUrl(String originalUrl) {
        ShortUrlEntity foundShortUrlEntity = shortUrlRepository.findByOrgUrl(originalUrl);
        return foundShortUrlEntity;
    }

    @Override
    public ShortUrlEntity updateShortUrl(ShortUrlEntity newShortUrlEntity) {
        ShortUrlEntity foundShortUrlEntity = shortUrlRepository.findByOrgUrl(newShortUrlEntity.getOrgUrl());

        foundShortUrlEntity.setUrl(newShortUrlEntity.getUrl());
        ShortUrlEntity savedShortUrlEntity = shortUrlRepository.save(foundShortUrlEntity);

        return savedShortUrlEntity;
    }

    @Override
    public void deleteByShortUrl(String shortUrl) {
        ShortUrlEntity foundShortUrlEntity = shortUrlRepository.findByUrl(shortUrl);
        shortUrlRepository.delete(foundShortUrlEntity);
    }

    @Override
    public void deleteByOriginalUrl(String originalUrl) {
        ShortUrlEntity foundShortUrlEntity = shortUrlRepository.findByOrgUrl(originalUrl);
        shortUrlRepository.delete(foundShortUrlEntity);

    }
}

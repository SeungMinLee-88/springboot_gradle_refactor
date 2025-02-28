package studio.thinkground.data.dao;

import studio.thinkground.data.Entity.ProductEntity;

public interface ProductDAO {

    ProductEntity saveProduct(ProductEntity productEntity);

    ProductEntity getProduct(Long productId);
}

package studio.thinkground.sample.repository;

import studio.thinkground.product.ProductEntity;

public interface ProductDAO {

  ProductEntity saveProduct(ProductEntity productEntity);

  ProductEntity getProduct(Long productId);
}

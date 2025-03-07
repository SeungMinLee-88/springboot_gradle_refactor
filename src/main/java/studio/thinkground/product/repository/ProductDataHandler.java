package studio.thinkground.product.repository;

import studio.thinkground.product.ProductEntity;

public interface ProductDataHandler {

  ProductEntity saveProductEntity(
      Long productId, String productName, int productPrice, int productStock);

  ProductEntity getProductEntity(Long productId);
}

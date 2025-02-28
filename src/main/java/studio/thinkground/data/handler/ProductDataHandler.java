package studio.thinkground.data.handler;

import studio.thinkground.data.Entity.ProductEntity;

public interface ProductDataHandler {

    ProductEntity saveProductEntity(
            Long productId, String productName, int productPrice, int productStock);

    ProductEntity getProductEntity(Long productId);
}
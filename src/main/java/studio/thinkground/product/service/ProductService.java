package studio.thinkground.product.service;

import studio.thinkground.product.dto.ProductRequest;

public interface ProductService {

  ProductRequest saveProduct(Long productId, String productName, int productPrice, int productStock);

  ProductRequest getProduct(Long productId);
}

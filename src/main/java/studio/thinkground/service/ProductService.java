package studio.thinkground.service;

import studio.thinkground.data.dto.ProductDTO;

public interface ProductService {

  ProductDTO saveProduct(Long productId, String productName, int productPrice, int productStock);

  ProductDTO getProduct(Long productId);
}

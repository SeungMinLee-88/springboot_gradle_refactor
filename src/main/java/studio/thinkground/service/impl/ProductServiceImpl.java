package studio.thinkground.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studio.thinkground.data.Entity.ProductEntity;
import studio.thinkground.data.dto.ProductDTO;
import studio.thinkground.data.handler.ProductDataHandler;
import studio.thinkground.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

  private final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

  ProductDataHandler productDataHandler;

  @Autowired
  public ProductServiceImpl(ProductDataHandler productDataHandler) {
    this.productDataHandler = productDataHandler;
  }

  @Override
  public ProductDTO saveProduct(
      Long productId, String productName, int productPrice, int productStock) {
    LOGGER.info("[saveProduct productPrice : " + productPrice);
    LOGGER.info("[saveProduct productStock : " + productStock);
    LOGGER.info("[saveProduct] productDataHandler 로 상품 정보 저장 요청");
    ProductEntity productEntity =
        productDataHandler.saveProductEntity(productId, productName, productPrice, productStock);

    LOGGER.info(
        "[saveProduct] Entity 객체를 DTO 객체로 변환 작업. productId : {}" + productEntity.getProductId());
    LOGGER.info(
        "[saveProduct] Entity 객체를 DTO 객체로 변환 작업. getProductPrice : {}"
            + productEntity.getProductPrice());
    LOGGER.info("[saveProduct productEntity.getProductId() : " + productEntity.getProductId());
    LOGGER.info("[saveProduct productEntity.getProductName() : " + productEntity.getProductName());
    LOGGER.info(
        "[saveProduct productEntity.getProductPrice() : " + productEntity.getProductPrice());
    LOGGER.info(
        "[saveProduct productEntity.getProductStock() : " + productEntity.getProductStock());
    /*ProductDTO productDTO =
    new ProductDTO(productEntity.getProductId(), productEntity.getProductName(), productEntity.getProductPrice(), productEntity.getProductStock());*/
    ProductDTO productDto = new ProductDTO();
    productDto.setProductId(productId);
    productDto.setProductName(productName);
    productDto.setProductPrice(productPrice);
    productDto.setProductStock(productStock);

    return productDto;
  }

  @Override
  public ProductDTO getProduct(Long productId) {

    LOGGER.info("[getProduct] productDataHandler 로 상품 정보 조회 요청");
    // LOGGER.info("productId : " + productId);
    ProductEntity productEntity = productDataHandler.getProductEntity(productId);

    LOGGER.info(
        "[getProduct] Entity 객체를 DTO 객체로 변환 작업. productId : {}" + productEntity.getProductId());
    /*ProductDTO productDto =
    new ProductDTO(productEntity.getProductId(), productEntity.getProductName(), productEntity.getProductPrice(), productEntity.getProductStock());*/
    ProductDTO productDto = new ProductDTO();
    /*ProductDTO productDto = new ProductDTO();
    productDto.setProductId(productId);*/

    return productDto;
  }
}

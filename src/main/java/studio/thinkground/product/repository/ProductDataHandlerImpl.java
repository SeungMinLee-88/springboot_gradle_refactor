package studio.thinkground.product.repository;

import jakarta.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studio.thinkground.product.ProductEntity;
import studio.thinkground.sample.repository.ProductDAO;

@Service
@Transactional
public class ProductDataHandlerImpl implements ProductDataHandler {

  private final Logger LOGGER = LoggerFactory.getLogger(ProductDataHandlerImpl.class);

  ProductDAO productDAO;

  @Autowired
  public ProductDataHandlerImpl(ProductDAO productDAO) {
    this.productDAO = productDAO;
  }

  @Override
  public ProductEntity saveProductEntity(
      Long productId, String productName, int productPrice, int productStock) {

    LOGGER.info("call saveProductEntity");
    LOGGER.info("saveProductEntity productId : " + productId);
    LOGGER.info("saveProductEntity productName : " + productName);
    LOGGER.info("saveProductEntity productPrice : " + productPrice);
    LOGGER.info("saveProductEntity productStock : " + productStock);
    LOGGER.info("[saveProductEntity] 매개변수를 통해 Entity 객체 생성");
    ProductEntity productEntity = new ProductEntity();

    productEntity.setProductId(productId);
    productEntity.setProductName(productName);
    productEntity.setProductPrice(productPrice);
    productEntity.setProductStock(productStock);
    LOGGER.info("[saveProductEntity] productDAO로 Product 정보 저장 요청. productId : {}", productId);
    return productDAO.saveProduct(productEntity);
  }

  @Override
  public ProductEntity getProductEntity(Long productId) {
    LOGGER.info("[saveProductEntity] productDAO로 Product 정보 요청. productId : {}", productId);
    return productDAO.getProduct(productId);
  }
}

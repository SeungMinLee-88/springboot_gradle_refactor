package studio.thinkground.sample.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studio.thinkground.product.ProductEntity;
import studio.thinkground.product.repository.ProductDataHandlerImpl;
import studio.thinkground.product.repository.ProductRepoitory;

@Service
public class ProductDAOImpl implements ProductDAO {
  private final Logger LOGGER = LoggerFactory.getLogger(ProductDataHandlerImpl.class);
  ProductRepoitory productRepoitory;

  @Autowired
  public ProductDAOImpl(ProductRepoitory productRepoitory) {
    this.productRepoitory = productRepoitory;
  }

  @Override
  public ProductEntity saveProduct(ProductEntity productEntity) {
    LOGGER.info("call saveProduct");
    LOGGER.info("saveProduct productId : " + productEntity.getProductId());
    LOGGER.info("saveProduct productName : " + productEntity.getProductName());
    LOGGER.info("saveProduct productPrice : " + productEntity.getProductPrice());
    LOGGER.info("saveProduct productStock : " + productEntity.getProductStock());
    return productRepoitory.save(productEntity);
  }

  @Override
  public ProductEntity getProduct(Long productId) {
    return productRepoitory.getById(productId);
  }
}

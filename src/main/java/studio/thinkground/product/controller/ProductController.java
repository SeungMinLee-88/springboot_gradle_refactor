package studio.thinkground.product.controller;

/*import junitparams.Parameters;
import org.hibernate.annotations.Parameter;*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import studio.thinkground.product.dto.ProductRequest;
import studio.thinkground.product.service.ProductService;

// http://127.0.0.1:8090/api/v1/product-api/product
@RestController
@RequestMapping(value = "/api/v1/product-api")
public class ProductController {

  private ProductService productService;
  private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

  @Autowired
  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  /*
  @GetMapping(value = "/reqtest")
  public String reqtest() {

      return "reqtest";
  }*/

  // http://localhost:8080/api/v1/product-api/product/{productId}
  @GetMapping(value = "/product/{productId}")
  public ProductRequest getProduct(@PathVariable Long productId) {

    long startTime = System.currentTimeMillis();
    LOGGER.info("[getProduct] perform {} of Around Hub API." + "getProduct");

    ProductRequest productRequest = productService.getProduct(productId);

    LOGGER.info(
        "[getProduct] Response :: productId = {} + productName = {} + productPrice = {} + productStock = {} + Response Time = {}ms"
            + productRequest.getProductId()
            + productRequest.getProductName()
            + productRequest.getProductPrice()
            + productRequest.getProductStock()
            + (System.currentTimeMillis() - startTime));
    return productRequest;
  }

  // http://localhost:8080/api/v1/product-api/product
  /*@Parameters({
          @Parameters(
                  name = "X-AUTH-TOKEN",
                  description = "로그인 성공 후 access_token",
                  required = true,
                  schema = @Schema(implementation = String.class),
                  in = ParameterIn.HEADER)
  })*/
  @PostMapping(value = "/product")
  public ResponseEntity<ProductRequest> createProduct(@Validated @RequestBody ProductRequest productRequest) {
    /* {
        'productId' : 'aaaa',
            'productName' : 'anamae',
            'productPrice' : '5000',
            'productStock' : '1000'
    }*/
    LOGGER.info("[createProduct] perform {} of Around Hub API." + "createProduct");

    // Validation Code Example
    if (productRequest.getProductId().equals("") || productRequest.getProductId().toString().isEmpty()) {
      LOGGER.info("[createProduct] Product Id is empty");
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(productRequest);
    }

    Long productId = productRequest.getProductId();
    String productName = productRequest.getProductName();
    int productPrice = productRequest.getProductPrice();
    int productStock = productRequest.getProductStock();

    ProductRequest response =
        productService.saveProduct(productId, productName, productPrice, productStock);

    LOGGER.info(
        "[createProduct] Response >> productId : {} + productName : {} + productPrice : {} + productStock : {}"
            + response.getProductId()
            + response.getProductName()
            + response.getProductPrice()
            + response.getProductStock());
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  // http://localhost:8080/api/v1/product-api/product/{productId}
  /*@Parameters({
          @Parameter(
                  name = "X-AUTH-TOKEN",
                  description = "로그인 성공 후 access_token",
                  required = true,
                  schema = @Schema(implementation = String.class),
                  in = ParameterIn.HEADER)
  })*/
  @DeleteMapping(value = "/product/{productId}")
  public ProductRequest deleteProduct(@PathVariable String productId) {
    return null;
  }

  /*@PostMapping(value = "/product/exception")
  public void exceptionTest() throws  {
      throw new AroundHubException(
              Constants.ExceptionClass.PRODUCT, HttpStatus.FORBIDDEN, "접근이 금지되었습니다.");
  }*/

}

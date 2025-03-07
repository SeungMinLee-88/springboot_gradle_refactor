package studio.thinkground.product.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import studio.thinkground.product.ProductEntity;

// 0:54
public interface ProductRepoitory extends JpaRepository<ProductEntity, Long> {

  List<ProductEntity> findByProductName(String name);

  List<ProductEntity> queryByProductName(String name);

  boolean existsByProductName(String name);

  long countByProductName(String name);

  void deleteByProductId(long id);

  long removeByProductId(long id);

  List<ProductEntity> findFirst3ByProductName(String name);

  List<ProductEntity> findFirst5ByProductName(String name);

  List<ProductEntity> findByProductIdNot(long id);

  List<ProductEntity> findByProductIdIsNot(long id);

  List<ProductEntity> findByProductNameIsNull();

  List<ProductEntity> findByProductNameIsNotNull();

  List<ProductEntity> findTopByProductIdAndProductName(Integer productprice, String productname);

  List<ProductEntity> findByProductPriceGreaterThan(Integer productprice);

  List<ProductEntity> findByProductNameContainingOrderByProductStockAsc(String productname);

  List<ProductEntity> findByProductNameContainingOrderByProductStockDesc(String productname);

  List<ProductEntity> findByProductNameContainingOrderByProductPriceAscProductStockDesc(
      String productname);

  List<ProductEntity> findByProductNameContaining(String productname, Sort sort);

  List<ProductEntity> findByProductPriceGreaterThan(Integer productprice, Pageable pageable);

  // 참고https://stackoverflow.com/questions/49817396/validation-failed-for-query-for-method-public-abstract-java-util-list
  @Query("select p from ProductEntity p where p.productPrice > 2000")
  List<ProductEntity> findByproductPriceBasis();

  @Query(value = "select p.* from product p where p.product_price > 2000", nativeQuery = true)
  List<ProductEntity> findByproductPriceNativeQuery();

  @Query(value = "select p.* from product p where p.product_price > ?1", nativeQuery = true)
  List<ProductEntity> findByproductPriceWithParameter(Integer productPrice);

  @Query(
      value = "select p.* from product p where p.product_price > :productPrice",
      nativeQuery = true)
  List<ProductEntity> findByproductPriceWithParameterNaming(Integer productPrice);

  @Query(value = "select p.* from product p where p.product_price > :pri", nativeQuery = true)
  List<ProductEntity> findByproductPriceWithParameterNaming2(@Param("pri") Integer productPrice);

  @Query(
      value = "select p.* from product p where p.product_price > :productPrice",
      countQuery = "select count(*) from product p where p.product_price > ?1",
      nativeQuery = true)
  List<ProductEntity> findByproductPriceWithParameterPaging(
      Integer productPrice, Pageable pageable);
}

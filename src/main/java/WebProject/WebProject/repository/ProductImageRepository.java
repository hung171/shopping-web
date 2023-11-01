package WebProject.WebProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import WebProject.WebProject.entity.ProductImage;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ProductImageRepository extends JpaRepository<ProductImage,Integer>{

	void deleteById(int id);

	@Modifying
	@Transactional
	@Query("DELETE FROM ProductImage pi WHERE pi.product.id = :productId")
	void deleteProductImageByProductId(@Param("productId") int productId);
}

package WebProject.WebProject.repository;

import WebProject.WebProject.entity.Outfit;
import WebProject.WebProject.entity.Outfit_Product;
import WebProject.WebProject.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Outfit_ProductRepository extends JpaRepository<Outfit_Product, Integer> {
    List<Outfit_Product> findByOutfit(Outfit outfit);
    List<Outfit_Product> findByProduct(Product product);

    Outfit_Product findByOutfitAndProduct(Outfit outfit, Product product);
}

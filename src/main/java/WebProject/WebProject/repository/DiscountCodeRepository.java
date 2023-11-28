package WebProject.WebProject.repository;

import WebProject.WebProject.entity.DiscountCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountCodeRepository extends JpaRepository<DiscountCode, Integer> {
    DiscountCode findByCode(String code);

    DiscountCode findById(int id);
}

package WebProject.WebProject.repository;

import WebProject.WebProject.entity.Outfit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutfitRepository extends JpaRepository<Outfit, Integer> {
    // Các phương thức tùy chỉnh nếu cần
}

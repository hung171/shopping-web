package WebProject.WebProject.repository;

import WebProject.WebProject.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Integer>{

	List<Cart> findAllByUser_id(String user_id);
	
}

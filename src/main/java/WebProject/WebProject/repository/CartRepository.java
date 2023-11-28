package WebProject.WebProject.repository;

import WebProject.WebProject.entity.Cart;
import WebProject.WebProject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Integer>{

	List<Cart> findAllByUser_id(String user_id);
	@Modifying
	@Transactional
	@Query("DELETE FROM Cart c WHERE c.user.id = :user_id")
	void deleteAllByUser_id(String user_id);
}

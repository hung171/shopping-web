package WebProject.WebProject.repository;

import WebProject.WebProject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByIdAndRole(String id, String role);
	
	void deleteById(String id);
}

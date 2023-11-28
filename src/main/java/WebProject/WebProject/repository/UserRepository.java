package WebProject.WebProject.repository;

import WebProject.WebProject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByIdAndRole(String id, String role);
	
	void deleteById(String id);

	List<User> findByRole(String role);
}

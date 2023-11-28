package WebProject.WebProject.service;

import java.util.List;

import WebProject.WebProject.entity.User;

public interface UserService {

	User saveUser(User user);

	User findByIdAndRole(String id, String role);

	List<User> findAll();

	List<User> findByRole(String role);
}

package WebProject.WebProject.service.impl;

import WebProject.WebProject.entity.User;
import WebProject.WebProject.repository.UserRepository;
import WebProject.WebProject.service.UserService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	SessionFactory factory;
	
	private UserRepository userRepository;
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository=userRepository;
	}

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public User findByIdAndRole(String id, String role) {
		return userRepository.findByIdAndRole(id, role);
	}
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	
}

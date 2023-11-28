package WebProject.WebProject.service;

import java.util.List;

import WebProject.WebProject.entity.Cart;
import WebProject.WebProject.entity.User;

public interface CartService {
	
	void deleteById(int id);
	
	List<Cart> GetAllCartByUser_id(String user_id);
	
	void saveCart(Cart cart);

	void deleteAllByUser_id(String user_id);
}

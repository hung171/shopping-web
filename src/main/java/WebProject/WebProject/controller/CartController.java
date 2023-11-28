package WebProject.WebProject.controller;

import WebProject.WebProject.entity.Cart;
import WebProject.WebProject.entity.DiscountCode;
import WebProject.WebProject.entity.Product;
import WebProject.WebProject.entity.User;
import WebProject.WebProject.service.CartService;
import WebProject.WebProject.service.DiscountCodeService;
import WebProject.WebProject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CartController {

	@Autowired
	CartService cartService;

	@Autowired
	ProductService productService;

	@Autowired
	DiscountCodeService discountCodeService;

	@Autowired
	HttpSession session;

	@GetMapping("/cart")
	public String CartView(Model model, HttpSession session) {
		User user = (User) session.getAttribute("acc");
		if (user == null) {
			session.setAttribute("AddToCartErr", "Vui lòng đăng nhập trước khi thực hiện thao tác!");
			return "redirect:/home";
		} else {
			List<Cart> listCart = cartService.GetAllCartByUser_id(user.getId());
			int total = 0;
			for (Cart cartItem : listCart) {
				total += cartItem.getCount() * cartItem.getProduct().getPrice();
			}

			Integer discount = (Integer) session.getAttribute("discountValue");
			model.addAttribute("discount", discount);
			session.setAttribute("discount", discount);

			model.addAttribute("Total", total);
			model.addAttribute("listCart", listCart);
			session.setAttribute("listCart", listCart);
			session.setAttribute("Total", total);

			return "shopping-cart";
		}
	}


	@GetMapping("/deleteCart/{id}")
	public String GetDeleteCart(@PathVariable int id, HttpServletRequest request) {
		String referer = request.getHeader("Referer");
		User user = (User) session.getAttribute("acc");
		if (user == null) {
			return "redirect:" +referer;
		} else {
			System.out.println(id);
			cartService.deleteById(id);
			session.setAttribute("CartDelete", id);
			List<Cart> listCart = cartService.GetAllCartByUser_id(user.getId());
			session.setAttribute("countCart", listCart.size());
			return "redirect:/cart";
		}
	}

	@PostMapping("/updateCart")
	public String UpdateCart(HttpServletRequest request) {
		@SuppressWarnings("unchecked")
		List<Cart> listCart = (List<Cart>) session.getAttribute("listCart");
		int i = 0;
		for (Cart o : listCart) {
			String a = request.getParameter("count" + i);
			int count = Integer.parseInt(a);
			System.out.println(count);
			o.setCount(count);
			i++;
		}
		for (Cart o : listCart) {
			cartService.saveCart(o);
		}
		return "redirect:/cart";
	}

	@GetMapping("/addToCart/{id}")
	public String AddToCart(@PathVariable int id, HttpServletRequest request) {
		String referer = request.getHeader("Referer");
		User user = (User) session.getAttribute("acc");
		if (user == null) {
			session.setAttribute("AddToCartErr", "Vui lòng đăng nhập trước khi thực hiện thao tác");
			return "redirect:" + referer;
		} else {
			List<Cart> listCart = cartService.GetAllCartByUser_id(user.getId());
			Product product = productService.getProductById(id);
			int cart = 0;
			for (Cart y : listCart) {
				if (y.getProduct().getId() == id) {
					cart++;
				}
			}
			if (cart > 0) {
				for (Cart y : listCart) {
					if (y.getProduct().getId() == id) {
						y.setCount(y.getCount() + 1);
						cartService.saveCart(y);
					}
				}
			} else {
				Cart newCart = new Cart();
				newCart.setCount(1);
				newCart.setProduct(product);
				newCart.setUser(user);
				cartService.saveCart(newCart);
			}
			listCart = cartService.GetAllCartByUser_id(user.getId());
			session.setAttribute("countCart", listCart.size());
			return "redirect:" + referer;
		}
	}

	@PostMapping("/addToCart")
	public String AddToCartPost(@ModelAttribute("product_id") int product_id, @ModelAttribute("count") String a,
								HttpServletRequest request) {
		int count = Integer.parseInt(a);
		String referer = request.getHeader("Referer");
		User user = (User) session.getAttribute("acc");
		if (user == null) {
			session.setAttribute("AddToCartErr", "Vui lòng đăng nhập trước khi thực hiện thao tác");
			return "redirect:" + referer;
		} else {
			List<Cart> listCart = cartService.GetAllCartByUser_id(user.getId());
			Product product = productService.getProductById(product_id);
			int cart = 0;
			for (Cart y : listCart) {
				if (y.getProduct().getId() == product_id) {
					y.setCount(y.getCount() + count);
					cartService.saveCart(y);
					cart++;
				}
			}
			if (cart == 0) {
				Cart newCart = new Cart();
				newCart.setCount(count);
				newCart.setProduct(product);
				newCart.setUser(user);
				cartService.saveCart(newCart);
			}
			listCart = cartService.GetAllCartByUser_id(user.getId());
			session.setAttribute("countCart", listCart.size());
			return "redirect:" + referer;
		}

	}

	@PostMapping("/check-code")
	public String CheckVoucherCode(@ModelAttribute("code") String code, RedirectAttributes redirectAttributes, HttpServletRequest request) {
		User user = (User) session.getAttribute("acc");
		if (user == null) {
			session.setAttribute("AddToCartErr", "Vui lòng đăng nhập trước khi thực hiện thao tác");
		} else {
			DiscountCode checkCode = discountCodeService.findByCode(code);
			if (checkCode != null && checkCode.isActive()) {
				int discountValue = checkCode.getDiscountAmount();
				session.setAttribute("discountValue", discountValue);
				redirectAttributes.addFlashAttribute("validCodeMessage", "Mã giảm giá hợp lệ.");
			} else {
				redirectAttributes.addFlashAttribute("invalidCodeMessage", "Mã giảm giá không hợp lệ.");
			}
		}
		return "redirect:/cart";
	}

}
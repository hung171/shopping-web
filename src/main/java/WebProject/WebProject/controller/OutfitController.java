package WebProject.WebProject.controller;

import WebProject.WebProject.entity.Favorite;
import WebProject.WebProject.entity.Product;
import WebProject.WebProject.entity.User;
import WebProject.WebProject.service.FavoriteService;
import WebProject.WebProject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class OutfitController {
    @Autowired
    FavoriteService favoriteService;

    @Autowired
    ProductService productService;

    @Autowired
    HttpSession session;

    @GetMapping("/outfit")
    public String OutfitView(Model model) {
        User user = (User) session.getAttribute("acc");
        if (user == null) {
            session.setAttribute("AddToCartErr", "Vui lòng đăng nhập trước khi thực hiện thao tác!");
            return "redirect:/home";
        } else {
            Pageable pageable = PageRequest.of(0, 9);
            Page<Favorite> favoritePage  = favoriteService.GetAllFavoriteByUser_id(user.getId(), pageable);
            model.addAttribute("favoritePage", favoritePage);
            return "outfit";
        }
    }

    @GetMapping("/outfit/{id}")
    public String OutfitPage(Model model, @PathVariable int id, HttpServletRequest request) {
        String referer = request.getHeader("Referer");
        User user = (User) session.getAttribute("acc");
        Pageable pageable = PageRequest.of(id, 9);
        Page<Favorite> favoritePage  = favoriteService.GetAllFavoriteByUser_id(user.getId(), pageable);
        model.addAttribute("favoritePage", favoritePage);
        model.addAttribute("referer", referer);
        return "outfit";
    }

    @GetMapping("/deleteOutfit/{id}")
    public String GetDeleteCart(@PathVariable int id, HttpServletRequest request) {
        String referer = request.getHeader("Referer");
        User user = (User) session.getAttribute("acc");
        if (user == null) {
            return "redirect:" +referer;
        } else {
            System.out.println(id);
            favoriteService.deleteById(id);
            session.setAttribute("favoriteDelete", id);
            return "redirect:/outfit";
        }
    }

    @GetMapping("/addToFavorite/{id}")
    public String AddToFavorite(@PathVariable int id, HttpServletRequest request) {
        String referer = request.getHeader("Referer");
        User user = (User) session.getAttribute("acc");
        if (user == null) {
            session.setAttribute("AddToCartErr", "Vui lòng đăng nhập trước khi thực hiện thao tác");
            return "redirect:" + referer;
        } else {
            Product product = productService.getProductById(id);
            Favorite newfavorite = new Favorite();
            newfavorite.setUser(user);
            newfavorite.setProduct(product);
            favoriteService.saveFavoriteProduct(newfavorite);
            return "redirect:" + referer;
        }
    }

}

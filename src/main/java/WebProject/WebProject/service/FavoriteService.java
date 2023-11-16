package WebProject.WebProject.service;

import WebProject.WebProject.entity.Favorite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface FavoriteService {
    void deleteById(int id);

    void saveFavoriteProduct(Favorite favorite);

    Page<Favorite> GetAllFavoriteByUser_id(String user_id, Pageable pageable);
}

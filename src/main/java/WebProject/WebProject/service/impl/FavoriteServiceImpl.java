package WebProject.WebProject.service.impl;

import WebProject.WebProject.entity.Favorite;
import WebProject.WebProject.repository.FavoriteRepository;
import WebProject.WebProject.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteServiceImpl implements FavoriteService {

    @Autowired
    FavoriteRepository favoriteRepository;

    @Override
    public void deleteById(int id) {
        favoriteRepository.deleteById(id);
    }

    @Override
    public void saveFavoriteProduct(Favorite favorite) {
        favoriteRepository.save(favorite);
    }

    @Override
    public Page<Favorite> GetAllFavoriteByUser_id(String user_id, Pageable pageable) {
        return favoriteRepository.findProductsByUserId(user_id, pageable);
    }


}


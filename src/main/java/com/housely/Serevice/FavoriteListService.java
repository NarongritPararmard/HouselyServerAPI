package com.housely.Serevice;

import com.housely.Model.Favorite.FavoriteList;
import com.housely.Repository.FavoriteListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteListService {
    private final FavoriteListRepository favoriteListRepository;

    public FavoriteListService(FavoriteListRepository favoriteListRepository) {
        this.favoriteListRepository = favoriteListRepository;
    }

    public List<FavoriteList> findAll() {
        return favoriteListRepository.findAll();
    }

    public FavoriteList save(FavoriteList favoriteList) {
        return favoriteListRepository.save(favoriteList);
    }

    public FavoriteList findById(Long id) {
        return favoriteListRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        favoriteListRepository.deleteById(id);
    }
}

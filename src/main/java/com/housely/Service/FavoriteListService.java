package com.housely.Service;

import com.housely.Exception.FavoriteListException.FavoriteListException;
import com.housely.Model.Favorite.FavoriteList;
import com.housely.Repository.FavoriteListRepository;
import org.springframework.http.ResponseEntity;
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
        return favoriteListRepository.findById(id)
                .orElseThrow(
                        () -> new FavoriteListException("FavoriteList with ID:"
                                + id
                                + " not found"));
    }

    public void deleteById(Long id) {
        favoriteListRepository.deleteById(id);
    }

    public FavoriteList findFavoriteInCustomerList(Long favoriteListId, Long cusId) {
        return favoriteListRepository.findFavoriteInCustomerList(favoriteListId, cusId)
                .orElseThrow(
                        () -> new FavoriteListException("FavoriteList with ID:"
                                + favoriteListId
                                + " not found in the customer's collection"));
    }

}

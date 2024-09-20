package com.housely.Repository;

import com.housely.Model.Favorite.FavoriteList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteListRepository extends JpaRepository<FavoriteList, Long> {
}

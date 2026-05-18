package com.animeslist.animeslist.repository;

import com.animeslist.animeslist.entity.Anime;
import com.animeslist.animeslist.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimeRepository extends JpaRepository<Anime, Long> {

    List<Anime> findAnimeByCategories(List<Category> categories);
}

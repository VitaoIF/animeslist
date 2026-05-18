package com.animeslist.animeslist.repository;

import com.animeslist.animeslist.entity.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeRepository extends JpaRepository<Anime, Long> {
}

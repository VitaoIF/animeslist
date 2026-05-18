package com.animeslist.animeslist.service;

import com.animeslist.animeslist.entity.Anime;
import com.animeslist.animeslist.repository.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AnimeService {

    @Autowired
    private AnimeRepository animeRepository;

    public Anime insert(Anime anime){
        return animeRepository.save(anime);
    }

    public List<Anime> findAll() {
        return animeRepository.findAll();
    }
}

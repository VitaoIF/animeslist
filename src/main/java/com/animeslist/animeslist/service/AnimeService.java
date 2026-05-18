package com.animeslist.animeslist.service;

import com.animeslist.animeslist.entity.Anime;
import com.animeslist.animeslist.entity.Category;
import com.animeslist.animeslist.entity.Streaming;
import com.animeslist.animeslist.repository.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnimeService {

    @Autowired
    private AnimeRepository animeRepository;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private StreamingService streamingService;

    public Anime insert(Anime anime){
        anime.setCategories(this.findCategories(anime.getCategories()));
        anime.setStreamings(this.findStreamings(anime.getStreamings()));
        return animeRepository.save(anime);
    }

    public List<Anime> findAll() {
        return animeRepository.findAll();
    }

    private List<Category> findCategories(List<Category> categories){
        List<Category> categoryList = new ArrayList<>();
        for (Category category: categories){
            categoryService.findById(category.getId()).ifPresent(categoryList::add);
        }

        return categoryList;
    }

    private List<Streaming> findStreamings(List<Streaming> streamings){
        List<Streaming> streamingsList = new ArrayList<>();
        for (Streaming streaming: streamings){
            streamingService.findById(streaming.getId()).ifPresent(streamingsList::add);
        }

        return streamingsList;
    }
}

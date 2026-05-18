package com.animeslist.animeslist.service;

import com.animeslist.animeslist.dto.request.AnimeRequest;
import com.animeslist.animeslist.dto.response.AnimeResponse;
import com.animeslist.animeslist.entity.Anime;
import com.animeslist.animeslist.entity.Category;
import com.animeslist.animeslist.entity.Streaming;
import com.animeslist.animeslist.mapper.AnimeMapper;
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

    public AnimeResponse findById(Long id){
        Anime anime = animeRepository.findById(id).orElseThrow(() -> new RuntimeException("Anime não encontrado"));
        return AnimeMapper.toAnimeResponse(anime);
    }

    public void delete(Long id){
        animeRepository.deleteById(id);
    }

    public AnimeResponse update(Long id, AnimeRequest animeRequest) {
        Anime entity = animeRepository.getReferenceById(id);
        updateAnime(entity, animeRequest);
        Anime updated = animeRepository.save(entity);
        return AnimeMapper.toAnimeResponse(updated);
    }

    public List<Anime> findByCategory(Long categoryId) {
        return animeRepository.findAnimeByCategories(List.of(Category.builder().id(categoryId).build()));
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


    private void updateAnime(Anime entity, AnimeRequest animeRequest){
        entity.setTittle(animeRequest.tittle());
        entity.setDescription(animeRequest.description());
        entity.setRating(animeRequest.raiting());
        entity.setStreamings(this.findStreamings(entity.getStreamings()));
        entity.setCategories(this.findCategories(entity.getCategories()));
        entity.setReleaseDate(animeRequest.releaseDate());
    }

}

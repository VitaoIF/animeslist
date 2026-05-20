package com.animeslist.animeslist.controller;

import com.animeslist.animeslist.dto.request.AnimeRequest;
import com.animeslist.animeslist.dto.response.AnimeResponse;
import com.animeslist.animeslist.entity.Anime;
import com.animeslist.animeslist.mapper.AnimeMapper;
import com.animeslist.animeslist.service.AnimeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/animes")
public class AnimeController {

    @Autowired
    private AnimeService animeService;

    @PostMapping
    public ResponseEntity<AnimeResponse> insert(@Valid @RequestBody AnimeRequest request){
        Anime saved = animeService.insert(AnimeMapper.toAnime(request));
        return ResponseEntity.ok(AnimeMapper.toAnimeResponse(saved));
    }

    @GetMapping
    public ResponseEntity<List<AnimeResponse>> findAll(){
        return ResponseEntity.ok(animeService.findAll()
                .stream()
                .map(AnimeMapper::toAnimeResponse).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnimeResponse> findById(@PathVariable Long id){
        AnimeResponse anime = animeService.findById(id);
        return ResponseEntity.ok().body(anime);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable Long id){
        animeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnimeResponse> update(@PathVariable Long id, @Valid @RequestBody AnimeRequest request){
        AnimeResponse response = animeService.update(id, request);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/search")
    public ResponseEntity<List<AnimeResponse>> findByCategory(@RequestParam Long category){
        List<AnimeResponse> list = animeService.findByCategory(category)
                .stream()
                .map(AnimeMapper::toAnimeResponse)
                .toList();
        return ResponseEntity.ok().body(list);
    }
}

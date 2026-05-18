package com.animeslist.animeslist.controller;

import com.animeslist.animeslist.dto.request.AnimeRequest;
import com.animeslist.animeslist.dto.response.AnimeResponse;
import com.animeslist.animeslist.entity.Anime;
import com.animeslist.animeslist.mapper.AnimeMapper;
import com.animeslist.animeslist.service.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animes")
public class AnimeController {

    @Autowired
    private AnimeService animeService;

    @PostMapping
    public ResponseEntity<AnimeResponse> insert(@RequestBody AnimeRequest request){
        Anime saved = animeService.insert(AnimeMapper.toAnime(request));
        return ResponseEntity.ok(AnimeMapper.toAnimeResponse(saved));
    }

    @GetMapping
    public ResponseEntity<List<AnimeResponse>> findAll(){
        return ResponseEntity.ok(animeService.findAll()
                .stream()
                .map(AnimeMapper::toAnimeResponse).toList());
    }
}

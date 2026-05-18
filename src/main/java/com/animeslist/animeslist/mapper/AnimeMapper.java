package com.animeslist.animeslist.mapper;

import com.animeslist.animeslist.dto.request.AnimeRequest;
import com.animeslist.animeslist.dto.response.AnimeResponse;
import com.animeslist.animeslist.dto.response.CategoryResponse;
import com.animeslist.animeslist.dto.response.StreamingResponse;
import com.animeslist.animeslist.entity.Anime;
import com.animeslist.animeslist.entity.Category;
import com.animeslist.animeslist.entity.Streaming;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class AnimeMapper {

    public static Anime toAnime(AnimeRequest request){

        List<Category> listCategories = request.categories()
                .stream()
                .map(categoryId -> Category.builder().id(categoryId).build())
                .toList();

        List<Streaming> listStreamings = request.streamings()
                .stream()
                .map(streamingId -> Streaming.builder().id(streamingId).build())
                .toList();

        return Anime.builder()
                .tittle(request.tittle())
                .description(request.description())
                .releaseDate(request.releaseDate())
                .rating(request.raiting())
                .categories(listCategories)
                .streamings(listStreamings)
                .build();
    }

    public static AnimeResponse toAnimeResponse(Anime anime){

        List<CategoryResponse> categoryList = anime.getCategories()
                .stream()
                .map(CategoryMapper::toCategoryResponse)
                .toList();

        List<StreamingResponse> streamingList = anime.getStreamings()
                .stream()
                .map(StreamingMapper::toStreamingResponse)
                .toList();

        return AnimeResponse.builder()
                .id(anime.getId())
                .tittle(anime.getTittle())
                .description(anime.getDescription())
                .releaseDate(anime.getReleaseDate())
                .rating(anime.getRating())
                .categoryResponseList(categoryList)
                .streamingResponses(streamingList)
                .build();
    }
}

package com.animeslist.animeslist.controller;

import com.animeslist.animeslist.dto.request.CategoryRequest;
import com.animeslist.animeslist.dto.response.CategoryResponse;
import com.animeslist.animeslist.entity.Category;
import com.animeslist.animeslist.mapper.CategoryMapper;
import com.animeslist.animeslist.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> findAll(){
        List<CategoryResponse> categories = categoryService.findAll()
                .stream()
                .map(CategoryMapper::toCategoryResponse)
                .toList();

        return ResponseEntity.ok().body(categories);
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> insert(@Valid @RequestBody CategoryRequest categoryRequest){
        Category category = CategoryMapper.toCategory(categoryRequest);
        Category savedCategory = categoryService.insert(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(CategoryMapper.toCategoryResponse(savedCategory));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> findById(@PathVariable Long id){
        return categoryService
                .findById(id)
                .map(category -> ResponseEntity.ok(CategoryMapper.toCategoryResponse(category)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        categoryService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

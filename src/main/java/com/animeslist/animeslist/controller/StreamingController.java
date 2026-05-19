package com.animeslist.animeslist.controller;

import com.animeslist.animeslist.dto.request.StreamingRequest;
import com.animeslist.animeslist.dto.response.StreamingResponse;
import com.animeslist.animeslist.entity.Streaming;
import com.animeslist.animeslist.mapper.StreamingMapper;
import com.animeslist.animeslist.service.StreamingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/streamings")
public class StreamingController {

    @Autowired
    private StreamingService streamingService;

    @GetMapping
    public ResponseEntity<List<StreamingResponse>> findAll(){
        List<StreamingResponse> categories = streamingService.findAll()
                .stream()
                .map(StreamingMapper::toStreamingResponse)
                .toList();

        return ResponseEntity.ok().body(categories);
    }

    @PostMapping
    public ResponseEntity<StreamingResponse> insert(@Valid @RequestBody StreamingRequest streamingRequest){
        Streaming streaming = StreamingMapper.toStreaming(streamingRequest);
        Streaming savedStream = streamingService.insert(streaming);
        return ResponseEntity.status(HttpStatus.CREATED).body(StreamingMapper.toStreamingResponse(savedStream));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StreamingResponse> findById(@PathVariable Long id){
        return streamingService
                .findById(id)
                .map(streaming -> ResponseEntity.ok(StreamingMapper.toStreamingResponse(streaming)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        streamingService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

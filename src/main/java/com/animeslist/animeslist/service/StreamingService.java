package com.animeslist.animeslist.service;

import com.animeslist.animeslist.entity.Streaming;
import com.animeslist.animeslist.repository.StreamingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StreamingService {

    @Autowired
    private StreamingRepository streamingRepository;

    public List<Streaming> findAll(){
        return streamingRepository.findAll();
    }

    public Streaming insert(Streaming streaming) {
        return streamingRepository.save(streaming);
    }

    public Optional<Streaming> findById(Long id) {
        return streamingRepository.findById(id);
    }

    public void delete(Long id) {
        streamingRepository.deleteById(id);
    }
}

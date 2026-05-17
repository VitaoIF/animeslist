package com.animeslist.animeslist.repository;

import com.animeslist.animeslist.entity.Streaming;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreamingRepository extends JpaRepository<Streaming, Long> {
}

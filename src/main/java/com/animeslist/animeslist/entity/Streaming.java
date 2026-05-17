package com.animeslist.animeslist.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_streaming")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Streaming {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;
}

package com.dnsgml.domain.posts;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter  // ⑥
@NoArgsConstructor  // ⑤
@Entity  // ①
public class Posts {

    @Id  // ②
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // ③
    private Long id;

    @Column(length = 500, nullable = false)  // ④
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder  // ⑦
    public Posts(String title, String content, String author){
        this.title=title;
        this.content=content;
        this.author=author;
    }

}

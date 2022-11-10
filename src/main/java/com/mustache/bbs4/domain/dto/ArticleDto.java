package com.mustache.bbs4.domain.dto;

import com.mustache.bbs4.domain.Article;
import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@Setter
@AllArgsConstructor
public class ArticleDto {
/*
*   noArgCon과 allArgCon을 사용하면 Setter를 사용하지 않으면 null이된다
*
*
* */
    private Long id;
    private String title;
    private String content;

    public ArticleDto(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Article toEntity() {
        return new Article(this.id, this.title, this.content);
    }
}

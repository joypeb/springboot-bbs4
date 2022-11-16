package com.mustache.bbs4.domain;

import com.mustache.bbs4.domain.dto.ArticleDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "article4")
@Getter
@NoArgsConstructor
@ToString
@Setter
@AllArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;
    @Column
    private String content;

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }


    public static ArticleDto of(Article article) {
        return new ArticleDto(article.getId(),article.getTitle(),article.getContent());
    }
}

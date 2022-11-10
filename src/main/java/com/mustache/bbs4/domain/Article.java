package com.mustache.bbs4.domain;

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
}

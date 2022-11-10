package com.mustache.bbs4.controller;

import com.mustache.bbs4.domain.Article;
import com.mustache.bbs4.domain.dto.ArticleDto;
import com.mustache.bbs4.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
@RequestMapping("articles")
public class ArticleController {

    private final ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping("")
    public String index() {
        return "redirect:/articles/list";
    }

    @GetMapping("/new")
    public String addPage() {
        return "new";
    }

    //add
    @PostMapping("")
    public String addUser(ArticleDto articleDto) {
        Article article = articleRepository.save(articleDto.toEntity());
        log.info("article 정보 : "+article.toString());
        String re = "redirect:/articles/" + article.getId();
        return re;
    }

    //id검색
    @GetMapping("/{id}")
    public String selectOne(@PathVariable Long id, Model model) {
        Optional<Article> optionalArticle = articleRepository.findById(id);

        if(optionalArticle.isEmpty()) {
            model.addAttribute("id",id);
            return "error";
        } else {
            model.addAttribute("article",optionalArticle.get());
            return "show";
        }
    }

    //list

    @GetMapping("/list")
    public String list(Model model) {
        List<Article> articles = articleRepository.findAll();
        model.addAttribute("articles", articles);
        return "list";
    }
}

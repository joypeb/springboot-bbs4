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

    //수정
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Optional<Article> optionalArticle = articleRepository.findById(id);
        log.info("에딧 로그 출력 : " + optionalArticle.get().toString());

        if(optionalArticle.isEmpty()) {
            model.addAttribute("id",id);
            return "error";
        } else {
            model.addAttribute("article",optionalArticle.get());
            return "edit";
        }
    }

    //수정 업데이트
    @PostMapping("/update")
    public String update(ArticleDto articleDto, Model model) {
        log.info("수정 정보 : " + articleDto.toString());
        Article article = articleRepository.save(articleDto.toEntity());
        model.addAttribute("article", article);
        String re = "redirect:/articles/" + article.getId();
        return re;
    }

    //삭제
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        articleRepository.deleteById(id);
        return "redirect:/articles/list";
    }
}
